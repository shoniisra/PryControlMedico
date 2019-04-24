package com.medico.app.web.controllers;

import com.medico.app.web.models.dao.IPacienteDAO;
import com.medico.app.web.models.entities.Paciente;
import com.medico.app.web.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value="/paciente")
public class PacienteController {
    //servicio => Inyeccion de dependencias
    @Autowired
    //private IPacienteDAO service;
    private IPacienteService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Paciente paciente=new Paciente();
        model.addAttribute("paciente",paciente);
        return "paciente/form";
    }
    @PostMapping(value="/save" )
    public String save(Paciente paciente,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(paciente);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/paciente/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Paciente paciente=service.findById(id);
        model.addAttribute("paciente",paciente);
        return "paciente/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Paciente paciente=service.findById(id);
        model.addAttribute("paciente",paciente);
        return "paciente/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/paciente/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Paciente> pacientes=service.findAll();
        model.addAttribute("lista",pacientes);
        return "paciente/list";
    }
}