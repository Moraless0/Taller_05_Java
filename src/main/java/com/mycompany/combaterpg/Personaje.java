/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

/**
 *
 * @author abdielmorales
 */
public class Personaje {
    // Atributos
    String nombre;
    double puntosVida;
    double puntosVidaMax;
    double puntosAtaque;
    double puntosDefensa;
    int nivel;
    static int totalPersonajesCreados;
    
    // Constructores

    public Personaje(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVidaMax;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = 1;
        totalPersonajesCreados++;
    }
    
    public Personaje(){
        nombre = "Guerrero Novato";
        puntosVida = 100;
        puntosVidaMax = 100;
        puntosAtaque = 15;
        puntosDefensa = 5.0;
        nivel = 1;
        totalPersonajesCreados++;
    }
    
    public void recibirDano(double cantidad) {
        this.puntosVida -= cantidad;
        
        if (puntosVida < 0) {
            puntosVida = 0.0;
        }
    }
    
    public boolean estaVivo (){
        if (puntosVida > 0.0) {
            return true;
            
        }else
            return false;
    }
    
    public void curar() {
        puntosVida += 25.0;
        
        if (puntosVida > puntosVidaMax) {
            puntosVida = puntosVidaMax;
        }
        
        System.out.println("El personaje se ha curado. Vida actual: " + puntosVida);
    }
    
    public void atacar(Personaje objetivo){
        double danoAgravado;
        
        danoAgravado = this.puntosAtaque - objetivo.puntosDefensa;
        
        if (danoAgravado <= 0) {
            danoAgravado = 3.0;
        }
        
        objetivo.recibirDano(danoAgravado);
        
        System.out.println(this.nombre + " ha atacado a " + objetivo.nombre + " causando " + danoAgravado + " de daño.");
    }
    
    public void subirNivel (){

        this.nivel++;
        this.puntosVidaMax += 20;
        this.puntosAtaque += 5.0;
        this.puntosDefensa += 2.0;

        this.puntosVida = puntosVidaMax;

        System.out.println("El personaje ha subido a nivel " + nivel + " , puntos de vida han subido a " + puntosVidaMax + " los puntos de ataque han subido a " + puntosAtaque + " y puntos de defensa a " + puntosDefensa);

    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + puntosVida + " / " + puntosVidaMax);
        System.out.println("Ataque: " + puntosAtaque);
        System.out.println("Defensa: " + puntosDefensa);
    }

    public static int getTotalPersonajesCreados() {
        return totalPersonajesCreados;
    }
}
