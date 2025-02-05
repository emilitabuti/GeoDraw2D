import java.awt.Color;
/**
 * No de uma lista ligada.
 * 
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 1.0 2023/05/15
 */
public class No{
    /**
     * Atributos
     */
    Object conteudox;       // coordenada x
    Object conteudoy;       // coordenada y
    int conteudoEsp;        //expessura
    Color conteudoCor;      //cor
    No proximo; 

    /**
     * No Construtor
     *
     * @param conteudo Object a ser inserido no no
     */
    public No(Object conteudox, Object conteudoy, int conteudoEsp, Color conteudoCor){
        setConteudo(conteudox, conteudoy, conteudoEsp, conteudoCor);
        setProximo(null);
    }
    
    /**
     * setters e getters
     */
    public void setConteudo(Object conteudox, Object conteudoy, int conteudoEsp, Color conteudoCor){
        this.conteudox = conteudox;
        this.conteudoy = conteudoy;
        this.conteudoEsp = conteudoEsp;
        this.conteudoCor = conteudoCor;
    }
    
    /**
     * M�todo setProximo
     *
     * @param proximo Um par�metro
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    
    /**
     * M�todo getConteudox
     *
     * @return O valor de retorno
     */
    public Object getConteudox(){
        return(this.conteudox);
    }
    
    /**
     * M�todo getConteudoy
     *
     * @return O valor de retorno
     */
    public Object getConteudoy(){
        return(this.conteudoy);
    }
    
    /**
     * M�todo getConteudoEsp
     *
     * @return O valor de retorno
     */
    public int getConteudoEsp(){
        return(this.conteudoEsp);
    }
    
    /**
     * M�todo getConteudoCor
     *
     * @return O valor de retorno
     */
    public Color getConteudoCor(){
        return(this.conteudoCor);
    }
    
    /**
     * M�todo getProximo
     *
     * @return O valor de retorno
     */
    public No getProximo(){
        return(this.proximo);
    }
    
    /**
     * M�todo toStringx
     *
     * @return O valor de retorno
     */
    public String toStringx(){
        return(conteudox.toString());
    }
    
    /**
     * M�todo toStringy
     *
     * @return O valor de retorno
     */
    public String toStringy(){
        return(conteudoy.toString());
    }
}
