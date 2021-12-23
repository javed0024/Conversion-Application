package com.conversion.conversion.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    public Double temperatureConverter(Character convertFrom, Character convertTo, Double temp){
        if(convertFrom=='C'|| convertFrom=='c'){
            if(convertTo=='F'|| convertTo=='f')
                return temp*(9.0/5.0)+32;
            else if(convertTo=='K'|| convertTo=='k')
                return temp+273.15;
        }
        else if(convertFrom=='F'|| convertFrom=='f'){
            if(convertTo=='C'|| convertTo=='c')
                return (temp-32)*(5.0/9.0);
            else if(convertTo=='K'|| convertTo=='k')
                return ((temp-32)*(5.0/9.0))+273.15;
        }
        else{
            if(convertTo=='C'|| convertTo=='c')
                return temp-273.15;
            else if(convertTo=='F'|| convertTo=='f')
                return ((temp-273.15)*(9.0/5.0))+32;
        }
        return -1D;
    }
}
