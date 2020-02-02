package com.newbegin.project.newbegin.controller;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping("/")
    public String greeting(Model model) {

        LocalTime localTime = new LocalTime();

        String date = new LocalDate().toString();
        String time = localTime.getHourOfDay() + " : " + localTime.getMinuteOfHour();

        model.addAttribute("time", time);
        model.addAttribute("date", date);

        return "main";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
