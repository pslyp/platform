package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    /*
    @GetMapping(value = "")
    public List<User> index() throws Exception {
        //List<User> users = userRepository.findAll();
        //List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18,19,22));
        List<User> users = userRepository.findByAgeIn(ages);
        System.out.println("############### List All Users (In Console) ###############");
        System.out.println(users);

        //return "Method Get, Function : index => HTML Render Lists Page";
        return users;
    }
    */

    /*
    // Example for findAllByQuery
    @GetMapping(value = "")
    public List<User> index() throws Exception {
        return userRepository.findAllByQuery();
    }
    */

    // Example for findAllByParamsQuery
    @GetMapping(value = "")
    public List<User> index() throws Exception {
        return userService.findAllByParamsQuery(0, "bangkok");
        //return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/create")
    public String create() throws Exception {
        return "Method Get, Function : create => HTML Render Form Create Page";
    }

    @PostMapping(value = "")
    public String store(@RequestParam Map<String,String> inputs) throws Exception {
        System.out.println("########### POST Param ###########");
        System.out.println(inputs);

        return "Method Post, Function : store => Receive post param and INSERT data to DB";
    }

    @GetMapping(value = "/{id}")
    public Optional show(@PathVariable String id) throws Exception {
        //return "Method Get, Function : show, ID : "+ id +" => HTML Render Detail Page from DB by ID";

        Optional<User> user = userService.findById(Integer.parseInt(id));
        return user;
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable String id) throws Exception {
        return "Method Get, Function : edit, ID : "+ id +" => HTML Render Form Edit Page from DB by ID";
    }

    @PutMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String,String> inputs) throws Exception {
        System.out.println("########### PUT Param ###########");
        System.out.println(inputs);

        return "Method PUT, Function : update => Receive id and PUT param and UPDATE data to DB";
    }

    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id) throws Exception {
        return "Method DELETE, Function : destroy, ID : "+ id +" => Receive id and DELETE data to DB";
    }

}

