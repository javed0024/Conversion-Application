package com.conversion.conversion.controller;

import com.conversion.conversion.response.Response;
import com.conversion.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @GetMapping("/temperature")
    public ResponseEntity<?> temperatureConverter(@RequestParam Character convertFrom, @RequestParam Character convertTo, @RequestParam Double temp){
        try {
            ArrayList<Character> list=new ArrayList<>(Arrays.asList('c','C','k','K','f','F'));
            if(!list.contains(convertFrom) ||!list.contains(convertTo) || convertTo == convertFrom) {
                throw new IllegalArgumentException("either 'convert to' or 'convert from' were not given in correct format or were same");
            }
            else
             return new ResponseEntity<Response>(new Response("successfully converted",conversionService.temperatureConverter(convertFrom, convertTo, temp)), HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
                return new ResponseEntity<Response>(new Response(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
        catch(Exception e)
        {
            return new ResponseEntity<Response>(new Response("something went wrong, please check the request params or contact your administrator"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
