/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.shafin.logtruncater.core.service.ConfigService;

/**
 *
 * @author shafin
 */
@Slf4j
public class TruncateServiceImplTest {
    
    @InjectMocks
    private TruncateServiceImpl truncateService;
    
    @Mock
    private ConfigService configService;
    
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        
        Mockito.when(
            configService.getTruncateReplacementText()
        ).thenReturn(
            "... (truncated) ..."
        );
    }
    
    @Test
    public void truncateBiggerSizeText() {
        
        String inputText = "123456789012345678901234567890";
        int maxLogSize = 25;
        String expected = "12 ... (truncated) ... 90";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateSmallerSizeText() {
        
        String inputText = "1234567890";
        int maxLogSize = 5;
        String expected = "1234567890";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateInTheLimitSizeText() {        
        String inputText = "123456789012345678901234567890";
        int maxLogSize = 31;
        String expected = "123456789012345678901234567890";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateCornerCase1() {        
        String inputText = "123456789012345678901234567890";
        int maxLogSize = 21;
        String expected = " ... (truncated) ... ";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateCornerCase2() {        
        String inputText = "123456789012345678901234567890";
        int maxLogSize = 22;
        String expected = "1 ... (truncated) ... ";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateCornerCase3() {        
        String inputText = "123456789012345678901234567890";
        int maxLogSize = 23;
        String expected = "1 ... (truncated) ... 0";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
    
    @Test
    public void truncateCornerCase4() {        
        String inputText = "1234567890123456789012345678901234567890";
        int maxLogSize = 27;
        String expected = "123 ... (truncated) ... 890";
        
        String responed = truncateService.truncate(inputText, maxLogSize);
        log.info("expected = {}, responed = {}", expected, responed);
        
        Assert.assertEquals(expected, responed) ;
    }    
}
