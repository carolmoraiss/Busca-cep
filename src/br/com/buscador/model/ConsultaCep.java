package br.com.buscador.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {

        HttpResponse<String> response;
        Gson gson;
        Endereco enderecoViaCep;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json")).build();


        try {

            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
            return new Gson().fromJson(response.body(), Endereco.class);

        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }

    }

}
