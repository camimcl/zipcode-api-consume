package org.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.dto.AdressDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    //requisição

    AdressDto adressDto = new AdressDto();

    public AdressDto getAdress(String cep) throws IOException, InterruptedException {
        try {
            //utilizaçao do construtor dessas classes para instanciar as variaveis client e request

            HttpClient client =  HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()

                    //uri responsavel por chamar o endereço http, com paramentro cep
                    .uri(URI.create("http://viacep.com.br/ws/"+ cep +"/json/")).build();

            //enviando a requisiçao e retornar ela como string
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //transcricao dos dados retornados em json para objeto java.
            ObjectMapper mapper = new ObjectMapper();
            adressDto = mapper.readValue(response.body(), AdressDto.class);
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return adressDto;
    }
}

