package com.media.unimamerica.Media;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestClassMedia {



    @Test
    public void testSoma(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o inteiro i para float e adicionando à lista
        }

        Media media = new Media(numeros);
        float soma = media.soma();
        float margemErro = 0.00f; // Margem de erro permitida

        Assert.assertEquals(210,soma,margemErro);
    }
    @Test
    public void testMinimo(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o i para float e adicionando à lista
        }
        Media media = new Media(numeros);
        float minimo = media.minimo();
        float margemErro = 0.00f; // Margem de erro permitida

        Assert.assertEquals(1,minimo,margemErro);

    }
    @Test
    public void testMaximo(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o inteiro i para float e adicionando à lista
        }
        Media media = new Media(numeros);
        float maximo = media.maximo();
        float margemErro = 0.00f; // Margem de erro permitida

        Assert.assertEquals(20,maximo,margemErro);
    }
    @Test
    public void testMedia(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o inteiro i para float e adicionando à lista
        }
        Media media = new Media(numeros);
        float tirarmedia = media.media();
        float margemErro = 0.00f; // Margem de erro permitida

        Assert.assertEquals(10.5,tirarmedia,margemErro);

    }
    @Test
    public void testDesvio(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o inteiro i para float e adicionando à lista
        }
        Media media = new Media(numeros);
        float desvio = media.desvio();
        float margemErro = 0.01f; // Margem de erro permitida

        Assert.assertEquals(5.76,desvio,margemErro);

    }
    @Test
    public void testMediana(){
        List<Float> numeros = new ArrayList<Float>();
        for (int i = 1; i <= 20; i++) {
            numeros.add((float) i); // Convertendo o inteiro i para float e adicionando à lista
        }
        Media media = new Media(numeros);
        float mediana = media.mediana();
        float margemErro = 0.00f; // Margem de erro permitida

        Assert.assertEquals(10.5,mediana,margemErro);
    }


}
