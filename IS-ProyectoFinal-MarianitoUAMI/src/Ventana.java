
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel{
    LinkedList<Bloques> ListaBloques;
    String imgFondo;
    URL url;
    Marianito M;
    Polygon marianito;
    int avanceX;
    int avanceY;
    int sec; 
    Image icons[];
    
    public Ventana() {
        this.ListaBloques = new LinkedList();
        this.imgFondo = "mundo.png";
        this.url = Ventana.class.getResource(imgFondo);
        this.M = new Marianito();
        this.marianito = new Polygon();
        this.avanceX = 0;
        this.avanceY = 0;
        this.sec = 0;
        this.icons = new Image[3];
        
        marianito.xpoints = M.xp;
        marianito.ypoints = M.yp;
        marianito.npoints = M.xp.length;
        
        ListaBloques.add(new Bloques("Ladrillo", 800, 168));
        ListaBloques.add(new Bloques("Ladrillo_plano", 860, 168));
        ListaBloques.add(new Bloques("Tuberia", 1000, 307));

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.drawImage(icons[0], 0-avanceX, 0, null);
        g.drawImage(icons[1], 1024-avanceX, 0, null);
        g.drawImage(icons[2], 2048-avanceX, 0, null);
        
        for(int i=0; i<ListaBloques.size(); i++){
            g.drawImage(ListaBloques.get(i).icon, ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y, null);
            g.drawRect(ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y, ListaBloques.get(i).ancho, ListaBloques.get(i).largo);
            if(ListaBloques.get(i).tipo.equals("Tuberia")){
                g.drawRect(ListaBloques.get(i).x2-avanceX, ListaBloques.get(i).y2, ListaBloques.get(i).ancho2, ListaBloques.get(i).largo2);
            }
        }
        
        if(M.saltando){
            avanceY = avanceY - M.vel_salto;
            M.salto();
            if(avanceY == -200){
                M.saltando = false;
                M.cayendo = true;
            }
        }
        if(M.cayendo){
            avanceY = avanceY + M.vel_salto;
            M.caida();
            if(avanceY == 0){
                M.cayendo = false;
                movimiento("Parado");
            }
        }
        if(M.cayendo || M.saltando){
            g.drawImage(M.icon, avanceX, 378+avanceY, null);
        }
        else{
            g.drawImage(M.icon, avanceX, 368+avanceY, null);
        }
        g.drawPolygon(marianito);
    }
    
    public void imagenesFondo(){
        icons[0] = new ImageIcon(url).getImage();
        icons[1] = new ImageIcon(url).getImage();
        icons[2] = new ImageIcon(url).getImage();
        
        for(int i=0; i<ListaBloques.size(); i++){
            url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
            ListaBloques.get(i).icon = new ImageIcon(url).getImage();
        }
        
        url = Ventana.class.getResource(M.imgFondo[0]);
        M.icon = new ImageIcon(url).getImage();
    }
    public void movimiento(String direccion){
        switch(direccion){
            case "Derecha":
                sec++;
                M.mov_derecha();
                //if(!choca()){
                avanceX += M.velocidad;
                //}
                if(!M.saltando && !M.cayendo){
                    if(sec % 2 == 0){
                        marianito.xpoints = M.xc2;
                        marianito.ypoints = M.yc2;
                        marianito.npoints = M.xc2.length;
                        url = Ventana.class.getResource(M.imgFondo[2]);
                    }
                    else{
                        marianito.xpoints = M.xc1;
                        marianito.ypoints = M.yc1;
                        marianito.npoints = M.xc1.length;
                        url = Ventana.class.getResource(M.imgFondo[1]);
                    }
                }else{
                    marianito.xpoints = M.xs;
                    marianito.ypoints = M.ys;
                    marianito.npoints = M.xs.length;
                    url = Ventana.class.getResource(M.imgFondo[3]);
                }
                
                M.icon = new ImageIcon(url).getImage();
                break;
            case "Izquierda":
                if(avanceX > 0){
                    sec++;
                    M.mov_izquierda();
                    avanceX = avanceX - M.velocidad;
                    if(!M.saltando && !M.cayendo){
                        if(sec % 2 == 0){
                            marianito.xpoints = M.xc2_i;
                            marianito.ypoints = M.yc2_i;
                            marianito.npoints = M.xc2_i.length;
                            url = Ventana.class.getResource(M.imgFondo[6]);
                        }
                        else{
                            marianito.xpoints = M.xc1_i;
                            marianito.ypoints = M.yc1_i;
                            marianito.npoints = M.xc1.length;
                            url = Ventana.class.getResource(M.imgFondo[5]);
                        }
                    }else{
                        marianito.xpoints = M.xs_i;
                        marianito.ypoints = M.ys_i;
                        marianito.npoints = M.xs_i.length;
                        url = Ventana.class.getResource(M.imgFondo[7]);
                    }
                    
                    M.icon = new ImageIcon(url).getImage();
                }
                break;
            case "Parado":
                sec = 0;
                if(!M.saltando && !M.cayendo){
                    marianito.xpoints = M.xp;
                    marianito.ypoints = M.yp;
                    marianito.npoints = M.xp.length;
                    url = Ventana.class.getResource(M.imgFondo[0]);
                    M.icon = new ImageIcon(url).getImage();
                }
                break;
            case "Parado2":
                sec = 0;
                if(!M.saltando && !M.cayendo){
                    marianito.xpoints = M.xp_i;
                    marianito.ypoints = M.yp_i;
                    marianito.npoints = M.xp_i.length;
                    url = Ventana.class.getResource(M.imgFondo[4]);
                    M.icon = new ImageIcon(url).getImage();
                }
                break;
            case "Arriba":
                if(!M.cayendo){
                    M.saltando = true;
                    marianito.xpoints = M.xs;
                    marianito.ypoints = M.ys;
                    marianito.npoints = M.xs.length;
                    url = Ventana.class.getResource(M.imgFondo[3]);
                    M.icon = new ImageIcon(url).getImage();
                }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        JFrame VentanaJuego = new JFrame("Marianito UAMI");
        VentanaJuego.setSize(1324, 650);
        VentanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Ventana juego = new Ventana();
        VentanaJuego.add(juego);
        VentanaJuego.setVisible(true);
        juego.imagenesFondo();
        
        VentanaJuego.addKeyListener(new KeyListener(){
            String tecla;
            
            @Override
            public void keyReleased(KeyEvent e){
                tecla = e.getKeyText(e.getKeyCode());
                if(tecla.equals("Derecha") || tecla.equals("Right")){
                    juego.movimiento("Parado");
                }
                if(tecla.equals("Izquierda") || tecla.equals("Left")){
                    juego.movimiento("Parado2");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyPressed(KeyEvent e) {
                tecla = e.getKeyText(e.getKeyCode());
                if(tecla.equals("Derecha") || tecla.equals("Right")){
                    juego.movimiento("Derecha");
                }
                if(tecla.equals("Izquierda") || tecla.equals("Left")){
                    juego.movimiento("Izquierda");
                }
                if(tecla.equals("Arriba") || tecla.equals("Up")){
                    juego.movimiento("Arriba");
                }
            }
        });
        
        while(true){
            juego.repaint();
            Thread.sleep(51);
        }
    }

}
