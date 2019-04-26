package com.medico.app.web.controllers;

import com.medico.app.web.models.dao.IDetalleRecetaDAO;
import com.medico.app.web.models.entities.DetalleReceta;
import com.medico.app.web.models.services.IDetalleRecetaService;
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
@RequestMapping(value="/detallereceta")
public class DetalleRecetaController {
    //servicio => Inyeccion de dependencias

    @Autowired
    //private IDetalleRecetaDAO service;
    private IDetalleRecetaService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        DetalleReceta detallereceta=new DetalleReceta();
        model.addAttribute("detallereceta",detallereceta);
        return "detallereceta/form";
    }
    @PostMapping(value="/save" )
    public String save(DetalleReceta detallereceta,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(detallereceta);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/detallereceta/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        DetalleReceta detallereceta=service.findById(id);
        model.addAttribute("detallereceta",detallereceta);
        return "detallereceta/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        DetalleReceta detallereceta=service.findById(id);
        model.addAttribute("detallereceta",detallereceta);
        return "detallereceta/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/detallereceta/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<DetalleReceta> detallerecetas=service.findAll();
        model.addAttribute("lista",detallerecetas);
        return "detallereceta/list";
    }
}
