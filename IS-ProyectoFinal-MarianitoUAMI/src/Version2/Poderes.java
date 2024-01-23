
package Version2;

import java.awt.Image;
import java.awt.Rectangle;

public class Poderes {
    int x, y;//posicion
    int largo, ancho;
    int velX = 3;
    int velY = 3;
    String tipo;
    boolean cayendo = false;
    boolean derecha = true;
    boolean izquierda = false;
    boolean choca = true;
    
    Image icon;
    String img_fondo;
    Rectangle r;
    
    public Poderes(int x, int y){
        this.x = x;
        this.y = y;
        largo = 46;
        ancho = 50;
        r = new Rectangle(x, y, largo, ancho);
        img_fondo = "hongo.png";
    }
    
    void mov(){
        if(derecha){
            x = x + velX;
        }
        if(cayendo){
            y = y + velY;
        }
        if(izquierda){
            x = x - velX;
        }
    }
}
