package com.media.unimamerica.Media;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;


@Getter
@Setter
@SpringBootTest
public class Media {
    private List<Float> numeros;

    public Media(List<Float> numeros) {
        this.numeros = numeros;
    }

    public float soma(){
        float soma = 0;
        for(int i = 0; i < numeros.size(); i++){
            soma += numeros.get(i);
        }
        return soma;
    }
    public float maximo (){
        float maximo;
        numeros.sort(Comparator.comparingDouble(numero -> (double) numero)); // colocando os números em ordem crescente
        maximo = numeros.get(numeros.size() - 1) ;
        return maximo;
    }
    public float minimo (){
        float minimo;
        numeros.sort(Comparator.comparingDouble(numero -> (double) numero)); // colocando os números em ordem crescente
        minimo = numeros.get(0) ;
        return minimo;
    }
    public float media(){
        float media;
        float subtotal =0;
        int quantidade = numeros.size();
        for(int i = 0; i < numeros.size(); i++){
            subtotal += numeros.get(i);
        }
        media = subtotal/quantidade;
        return media;
    }
    public float desvio(){
        float Difquadrado = 0;
        float desvio;
        int quantidade = numeros.size();
        for (int i = 0; i < numeros.size(); i++) {
            float diferenca = numeros.get(i) - media();// diferença da média comparando com cada número
            Difquadrado += diferenca * diferenca;
        }
        desvio = (float) Math.sqrt(Difquadrado / quantidade);
        return  desvio;
    }
    public float mediana(){
        float mediana;
        int quantidade = numeros.size();
        numeros.sort(Comparator.comparingDouble(numero -> (double) numero)); // colocando os números em ordem crescente
        if (quantidade % 2 == 0) {// se o número for par, ele vai pegar os dois números do meio
            mediana = (numeros.get(quantidade / 2 - 1) + numeros.get(quantidade / 2)) / 2;
        } else {
            mediana = numeros.get(quantidade / 2);
        }
        return mediana;
    }



}
