package circulo; 
import ponto.Ponto;
/**
 * Representação de um circulo matematico
 *
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 12/08/2020
 */
public class Circulo {
 
    // Atributos do Circulo
    public Ponto pc, p;

    /**
     * Constroi um Circulo com valores (int) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Circulo(int xc, int yc, int x, int y) {
        setPc(new Ponto(xc, yc));
        setP(new Ponto(x, y));
    }
    
    /**
     * Constroi um Circulo com valores (double) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Circulo(double xc, double yc, double x, double y) {
        setPc(new Ponto(xc, yc));
        setP(new Ponto(x, y));
    }
    
    /**
     * Controi um Circulo com valores de p1 e p2 (externos)
     *
     * @param p1 Um parâmetro
     * @param p2 Um parâmetro
     */
    public Circulo(Ponto pc, Ponto p) {
        setPc(pc);
        setP(p);
    }
    
    /**
     * Constroi um Circulo com dados de outra (externa)
     *
     * @param c Circulo externa
     */
    public Circulo (Circulo c){
        setPc(c.getPc());
        setP(c.getP());
    }
    
    /**
     * Altera valor de p1 de acordo com o parametro
     *
     * @param p valor de p1 (externo)
     */
    public void setPc(Ponto p){
        this.pc = p;
    }
    
    /**
     * Altera valor de p2 de acordo com o parametro
     *
     * @param p valor de p2 (externo)
     */
    public void setP(Ponto p){
        this.p = p;
    }
    
    /**
     * Retorna valor de p1
     *
     * @return valor de p1
     */
    public Ponto getPc(){
        return this.pc;
    }
    
    /**
     * Retorna p2
     *
     * @return valor de p2
     */
    public Ponto getP(){
        return this.p;
    }
    
    /**
     * Calcula o valor de r(raio) da equacao reduzida do Circulo: r^2 = (x - xc)^2 + (y - yc)^2
     *
     * @return valor de r
     */
    public double calcularR(){
        double r2 = Math.pow(getP().getX() - getPc().getX(), 2) + Math.pow(getP().getY() - getPc().getY(), 2);
        double r = Math.sqrt(r2);
        return r;
    }
}
