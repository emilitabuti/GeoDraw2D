import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import ponto.FiguraPontos;
import reta.FiguraRetas;
import circulo.FiguraCirculos;
import retangulo.FiguraRetangulos;
import triangulo.FiguraTriangulos;

/**
 * Cria desenhos de acordo com o tipo e eventos do mouse
 * 
 * @author Caroline, Emili, Gustavo Macedo, Isabela
 * @version 20220815
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
    JLabel msg;           // Label para mensagens
    TipoPrimitivo tipo; // Tipo do primitivo
    Color corAtual;       // Cor atual do primitivo
    int esp;              // Diametro do ponto

    // Para pontos
    int x1, y1, x2, y2, x3, y3, xant=0, yant=0;
    int x, y, xt, yt;

    // selecionar primeiro click do mouse
    boolean primeiraVez = true;
    boolean segundaVez = false;

    //Para armazenar cada tipo de figura
    ListaLigadaSimples armazenador[] = new ListaLigadaSimples[5];  
    ListaLigadaSimples lP = new ListaLigadaSimples();
    ListaLigadaSimples lReta = new ListaLigadaSimples();
    ListaLigadaSimples lC = new ListaLigadaSimples();
    ListaLigadaSimples lRetangulo = new ListaLigadaSimples();
    ListaLigadaSimples lT = new ListaLigadaSimples();

    /**
     * Constroi o painel de desenho
     *
     * @param msg mensagem a ser escrita no rodape do painel
     * @param tipo tipo atual do primitivo
     * @param corAtual cor atual do primitivo
     * @param esp espessura atual do primitivo
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }

    /**
     * Altera o tipo atual do primitivo
     *
     * @param tipo tipo do primitivo
     */
    public void setTipo(TipoPrimitivo tipo){
        this.tipo = tipo;
    }

    /**
     * Retorna o tipo do primitivo
     *
     * @return tipo do primitivo
     */
    public TipoPrimitivo getTipo(){
        return this.tipo;
    }

    /**
     * Altera a espessura do primitivo
     *
     * @param esp espessura do primitivo
     */
    public void setEsp(int esp){
        this.esp = esp;
    }

    /**
     * Retorna a espessura do primitivo
     *
     * @return espessura do primitivo
     */
    public int getEsp(){
        return this.esp;
    }

    /**
     * Altera a cor atual do primitivo
     *
     * @param corAtual cor atual do primitivo
     */
    public void setCorAtual(Color corAtual){
        this.corAtual = corAtual;
    }

    /**
     * retorna a cor atual do primitivo
     *
     * @return cor atual do primitivo
     */
    public Color getCorAtual(){
        return this.corAtual;
    }

    /**
     * Altera a msg a ser apresentada no rodape
     *
     * @param msg mensagem a ser apresentada
     */
    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    /**
     * Retorna a mensagem
     *
     * @return mensagem as ser apresentada no rodape
     */
    public JLabel getMsg(){
        return this.msg;
    }

    /**
     * Metodo chamado quando o paint eh acionado
     *
     * @param g biblioteca para desenhar em modo grafico
     */
    public void paintComponent(Graphics g) {   
        apagarPrimitivos(g);
        desenharPrimitivosTemporario(g);
    }

    /**
     * Evento: pressionar do mouse
     *
     * @param e dados do evento
     */
    public void mousePressed(MouseEvent e) { 
        Graphics g = getGraphics();  
        if (tipo == TipoPrimitivo.PONTO){
            x1 = e.getX();
            y1 = e.getY();
        } else if (tipo == TipoPrimitivo.RETA){
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            }
        }else if (tipo == TipoPrimitivo.CIRCULO){
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            }
        }else if (tipo == TipoPrimitivo.RETANGULO){
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            } 
        }else if (tipo == TipoPrimitivo.TRIANGULO){
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
                segundaVez = true;
            }else if (segundaVez == true) {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                segundaVez = false;
            }else{
                x3 = (int)e.getX();
                y3 = (int)e.getY();
                primeiraVez = true;
                paint(g);
                armazenarPrimitivos();
            }
        }else if(tipo == TipoPrimitivo.DELETAR){
            x = e.getX();
            y = e.getY();
            deletarFigura(g);
        }else if(tipo == TipoPrimitivo.TRANSLACAO){
            if (primeiraVez == true) {
                x = (int)e.getX();
                y = (int)e.getY();
                primeiraVez = false;
                segundaVez = true;
            }else if (segundaVez == true) {
                xt = (int)e.getX();
                yt = (int)e.getY();
                segundaVez = false;
                primeiraVez = true;
                translacaoPrimitivos(g);
            }
        }else if(tipo == TipoPrimitivo.ROTACAO){
            x = e.getX();
            y = e.getY();
            rotacaoPrimitivos(g);
        }else if(tipo == TipoPrimitivo.ESCALA){
            x = e.getX();
            y = e.getY();
            escalaPrimitivos(g);
        }
    }

    /**
     * Método mouseReleased
     *
     * @param e Um parametro
     */
    public void mouseReleased(MouseEvent e) { 
        if (tipo != TipoPrimitivo.TRIANGULO && tipo != TipoPrimitivo.TRANSLACAO){
            Graphics g = getGraphics();  
            //System.out.println("Released ");
            x2 = (int)e.getX();
            y2 = (int)e.getY();

            primeiraVez = true; 
            armazenarPrimitivos();
            paint(g); 
        }
    }           

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * Método mouseDragged
     *
     * @param e Um parametro
     */
    public void mouseDragged(MouseEvent e) {
        if (tipo != TipoPrimitivo.TRIANGULO && tipo != TipoPrimitivo.PONTO){
            Graphics g = getGraphics();  
            xant = x2;
            yant = y2;
            x2 = (int)e.getX();
            y2 = (int)e.getY();

            paint(g);

            //System.out.println("Dragged ");
            this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
        }
    }

    /**
     * Evento mouseMoved: escreve mensagem no rodape (x, y) do mouse
     *
     * @param e dados do evento do mouse
     */
    public void mouseMoved(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
    }

    /**
     * redesenhar
     *
     * Redesenha todas as figuras que estao armazenadas na ED
     */
    public void redesenhar(Graphics g) {
        // Limpa a area onde os desenhos serao feitos
        g.clearRect(0, 0, getWidth(), getHeight()); // Limpa a area do painel
        
        //Para pontos
        int ax1, ay1, ax2, ay2, ax3, ay3;

        // Verificar cada lista dentro do array armazenador
        for (int i = 0; i < armazenador.length; i++) {
            if (armazenador[i] != null && !armazenador[i].estaVazia()) {
                No temp = armazenador[i].getInicio();
                int contador = 1;

                // Percorrer a lista ligada e desenhar os pontos
                while (temp != null && contador <= armazenador[i].getQtdNos()) {
                    // Obter x1 e y1
                    ax1 = ((Integer) temp.getConteudox()).intValue();
                    ay1 = ((Integer) temp.getConteudoy()).intValue();

                    if(i == 0){ // Se for PONTO
                        if (temp != null){
                            FiguraPontos.desenharPonto(g, ax1, ay1, "", temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                    }
                    // Se for RETA, CIRCULO ou RETANGULO
                    else if (i == 1 || i == 2 || i == 3) {
                        if (temp != null) {
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            
                            if(i == 1){
                                FiguraRetas.desenharReta(g, ax1, ay1, ax2, ay2, "", temp.getConteudoEsp(), temp.getConteudoCor());
                            }
                            else if(i == 2){
                                FiguraCirculos.desenharCirculo(g, ax1, ay1, ax2, ay2, "", temp.getConteudoEsp(), temp.getConteudoCor());
                            }
                            else{
                                FiguraRetangulos.desenharRetangulo(g, ax1, ay1, ax2, ay2, "", temp.getConteudoEsp(), temp.getConteudoCor());
                            }
                            //Desenha os pontos vermelhos
                            if(tipo == TipoPrimitivo.DELETAR || tipo == TipoPrimitivo.TRANSLACAO || tipo == TipoPrimitivo.ROTACAO || tipo == TipoPrimitivo.ESCALA){
                                FiguraPontos.desenharPonto(g, ax2, ay2, "", temp.getConteudoEsp(), Color.red);
                            }
                        }
                    }
                    // Se for TRIANGULO
                    else if (i == 4) {
                        if (temp != null) {
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            
                            temp = temp.getProximo();
                            ax3 = ((Integer) temp.getConteudox()).intValue();
                            ay3 = ((Integer) temp.getConteudoy()).intValue();
                            
                            FiguraTriangulos.desenharTriangulo(g, ax1, ay1, ax2, ay2, ax3, ay3, "", temp.getConteudoEsp(), temp.getConteudoCor());
                            //Desenha os pontos vermelhos
                            if(tipo == TipoPrimitivo.DELETAR || tipo == TipoPrimitivo.TRANSLACAO || tipo == TipoPrimitivo.ROTACAO || tipo == TipoPrimitivo.ESCALA){
                                FiguraPontos.desenharPonto(g, ax2, ay2, "", temp.getConteudoEsp(), Color.red);
                                FiguraPontos.desenharPonto(g, ax3, ay3, "", temp.getConteudoEsp(), Color.red);
                            }
                        }
                    }
                    //Desenha os pontos vermelhos
                    if(tipo == TipoPrimitivo.DELETAR || tipo == TipoPrimitivo.TRANSLACAO || tipo == TipoPrimitivo.ROTACAO || tipo == TipoPrimitivo.ESCALA){
                        FiguraPontos.desenharPonto(g, ax1, ay1, "", temp.getConteudoEsp(), Color.red);
                    }

                    contador++;
                    temp = temp.getProximo(); // Ir para o proximo no
                }
            }
        }
    }

    /**
     * desenharPrimitivosTemporario
     *
     * Desenha as figuras temporariamente
     */
    public void desenharPrimitivosTemporario(Graphics g) {
        if (tipo == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g, x1, y1, "", getEsp(), getCorAtual());
        }

        if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }

        if (tipo==TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }

        if (tipo == TipoPrimitivo.RETANGULO){
            FiguraRetangulos.desenharRetangulo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }

        if (tipo == TipoPrimitivo.TRIANGULO){
            FiguraTriangulos.desenharTriangulo(g, x1, y1, x2, y2, x3, y3, "", getEsp(), getCorAtual());
        }
    }

    /**
     * armazenarPrimitivos
     *
     * Armzena os primitivos em listas ligadas dentro de um array
     */
    public void armazenarPrimitivos() {
        if (tipo == TipoPrimitivo.PONTO){
            lP.inserirFim(new No(Integer.valueOf(x1), Integer.valueOf(y1), getEsp(), getCorAtual()));
            armazenador[0] = lP;
        }

        if (tipo == TipoPrimitivo.RETA){
            lReta.inserirFim(new No(Integer.valueOf(x1), Integer.valueOf(y1),getEsp(), getCorAtual()));
            lReta.inserirFim(new No(Integer.valueOf(x2), Integer.valueOf(y2),getEsp(), getCorAtual()));
            armazenador[1] = lReta;
        }

        if (tipo==TipoPrimitivo.CIRCULO){
            lC.inserirFim(new No(Integer.valueOf(x1), Integer.valueOf(y1),getEsp(), getCorAtual()));
            lC.inserirFim(new No(Integer.valueOf(x2), Integer.valueOf(y2),getEsp(), getCorAtual()));
            armazenador[2] = lC;
        }

        if (tipo == TipoPrimitivo.RETANGULO){
            lRetangulo.inserirFim(new No(Integer.valueOf(x1), Integer.valueOf(y1),getEsp(), getCorAtual()));
            lRetangulo.inserirFim(new No(Integer.valueOf(x2), Integer.valueOf(y2),getEsp(), getCorAtual()));
            armazenador[3] = lRetangulo;
        }

        if (tipo == TipoPrimitivo.TRIANGULO){
            lT.inserirFim(new No(Integer.valueOf(x1), Integer.valueOf(y1),getEsp(), getCorAtual()));
            lT.inserirFim(new No(Integer.valueOf(x2), Integer.valueOf(y2),getEsp(), getCorAtual()));
            lT.inserirFim(new No(Integer.valueOf(x3), Integer.valueOf(y3),getEsp(), getCorAtual()));
            armazenador[4] = lT;
        }
    }

    /**
     * apagarPrimitivos
     *
     * apaga as figuras da tela
     */
    public void apagarPrimitivos(Graphics g){
        if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharReta(g, x1, y1, xant, yant, "", getEsp(), getBackground());
        }

        if (tipo==TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculo(g, x1, y1, xant, yant, "", getEsp(), getBackground());
        }

        if (tipo == TipoPrimitivo.RETANGULO){
            FiguraRetangulos.desenharRetangulo(g, x1, y1, xant, yant, "", getEsp(), getBackground());
        }
    }

    /**
     * deletarFigura
     *
     * deleta as figuras da ED
     */
    public void deletarFigura(Graphics g){
        int ax1, ay1;
        //Ponto da ED que e o mais proximo de onde o usuario clicou
        double deletar[] = selecionarPontoProximo(g);

        if(deletar[0] != -1){ //se achou um ponto da ED
            No temp = armazenador[(int)deletar[0]].getInicio();//acessar o inicio da lista da figura correspondente ao ponto
            No ant = null;
            No antAnt = null; 
            int contador = 1;

            // Percorrer a lista ligada e apagar da ED
            while (temp != null && contador <= armazenador[(int)deletar[0]].getQtdNos()) {
                // Obter x1 e y1
                ax1 = ((Integer) temp.getConteudox()).intValue();
                ay1 = ((Integer) temp.getConteudoy()).intValue();

                if(ax1 == deletar[1] && ay1 == deletar[2]){//achou os pontos na lista
                    if(deletar[0] == 0){
                        lP.remover(temp);
                    }
                    else if(deletar[0] == 1){
                        lReta.remover(temp);
                        if(contador % 2 != 0){
                            temp = temp.getProximo();
                            lReta.remover(temp);
                        }
                        else
                            lReta.remover(ant);
                    }
                    else if(deletar[0] == 2){
                        lC.remover(temp);
                        if(contador % 2 != 0){
                            temp = temp.getProximo();
                            lC.remover(temp);
                        }
                        else
                            lC.remover(ant);
                    }
                    else if(deletar[0] == 3){
                        lRetangulo.remover(temp);
                        if(contador % 2 != 0){
                            temp = temp.getProximo();
                            lRetangulo.remover(temp);
                        }
                        else
                            lRetangulo.remover(ant);
                    }
                    else if(deletar[0] == 4){
                        lT.remover(temp);
                        if(contador % 3 == 0){
                            lT.remover(ant);
                            lT.remover(antAnt);
                        }else if((contador + 2) % 3 == 0){
                            temp = temp.getProximo();
                            lT.remover(temp);       
                            temp = temp.getProximo();
                            lT.remover(temp);
                        }else if((contador + 1) % 3 == 0){
                            lT.remover(ant);      
                            temp = temp.getProximo();
                            lT.remover(temp);
                        }
                    }
                }
                
                contador++;
                antAnt = ant;
                ant = temp;
                temp = temp.getProximo(); // Ir para o proximo no
            }
        }
        setTipo(TipoPrimitivo.NENHUM);
        redesenhar(g);
    }
    
    /**
     * selecionarPontoProximo
     *
     * @return array com o ponto da ED mais proximo do lugar que o usuario clicou
     */
    public double[] selecionarPontoProximo(Graphics g){
        int ax1, ay1;
        double d; //para distancia de um ponto a outro
        double ponto[] = new double[4];
        ponto[0] = -1;
        ponto[3] = 20;//maxima distancia e 20

        //percorre toda a ED
        for (int i = 0; i < armazenador.length; i++) {
            if (armazenador[i] != null && !armazenador[i].estaVazia()) {
                No temp = armazenador[i].getInicio();
                int contador = 1;

                // Percorrer a lista ligada e armazenar os pontos com menor distancia
                while (temp != null && contador <= armazenador[i].getQtdNos()) {
                    // Obter x1 e y1
                    ax1 = ((Integer) temp.getConteudox()).intValue();
                    ay1 = ((Integer) temp.getConteudoy()).intValue();
                    
                    d = Math.sqrt(Math.pow(ax1 - x, 2) + Math.pow(ay1 - y, 2));//distancia entre dois pontos
                    
                    if(d < ponto[3]){
                        ponto[0] = i;
                        ponto[1] = ax1;
                        ponto[2] = ay1;
                        ponto[3] = d;
                    }
                    if (i == 1 || i == 2 || i == 3) {// Se for RETA, CIRCULO, RETANGULO
                        if (temp != null) {
                            temp = temp.getProximo();
                            ax1 = ((Integer) temp.getConteudox()).intValue();
                            ay1 = ((Integer) temp.getConteudoy()).intValue();

                            d = Math.sqrt(Math.pow(ax1 - x, 2) + Math.pow(ay1 - y, 2));
                            if(d < ponto[3]){
                                ponto[0] = i;
                                ponto[1] = ax1;
                                ponto[2] = ay1;
                                ponto[3] = d;
                            }
                        }
                    }
                    // Se for TRIANGULO
                    else if (i == 4) {
                        if (temp != null) {
                            temp = temp.getProximo();
                            ax1 = ((Integer) temp.getConteudox()).intValue();
                            ay1 = ((Integer) temp.getConteudoy()).intValue();

                            d = Math.sqrt(Math.pow(ax1 - x, 2) + Math.pow(ay1 - y, 2));
                            if(d < ponto[3]){
                                ponto[0] = i;
                                ponto[1] = ax1;
                                ponto[2] = ay1;
                                ponto[3] = d;
                            }
                            temp = temp.getProximo();
                            ax1 = ((Integer) temp.getConteudox()).intValue();
                            ay1 = ((Integer) temp.getConteudoy()).intValue();

                            d = Math.sqrt(Math.pow(ax1 - x, 2) + Math.pow(ay1 - y, 2));
                            if(d < ponto[3]){
                                ponto[0] = i;
                                ponto[1] = ax1;
                                ponto[2] = ay1;
                                ponto[3] = d;
                            }
                        }
                    }

                    contador++;
                    temp = temp.getProximo(); // Ir para o proximo no
                }
            }
        }
        return ponto;
    }
    
    /**
     * translacaoPrimitivos
     *
     * translaciona o primitivo para outro lugar e altera na ED
     */
    public void translacaoPrimitivos(Graphics g){
        int ax1, ay1, ax2, ay2;
        //Ponto da ED que e o mais proximo de onde o usuario clicou
        double novoPonto[] = selecionarPontoProximo(g);
        
        if(novoPonto[0] != -1){
            No temp = armazenador[(int)novoPonto[0]].getInicio();
            No ant = null;
            No antAnt = null; 
            int contador = 1;

            // Percorrer a lista ligada e atualizar com o novo ponto
            while (temp != null && contador <= armazenador[(int)novoPonto[0]].getQtdNos()) {
                // Obter x1 e y1
                ax1 = ((Integer) temp.getConteudox()).intValue();
                ay1 = ((Integer) temp.getConteudoy()).intValue();

                if(ax1 == novoPonto[1] && ay1 == novoPonto[2]){
                    temp.setConteudo(xt, yt, temp.getConteudoEsp(), temp.getConteudoCor());//atualizar com o novo ponto
                    
                    if(novoPonto[0] == 1 || novoPonto[0] == 2 || novoPonto[0] == 3){//se for RETA, CIRCULO, RETANGULO
                        if(contador % 2 != 0){
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            //calculo para os novos pontos apos a translacao
                            temp.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                        else{
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            ant.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                    }
                    else if(novoPonto[0] == 4){//se for TRIANGULO
                        if(contador % 3 == 0){
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            ant.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                            
                            ax2 = ((Integer) antAnt.getConteudox()).intValue();
                            ay2 = ((Integer) antAnt.getConteudoy()).intValue();
                            antAnt.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                        }else if((contador + 2) % 3 == 0){
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            temp.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());      
                            
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            temp.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                        }else if((contador + 1) % 3 == 0){
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            ant.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());     
                            
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            temp.setConteudo((ax2 - ax1) + xt, (ay2 - ay1) + yt, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                    }
                }
                
                contador++;
                antAnt = ant;
                ant = temp;
                temp = temp.getProximo(); // Ir para o proximo no
            }
        }
        setTipo(TipoPrimitivo.NENHUM);
        redesenhar(g);
    }
    
    /**
     * rotacaoPrimitivos
     *
     * rotaciona os primitivos e altera na ED
     */
    public void rotacaoPrimitivos(Graphics g){
        int ax1, ay1, ax2, ay2, ax3, ay3, xr, yr, xc, yc;
        float angulo = Float.parseFloat(JOptionPane.showInputDialog("Angulo: "));
        double anguloRadianos = Math.toRadians(angulo); // Converter de graus para r
        
        //Ponto da ED que e o mais proximo de onde o usuario clicou
        double novoPonto[] = selecionarPontoProximo(g);
        
        if(novoPonto[0] != -1){
            No temp = armazenador[(int)novoPonto[0]].getInicio();
            No ant = null;
            No antAnt = null; 
            int contador = 1;

            // Percorrer a lista ligada e atualizar com os novos pontos a ED
            while (temp != null && contador <= armazenador[(int)novoPonto[0]].getQtdNos()) {
                // Obter x1 e y1
                ax1 = ((Integer) temp.getConteudox()).intValue();
                ay1 = ((Integer) temp.getConteudoy()).intValue();

                if(ax1 == novoPonto[1] && ay1 == novoPonto[2]){
                    if(novoPonto[0] == 1 || novoPonto[0] == 2|| novoPonto[0] == 3){//se for RETA, CIRCULO, RETANGULO
                        if(contador % 2 != 0){
                            ant = temp;
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            
                            //coordenadas do centro da figura
                            xc = (ax1 + ax2) / 2;
                            yc = (ay1 + ay2) / 2;
                            if(novoPonto[0] == 2){//o centro do circulo e o ponto do centro
                                xc = ax1;
                                yc = ay1;
                            }
                            
                            if(novoPonto[0] != 2){//calculo do novo ponto apos a rotacao, para a reta ou retangulo
                                xr = (int) (xc + (ax1 - xc) * Math.cos(anguloRadianos) - (ay1 - yc) * Math.sin(anguloRadianos));
                                yr = (int) (yc + (ax1 - xc) * Math.sin(anguloRadianos) + (ay1 - yc) * Math.cos(anguloRadianos));
                                ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            }
                            
                            xr = (int) (xc + (ax2 - xc) * Math.cos(anguloRadianos) - (ay2 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax2 - xc) * Math.sin(anguloRadianos) + (ay2 - yc) * Math.cos(anguloRadianos));
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                        else{
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2) / 2;
                            yc = (ay1 + ay2) / 2;
                            if(novoPonto[0] == 2){
                                xc = ax1;
                                yc = ay1;
                            }
                            
                            if(novoPonto[0] != 2){
                                xr = (int) (xc + (ax1 - xc) * Math.cos(anguloRadianos) - (ay1 - yc) * Math.sin(anguloRadianos));
                                yr = (int) (yc + (ax1 - xc) * Math.sin(anguloRadianos) + (ay1 - yc) * Math.cos(anguloRadianos));
                                temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                            }
                            
                            xr = (int) (xc + (ax2 - xc) * Math.cos(anguloRadianos) - (ay2 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax2 - xc) * Math.sin(anguloRadianos) + (ay2 - yc) * Math.cos(anguloRadianos));
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                        }
                    }
                    else if(novoPonto[0] == 4){//se for TRIANGULO
                        if(contador % 3 == 0){
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            
                            ax3 = ((Integer) antAnt.getConteudox()).intValue();
                            ay3 = ((Integer) antAnt.getConteudoy()).intValue();
                            
                            //ponto do centro
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;

                            //calculo dos novos pontos apos a rotacao
                            xr = (int) (xc + (ax1 - xc) * Math.cos(anguloRadianos) - (ay1 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax1 - xc) * Math.sin(anguloRadianos) + (ay1 - yc) * Math.cos(anguloRadianos));
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                            
                            xr = (int) (xc + (ax2 - xc) * Math.cos(anguloRadianos) - (ay2 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax2 - xc) * Math.sin(anguloRadianos) + (ay2 - yc) * Math.cos(anguloRadianos));
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) (xc + (ax3 - xc) * Math.cos(anguloRadianos) - (ay3 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax3 - xc) * Math.sin(anguloRadianos) + (ay3 - yc) * Math.cos(anguloRadianos));
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                        }else if((contador + 2) % 3 == 0){
                            antAnt = temp;
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue(); 
                            
                            ant = temp;
                            temp = temp.getProximo();
                            ax3 = ((Integer) temp.getConteudox()).intValue();
                            ay3 = ((Integer) temp.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;
                            
                            xr = (int) (xc + (ax1 - xc) * Math.cos(anguloRadianos) - (ay1 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax1 - xc) * Math.sin(anguloRadianos) + (ay1 - yc) * Math.cos(anguloRadianos));
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                            
                            xr = (int) (xc + (ax2 - xc) * Math.cos(anguloRadianos) - (ay2 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax2 - xc) * Math.sin(anguloRadianos) + (ay2 - yc) * Math.cos(anguloRadianos));
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) (xc + (ax3 - xc) * Math.cos(anguloRadianos) - (ay3 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax3 - xc) * Math.sin(anguloRadianos) + (ay3 - yc) * Math.cos(anguloRadianos));
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }else if((contador + 1) % 3 == 0){
                            antAnt = temp;
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();    
                            
                            temp = temp.getProximo();
                            ax3 = ((Integer) temp.getConteudox()).intValue();
                            ay3 = ((Integer) temp.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;
                            
                            xr = (int) (xc + (ax1 - xc) * Math.cos(anguloRadianos) - (ay1 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax1 - xc) * Math.sin(anguloRadianos) + (ay1 - yc) * Math.cos(anguloRadianos));
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                            
                            xr = (int) (xc + (ax2 - xc) * Math.cos(anguloRadianos) - (ay2 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax2 - xc) * Math.sin(anguloRadianos) + (ay2 - yc) * Math.cos(anguloRadianos));
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) (xc + (ax3 - xc) * Math.cos(anguloRadianos) - (ay3 - yc) * Math.sin(anguloRadianos));
                            yr = (int) (yc + (ax3 - xc) * Math.sin(anguloRadianos) + (ay3 - yc) * Math.cos(anguloRadianos));
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                    }
                }
                
                contador++;
                antAnt = ant;
                ant = temp;
                temp = temp.getProximo(); // Ir para o proximo no
            }
        }
        setTipo(TipoPrimitivo.NENHUM);
        redesenhar(g);
    }
    
    /**
     * escalaPrimitivos
     *
     * altera a escala do primitivo a atualiza na ED
     */
    public void escalaPrimitivos(Graphics g){
        int ax1, ay1, ax2, ay2, ax3, ay3, xr, yr, xc, yc;
        int Sx = Integer.parseInt(JOptionPane.showInputDialog("Forneça o fator de escala Sx: "));
        int Sy = Integer.parseInt(JOptionPane.showInputDialog("Forneça o fator de escala Sy: "));
        
        //Ponto da ED que e o mais proximo de onde o usuario clicou
        double novoPonto[] = selecionarPontoProximo(g);
        
        if(novoPonto[0] != -1){
            No temp = armazenador[(int)novoPonto[0]].getInicio();
            No ant = null;
            No antAnt = null; 
            int contador = 1;

            // Percorrer a lista ligada e atualizar com os novos pontos a ED
            while (temp != null && contador <= armazenador[(int)novoPonto[0]].getQtdNos()) {
                // Obter x1 e y1
                ax1 = ((Integer) temp.getConteudox()).intValue();
                ay1 = ((Integer) temp.getConteudoy()).intValue();

                if(ax1 == novoPonto[1] && ay1 == novoPonto[2]){
                    if(novoPonto[0] == 1 || novoPonto[0] == 2|| novoPonto[0] == 3){//e for RETA, CIRCULO, RETANGULO
                        if(contador % 2 != 0){
                            ant = temp;
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue();
                            
                            //ponto do centro da figura
                            xc = (ax1 + ax2) / 2;
                            yc = (ay1 + ay2) / 2;
                            if(novoPonto[0] == 2){
                                xc = ax1;
                                yc = ay1;
                            }
                            
                            //calculo dos novos pontos apos a escala
                            xr = (int) ax1 * Sx + xc *(1 - Sx);
                            yr = (int) ay1 * Sy + yc *(1 - Sy);
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            
                            xr = (int) ax2 * Sx + xc *(1 - Sx);
                            yr = (int) ay2 * Sy + yc *(1 - Sy);
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                        else{
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2) / 2;
                            yc = (ay1 + ay2) / 2;
                            if(novoPonto[0] == 2){
                                xc = ax1;
                                yc = ay1;
                            }
                           
                            xr = (int) ax1 * Sx + xc *(1 - Sx);
                            yr = (int) ay1 * Sy + yc *(1 - Sy);
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                            
                            xr = (int) ax2 * Sx + xc *(1 - Sx);
                            yr = (int) ay2 * Sy + yc *(1 - Sy);
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                        }
                    }
                    else if(novoPonto[0] == 4){//se for TRIANGULO
                        if(contador % 3 == 0){
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();
                            
                            ax3 = ((Integer) antAnt.getConteudox()).intValue();
                            ay3 = ((Integer) antAnt.getConteudoy()).intValue();
                            
                            //ponto do centro da figura
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;
                            
                            xr = (int) ax1 * Sx + xc *(1 - Sx);
                            yr = (int) ay1 * Sy + yc *(1 - Sy);
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                            
                            xr = (int) ax2 * Sx + xc *(1 - Sx);
                            yr = (int) ay2 * Sy + yc *(1 - Sy);
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) ax3 * Sx + xc *(1 - Sx);
                            yr = (int) ay3 * Sy + yc *(1 - Sy);
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                        }else if((contador + 2) % 3 == 0){
                            antAnt = temp;
                            temp = temp.getProximo();
                            ax2 = ((Integer) temp.getConteudox()).intValue();
                            ay2 = ((Integer) temp.getConteudoy()).intValue(); 
                            
                            ant = temp;
                            temp = temp.getProximo();
                            ax3 = ((Integer) temp.getConteudox()).intValue();
                            ay3 = ((Integer) temp.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;
                            
                            xr = (int) ax1 * Sx + xc *(1 - Sx);
                            yr = (int) ay1 * Sy + yc *(1 - Sy);
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                            
                            xr = (int) ax2 * Sx + xc *(1 - Sx);
                            yr = (int) ay2 * Sy + yc *(1 - Sy);
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) ax3 * Sx + xc *(1 - Sx);
                            yr = (int) ay3 * Sy + yc *(1 - Sy);
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }else if((contador + 1) % 3 == 0){
                            antAnt = temp;
                            ax2 = ((Integer) ant.getConteudox()).intValue();
                            ay2 = ((Integer) ant.getConteudoy()).intValue();    
                            
                            temp = temp.getProximo();
                            ax3 = ((Integer) temp.getConteudox()).intValue();
                            ay3 = ((Integer) temp.getConteudoy()).intValue();
                            
                            xc = (ax1 + ax2 + ax3) / 3;
                            yc = (ay1 + ay2 + ay3) / 3;
                            
                            xr = (int) ax1 * Sx + xc *(1 - Sx);
                            yr = (int) ay1 * Sy + yc *(1 - Sy);
                            antAnt.setConteudo(xr, yr, antAnt.getConteudoEsp(), antAnt.getConteudoCor());
                            
                            xr = (int) ax2 * Sx + xc *(1 - Sx);
                            yr = (int) ay2 * Sy + yc *(1 - Sy);
                            ant.setConteudo(xr, yr, ant.getConteudoEsp(), ant.getConteudoCor());
                            
                            xr = (int) ax3 * Sx + xc *(1 - Sx);
                            yr = (int) ay3 * Sy + yc *(1 - Sy);
                            temp.setConteudo(xr, yr, temp.getConteudoEsp(), temp.getConteudoCor());
                        }
                    }
                }
                contador++;
                antAnt = ant;
                ant = temp;
                temp = temp.getProximo(); // Ir para o proximo no
            }
        }
        setTipo(TipoPrimitivo.NENHUM);
        redesenhar(g);
    }
}
