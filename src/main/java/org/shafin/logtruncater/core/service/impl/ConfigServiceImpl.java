/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service.impl;

import lombok.Getter;
import org.shafin.logtruncater.core.service.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Service
@Getter
public class ConfigServiceImpl implements ConfigService {
    
    @Value("${org.shafin.logtruncater.config.log-truncate-replacement-text}")
    private String truncateReplacementText;
    
}
