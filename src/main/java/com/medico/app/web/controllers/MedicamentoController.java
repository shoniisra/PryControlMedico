package com.medico.app.web.controllers;

import com.medico.app.web.models.dao.IMedicamentoDAO;
import com.medico.app.web.models.entities.Medicamento;
import com.medico.app.web.models.services.IMedicamentoService;
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
@RequestMapping(value="/medicamento")
public class MedicamentoController {
    //servicio => Inyeccion de dependencias
    @Autowired
    //private IMedicamentoDAO service;
    private IMedicamentoService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Medicamento medicamento=new Medicamento();
        model.addAttribute("medicamento",medicamento);
        return "medicamento/form";
    }
    @PostMapping(value="/save" )
    public String save(Medicamento medicamento,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(medicamento);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/medicamento/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Medicamento medicamento=service.findById(id);
        model.addAttribute("medicamento",medicamento);
        return "medicamento/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Medicamento medicamento=service.findById(id);
        model.addAttribute("medicamento",medicamento);
        return "medicamento/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/medicamento/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Medicamento> medicamentos=service.findAll();
        model.addAttribute("lista",medicamentos);
        return "medicamento/list";
    }
}
