package Version2;

import java.awt.Image;
import java.net.URL;

public class Marianito {
    int[] xp = {0,0,5,5,10,10,0,0,5,5,10,10,15,15,5,5,10,10,15,15,20,20,40,40,55,55,45,45,55,55,60,60,55,55,50,50,40,40,55,55,60,60,50,50,55,55,60,60,40,40,35,35,25,25,20,20};
    
    int[] yp = {448,443,443,438,438,433,433,413,413,408,408,403,403,398,398,383,383,378,378,373,373,368,368,373,373,378,378,383,383,388,388,393,393,398,398,403,403,408,408,
                413,413,433,433,438,438,443,443,448,448,438,438,433,433,438,438,448};
    
    int[] xc1 = {0,0,10,10,25,25,15,15,20,20,25,25,50,50,65,65,55,55,65,65,70,70,65,65,60,60,50,50,75,75,70,70,45,45,30,30,20,20,25,25,10,10,5,5,10,10,15,15,20,20,15,15,10,10};
    
    int[] yc1 = {423,408,408,403,403,398,398,383,383,373,373,368,368,373,373,378,378,383,383,388,388,393,393,398,398,403,403,408,408,410,410,438,438,433,433,438,438,443,443,
                448,448,443,443,433,433,420,420,423,423,413,413,418,418,423};
    
    int[] xc2 = {0,0,5,5,10,10,0,0,5,5,10,10,35,35,50,50,40,40,50,50,55,55,50,50,45,45,35,35,40,40,45,45,40,40,45,45,30,30,10,10,5,5};
    
    int[] yc2 = {428,408,408,403,403,398,398,383,383,373,373,368,368,373,373,378,378,383,383,388,388,393,393,398,398,403,403,408,408,413,413,420,420,438,438,443,443,448,448,433,433,428};
    
    int[] xs = {0,0,5,5,20,20,10,10,15,15,20,20,45,45,55,55,70,70,65,65,60,60,55,55,65,65,70,70,75,75,45,45,15,15,5,5,10,10,5,5};
    
    int[] ys = {428,418,418,413,413,408,408,393,393,383,383,378,378,383,383,378,378,403,403,413,413,418,418,423,423,418,418,413,413,438,438,443,443,448,448,438,438,433,433,428};
        
    int xp_i[];
    int yp_i[];
    int xc1_i[];
    int yc1_i[];
    int xc2_i[];
    int yc2_i[];
    int xs_i[];
    int ys_i[];
    
    int velocidad = 3;
    boolean saltando = false;
    boolean cayendo = false;
    boolean encima = false;
    boolean izquierda = false;
    boolean derecha = false;
    
    int vel_salto = 10;
    Image icon;
    URL url;
    String imgFondo[] = {"mario.png", "corre1.png", "corre2.png", "salta.png",
        "mario2.png", "corre3.png", "corre4.png", "salta2.png"
        };
    
    public Marianito(){
        xp_i = new int [xp.length];
        yp_i = new int [yp.length];
        xc1_i = new int [xc1.length];
        yc1_i = new int [yc1.length];
        xc2_i = new int [xc2.length];
        yc2_i = new int [yc2.length];
        xs_i = new int [xs.length];
        ys_i = new int [ys.length];
        
        for(int i=0;i<xp.length;i++){
            xp_i[i]=60-xp[i];
            yp_i[i]=yp[i];
        }
        for(int i=0;i<xc1.length;i++){
            xc1_i[i]=75-xc1[i];
            yc1_i[i]=yc1[i];
        }
        for(int i=0;i<xc2.length;i++){
            xc2_i[i]=55-xc2[i];
            yc2_i[i]=yc2[i];
        }
        for(int i=0;i<xs.length;i++){
            xs_i[i]=75-xs[i];
            ys_i[i]=ys[i];
        }
    }
    
    public void mov_derecha(){  
        for(int i=0;i<xp.length;i++){
            xp[i]=xp[i]+velocidad;
            xp_i[i]=xp_i[i]+velocidad;
        }
        for(int i=0;i<xc1.length;i++){
            xc1[i]=xc1[i]+velocidad;
            xc1_i[i]=xc1_i[i]+velocidad;
        }
        for(int i=0;i<xc2.length;i++){
            xc2[i]=xc2[i]+velocidad;
            xc2_i[i]=xc2_i[i]+velocidad;
        }
        for(int i=0;i<xs.length;i++){
            xs[i]=xs[i]+velocidad;
            xs_i[i]=xs_i[i]+velocidad;
        }
    }
    public void mov_izquierda(){
        
        for(int i=0;i<xp.length;i++){
            xp[i]=xp[i]-velocidad;
            xp_i[i]=xp_i[i]-velocidad;
        }
        for(int i=0;i<xc1.length;i++){
            xc1[i]=xc1[i]-velocidad;
            xc1_i[i]=xc1_i[i]-velocidad;
        }
        for(int i=0;i<xc2.length;i++){
            xc2[i]=xc2[i]-velocidad;
            xc2_i[i]=xc2_i[i]-velocidad;
        }
        for(int i=0;i<xs.length;i++){
            xs[i]=xs[i]-velocidad;
            xs_i[i]=xs_i[i]-velocidad;
        }
    }
    public void salto(){   
        for(int i=0;i<yp.length;i++){
            yp[i]=yp[i]-vel_salto;
            yp_i[i]=yp_i[i]-vel_salto;
        }
        for(int i=0;i<yc1.length;i++){
            yc1[i]=yc1[i]-vel_salto;
            yc1_i[i]=yc1_i[i]-vel_salto;
        }
        for(int i=0;i<yc2.length;i++){
            yc2[i]=yc2[i]-vel_salto;
            yc2_i[i]=yc2_i[i]-vel_salto;
        }
        for(int i=0;i<xs.length;i++){
            ys[i]=ys[i]-vel_salto;
            ys_i[i]=ys_i[i]-vel_salto;
        }
    }
    public void caida(){    
        for(int i=0;i<yp.length;i++){
            yp[i]=yp[i]+vel_salto;
            yp_i[i]=yp_i[i]+vel_salto;
        }
        for(int i=0;i<yc1.length;i++){
            yc1[i]=yc1[i]+vel_salto;
            yc1_i[i]=yc1_i[i]+vel_salto;
        }
        for(int i=0;i<yc2.length;i++){
            yc2[i]=yc2[i]+vel_salto;
            yc2_i[i]=yc2_i[i]+vel_salto;
        }
        for(int i=0;i<xs.length;i++){
            ys[i]=ys[i]+vel_salto;
            ys_i[i]=ys_i[i]+vel_salto;
        }
    }
}
