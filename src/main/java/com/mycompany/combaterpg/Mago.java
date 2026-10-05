/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

public class Mago extends Personaje implements Curable {

    // Atributos propios del Mago
    private double mana;
    private double manaMax;

    // Constructor parametrizado - usa super(...) para llamar al constructor de la clase padre
    public Mago(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double mana) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.mana = mana;
        this.manaMax = mana;
    }

    // Constructor predeterminado - usa this(...) para encadenar constructores
    public Mago() {
        this("Mago Aprendiz", 80.0, 20.0, 2.0, 100.0);
    }

    // Sobrescribe atacar - Rayo Arcano
    @Override
    public void atacar(Personaje objetivo) {
        double dano;

        if (mana >= 5.0) {
            mana -= 5.0;
            dano = this.puntosAtaque - (objetivo.puntosDefensa / 2);

            if (dano <= 0) {
                dano = 3.0;
            }

            System.out.println(this.nombre + " lanza Rayo Arcano contra " + objetivo.nombre + " causando " + dano + " de daño.");
        } else {
            dano = 3.0;
            System.out.println(this.nombre + " no tiene suficiente maná. Causa " + dano + " de daño básico.");
        }

        objetivo.recibirDano(dano);
    }

    // Sobrescribe habilidadEspecial - Bola de Fuego
    @Override
    public void habilidadEspecial(Personaje objetivo) {
        if (mana >= 30.0) {
            mana -= 30.0;
            double dano = this.puntosAtaque * 2;
            objetivo.recibirDano(dano);
            System.out.println(this.nombre + " lanza una Bola de Fuego contra " + objetivo.nombre + " causando " + dano + " de daño.");
        } else {
            System.out.println(this.nombre + " no tiene suficiente maná para Bola de Fuego. Usa ataque básico.");
            atacar(objetivo);
        }
    }

    // Implementa curar de la interface Curable
    @Override
    public void curar() {
        if (mana >= 20.0) {
            mana -= 20.0;
            double vidaRecuperada = CURACION_BASE + 5.0;
            puntosVida += vidaRecuperada;

            if (puntosVida > puntosVidaMax) {
                puntosVida = puntosVidaMax;
            }

            System.out.println(this.nombre + " se ha curado. Recuperó " + vidaRecuperada + " de vida. Vida actual: " + puntosVida);
        } else {
            System.out.println(this.nombre + " no tiene suficiente maná para curarse.");
        }
    }

    // Sobrescribe subirNivel - usa super.método() para reutilizar código del padre
    @Override
    public void subirNivel() {
        super.subirNivel();
        this.manaMax += 20.0;
        this.mana = manaMax;
    }

    // Sobrescribe mostrarEstado - usa super.método() y agrega información propia
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Maná: " + mana + " / " + manaMax);
    }

    // Sobrescribe getTipo - polimorfismo por sobrescritura
    @Override
    public String getTipo() {
        return "Mago";
    }
}
