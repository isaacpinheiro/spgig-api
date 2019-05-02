/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.spgig.controller;

/**
 *
 * @author isaac
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ufabc.spgig.model.Organizador;
import br.edu.ufabc.spgig.repository.OrganizadorRepository;
import br.edu.ufabc.spgig.model.Login;

import br.edu.ufabc.spgig.util.MyHash;

@RestController
public class OrganizadorController {
    
    @Autowired
    private OrganizadorRepository repository;
    
    @RequestMapping(value="/api/organizador/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Organizador listOne(@PathVariable("id") String id) {
        Organizador obj = repository.findOne(Long.parseLong(id));
        return obj;
    }
    
    @RequestMapping(value="/api/organizador", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Iterable<Organizador> findAll() {
        return repository.findAll();
    }
    
    @RequestMapping(value="/api/organizador", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody String insert(@RequestBody Organizador obj) {
        repository.save(obj);
        return "{\"msg\": \"success\"}";
    }
    
    @RequestMapping(value="/api/organizador/{id}", method=RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable("id") String id) {
        Organizador obj = repository.findOne(Long.parseLong(id));
        repository.delete(obj);
        return "{\"msg\": \"success\"}";
    }
    
    @RequestMapping(value="/api/organizador/cadastrar", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody String cadastrar(@RequestBody Organizador obj) {
        obj.setSalt(MyHash.generateToken());
        obj.setSenha(MyHash.generate(obj.getSenha(), obj.getSalt()));
        repository.save(obj);
        return "{\"msg\": \"success\"}";
    }
    
    @RequestMapping(value="/api/organizador/login", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody String login(@RequestBody Login obj) {
        
        Organizador o = repository.findByNomeUsuario(obj.getNomeUsuario());
        
        if (o == null) {
            return "{\"msg\": \"Nome de Usuário ou a Senha está incorreto.\"}";
        } else if (!MyHash.match(o.getSenha(), obj.getSenha(), o.getSalt())) {
            return "{\"msg\": \"Nome de Usuário ou a Senha está incorreto.\"}";
        }
        
        return "{\"msg\": \"success\"}";
        
    }
    
}
