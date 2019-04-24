package com.medico.app.web.controllers;

import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.services.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/medico")
public class MedicoController {
    @Autowired
    //private IMedicoDAO service;
    private IMedicoService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Medico medico=new Medico();
        model.addAttribute("medico",medico);
        return "medico/form";
    }
    @PostMapping(value="/save" )
    public String save(Medico medico,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(medico);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/medico/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Medico medico=service.findById(id);
        model.addAttribute("medico",medico);
        return "medico/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Medico medico=service.findById(id);
        model.addAttribute("medico",medico);
        return "medico/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/medico/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Medico> medicos=service.findAll();
        model.addAttribute("lista",medicos);
        return "medico/list";
    }
}
