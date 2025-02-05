package circulo; 
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;

/**
 * Implementacao da classe circulo grafica.
 *
 * @author Julio Arakaki
 * @version 1.0 - 24/08/2020
 */
public class CirculoGr extends Circulo{
    // Atributos do circulo grafica
    Color corCirculo = Color.BLACK;   // cor do circulo
    String nomeCirculo = ""; // nome do circulo
    Color corNomeCirculo  = Color.BLACK;
    int espCirculo = 1; // espessura do circulo

    // Construtores
    /**
     * RetaGr - Constroi um circulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do circulo
     * @param nome String. Nome do circulo
     * @param esp int. Espessura do circulo
     */
    public CirculoGr(int xc, int yc, int x, int y, Color cor, String nome, int esp){
        super (xc, yc, x, y);
        setCorCirculo(cor);
        setNomeCirculo(nome);
        setEspCirculo(esp);
    }    

    /**
     * RetaGr - Constroi um circulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do Circulo
     */
    public CirculoGr(int xc, int yc, int x, int y, Color cor){
        super (xc, yc, x, y);
        setCorCirculo(cor);
        setNomeCirculo("");
    }   

    /**
     * RetaGr - Constroi um Circulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do Circulo
     * @param esp int. Espessura do Circulo
     */
    public CirculoGr(int xc, int yc, int x, int y, Color cor, int esp){
        super (xc, yc, x, y);
        setCorCirculo(cor);
        setNomeCirculo("");
        setEspCirculo(esp);
    }   

    /**
     * RetaGr - Constroi um Circulo grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     */
    public CirculoGr(int xc, int yc, int x, int y){
        super (xc, yc, x, y);
        setCorCirculo(Color.black);
        setNomeCirculo("");
    }   

    /**
     * RetaGr - Constroi um Circulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     */
    public CirculoGr(PontoGr pc, PontoGr p){
        super(pc, p);
        setCorCirculo(Color.black);
        setNomeCirculo("");
    }    

    /**
     * RetaGr - Constroi um Circulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor do Circulo
     */
    public CirculoGr(PontoGr pc, PontoGr p, Color cor){
        super(pc, p);
        setCorCirculo(cor);
        setNomeCirculo("");
    }    

    /**
     * RetaGr - Constroi um Circulo grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor do Circulo
     * @param nome String. Nome do Circulo
     */
    public CirculoGr(PontoGr pc, PontoGr p, Color cor, String str){
        super(pc, p);
        setCorCirculo(cor);
        setNomeCirculo(str);
    }    

    /**
     * Altera a cor do Circulo.
     *
     * @param cor Color. Cor do Circulo.
     */
    public void setCorCirculo(Color cor) {
        this.corCirculo = cor;
    }

    /**
     * Altera o nome do Circulo.
     *
     * @param str String. Nome do Circulo.
     */
    public void setNomeCirculo(String str) {
        this.nomeCirculo = str;
    }

    /**
     * Altera a espessura do Circulo.
     *
     * @param esp int. Espessura do Circulo.
     */
    public void setEspCirculo(int esp) {
        this.espCirculo = esp;
    }

    /**
     * Retorna a espessura do Circulo.
     *
     * @return int. Espessura do Circulo.
     */
    public int getEspCirculo() {
        return(this.espCirculo);
    }

    /**
     * Retorna a cor do Circulo.
     *
     * @return Color. Cor do Circulo.
     */
    public Color getCorCirculo() {
        return corCirculo;
    }

    /**
     * Retorna o nome do Circulo.
     *
     * @return String. Nome do Circulo.
     */
    public String getNomeCirculo() {
        return nomeCirculo;
    }

    /**
     * @return the corNomeCirculo
     */
    public Color getCorNomeCirculo() {
        return corNomeCirculo;
    }

    /**
     * @param corNomeCirculo the corNomeCirculo to set
     */
    public void setCorNomeCirculo(Color corNomCirculo) {
        this.corNomeCirculo = corNomeCirculo;
    }

    /**
     * Desenha Circulo grafica 
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharCirculo(Graphics g){
        //eqReduzida(g);
        //eqParametrica(g);
        eqSimetrica(g);
    }

    /**
     * Desenha Circulo grafica 
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void eqReduzida(Graphics g){
        // calcula raio
        double r = calcularR();

        // Variaveis auxiliares
        PontoGr ponto1, ponto2, ponto3, ponto4, ponto5, ponto6, ponto7, ponto8; 
        double x, y1, y2;

        double pIni;
        double pFim;

        // desenha nome do Circulo
        g.setColor(getCorNomeCirculo());
        g.drawString(getNomeCirculo(), (int)getPc().getX() + getEspCirculo(), (int)getPc().getY());

        //Desenha Circulo grafica utilizando equacao reduzida do Circulo
        pIni = pc.getX() - r;
        pFim = pc.getX() + r;

        for(x = pIni; x <= pFim; ++x){ 
            // Calculo de y pela equacao do Circulo
            y1 = pc.getY() + Math.sqrt(Math.pow(r, 2) - Math.pow(x - pc.getX(), 2));
            y2 = pc.getY() - Math.sqrt(Math.pow(r, 2) - Math.pow(x - pc.getX(), 2));

            // Define ponto grafico
            ponto1 = new PontoGr((int)x, (int)y1, getCorCirculo(), getEspCirculo());
            ponto2 = new PontoGr((int)x, (int)y2, getCorCirculo(), getEspCirculo());

            // Desenha ponto grafico
            ponto1.desenharPonto(g);
            ponto2.desenharPonto(g);
        }
    }

    /**
     * Desenha Circulo grafica 
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void eqParametrica(Graphics g){
        // calcula raio
        double r = calcularR();

        // Variaveis auxiliares
        PontoGr ponto1, ponto2, ponto3, ponto4, ponto5, ponto6, ponto7, ponto8; 
        double x, y1, y2;

        double pIni;
        double pFim;

        // desenha nome do Circulo
        g.setColor(getCorNomeCirculo());
        g.drawString(getNomeCirculo(), (int)getPc().getX() + getEspCirculo(), (int)getPc().getY());
        
        //Desenha Circulo grafica utilizando equacao parametrica do Circulo
        for(int t = 0; t <= 360; t++){
            double rad = Math.toRadians(t);  // Converte t para radianos

            x = pc.getX() + (r * Math.cos(rad));
            y1 = pc.getY() + (r * Math.sin(rad));

            ponto1 = new PontoGr((int)x, (int)y1, getCorCirculo(), getEspCirculo());

            ponto1.desenharPonto(g);
        }
    }

    /**
     * Desenha Circulo grafica 
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void eqSimetrica(Graphics g){
        // calcula raio
        double r = calcularR();

        // Variaveis auxiliares
        PontoGr ponto1, ponto2, ponto3, ponto4, ponto5, ponto6, ponto7, ponto8; 
        double x, y1, y2;

        double pIni;
        double pFim;

        // desenha nome do Circulo
        g.setColor(getCorNomeCirculo());
        g.drawString(getNomeCirculo(), (int)getPc().getX() + getEspCirculo(), (int)getPc().getY());

        //Desenha Circulo grafica utilizando equacao parametrica do Circulo com octantes
        for(int t = 0; t <= 45; t++){
            double rad = Math.toRadians(t);  // Converte t para radianos

            x = r * Math.cos(rad);
            y1 = r * Math.sin(rad);

            ponto1 = new PontoGr((int)(pc.getX() + x), (int)(pc.getY() + y1), getCorCirculo(), getEspCirculo());
            ponto2 = new PontoGr((int)(pc.getX() - x), (int)(pc.getY() + y1), getCorCirculo(), getEspCirculo());
            ponto3 = new PontoGr((int)(pc.getX() + x), (int)(pc.getY() - y1), getCorCirculo(), getEspCirculo());
            ponto4 = new PontoGr((int)(pc.getX() - x), (int)(pc.getY() - y1), getCorCirculo(), getEspCirculo());
            ponto5 = new PontoGr((int)(pc.getX() + y1), (int)(pc.getY() + x), getCorCirculo(), getEspCirculo());
            ponto6 = new PontoGr((int)(pc.getX() - y1), (int)(pc.getY() + x), getCorCirculo(), getEspCirculo());
            ponto7 = new PontoGr((int)(pc.getX() + y1), (int)(pc.getY() - x), getCorCirculo(), getEspCirculo());
            ponto8 = new PontoGr((int)(pc.getX() - y1), (int)(pc.getY() - x), getCorCirculo(), getEspCirculo());

            ponto1.desenharPonto(g);
            ponto2.desenharPonto(g);
            ponto3.desenharPonto(g);
            ponto4.desenharPonto(g);
            ponto5.desenharPonto(g);
            ponto6.desenharPonto(g);
            ponto7.desenharPonto(g);
            ponto8.desenharPonto(g);
        }
    }
}

