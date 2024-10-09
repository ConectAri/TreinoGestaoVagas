package com.arianemoura.primeiro_projeto_springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id){
        return "O parametro é " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id){
        return "O parametro com metodoComQueryParams é " + id;
    }

    //Pegando todos os parametros
    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams ){
        return "O parametro com metodoComQueryParams2 é " + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody  Usuario usuario){
        return " metodoComBodyParams " + usuario.username();
    }

    @PostMapping("/metodoComHeadersString")
    public String metodoComHeaders(@RequestHeader("name")  String name){
        return " metodoComHeadersString " + name;
    }

    @PostMapping("/metodoComHeadersMaps")
    public String metodoComHeadersMap(@RequestHeader Map<String, String> headers){

        return " metodoComHeadersMap " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id) {
        var usuario = new Usuario("Ida");

        if (id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        return ResponseEntity.badRequest().body("Numero menor que 5");
    }

    record Usuario(String username){

    }

}
