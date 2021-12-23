package com.conversion.conversion.controller;

import com.conversion.conversion.service.ConversionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class ConversionControllerTest {

    @InjectMocks
    ConversionController conversionController;

    @Mock
    ConversionService conversionService;

    @Test
    public void test_temperatureConverterWhenValidInput(){
        Mockito.when(conversionService.temperatureConverter('C', 'K', 0.0D))
                .thenReturn(273.15D);
        Assertions.assertEquals(conversionController.temperatureConverter('C', 'K', 0.0D).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void test_temperatureConverterWhenInvalidInput(){
        Mockito.when(conversionService.temperatureConverter('g', 'K', 0.0D))
                .thenReturn(273.15D);
        Assertions.assertEquals(conversionController.temperatureConverter('g', 'K', 0.0D).getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}
