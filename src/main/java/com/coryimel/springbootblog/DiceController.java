package com.coryimel.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {
    private Random generator = new Random();

    @GetMapping("/roll-dice")
    public String landing(Model model) {
        return "landing";
    }

    @GetMapping("/roll-dice/{n}")
    public String thisRoll(@PathVariable String n,  Model model){
        model.addAttribute("guess", n);
        System.out.println(n);
        model.addAttribute("rolls", rollDice());
        return "this-roll";
    }

    private List<Integer> rollDice() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            rolls.add(generator.nextInt(6) + 1);
        }
       return rolls;
    }


}
