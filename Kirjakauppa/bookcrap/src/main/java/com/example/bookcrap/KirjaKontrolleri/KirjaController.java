package com.example.bookcrap.KirjaKontrolleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class KirjaController {
    @Autowired
    private KirjaRepo repo;
    private ArrayList<Kirja> kirja = new ArrayList<Kirja>();

    @RequestMapping(value="/index")
    public String home(){
        return "index";
    }
    //tehtävä 3 harjoitus 2 osiota varten kaikki kirjat:
    @RequestMapping(value="/lista")
    public String listAll(Model model){
        model.addAttribute("lista", repo.findAll());
        return "booklist";
    }
}
