package com.igs.ipi.tpspringbootjebabli.model;

public enum Jeton {
    ROUGE, BLEU, VIDE;

    public String getCode() {

        switch (this) {
            case ROUGE:
                return "jeton rouge.png";
            case BLEU:
                return "jeton bleu.png";
            default:
                return null;
        }
    }
}