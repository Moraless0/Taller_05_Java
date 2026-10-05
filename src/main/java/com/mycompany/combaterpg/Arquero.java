/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

public class Arquero extends Personaje {

    // Atributo propio del Arquero
    private int precision;

    // Constructor parametrizado - usa super(...) para llamar al constructor de la clase padre
    public Arquero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, int precision) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.precision = precision;
    }

    // Constructor predeterminado - usa this(...) para encadenar constructores
    public Arquero() {
        this("Arquero Novato", 90.0, 18.0, 4.0, 40);
    }

    // Sobrescribe atacar - puede hacer golpe crítico según precisión
    @Override
    public void atacar(Personaje objetivo) {
        double numeroAleatorio = Math.random() * 100;

        if (numeroAleatorio < precision) {
            // Golpe crítico
            Batalla.ejecutarAtaqueCritico(this, objetivo, 1.5);
        } else {
            // Ataque normal
            double dano = calcularDanoBase(objetivo);
            objetivo.recibirDano(dano);
            System.out.println(this.nombre + " ataca a " + objetivo.nombre + " causando " + dano + " de daño.");
        }
    }

    // Sobrescribe habilidadEspecial - Lluvia de Flechas
    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println(this.nombre + " usa Lluvia de Flechas contra " + objetivo.nombre + ":");

        for (int i = 1; i <= 3; i++) {
            double dano = this.puntosAtaque * 0.6 - objetivo.puntosDefensa;

            if (dano <= 0) {
                dano = 3.0;
            }

            objetivo.recibirDano(dano);
            System.out.println("  Impacto " + i + ": " + dano + " de daño.");
        }
    }

    // Sobrescribe subirNivel - usa super.método() para reutilizar código del padre
    @Override
    public void subirNivel() {
        super.subirNivel();
        this.precision += 3;

        if (this.precision > 95) {
            this.precision = 95;
        }
    }

    // Sobrescribe mostrarEstado - usa super.método() y agrega información propia
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Precisión: " + precision + "%");
    }

    // Sobrescribe getTipo - polimorfismo por sobrescritura
    @Override
    public String getTipo() {
        return "Arquero";
    }
}
