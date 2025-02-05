package triangulo;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Desenha figuras com triangulos.
 * 
 * @author Julio Arakaki 
 * @version 20220815
 */
public class FiguraTriangulos {
    /**
     * Desenha um triangulo de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome do triangulo
     * @param esp espessura do triangulo
     * @param cor cor do triangulo
     */
    public static void desenharTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, String nome, int esp, Color cor){
       TrianguloGr r = new TrianguloGr(x1, y1, x2, y2, x3, y3, cor, nome, esp);
        r.desenharTriangulo(g );
    }

    /**
     * Desenha varios triangulos na area de desenho
     *
     * @param g biblioteca grafica para desenhar os primitivos
     * @param qtde quantidade de triangulos
     * @param esp espessura dos triangulos
     */
    public static void desenharTriangulos(Graphics g, int qtde, int esp){
        for(int i=0; i < qtde; i++) {
            int x1 = (int) (Math.random() * 801);
            int y1 = (int) (Math.random() * 801);
            int x2 = (int) (Math.random() * 801);
            int y2 = (int) (Math.random() * 801);
            int x3 = (int) (Math.random() * 801);
            int y3 = (int) (Math.random() * 801);

            // Cor (R, G e B) aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            TrianguloGr r = new TrianguloGr(x1, y1, x2, y2, x3, y3, cor, "", esp);
            r.desenharTriangulo(g);
        }
    }
}