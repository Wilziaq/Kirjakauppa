package com.example.bookcrap.KirjaKontrolleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class KirjaController {
    @Autowired
    private KirjaRepo repo;
    private ArrayList<Kirja> kirja = new ArrayList<Kirja>();

    @RequestMapping(value = "/index")
    public String home(){
        return "index";
    }

    //tehtävä 3 harjoitus 2 osiota varten kaikki kirjat:
    @RequestMapping(value = "/lista")
    public String listAll(Model model){
        model.addAttribute("lista", repo.findAll());
        return "booklist";
    }
    //Tehtävä 3 harjoitus 3 osiota varten Create ja Delete toiminnot sivulle:
    @RequestMapping(value = "/addbook")
    public String luoFormi(Model model){
        model.addAttribute("kirja", new Kirja());
        return "addbook";
    }
    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String lisaaKirja(Kirja kirja){
        repo.save(kirja);
        return "redirect:/lista";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") String id, Model model){
        Long ID = Long.parseLong(id);
        repo.delete(ID);
        return "redirect:/lista";
    }
}
