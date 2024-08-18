package org.application;

import org.application.dto.AdressDto;
import org.application.service.ApiService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiService apiService = new ApiService();
        AdressDto adressDto = apiService.getAdress("51130610");

             System.out.println(adressDto.getLogradouro());

    }
}
