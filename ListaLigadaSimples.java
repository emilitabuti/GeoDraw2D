/**
 * Estrutura de dados para lista ligada simples
 * 
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 1.0 2023/05/15
 */
public class ListaLigadaSimples {
    No inicio, fim;
    int qtdNos;

    /**
     * ListaLigadaSimples Construtor
     *
     */
    public ListaLigadaSimples(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * setInicio
     *
     * @param inicio No inicio da lista ligada
     */
    private void setInicio(No inicio){
        this.inicio = inicio;
    }

    /**
     * getInicio
     *
     * @return No de inicio da lista ligada
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * getFim
     *
     * @return No do final da lista ligada
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * setFim
     *
     * @param fim No fim da lista ligada
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * getQtdNos
     *
     * @return int, qtde de nos na lista ligada
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * setQtdNos
     *
     * @param qtdNos Um parametro
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * estaVazia
     *
     * @return boolean, true se estiver vazia e false caso contrario
     */
    public boolean estaVazia(){
        boolean vazia = false; 
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            vazia = true;
        }
        return vazia;
    }

    /**
     * inserirInicio
     *
     * @param elem Objeto a ser inserido no inicio da lista ligada
     */
    public void inserirInicio(No elem) {
        No novo = elem; //1

        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            novo.setProximo(inicio);
            setInicio(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * inserirFim
     *
     * @param elem Objeto a ser inserido no fim da lista ligada
     */
    public void inserirFim(No elem){
        No novo = elem;
        novo.setProximo(null);
        
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            getFim().setProximo(novo);
            setFim(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * removerFim
     *
     * @return Objeto removido
     */
    public Object removerFim(){
        No ant = getInicio();
        No aux = null;
        Object obj = null; 
        if (!estaVazia()){
            if ((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {            
                // percorre ate achar o no antes do fim
                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null);
                aux = fim;
                setFim(ant);
            }
            setQtdNos(getQtdNos() - 1);
            //obj = aux.getConteudo();           
        }
        return obj;
    }
    
    /**
     * remover
     *
     * Remove o no dado como parametro
     */
    public void remover(No noARemover) {
        No cabeca = getInicio();
        if (cabeca == null) {
            return;
        }

        // Se o no a ser removido for o primeiro (cabeca)
        if (cabeca.getConteudox() == noARemover.getConteudox() && cabeca.getConteudoy() == noARemover.getConteudoy()) {
            setInicio(cabeca.getProximo());
            setQtdNos(getQtdNos() - 1);
            
            if(getQtdNos() == 0)
                    setFim(null);
            return;
        }

        // Se o no a ser removido estiver no meio ou no final
        No atual = cabeca.getProximo();
        No anterior = cabeca;

        while (atual != null) {
            if (atual.getConteudox() == noARemover.getConteudox() && atual.getConteudoy() == noARemover.getConteudoy()) {
                anterior.setProximo(atual.getProximo());
                setQtdNos(getQtdNos() - 1);
                
                if(getQtdNos() == 0)
                    setFim(null);
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }
    
    /**
     * printLista
     *
     * Apresentar os objetos da lista ligada
     */
    public void printLista() {
        No atual = getInicio();  // Pega o inicio da lista (cabeca)
    
        // Verifica se a lista esta vazia
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }
    
        // Percorre a lista e imprime os elementos
        while (atual != null) {
            System.out.println("ConteudoX: " + atual.getConteudox() + ", ConteudoY: " + atual.getConteudoy());
            atual = atual.getProximo();  // Move para o próximo no
        }
    }
}
