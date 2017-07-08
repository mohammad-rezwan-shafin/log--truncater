/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.shafin.logtruncater.core.service.ConfigService;
import org.shafin.logtruncater.core.service.TruncateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class TruncateServiceImpl implements TruncateService {
    
    private static final String REPLACEMENT_TEXT_PREFIX = " ";
    private static final String REPLACEMENT_TEXT_SUFFIX = " ";
    
    @Autowired
    private ConfigService configService;

    @Override
    public String truncate(String strData, int limitSize) {
        String replacementText = configService.getTruncateReplacementText();
        int totalReplacementTextSize = replacementText.length() 
                                        + REPLACEMENT_TEXT_PREFIX.length()
                                        + REPLACEMENT_TEXT_SUFFIX.length();
        
        log.info("replacementText = {}", replacementText);
        log.info(
            "replacementTextSize = {}, strDataSize = {}, limitSize = {}, limit-trts = {}",
            totalReplacementTextSize,
            strData.length(),
            limitSize,
            limitSize - totalReplacementTextSize
        );

        StringBuilder strBuilderReturn = new StringBuilder();
        if ( strData.length() > limitSize && strData.length() >= totalReplacementTextSize ) {
            
            int bothEndTxtSize = ( limitSize - totalReplacementTextSize );
            if (bothEndTxtSize < 0) {
                bothEndTxtSize = 0;
            }
            int backEndTxtSize = bothEndTxtSize / 2;
            int frontEndTxtSize = bothEndTxtSize - backEndTxtSize;
            
            strBuilderReturn.append(strData.substring(0, frontEndTxtSize));
            strBuilderReturn.append(REPLACEMENT_TEXT_PREFIX);
            strBuilderReturn.append(replacementText);
            strBuilderReturn.append(REPLACEMENT_TEXT_SUFFIX);
            strBuilderReturn.append(
                strData.substring ( 
                    strData.length() - backEndTxtSize, 
                    strData.length()
                )
            );
        } else {
            strBuilderReturn.append(strData);
        }
        return strBuilderReturn.toString();
    }    
}
