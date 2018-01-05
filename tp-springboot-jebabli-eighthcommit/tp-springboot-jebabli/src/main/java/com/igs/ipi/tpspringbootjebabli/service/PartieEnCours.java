package com.igs.ipi.tpspringbootjebabli.service;

import com.igs.ipi.tpspringbootjebabli.model.GameModel;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours{
	
	private GameModel gm;
	
	public GameModel getGameModel() {
		return gm;
	}
	
	public void setGameModel(GameModel gm) {
		this.gm = gm;
	}
}


