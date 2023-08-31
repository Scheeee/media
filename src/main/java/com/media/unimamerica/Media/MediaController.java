package com.media.unimamerica.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping(value = "/media")
public class MediaController {
    @Autowired
    private NumeroRep numeroRep;

    @GetMapping("/lista")
    public ResponseEntity <?> getAllMarca(){
        return ResponseEntity.ok(numeroRep.findAll());
    }
    @GetMapping("/media/{id}")
    public ResponseEntity<?> calculaLista(@PathVariable("id") Long id) {
        List<Float> numeros = numeroRep.findById(id).get().getNumeros();
        int quantidade = numeros.size();
        float subtotal = 0;
        float media;
        float desvio;
        float mediana;
        float maiorNum;
        float menorNum;
        for(int i = 0; i < numeros.size(); i++){
            subtotal += numeros.get(i);
        }
        media = subtotal/quantidade;
        // desvio padrão

        float Difquadrado = 0;
        for (int i = 0; i < numeros.size(); i++) {
            float diferenca = numeros.get(i) - media;// diferença da média comparando com cada número
            Difquadrado += diferenca * diferenca;
        }
        desvio = (float) Math.sqrt(Difquadrado / quantidade);

        // mediana
        Collections.sort(numeros, Comparator.comparingDouble(numero -> (double) numero)); // colocando os números em ordem crescente
        if (quantidade % 2 == 0) {// se o número for par, ele vai pegar os dois números do meio
            mediana = (numeros.get(quantidade / 2 - 1) + numeros.get(quantidade / 2)) / 2;
        } else {
            mediana = numeros.get(quantidade / 2);
        }
        menorNum = numeros.get(0);
        maiorNum = numeros.get(quantidade - 1);

        String resultado = "\n a média é " + media  + " \n a mediana é " + mediana + "\n o desvio padrão é:" + desvio + "\n a soma de todos os números é: " + subtotal + "\n o maior número é: " + maiorNum + "\n o menor número é: " +menorNum ;

        return ResponseEntity.ok(resultado );

    };
    @PostMapping
    public ResponseEntity <?> inserir(@RequestBody final Numero numero){
        try {

            numeroRep.save(numero);
            return ResponseEntity.ok("número cadastrado com sucesso!");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Numero numero){
        try {
            final Numero numero1 = this.numeroRep.findById(id).orElse(null);

            if (numero1 == null || numero1.equals(numero.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.numeroRep.save(numero);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    @DeleteMapping("/numero/{id}")
    public ResponseEntity <?> deletar(@RequestBody final Numero numero){
        try {
            this.numeroRep.delete(numero);
            return ResponseEntity.ok("numero removido com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }





}
