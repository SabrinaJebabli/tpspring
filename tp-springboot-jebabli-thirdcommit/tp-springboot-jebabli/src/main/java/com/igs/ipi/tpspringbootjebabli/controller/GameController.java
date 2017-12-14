package com.igs.ipi.tpspringbootjebabli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootjebabli.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController { 	
	
	GameService gs = new GameService();
	
	@GetMapping("/new")
	public ModelAndView newGame() {		
		
		ModelAndView mav = new ModelAndView("game")
				.addObject("Joueur1",gs.newGame().getNom1())
				.addObject("Joueur2",gs.newGame().getNom2());
		
		return mav;
	}
	
}

