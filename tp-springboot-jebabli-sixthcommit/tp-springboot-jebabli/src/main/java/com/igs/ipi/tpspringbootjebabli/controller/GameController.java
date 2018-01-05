package com.igs.ipi.tpspringbootjebabli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootjebabli.PartieEnCours;
import com.igs.ipi.tpspringbootjebabli.model.GameModel;
import com.igs.ipi.tpspringbootjebabli.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	GameService gs = new GameService();
	private PartieEnCours partieEnCours;
	
	public  GameController(GameService gs, PartieEnCours partieEnCours) {
		this.gs = gs;
		this.partieEnCours = partieEnCours;
	}
	
	
	@GetMapping("/new")
	public ModelAndView newGame() {		
		GameModel gm = gs.newGame();
		partieEnCours.setGameModel(gm);	
		ModelAndView mav = new ModelAndView("game")
				.addObject("Joueur1",gs.newGame().getNom1())
				.addObject("Joueur2",gs.newGame().getNom2())
				.addObject("Jetons",gs.newGame().getJetons())
				.addObject("game", gm);		
		return mav;
	}
	
	@GetMapping("/drop/{i}")
	public ModelAndView drop(@PathVariable("i")Integer numColonne) {
		ModelAndView mav = new ModelAndView("game");
		GameModel gm = partieEnCours.getGameModel();
		int index = numColonne -1;
		gm.add(index);
		mav.addObject("game",gm);
		return mav;
		
	}
	
	
}

