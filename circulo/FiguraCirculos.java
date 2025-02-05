package circulo; 
import java.awt.Color;
import java.awt.Graphics;

/**
 * Desenha figuras com Circulo.
 * 
 * @author Julio Arakaki 
 * @version 20220815
 */
public class FiguraCirculos {
    /**
     * Desenha um Circulo de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome da reta
     * @param esp espessura do Circulo
     * @param cor cor do Circulo
     */
    public static void desenharCirculo(Graphics g, int xc, int yc, int x, int y, String nome, int esp, Color cor){
       CirculoGr c = new CirculoGr(xc, yc, x, y, cor, nome, esp);
       c.desenharCirculo(g );
    }

    /**
     * Desenha varias Circulo na area de desenho
     *
     * @param g biblioteca grafica para desenhar os primitivos
     * @param qtde quantidade de Circulo
     * @param esp espessura das Circulo
     */
    public static void desenharCirculos(Graphics g, int qtde, int esp){
        for(int i=0; i < qtde; i++) {
            int x1 = (int) (Math.random() * 801);
            int y1 = (int) (Math.random() * 801);
            int x2 = (int) (Math.random() * 801);
            int y2 = (int) (Math.random() * 801);

            // Cor (R, G e B) aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            CirculoGr r = new CirculoGr(x1, y1, x2, y2, cor, "", esp);
            r.desenharCirculo(g);
        }
    }
}
