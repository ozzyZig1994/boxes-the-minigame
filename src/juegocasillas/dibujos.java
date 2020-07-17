/*
    Clase que ejecuta los metodos para dibujar las casillas de un tablero de juego
    *METODO PINTAR: dibuja las casillas del tablero a cuantas casillas y tamaños se quiera
                    para todas
*/
package juegocasillas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Abraham Josue Galvan Torres
 */
public class dibujos 
{   
    public static void pintarTablero(Graphics g, JPanel pan)
    {
        int i= 0,
            posLetra= 56,
            posCasilla= 20;
        
        g.clearRect(0, 0, pan.getWidth(), pan.getHeight());
        g.setColor(Color.BLUE);
        while (i < 5) 
        {
            g.drawString(""+(i+1), posLetra, 144);//(numero, x, y)
            g.drawRect(posCasilla, 100, 80, 80);//(x, y, ancho,largo)
            i++;
            posLetra+= 79;
            posCasilla+= 80;
        }  
    }
    
    public static void pintarFicha(Graphics g, JPanel pan, int tiro, int casilla) 
    {
        int posFicha= 33;
        int i= 1;
    
        g.setColor(Color.RED);   
        switch(casilla)
        {
            case 1:
                if(tiro == 1 | tiro == 2 | tiro == 4 | tiro == 6)
                {
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    if(tiro == 3)
                    {
                        posFicha+= 78;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                    }
                    else
                    {
                        posFicha+= 160;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                }
                break;
            case 2:
                if(tiro == 3 | tiro == 4 | tiro == 5 | tiro == 6)
                {
                    posFicha+= 160;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    i++;
                    posFicha= 111;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                    if(i == 3)
                    {
                        posFicha= 33;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                    }
                }
                break;
            case 3:
                if(tiro == 6)
                {
                    posFicha+= 240;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    if(tiro == 2)
                    {
                        posFicha= 111;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                    else
                    {
                        posFicha= 33;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                }
                break;
            case 4:
                if(tiro == 4 | tiro == 5 | tiro == 6)
                {
                    posFicha+= 320;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                break;
        }
    }
    
    public static void quitarFicha(Graphics g, JPanel pan, int tiro, int casilla)
    {
        int posFicha= 33;
        int i= 1;
        
        g.setColor(new Color(214,217,223));
        switch(casilla)
        {
            case 1:
                if(tiro == 1 | tiro == 2 | tiro == 4 | tiro == 6 | tiro == 5)
                {
                    posFicha= 33;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    if(tiro == 3)
                    {
                        posFicha+= 78;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                    }
                    else
                    {
                        posFicha+= 160;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                }
                break;
            case 2:
                if(tiro == 3 | tiro == 4 | tiro == 5 | tiro == 6)
                {
                    posFicha+= 160;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    i++;
                    posFicha= 111;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    if(i == 3)
                    {
                        posFicha= 33;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                }
                break;
            case 3:
                if(tiro == 6)
                {
                    posFicha+= 240;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)
                }
                else
                {
                    if(tiro == 2)
                    {
                        posFicha= 111;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                    else
                    {
                        posFicha= 33;
                        g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                        g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                    }
                }
                break;
            case 4:
                if(tiro == 4 | tiro == 5 | tiro == 6)
                {
                    posFicha+= 78;
                    g.fillOval(posFicha, 110, 51, 51);//(x, y, ancho, largo)
                    g.drawOval(posFicha, 110, 50, 50);//(x, y, ancho, largo)*/
                }
                break;
        }
    }
    
    public static void pintarCasillas(Graphics g, JPanel pan)
    {
        int i= 0,
            posLetra= 56;
        
        g.setColor(Color.BLUE);
        while (i < 5) 
        {
            g.drawString(""+(i+1), posLetra, 144);//(numero, x, y)
            i++;
            posLetra+= 79;
        }  
    }
}