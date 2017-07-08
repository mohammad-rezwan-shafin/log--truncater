/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.shafin.logtruncater.core.service.TruncateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class TruncateServiceImpl implements TruncateService {

    @Value("${org.shafin.logtruncater.config.log-truncate-replacement-text}")
    private String replacementText;
    
    @Override
    public String truncate(String strData, int limitSize) {
        log.info("replacementText = {}", replacementText);
        return "truncate";
    }    
}
