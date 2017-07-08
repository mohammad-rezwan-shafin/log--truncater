/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.shafin.logtruncater.core.service.OrderService;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    public String testMethod(String input) {
        log.info("Request received with ={}", input);
        return "<OrderServiceImpl say:> Good for you!" ;
    }
}
