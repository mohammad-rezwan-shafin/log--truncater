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
    @Override
    public String order(String input) {
        log.info("Order Request received with => {}", input);
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i=0;i<1000;i++) {
            stringBuilder.append("0123456789");
        }
        return stringBuilder.toString() ;
    }
}
