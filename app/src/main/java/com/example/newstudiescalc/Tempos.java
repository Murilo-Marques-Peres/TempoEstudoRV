package com.example.newstudiescalc;

public class Tempos {
    private int primeiroHora;
    private int primeiroMinuto;
    private int segundoHora;
    private int segundoMinuto;

    public Tempos(int primeiroHora, int primeiroMinuto, int segundoHora, int segundoMinuto){
        this.primeiroHora = primeiroHora;
        this.primeiroMinuto = primeiroMinuto;
        this.segundoHora = segundoHora;
        this.segundoMinuto = segundoMinuto;
    }

    public int getPrimeiroHora() {
        return primeiroHora;
    }

    public void setPrimeiroHora(int primeiroHora) {
        this.primeiroHora = primeiroHora;
    }

    public int getPrimeiroMinuto() {
        return primeiroMinuto;
    }

    public void setPrimeiroMinuto(int primeiroMinuto) {
        this.primeiroMinuto = primeiroMinuto;
    }

    public int getSegundoHora() {
        return segundoHora;
    }

    public void setSegundoHora(int segundoHora) {
        this.segundoHora = segundoHora;
    }

    public int getSegundoMinuto() {
        return segundoMinuto;
    }

    public void setSegundoMinuto(int segundoMinuto) {
        this.segundoMinuto = segundoMinuto;
    }
}
