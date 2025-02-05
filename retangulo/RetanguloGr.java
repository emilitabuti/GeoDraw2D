package retangulo; 
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;
import reta.RetaGr;

/**
 * Implementacao da classe retangulo grafico.
 *
 * @author Julio Arakaki
 * @version 1.0 - 24/08/2020
 */
public class RetanguloGr extends Retangulo{
    // Atributos do retangulo grafico
    Color corRetangulo = Color.BLACK;   // cor do retangulo
    String nomeRetangulo = ""; // nome do retangulo
    Color corNomeRetangulo  = Color.BLACK;
    int espRetangulo = 1; // espessura do retangulo

    // Construtores
    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do retangulo
     * @param nome String. Nome do retangulo
     * @param esp int. Espessura do retangulo
     */
    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        super (x1, y1, x2, y2);
        setCorRetangulo(cor);
        setNomeRetangulo(nome);
        setEspRetangulo(esp);
    }    

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do retangulo
     */
    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor){
        super (x1, y1, x2, y2);
        setCorRetangulo(cor);
        setNomeRetangulo("");
    }   

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor do retangulo
     * @param esp int. Espessura do retangulo
     */
    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor, int esp){
        super (x1, y1, x2, y2);
        setCorRetangulo(cor);
        setNomeRetangulo("");
        setEspRetangulo(esp);
    }   

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     */
    public RetanguloGr(int x1, int y1, int x2, int y2){
        super (x1, y1, x2, y2);
        setCorRetangulo(Color.black);
        setNomeRetangulo("");
    }   

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     */
    public RetanguloGr(PontoGr p1, PontoGr p2){
        super(p1, p2);
        setCorRetangulo(Color.black);
        setNomeRetangulo("");
    }    

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor do retangulo
     */
    public RetanguloGr(PontoGr p1, PontoGr p2, Color cor){
        super(p1, p2);
        setCorRetangulo(cor);
        setNomeRetangulo("");
    }    

    /**
     * RetaGr - Constroi um retangulo grafico
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor do retangulo
     * @param nome String. Nome do retangulo
     */
    public RetanguloGr(PontoGr p1, PontoGr p2, Color cor, String str){
        super(p1, p2);
        setCorRetangulo(cor);
        setNomeRetangulo(str);
    }    

    /**
     * Altera a cor do retangulo
     *
     * @param cor Color. Cor do retangulo.
     */
    public void setCorRetangulo(Color cor) {
        this.corRetangulo = cor;
    }

    /**
     * Altera o nome do retangulo.
     *
     * @param str String. Nome do retangulo.
     */
    public void setNomeRetangulo(String str) {
        this.nomeRetangulo = str;
    }

    /**
     * Altera a espessura dretangulo retangulo.
     *
     * @param esp int. Espessura do retangulo.
     */
    public void setEspRetangulo(int esp) {
        this.espRetangulo = esp;
    }

    /**
     * Retorna a espessura do retangulo.
     *
     * @return int. Espessura do retangulo.
     */
    public int getEspRetangulo() {
        return(this.espRetangulo);
    }

    /**
     * Retorna a cor do retangulo.
     *
     * @return Color. Cor do retangulo.
     */
    public Color getCorRetangulo() {
        return corRetangulo;
    }

    /**
     * Retorna o nome do retangulo.
     *
     * @return String. Nome do retangulo.
     */
    public String getNomeRetangulo() {
        return nomeRetangulo;
    }

    /**
     * @return the corNomeRetangulo
     */
    public Color getCorNomeRetangulo() {
        return corNomeRetangulo;
    }

    /**
     * @param corNomeRetangulo the corNomeRetangulo to set
     */
    public void setCorNomeRetangulo(Color corNomeRetangulo) {
        this.corNomeRetangulo = corNomeRetangulo;
    }

    /**
     * Desenha retangulo grafico utilizando a equacao da reta: y = mx + b
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharRetangulo(Graphics g){
        // Variaveis auxiliares
        RetaGr p1, p2, p3, p4; 
        int x1, y1, x2, y2;
    
        x1 = (int)getP1().getX();
        y1 = (int)getP1().getY();
        x2 = (int)getP2().getX();
        y2 = (int)getP2().getY();
        
        //cria as retas
        p1 = new RetaGr(x1, y1, x2, y1, getCorRetangulo(), getEspRetangulo());
        p2 = new RetaGr(x1, y1, x1, y2, getCorRetangulo(), getEspRetangulo());
        p3 = new RetaGr(x1, y2, x2, y2, getCorRetangulo(), getEspRetangulo());
        p4 = new RetaGr(x2, y1, x2, y2, getCorRetangulo(), getEspRetangulo());

        // Desenha ponto grafico
        p1.desenharReta(g);
        p2.desenharReta(g);
        p3.desenharReta(g);
        p4.desenharReta(g);
    }
}

