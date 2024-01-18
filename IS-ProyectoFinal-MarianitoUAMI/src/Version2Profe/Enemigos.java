/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Version2Profe;

import java.awt.Image;

/**
 *
 * @author artur
 */
public class Enemigos {
    int x;
    int y;
    
    int velocidad = 3;
    Image icon;
    int ancho;
    int alto;
    boolean muerto = false;
    boolean derecha = true;
    boolean izquierda = false;
    int img_M;
    String img_fondo;
    String tipo;
    
    public Enemigos(String nombre, int cx){
        
        if(nombre.equals("goomba")){
            ancho = alto = 48;
            this.x = cx;
            this.y = 400;
            this.tipo =  nombre;
            img_fondo = "goomba1.png";
            img_M = 6;
        }
        if(nombre.equals("koopa")){
            ancho = 48;
            alto = 78;
            this.x = cx;
            this.y = 370;
            this.tipo =  nombre;
            img_fondo = "koopa1.png";
            img_M = 41;
        }
    }
    
    public void mov(){
        if(derecha){
            x=x-velocidad;
        }
        if(izquierda){
            x=x+velocidad;
        }
    }
}
