package com.igs.ipi.tpspringbootjebabli.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootjebabli.model.GameModel;

@Service
public class GameService {
	
	public GameModel newGame() {
		GameModel gm = new GameModel();
		gm.setNom1("Sabrina");
		gm.setNom2("JS021");
		return gm;
	}
}
