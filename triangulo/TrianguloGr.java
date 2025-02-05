package triangulo;
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;

/**
 * Implementacao da classe triangulo grafico.
 *
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 1.0 - 24/08/2020
 */
public class TrianguloGr extends Triangulo{
    // Atributos do triangulo grafica
    Color corTriangulo = Color.BLACK;   // cor do triangulo
    String nomeTriangulo = ""; // nome do triangulo
    Color corNomeTriangulo  = Color.BLACK;
    int espTriangulo = 1; // espessura do triangulo

    // Construtores
    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do triangul
     * @param nome String. Nome do triangulo
     * @param esp int. Espessura do triangulo
     */
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor, String nome, int esp){
        super (x1, y1, x2, y2, x3, y3);
        setCorTriangulo(cor);
        setNomeTriangulo(nome);
        setEspTriangulo(esp);
    }    

    /**
     * RetaGr - Constroi um triangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     *  @param x3 int. Coordenada x3
     * @param y3 int. Coordenada y3
     * @param cor Color. Cor do triangulo
     */
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor){
        super (x1, y1, x2, y2, x3, y3);
        setCorTriangulo(cor);
        setNomeTriangulo("");
    }   

    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     *  @param x3 int. Coordenada x3
     * @param y3 int. Coordenada y3
     * @param cor Color. Cor do triangulo
     * @param esp int. Espessura do triangulo
     */
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor, int esp){
        super (x1, y1, x2, y2, x3, y3);
        setCorTriangulo(cor);
        setNomeTriangulo("");
        setEspTriangulo(esp);
    }   

    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     *  @param x3 int. Coordenada x3
     * @param y3 int. Coordenada y3
     */
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3){
        super (x1, y1, x2, y2, x3, y3);
        setCorTriangulo(Color.black);
        setNomeTriangulo("");
    }   

    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param p2 PontoGr. Ponto grafico p3 (x3, y3)
     */
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3){
        super(p1, p2, p3);
        setCorTriangulo(Color.black);
        setNomeTriangulo("");
    }    

    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param p2 PontoGr. Ponto grafico p3 (x3, y3)
     * @param cor Color. Cor do triangulo
     */
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3, Color cor){
        super(p1, p2, p3);
        setCorTriangulo(cor);
        setNomeTriangulo("");
    }    

    /**
     * RetaGr - Constroi um triangulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param p2 PontoGr. Ponto grafico p3 (x3, y3)
     * @param cor Color. Cor do triangulo
     * @param nome String. Nome do triangulo
     */
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3, Color cor, String str){
        super(p1, p2, p3);
        setCorTriangulo(cor);
        setNomeTriangulo(str);
    }    

    /**
     * Altera a cor do triangulo
     *
     * @param cor Color. Cor do triangulo
     */
    public void setCorTriangulo(Color cor) {
        this.corTriangulo = cor;
    }

    /**
     * Altera o nome do triangulo
     *
     * @param str String. Nome do triangulo
     */
    public void setNomeTriangulo(String str) {
        this.nomeTriangulo = str;
    }

    /**
     * Altera a espessura do triangulo
     *
     * @param esp int. Espessura do triangulo
     */
    public void setEspTriangulo(int esp) {
        this.espTriangulo = esp;
    }

    /**
     * Retorna a espessura do triangulo
     *
     * @return int. Espessura do triangulo
     */
    public int getEspTriangulo() {
        return(this.espTriangulo);
    }

    /**
     * Retorna a cor do triangulo
     *
     * @return Color. Cor do triangulo
     */
    public Color getCorTriangulo() {
        return corTriangulo;
    }

    /**
     * Retorna o nome do triangulo
     *
     * @return String. Nome do triangulo
     */
    public String getNomeTriangulo() {
        return nomeTriangulo;
    }

    /**
     * @return the corNomeTriangulo
     */
    public Color getCorNomeTriangulo() {
        return corNomeTriangulo;
    }

    /**
     * @param corNomeTriangulo the corNomeTriangulo to set
     */
    public void setCorNomeTriangulo(Color corNomeTriangulo) {
        this.corNomeTriangulo = corNomeTriangulo;
    }
    
    /**
     * Método que desenha o triangulo grafico
     *
     * @param g Um parâmetro
     */
    public void desenharTriangulo(Graphics g) {
        PontoGr ponto;
        double x, y;
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        double pontos[][] = {{x1, y1, x2, y2}, {x2, y2, x3, y3}, {x3, y3, x1, y1}};

        double pIni;
        double pFim;

        for (int i = 0; i < 3; i++) {
            double p1x = pontos[i][0];
            double p1y = pontos[i][1];
            double p2x = pontos[i][2];
            double p2y = pontos[i][3];

            double m = calcularM(p1x, p1y, p2x, p2y);
            double b = calcularB(p1x, p1y, p2x, p2y);

            if(p1x == p2x) { // reta vertical
                if (p1y < p2y){ // Caso 1: y1 < y2
                    pIni = p1y;
                    pFim = p2y;
                } else { // Caso 2: y1 > y2
                    pIni = p2y;
                    pFim = p1y;            
                }
                // percorre de y1 ate y2. 
                // x e´ calculado pela equacao: x = (y - b) / m
                for(y = pIni; y <= pFim; ++y){ // percorre de y1 ate y2
                    // x1 e x2 são iguais
                    x = p1x; // ou x = p2.getX()

                    // Define ponto grafico
                    ponto = new PontoGr((int)x, (int)y, getCorTriangulo(), getEspTriangulo());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
            } else { // Outras retas (diferentes de vertical)
                double deltaX = Math.abs(p1x - p2x);
                double deltaY = Math.abs(p1y - p2y);

                if (deltaX > deltaY){ // percorre pelo x
                    if (p1x < p2x){ // Caso 1: x1 < x2
                        pIni = p1x;
                        pFim = p2x;
                    } else { // Caso 2: x1 > x2
                        pIni = p2x;
                        pFim = p1x;            
                    }
                    // percorre de x1 ate x2. 
                    // y e´ calculado pela equacao: y = mx + b
                    for(x = pIni; x <= pFim; ++x){ 
                        // Calculo de y pela equacao da reta
                        y = (m*x + b);

                        // Define ponto grafico
                        ponto = new PontoGr((int)x, (int)y, getCorTriangulo(), getEspTriangulo());

                        // Desenha ponto grafico
                        ponto.desenharPonto(g);
                    }
                } else { //deltaY > deltaX, percorre pelo y
                    if (p1y < p2y){ // Caso 1: y1 < y2
                        pIni = p1y;
                        pFim = p2y;
                    } else { // Caso 2: y1 > y2
                        pIni = p2y;
                        pFim = p1y;            
                    }
                    // percorre de y1 ate y2. 
                    // x e´ calculado pela equacao: x = (y - b) / m
                    for(y = pIni; y <= pFim; ++y){ // percorre de y1 ate y2
                        // Calculo de x pela equacao da reta
                        x = ((y - b)/m);

                        // Define ponto grafico
                        ponto = new PontoGr((int)x, (int)y, getCorTriangulo(), getEspTriangulo());

                        // Desenha ponto grafico
                        ponto.desenharPonto(g);
                    }
                }
            }
        }
    }
}

