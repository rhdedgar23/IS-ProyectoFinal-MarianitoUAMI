package Version2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    
    LinkedList <Poderes> ListaPoderes;
    int puntaje = 0;
    int vidas = 0;
    int tiempo = 1000;
    AudioClip musica;
    boolean choca[];
    int alturaSalto = 0;
    int sec2 = 0;
    int cont = 0;
    
    LinkedList <Enemigos> ListaEnemigos;
    boolean termina = false;
    
    public Ventana() {
        this.ListaBloques = new LinkedList();
        this.imgFondo = "mundo.png";
        this.url = Ventana.class.getResource(imgFondo);
        this.M = new Marianito();
        this.marianito = new Polygon();
        this.avanceX = 0;//avance de marianito en x
        this.avanceY = 0;//avance de marianito en y 
        this.sec = 0;//avance de la secuencia de movimiento de marianito
        this.icons = new Image[3];
        
        choca=new boolean[4];
        choca[0]=false;
        choca[1]=false;
        choca[2]=false;
        choca[3]=false;
        ListaPoderes = new LinkedList();
        
        ListaEnemigos = new LinkedList();
        
        marianito.xpoints = M.xp;
        marianito.ypoints = M.yp;
        marianito.npoints = M.xp.length;
        
        ListaBloques.add(new Bloques("Ladrillo", 640, 168, false));
        ListaEnemigos.add(new Enemigos("goomba", 640));
        ListaBloques.add(new Bloques("Moneda", 700, 168, true));
        ListaBloques.add(new Bloques("Ladrillo", 760, 168, false));
        ListaEnemigos.add(new Enemigos("goomba", 760));
        ListaBloques.add(new Bloques("Tuberia", 1000, 307, false));
        ListaEnemigos.add(new Enemigos("goomba", 1200));
        ListaEnemigos.add(new Enemigos("koopa", 1300));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1250, 168, false));
        ListaBloques.add(new Bloques("Moneda", 1310, 168, true));
        ListaBloques.add(new Bloques("Ladrillo", 1370, 168, false));
        ListaBloques.add(new Bloques("Tuberia", 1500, 307, false));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1700, 168, false));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1760, 168, false));
        ListaBloques.add(new Bloques("Ladrillo", 1820, 168, false));

    }
    
    public void reset(){
        this.ListaBloques = new LinkedList();
        this.imgFondo = "mundo.png";
        this.url = Ventana.class.getResource(imgFondo);
        this.M = new Marianito();
        this.marianito = new Polygon();
        this.avanceX = 0;//avance de marianito en x
        this.avanceY = 0;//avance de marianito en y 
        this.sec = 0;//avance de la secuencia de movimiento de marianito
        this.icons = new Image[3];
        
        choca=new boolean[4];
        choca[0]=false;
        choca[1]=false;
        choca[2]=false;
        choca[3]=false;
        ListaPoderes = new LinkedList();
        
        ListaEnemigos = new LinkedList();
        
        marianito.xpoints = M.xp;
        marianito.ypoints = M.yp;
        marianito.npoints = M.xp.length;
        
        ListaBloques.add(new Bloques("Ladrillo", 640, 168, false));
        ListaBloques.add(new Bloques("Moneda", 700, 168, true));
        ListaBloques.add(new Bloques("Ladrillo", 760, 168, false));
        ListaBloques.add(new Bloques("Tuberia", 1000, 307, false));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1250, 168, false));
        ListaBloques.add(new Bloques("Moneda", 1310, 168, true));
        ListaBloques.add(new Bloques("Ladrillo", 1370, 168, false));
        ListaBloques.add(new Bloques("Tuberia", 1500, 307, false));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1700, 168, false));
        ListaBloques.add(new Bloques("Ladrillo_plano", 1760, 168, false));
        ListaBloques.add(new Bloques("Ladrillo", 1820, 168, false));
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        sec2 ++;
        cont += 50;
        if(cont % 1000 == 0){
            tiempo--;
        }
        
        g.drawImage(icons[0], 0-avanceX, 0, null);
        g.drawImage(icons[1], 1024-avanceX, 0, null);
        g.drawImage(icons[2], 2048-avanceX, 0, null);
        
        //dibujamos los datos
        Font fuente = new Font("Source Code Pro Black", Font.BOLD, 25);
        g.setFont(fuente);
        g.drawString("MUNDO", 40, 30);
        g.drawString("1-1", 40, 60);
        g.drawString("MARIO", 300, 30);
        g.drawString(""+vidas, 300, 60);
        g.drawString("MONEDAS", 600, 30);
        g.drawString("" + puntaje, 600, 60);
        g.drawString("TIEMPO", 1000, 30);
        g.drawString(""+tiempo, 1000, 60);
        
        //para cada elemento en ListaBloques
        for (int i=0; i<ListaBloques.size(); i++) {
            //dibujamos el rectangulo envolvente
            g.drawRect(ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y, ListaBloques.get(i).ancho, ListaBloques.get(i).largo);
            
            //si el elemento es una tuberia
            if(ListaBloques.get(i).tipo.equals("Tuberia")){
                g.drawRect(ListaBloques.get(i).x2-avanceX, ListaBloques.get(i).y2, ListaBloques.get(i).ancho2, ListaBloques.get(i).largo2);
            }
            //si el elemento es un ladrillo Moneda
            if(ListaBloques.get(i).tipo.equals("Moneda")){
                if(sec2 <= 7){
                    ListaBloques.get(i).img_fondo = "Moneda.png";
                    url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
                    ListaBloques.get(i).icon = new ImageIcon(url).getImage();  
                }else{
                    ListaBloques.get(i).img_fondo = "Moneda2.png";
                    url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
                    ListaBloques.get(i).icon = new ImageIcon(url).getImage(); 
                }
            }
            
            g.drawImage(ListaBloques.get(i).icon, ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y, null);
        }
        
        //para cada elemento en la lista poderes
        for(int i = 0; i < ListaPoderes.size(); i++){
            //obtenemos su url y lo dibujamos
            url = Ventana.class.getResource(ListaPoderes.get(i).img_fondo);
            ListaPoderes.get(i).icon = new ImageIcon(url).getImage(); 
            g.drawImage(ListaPoderes.get(i).icon, ListaPoderes.get(i).x-avanceX,ListaPoderes.get(i).y, null);
            
            Rectangle re = new Rectangle(ListaPoderes.get(i).x-avanceX,ListaPoderes.get(i).y,ListaPoderes.get(i).largo,ListaPoderes.get(i).ancho);
            
            //para cada elemento en la lista bloques
            for (int j = 0; j < ListaBloques.size(); j++) {
                //si el elemento es una tuberia
                if(ListaBloques.get(j).tipo.equals("Tuberia")){
                    //y si intersecta con el rectangulo que envuelve al poder
                    if(re.intersects(ListaBloques.get(j).x2-avanceX, ListaBloques.get(j).y2, ListaBloques.get(j).ancho2, ListaBloques.get(j).largo2)){
                        //y si el poder va hacia la derecha
                            if(ListaPoderes.get(i).derecha){
                                ListaPoderes.get(i).derecha = false;
                                ListaPoderes.get(i).izquierda = true;
                        }
                    }
                }
                // si no es una tuberia pero aun asi intersecta con el rectangulo que envuelve al poder
                if(re.intersects(ListaBloques.get(j).x-avanceX, ListaBloques.get(j).y, ListaBloques.get(j).ancho, ListaBloques.get(j).largo)){
                    ListaPoderes.get(i).choca = true;
                    //si el poder va cayendo
                    if(ListaPoderes.get(i).cayendo){
                        ListaPoderes.get(i).derecha = true;
                        ListaPoderes.get(i).cayendo = false;
                    }
                }
            }
            //si el poder no esta chocando 
            if(!ListaPoderes.get(i).choca){
                //y va hacia la derecha y esta menor su altura que la altura de mario
                if(ListaPoderes.get(i).derecha && ListaPoderes.get(i).y < 448){
                    ListaPoderes.get(i).derecha = false;
                    ListaPoderes.get(i).cayendo = true;
                    break;
                }
                //si esta por encima de mario, cayendo 
                if(ListaPoderes.get(i).y + ListaPoderes.get(i).largo >= 448){
                    //y no esta yendo hacia la izquierda
                    if(!ListaPoderes.get(i).izquierda){
                        ListaPoderes.get(i).derecha = true;
                    } 
                    else{
                        ListaPoderes.get(i).derecha = false;
                    }
                    ListaPoderes.get(i).cayendo = false;
                }
            }
            
            ListaPoderes.get(i).choca = false;
            ListaPoderes.get(i).mov();
            
            if(marianito.intersects(re)){
                if(ListaPoderes.get(i).img_fondo.equals("hongo.png")){
                    vidas++;
                    url = Ventana.class.getResource("vida.wav"); 
                    musica = Applet.newAudioClip(url);
                    musica.play();
                    ListaPoderes.remove(i);
                }
            }
        }
        for (int i = 0; i < ListaEnemigos.size(); i++) {
            int d = 1;
            if(!ListaEnemigos.get(i).muerto){
                if(ListaEnemigos.get(i).tipo.equals("koopa")){
                    if(ListaEnemigos.get(i).derecha){
                    d=1;
                    }else{
                        d=3;
                    }
                }
                if(sec2 <= 7){
                    ListaEnemigos.get(i).img_fondo = ListaEnemigos.get(i).tipo + (d+".png");
                    url = Ventana.class.getResource(ListaEnemigos.get(i).img_fondo);
                    ListaEnemigos.get(i).icon = new ImageIcon(url).getImage();  
                }else{
                    ListaEnemigos.get(i).img_fondo = ListaEnemigos.get(i).tipo + (d+1)+".png";
                    url = Ventana.class.getResource(ListaEnemigos.get(i).img_fondo);
                    ListaEnemigos.get(i).icon = new ImageIcon(url).getImage(); 
                }
                g.drawImage(ListaEnemigos.get(i).icon, ListaEnemigos.get(i).x-avanceX,ListaEnemigos.get(i).y, null);  
                Rectangle re = new Rectangle(ListaEnemigos.get(i).x-avanceX,ListaEnemigos.get(i).y,ListaEnemigos.get(i).alto,ListaEnemigos.get(i).ancho);
                for(int j = 0; j<ListaBloques.size(); j++){
                    if(ListaBloques.get(j).tipo.equals("Tuberia")){
                        if(re.intersects(ListaBloques.get(j).x2-avanceX, ListaBloques.get(j).y2, ListaBloques.get(j).ancho2, ListaBloques.get(j).largo2)){
                            if(ListaEnemigos.get(i).derecha){
                                ListaEnemigos.get(i).derecha = false;
                                ListaEnemigos.get(i).izquierda = true;
                            }else{
                                ListaEnemigos.get(i).derecha = true;
                                ListaEnemigos.get(i).izquierda = false;
                            }
                            break;
                        }
                    }
                }
                ListaEnemigos.get(i).mov();
                if(marianito.intersects(ListaEnemigos.get(i).x-avanceX, ListaEnemigos.get(i).y, 48, 48)){
                    if(avanceY==0){
                        url = Ventana.class.getResource("muerte.wav"); 
                        musica = Applet.newAudioClip(url);
                        musica.play();
                        termina = true;
                    }else{
                        ListaEnemigos.get(i).muerto = true;
                        
                    }
                }
            }else{
                ListaEnemigos.get(i).img_fondo = ListaEnemigos.get(i).tipo + "_M.png";
                url = Ventana.class.getResource(ListaEnemigos.get(i).img_fondo);
                ListaEnemigos.get(i).icon = new ImageIcon(url).getImage();
                g.drawImage(ListaEnemigos.get(i).icon, ListaEnemigos.get(i).x-avanceX,448-ListaEnemigos.get(i).img_M, null);
            }
        }
        
        
        if(M.saltando){
            movimiento("Arriba");
        }
        if(M.cayendo){
            movimiento("Abajo");
        }
        if(M.cayendo || M.saltando){
            g.drawImage(M.icon, avanceX, 378+avanceY, null);
        }
        else{
            g.drawImage(M.icon, avanceX, 368+avanceY, null);
        }
        g.drawPolygon(marianito);
        if(sec2 == 14){
            sec2 = 0;
        }
    }
    
    public void colision(){
        //para cada elemento en la lista bloques
        for(int i=0; i<ListaBloques.size(); i++){
            System.out.println("Elemento de la lista Bloques");
            //si el elemento es una tuberia
            if(ListaBloques.get(i).tipo.equals("Tuberia")){
                System.out.println("Tuberia");
                
                if(marianito.intersects(ListaBloques.get(i).x2-avanceX, ListaBloques.get(i).y2, ListaBloques.get(i).ancho2, ListaBloques.get(i).largo2)){
                    System.out.println("Mario intersecta Tuberia");
                    if(M.derecha){
                        choca[2] = true;
                        break;
                    }
                    if(M.izquierda){
                        choca[3] = true;
                        break;
                    }
                }
                if(marianito.intersects(ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y-10, ListaBloques.get(i).ancho+10, ListaBloques.get(i).largo+10)){
                    
                    if(M.saltando){
                        System.out.println((448 + avanceY) + " " + (ListaBloques.get(i).y + 70));
                        if(448 + avanceY == ListaBloques.get(i).y+70){
                            M.saltando=false;
                            M.cayendo=true;
                            break;
                        }
                    }
                    if(M.cayendo){
                        if(448 + avanceY - 11 == ListaBloques.get(i).y-10){
                            M.cayendo = false;
                            M.encima = true;
                            alturaSalto = 0;
                            break;
                        }
                    }
                }
            }
            //si el elemento no es una tuberia, es un ladrillo 
            else{
                //si se intersectan los poligonos
                if(marianito.intersects(ListaBloques.get(i).x-avanceX, ListaBloques.get(i).y-10, ListaBloques.get(i).ancho, ListaBloques.get(i).largo+10)){              
                    System.out.println("Mario intersecta bloque");
                    //si Mario esta saltando
                    if(M.saltando){
                            //si la altura de Mario + su avance en Y - la altura del bloque == la posicion del bloque en Y + su altura (la parte inferior del bloque)
                            if(448 + avanceY - 60 == ListaBloques.get(i).y + 60){
                                M.saltando = false;
                                M.cayendo = true;
                                
                                //si en ese brinco se encuentra con un ladrillo moneda
                                if(ListaBloques.get(i).tipo.equals("Moneda")){
                                    //aumentamos el puntuaje
                                    puntaje ++;
                                    
                                    //tocamos la musica
                                    url = Ventana.class.getResource("moneda.wav"); 
                                    musica = Applet.newAudioClip(url);
                                    musica.play();
                                    
                                    //cambiamos el estado del ladrillo
                                    ListaBloques.get(i).tipo = "Ladrillo_plano";
                                    ListaBloques.get(i).img_fondo = "Ladrillo_plano.png";
                                    url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
                                    ListaBloques.get(i).icon = new ImageIcon(url).getImage();
                                }
                                //si en el brinco se encuentra con una ladrillo
                                if(ListaBloques.get(i).tipo.equals("Ladrillo")){
                                    //y tiene poderes el ladrillo
                                    if(ListaBloques.get(i).poder){
                                        //hacemos que aparezca un nuevo poder del lado izquierdo del ladrillo
                                        ListaPoderes.add(new Poderes(ListaBloques.get(i).x, ListaBloques.get(i).y-50));
                                       
                                        //cambiamos el estado del ladrillo
                                        ListaBloques.get(i).tipo = "Ladrillo_plano";
                                        ListaBloques.get(i).img_fondo = "Ladrillo_plano.png";
                                        url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
                                        ListaBloques.get(i).icon = new ImageIcon(url).getImage();
                                    }
                                    //si no tiene poderes el ladrillo
                                    else{
                                        //tocamos la musica de romper ladrillo 
                                        url = Ventana.class.getResource("ladrillo.wav"); 
                                        musica = Applet.newAudioClip(url);
                                        musica.play();
                                        
                                        //y quitamos el ladrillo del juego
                                        ListaBloques.remove(i);
                                    }
                                }
                                
                                //en cualquiera de los casos, 
                                choca[0] = true;
                                break;
                            }
                            if(!choca[2]){
                                choca[2] = true;
                                break;
                            }
                            if(!choca[3]){
                                choca[3] = true;
                                break;
                            }
                    }
                    //y si esta cayendo    
                    if(M.cayendo){
                        //pero llega a estar en la misma posicion y del bloque en el que esta
                        if(448 + avanceY == ListaBloques.get(i).y){
                            M.cayendo = false;
                            M.encima = true;
                            alturaSalto = 0;
                        }
                        break;
                    }
                    //en cualquier interseccion de poligonos
                    if(!choca[3] && !M.encima){
                        choca[3] = true;
                        break;
                    }
                    if(!choca[2] && !M.encima){
                        choca[2] = true;
                        break;
                    }
                }
            }
        }
    }
    
    //metodo para asignar imagenes a los sprites en la lista de bloques y enemigos
    public void imagenesFondo(){
        icons[0] = new ImageIcon(url).getImage();
        icons[1] = new ImageIcon(url).getImage();
        icons[2] = new ImageIcon(url).getImage();
        
        //para cada bloque en la lista de bloques
        for(int i=0; i<ListaBloques.size(); i++){
            //obtenemos el url del sprite del bloque
            url = Ventana.class.getResource(ListaBloques.get(i).img_fondo);
            //y asignamos el sprite a su variable icon
            ListaBloques.get(i).icon = new ImageIcon(url).getImage();
        }
        //y hacemos lo mismo para la lista de enemigos
        for (int i = 0; i < ListaEnemigos.size(); i++) {
            url = Ventana.class.getResource(ListaEnemigos.get(i).img_fondo);
            ListaEnemigos.get(i).icon = new ImageIcon(url).getImage();
        }
        //y tambien lo mismo para marianito en su posicion parado
        url = Ventana.class.getResource(M.imgFondo[0]);
        M.icon = new ImageIcon(url).getImage();
    }
    
    //metodo para modificar el movimiento de mario
    public void movimiento(String direccion){
        
        marianito = new Polygon();
        
        switch(direccion){
            case "Derecha":
                sec++;
                //M.mov_derecha();
                choca[3] = false;
                
                if(!choca[2]){
                    M.izquierda = false;
                    M.derecha = true;
                    M.mov_derecha();
                    avanceX += M.velocidad;
                    
                    if(!M.saltando && !M.cayendo){
                        
                        switch(sec){
                            case 1:
                            case 2:
                                marianito.xpoints = M.xc1;
                                marianito.ypoints = M.yc1;
                                marianito.npoints = M.xc1.length;
                                M.x_img = marianito.xpoints[1];
                                url = Ventana.class.getResource(M.imgFondo[1]);
                                break;
                            case 3:
                            case 4:
                                marianito.xpoints = M.xc3;
                                marianito.ypoints = M.yc3;
                                marianito.npoints = M.xc3.length;
                                M.x_img = marianito.xpoints[1];
                                url = Ventana.class.getResource(M.imgFondo[2]);
                                break;
                            case 5:
                            case 6:
                                marianito.xpoints = M.xc2;
                                marianito.ypoints = M.yc2;
                                marianito.npoints = M.xc2.length;
                                M.x_img = marianito.xpoints[1];
                                url = Ventana.class.getResource(M.imgFondo[4]);
                            case 7:
                            case 8:
                                marianito.xpoints = M.xc4;
                                marianito.ypoints = M.yc4;
                                marianito.npoints = M.xc4.length;
                                M.x_img = marianito.xpoints[1];
                                url = Ventana.class.getResource(M.imgFondo[3]);
                                break;
                        }
                    }
                    else{
                        marianito.xpoints = M.xs;
                        marianito.ypoints = M.ys;
                        marianito.npoints = M.xs.length;
                        url = Ventana.class.getResource(M.imgFondo[5]);    
                    }   
                }
                else{
                    marianito.xpoints = M.xp;
                    marianito.ypoints = M.yp;
                    marianito.npoints = M.xp.length;
                    M.x_img = marianito.xpoints[1];
                    url = Ventana.class.getResource(M.imgFondo[0]);
                }
                if(M.encima && !M.saltando){
                    M.encima = false;
                    M.cayendo = true;
                }
                
                M.icon = new ImageIcon(url).getImage();
                break;
            case "Izquierda":
                choca[2] = false;
                if(avanceX > 0){
                    M.izquierda = true;
                    M.derecha = false;
                    sec++;
                    
                    if(!choca[3] || (choca[3] && choca[2])){
                        M.mov_izquierda();
                        avanceX = avanceX - M.velocidad;
                        
                        if(!M.saltando && !M.cayendo){
                            switch(sec){
                                case 1:
                                case 2:
                                    marianito.xpoints = M.xc1_i;
                                    marianito.ypoints = M.yc1_i;
                                    marianito.npoints = M.xc1_i.length;
                                    url = Ventana.class.getResource(M.imgFondo[7]);
                                    break;
                                case 3:
                                case 4:
                                    marianito.xpoints = M.xc3_i;
                                    marianito.ypoints = M.yc3_i;
                                    marianito.npoints = M.xc3_i.length;
                                    url = Ventana.class.getResource(M.imgFondo[8]);
                                    break;
                                case 5:
                                case 6:
                                    marianito.xpoints = M.xc2_i;
                                    marianito.ypoints = M.yc2_i;
                                    marianito.npoints = M.xc2_i.length;
                                    url = Ventana.class.getResource(M.imgFondo[10]);
                                    break;
                                case 7:
                                case 8:
                                    marianito.xpoints = M.xc4_i;
                                    marianito.ypoints = M.yc4_i;
                                    marianito.npoints = M.xc4_i.length;
                                    url = Ventana.class.getResource(M.imgFondo[9]);
                                    break;
                            }
                        }
                        else{
                            marianito.xpoints = M.xs_i;
                            marianito.ypoints = M.ys_i;
                            marianito.npoints = M.xs_i.length;
                            url = Ventana.class.getResource(M.imgFondo[11]);
                        }
                    }
                    else{
                        marianito.xpoints = M.xp_i;
                        marianito.ypoints = M.yp_i;
                        marianito.npoints = M.xp_i.length;
                        url = Ventana.class.getResource(M.imgFondo[0]);
                    }
                    if(M.encima && !M.saltando){
                        M.encima = false;
                        M.cayendo = true;
                    }
                    M.x_img = 0+avanceX;
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
                    M.x_img = marianito.xpoints[0];
                }
                break;
            case "Parado2":
                sec = 0;
                if(!M.saltando && !M.cayendo){
                    marianito.xpoints = M.xp_i;
                    marianito.ypoints = M.yp_i;
                    marianito.npoints = M.xp_i.length;
                    url = Ventana.class.getResource(M.imgFondo[6]);
                    M.icon = new ImageIcon(url).getImage();
                }
                break;
            case "Arriba":
                if(!M.cayendo){
                    M.saltando=true;
                    if(M.derecha){
                        marianito.xpoints = M.xs;
                        marianito.ypoints = M.ys;
                        marianito.npoints = M.xs.length;
                        url = Ventana.class.getResource(M.imgFondo[5]);
                    }
                    if(M.izquierda){
                        marianito.xpoints = M.xs_i;
                        marianito.ypoints = M.ys_i;
                        marianito.npoints = M.xs_i.length;
                        url = Ventana.class.getResource(M.imgFondo[11]);
                    }
                    M.icon = new ImageIcon(url).getImage();
                    avanceY = avanceY - M.vel_salto;
                    alturaSalto -= M.vel_salto;
                    M.salto();
                    if(alturaSalto==-200){
                        choca[2] = false;
                        choca[3] = false;
                        M.saltando=false;
                        M.cayendo=true;
                    }
                }
                break;
            case "Abajo":
                    if(M.derecha){
                        marianito.xpoints = M.xs;
                        marianito.ypoints = M.ys;
                        marianito.npoints = M.xs.length;
                        url = Ventana.class.getResource(M.imgFondo[5]);
                    }
                    if(M.izquierda){
                        marianito.xpoints = M.xs_i;
                        marianito.ypoints = M.ys_i;
                        marianito.npoints = M.xs_i.length;
                        url = Ventana.class.getResource(M.imgFondo[11]);
                    }
                    M.icon = new ImageIcon(url).getImage();
                    avanceY = avanceY + M.vel_salto;
                    alturaSalto += M.vel_salto;
                    M.caida();
                    if(avanceY==0){
                        alturaSalto = 0;
                        M.cayendo=false;
                        choca[2] =false;
                        choca[3] = false;
                        movimiento("Parado");
                    }   
                break;
        }
        if(sec == 8){
            sec = 0;
        }
        
        colision();
    }
    
    public static void main(String[] args) throws InterruptedException{
        JFrame VentanaJuego = new JFrame("Marianito UAMI");
        VentanaJuego.setSize(1324, 580);
        VentanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Ventana juego = new Ventana();
        VentanaJuego.add(juego);
        VentanaJuego.setVisible(true);
        
        juego.imagenesFondo();
        URL url = Ventana.class.getResource("cancion.wav"); 
        juego.musica = Applet.newAudioClip(url);
        juego.musica.loop();
        
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
                    if(juego.alturaSalto == 0){
                        juego.url = Ventana.class.getResource("salto.wav"); 
                        juego.musica = Applet.newAudioClip(juego.url);
                        juego.musica.play();
                        juego.movimiento("Arriba");
                    }
                }
            }
        });
        
        while(true){
            if(!juego.termina){
                juego.repaint();
                Thread.sleep(47);
            }else{
                Object[] opciones={"Si","No"};
                int n=0;
                    n=JOptionPane.showOptionDialog(null,"¿Quieres volver a jugar?","Marianito UAMI",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[1]);
                if(n==0){
                    
                    juego.reset();
                    juego.imagenesFondo();
                }else{
                    juego.musica.stop();
                    VentanaJuego.dispose();
                    break;
                }
            }
        }
    }
}
