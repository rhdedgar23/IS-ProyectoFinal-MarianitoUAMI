
package Version2;

import java.awt.Image;


public class Enemigos {
    int x, y;
    int ancho, alto;
    int velocidad = 3;
    boolean muerto = false;
    boolean derecha = true;
    boolean izquierda = false;
    
    int img_M;
    Image icon;
    String img_fondo;
    String tipo;
    
    public Enemigos(String nombre, int cx){
        if(nombre.equals("goomba")){
            ancho = alto = 48;
            this.x = cx;//posicion x en la que quieres que empiece
            this.y = 400;
            this.tipo = nombre;
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
            x = x - velocidad;
        }
        if(izquierda){
            x= x + velocidad;
        }
    }
}
