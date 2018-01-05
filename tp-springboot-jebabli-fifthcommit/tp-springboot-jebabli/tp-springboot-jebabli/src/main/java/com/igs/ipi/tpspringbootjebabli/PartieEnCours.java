package com.igs.ipi.tpspringbootjebabli;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.igs.ipi.tpspringbootjebabli.model.GameModel;

@SessionScope 
@Component
public class PartieEnCours {

	private GameModel gm;

	public void setGameModel(GameModel gameModel) {
		// TODO Auto-generated method stub
		
	}
	
}
