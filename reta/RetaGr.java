package reta;
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;

/**
 * Implementacao da classe reta grafica.
 *
 * @author Julio Arakaki
 * @version 1.0 - 24/08/2020
 */
public class RetaGr extends Reta{
    // Atributos da reta grafica
    Color corReta = Color.BLACK;   // cor da reta
    String nomeReta = ""; // nome da reta
    Color corNomeReta  = Color.BLACK;
    int espReta = 1; // espessura da reta

    // Construtores
    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta(nome);
        setEspReta(esp);
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
        setEspReta(esp);
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     */
    public RetaGr(int x1, int y1, int x2, int y2){
        super (x1, y1, x2, y2);
        setCorReta(Color.black);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     */
    public RetaGr(PontoGr p1, PontoGr p2){
        super(p1, p2);
        setCorReta(Color.black);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor, String str){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta(str);
    }    

    /**
     * Altera a cor da reta.
     *
     * @param cor Color. Cor da reta.
     */
    public void setCorReta(Color cor) {
        this.corReta = cor;
    }

    /**
     * Altera o nome da reta.
     *
     * @param str String. Nome da reta.
     */
    public void setNomeReta(String str) {
        this.nomeReta = str;
    }

    /**
     * Altera a espessura da reta.
     *
     * @param esp int. Espessura da reta.
     */
    public void setEspReta(int esp) {
        this.espReta = esp;
    }

    /**
     * Retorna a espessura da reta.
     *
     * @return int. Espessura da reta.
     */
    public int getEspReta() {
        return(this.espReta);
    }

    /**
     * Retorna a cor da reta.
     *
     * @return Color. Cor da reta.
     */
    public Color getCorReta() {
        return corReta;
    }

    /**
     * Retorna o nome da reta.
     *
     * @return String. Nome da reta.
     */
    public String getNomeReta() {
        return nomeReta;
    }

    /**
     * @return the corNomeReta
     */
    public Color getCorNomeReta() {
        return corNomeReta;
    }

    /**
     * @param corNomeReta the corNomeReta to set
     */
    public void setCorNomeReta(Color corNomeReta) {
        this.corNomeReta = corNomeReta;
    }

    /**
     * Desenha reta grafica utilizando a equacao da reta: y = mx + b
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharReta(Graphics g){
        // calcula m e b da equacao da reta y = mx + b
        double m = calcularM();
        double b = calcularB();

        // Variaveis auxiliares
        PontoGr ponto; 
        double x, y;
        double pIni;
        double pFim;

        // desenha nome da Reta
        g.setColor(getCorNomeReta());
        g.drawString(getNomeReta(), (int)getP1().getX() + getEspReta(), (int)getP1().getY());

        if(p1.getX() == p2.getX()) { // reta vertical
            if (p1.getY() < p2.getY()){ // Caso 1: y1 < y2
                pIni = p1.getY();
                pFim = p2.getY();
            } else { // Caso 2: y1 > y2
                pIni = p2.getY();
                pFim = p1.getY();            
            }
            // percorre de y1 ate y2. 
            // x e calculado pela equacao: x = (y - b) / m
            for(y = pIni; y <= pFim; ++y){ // percorre de y1 ate y2
                // x1 e x2 sao iguais
                x = p1.getX(); // ou x = p2.getX()

                // Define ponto grafico
                ponto = new PontoGr((int)x, (int)y, getCorReta(), getEspReta());

                // Desenha ponto grafico
                ponto.desenharPonto(g);
            }
        } else { // Outras retas (diferentes de vertical)
            double deltaX = Math.abs(p1.getX() - p2.getX());
            double deltaY = Math.abs(p1.getY() - p2.getY());

            if (deltaX > deltaY){ // percorre pelo x
                if (p1.getX() < p2.getX()){ // Caso 1: x1 < x2
                    pIni = p1.getX();
                    pFim = p2.getX();
                } else { // Caso 2: x1 > x2
                    pIni = p2.getX();
                    pFim = p1.getX();            
                }
                // percorre de x1 ate x2. 
                // y e calculado pela equacao: y = mx + b
                for(x = pIni; x <= pFim; ++x){ 
                    // Calculo de y pela equacao da reta
                    y = (m*x + b);

                    // Define ponto grafico
                    ponto = new PontoGr((int)x, (int)y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
            } else { //deltaY > deltaX, percorre pelo y
                if (p1.getY() < p2.getY()){ // Caso 1: y1 < y2
                    pIni = p1.getY();
                    pFim = p2.getY();
                } else { // Caso 2: y1 > y2
                    pIni = p2.getY();
                    pFim = p1.getY();            
                }
                // percorre de y1 ate y2. 
                // x e calculado pela equacao: x = (y - b) / m
                for(y = pIni; y <= pFim; ++y){ // percorre de y1 ate y2
                    // Calculo de x pela equacao da reta
                    x = ((y - b)/m);

                    // Define ponto grafico
                    ponto = new PontoGr((int)x, (int)y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
            }
        }
    }
}

