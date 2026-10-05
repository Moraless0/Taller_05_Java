/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

public abstract class Personaje implements Mejorable {

    // Atributos protected para que las clases hijas puedan acceder
    protected String nombre;
    protected double puntosVida;
    protected double puntosVidaMax;
    protected double puntosAtaque;
    protected double puntosDefensa;
    protected int nivel;

    // Contador estático de personajes creados
    private static int totalPersonajesCreados;

    // Constructor parametrizado - uso de super(...) en clases hijas
    public Personaje(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVidaMax;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = 1;
        totalPersonajesCreados++;
    }

    // Método concreto para recibir daño
    public void recibirDano(double cantidad) {
        this.puntosVida -= cantidad;

        if (puntosVida < 0) {
            puntosVida = 0.0;
        }
    }

    // Método concreto para verificar si está vivo
    public boolean estaVivo() {
        if (puntosVida > 0.0) {
            return true;
        } else {
            return false;
        }
    }

    // Método protected para calcular daño base (usado por las clases hijas)
    protected double calcularDanoBase(Personaje objetivo) {
        double dano = this.puntosAtaque - objetivo.puntosDefensa;

        if (dano <= 0) {
            dano = 3.0;
        }

        return dano;
    }

    // Método concreto para subir de nivel (implementa la interface)
    @Override
    public void subirNivel() {
        this.nivel++;
        this.puntosVidaMax += 20.0;
        this.puntosAtaque += 5.0;
        this.puntosDefensa += 2.0;

        this.puntosVida = puntosVidaMax;

        // Llama al método default de la interface Mejorable
        mostrarMensajeNivel(nivel);
    }

    // Método concreto para mostrar estado del personaje
    public void mostrarEstado() {
        System.out.println("Tipo: " + getTipo());
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + puntosVida + " / " + puntosVidaMax);
        System.out.println("Ataque: " + puntosAtaque);
        System.out.println("Defensa: " + puntosDefensa);
    }

    // Método estático para obtener el total de personajes creados
    public static int getTotalPersonajesCreados() {
        return totalPersonajesCreados;
    }

    // Métodos abstractos - cada clase hija debe implementarlos a su manera (polimorfismo)
    public abstract void atacar(Personaje objetivo);

    public abstract void habilidadEspecial(Personaje objetivo);

    public abstract String getTipo();
}
