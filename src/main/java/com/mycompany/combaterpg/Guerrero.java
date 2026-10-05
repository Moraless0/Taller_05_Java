/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

public class Guerrero extends Personaje implements Curable {

    // Atributo propio del Guerrero
    private double escudo;

    // Constructor parametrizado - usa super(...) para llamar al constructor de la clase padre
    public Guerrero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double escudo) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.escudo = escudo;
    }

    // Constructor predeterminado - usa this(...) para encadenar constructores
    public Guerrero() {
        this("Guerrero Novato", 120.0, 15.0, 8.0, 20.0);
    }

    // Sobrescribe atacar - polimorfismo por sobrescritura
    @Override
    public void atacar(Personaje objetivo) {
        double dano = calcularDanoBase(objetivo);
        objetivo.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + objetivo.nombre + " causando " + dano + " de daño.");
    }

    // Sobrescribe habilidadEspecial - polimorfismo por sobrescritura
    @Override
    public void habilidadEspecial(Personaje objetivo) {
        double dano = this.puntosAtaque * 1.5 - objetivo.puntosDefensa;

        if (dano <= 0) {
            dano = 3.0;
        }

        objetivo.recibirDano(dano);

        // El guerrero se lastima a sí mismo
        this.puntosVida -= 10.0;
        if (this.puntosVida < 1.0) {
            this.puntosVida = 1.0;
        }

        System.out.println(this.nombre + " usa Golpe Furioso contra " + objetivo.nombre + " causando " + dano + " de daño.");
    }

    // Sobrescribe recibirDano - el escudo absorbe primero el daño
    @Override
    public void recibirDano(double cantidad) {
        if (escudo >= cantidad) {
            escudo -= cantidad;
        } else {
            double danoRestante = cantidad - escudo;
            escudo = 0;
            super.recibirDano(danoRestante);
        }
    }

    // Implementa curar de la interface Curable
    @Override
    public void curar() {
        double vidaRecuperada = CURACION_BASE;
        puntosVida += vidaRecuperada;

        if (puntosVida > puntosVidaMax) {
            puntosVida = puntosVidaMax;
        }

        System.out.println(this.nombre + " se ha curado. Recuperó " + vidaRecuperada + " de vida. Vida actual: " + puntosVida);
    }

    // Sobrescribe subirNivel - usa super.método() para reutilizar código del padre
    @Override
    public void subirNivel() {
        super.subirNivel();
        this.escudo += 10.0;
    }

    // Sobrescribe mostrarEstado - usa super.método() y agrega información propia
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Escudo: " + escudo);
    }

    // Sobrescribe getTipo - polimorfismo por sobrescritura
    @Override
    public String getTipo() {
        return "Guerrero";
    }
}
