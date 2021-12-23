package com.conversion.conversion.service;

import com.conversion.conversion.controller.ConversionController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class ConversionServiceTest {

    @InjectMocks
    ConversionService conversionService;

    @Test
    public void test_temperatureConverterWhenValidInput()
    {
        Assertions.assertEquals(conversionService.temperatureConverter('C', 'K', 0.0D), 273.15D);
    }

    @Test
    public void test_temperatureConverterWhenInvalidInput()
    {
        Assertions.assertEquals(conversionService.temperatureConverter('G', 'K', 0.0D), -1D);
    }
}
