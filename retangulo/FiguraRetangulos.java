package retangulo; 
import java.awt.Color;
import java.awt.Graphics;

/**
 * Desenha figuras com retangulos.
 * 
 * @author Julio Arakaki 
 * @version 20220815
 */
public class FiguraRetangulos {
    /**
     * Desenha um retangulo de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome do retangulo
     * @param esp espessura do retangulo
     * @param cor cor do retangulo
     */
    public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
       RetanguloGr r = new RetanguloGr(x1, y1, x2, y2, cor, nome, esp);
        r.desenharRetangulo(g );
    }

    /**
     * Desenha varios retangulos na area de desenho
     *
     * @param g biblioteca grafica para desenhar os primitivos
     * @param qtde quantidade de retangulo
     * @param esp espessura dos retangulo
     */
    public static void desenharRetangulos(Graphics g, int qtde, int esp){

        for(int i=0; i < qtde; i++) {
            int x1 = (int) (Math.random() * 801);
            int y1 = (int) (Math.random() * 801);
            int x2 = (int) (Math.random() * 801);
            int y2 = (int) (Math.random() * 801);

            // Cor (R, G e B) aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            RetanguloGr r = new RetanguloGr(x1, y1, x2, y2, cor, "", esp);
            r.desenharRetangulo(g);
        }
    }
}
