package br.com.buscador.application;

import br.com.buscador.model.ConsultaCep;
import br.com.buscador.model.Endereco;
import br.com.buscador.model.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {
        Scanner entradaTeclado = new Scanner(System.in);
        String cep = "";
        String resposta = "";
        ConsultaCep consultaCep = new ConsultaCep();
        Endereco endereco;
        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

    try {
        System.out.println("======================================");
        System.out.println("            BUSCADOR DE CEP");
        System.out.println("======================================");


        while (!cep.equalsIgnoreCase("sair")){
        System.out.println("Digite um cep [para sair digite 'sair']: ");
        cep = entradaTeclado.nextLine().trim().toLowerCase();

        if (cep.equalsIgnoreCase("sair")){
            break;
        }

            endereco = consultaCep.buscaEndereco(cep);

            System.out.println("Deseja adicionar em um arquivo JSON [s/n]:  ");
            resposta = entradaTeclado.nextLine().trim().toLowerCase();

            if (resposta.equalsIgnoreCase("s")){
                geradorDeArquivo.geraArquivoJson(endereco);
            }

            System.out.println(endereco);
            System.out.println("===========================================================================================================");
        }
    } catch (RuntimeException | IOException e){
        e.printStackTrace();

    }

        System.out.println("Aplicação encerrada!");
    }
}
