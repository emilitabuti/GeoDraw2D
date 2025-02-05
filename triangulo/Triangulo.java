package triangulo;
import ponto.Ponto;
/**
 * Representação de um triangulo matematico
 *
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 12/08/2020
 */
public class Triangulo {
    // Atributos do triangulo
    public Ponto p1, p2, p3;

    /**
     * Constroi um triangulo com valores (int) de x1, y1, x2, y2, x3, y3
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada x de p3
     * @param y3 coordenada y de p3
     */
    public Triangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
        setP1(new Ponto(x1, y1));
        setP2(new Ponto(x2, y2));
        setP3(new Ponto(x3, y3));
    }
    
    /**
     * Constroi um triangulo com valores (double) de x1, y1,  x2, y2,  x3, y3
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada x de p3
     * @param y3 coordenada y de p3
     */
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
        setP1(new Ponto(x1, y1));
        setP2(new Ponto(x2, y2));
        setP3(new Ponto(x3, y3));
    }
    
    /**
     * Controi um triangulo com valores de p1, p2, p3 (externos)
     *
     * @param p1 Um parâmetro
     * @param p2 Um parâmetro
     * @param p3 Um parâmetro
     */
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        setP1(p1);
        setP2(p2);
        setP3(p3);
    }
    
    /**
     * Constroi um triangulo com dados de outra (externa)
     *
     * @param r triangulo externa
     */
    public Triangulo (Triangulo r){
        setP1(r.getP1());
        setP2(r.getP2());
        setP3(r.getP3());
    }
    
    /**
     * Altera valor de p1 de acordo com o parametro
     *
     * @param p valor de p1 (externo)
     */
    public void setP1(Ponto p){
        this.p1 = p;
    }
    
    /**
     * Altera valor de p2 de acordo com o parametro
     *
     * @param p valor de p2 (externo)
     */
    public void setP2(Ponto p){
        this.p2 = p;
    }
    
    /**
     * Altera valor de p3 de acordo com o parametro
     *
     * @param p valor de p3 (externo)
     */
    public void setP3(Ponto p){
        this.p3 = p;
    }
    
    /**
     * Retorna valor de p1
     *
     * @return valor de p1
     */
    public Ponto getP1(){
        return this.p1;
    }
    
    /**
     * Retorna p2
     *
     * @return valor de p2
     */
    public Ponto getP2(){
        return this.p2;
    }
    
    /**
     * Retorna p3
     *
     * @return valor de p3
     */
    public Ponto getP3(){
        return this.p3;
    }
    
    /**
     * Calcula o valor de m (da equacao reduzida de reta: y = mx + b)
     *
     * @return valor de m
     */
    public double calcularM(double p1x, double p1y, double p2x, double p2y){
        // m = (y2-y1)/(x2-x1)
        double m = (p2y - p1y)/(p2x - p1x);
        return m;
    }
    
     /**
      * Calcula o valor de b (y = mx + b)
      *
      * @return valor de b
      */
     public double calcularB(double p1x, double p1y, double p2x, double p2y){
        //b = y1 - mx1
        double b = p1y - calcularM(p1x, p1y, p2x, p2y)*p1x;
        return b;
    }
}