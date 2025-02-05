import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
/**
 * Cria a interface com o usuario (GUI)
 * 
 * @author Julio Arakaki 
 * @version 20220815
 */
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.NENHUM;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 1;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, 10);

    // Botoes
    private JButton jbPonto = new JButton("Ponto");
    private JButton jbReta = new JButton("Reta");
    private JButton jbCirculo = new JButton("Circulo");
    private JButton jbRetangulo = new JButton("Retangulo");
    private JButton jbTriangulo = new JButton("Triangulo");
    private JButton jbTransformacoes = new JButton("Transformações");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbRedesenhar = new JButton("Redesenhar");
    private JButton jbDeletar = new JButton("Deletar figura");
    private JButton jbCor = new JButton("Cor");
    private JButton jbSair = new JButton("Sair");
        
    // Criar um menu pop-up
    JPopupMenu popupMenu = new JPopupMenu();
    
    // Adicionar itens ao menu pop-up
    JMenuItem mover = new JMenuItem("Mover");
    JMenuItem girar = new JMenuItem("Girar");
    JMenuItem redimencionar = new JMenuItem("Redimencionar");

    // Entrada (slider) para definir espessura dos primitivos
    private JLabel jlEsp = new JLabel("   Espessura: " + String.format("%-5s", 1));
    private JSlider jsEsp = new JSlider(1, 50, 1);

    /**
     * Constroi a GUI
     *
     * @param larg largura da janela
     * @param alt altura da janela
     */
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);

        // Adicionando os componentes
        barraComandos.add(jbPonto);
        barraComandos.add(jbReta);
        barraComandos.add(jbCirculo);
        barraComandos.add(jbRetangulo);
        barraComandos.add(jbTriangulo);
        barraComandos.add(jbTransformacoes);
        barraComandos.add(jbLimpar); 
        barraComandos.add(jbRedesenhar);
        barraComandos.add(jbDeletar);
        
        // Adicionar itens ao menu pop-up
        popupMenu.add(mover);
        popupMenu.add(girar);
        popupMenu.add(redimencionar);
        
        barraComandos.add(jbCor); // Botao de Cores
        barraComandos.add(jlEsp); // Label para espessura
        barraComandos.add(jsEsp);    // Slider para espacamento
        areaDesenho.setEsp(espAtual); // define a espessura inicial
        barraComandos.add(jbSair); // Botao de Cores

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        // Adiciona "tratador" ("ouvidor") de eventos para cada componente
        jbPonto.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.PONTO;
            areaDesenho.setTipo(tipoAtual);
        });        
        jbReta.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETA;
            areaDesenho.setTipo(tipoAtual);
        });        
        jbCirculo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CIRCULO;
            areaDesenho.setTipo(tipoAtual);
        });      
        jbRetangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETANGULO;
            areaDesenho.setTipo(tipoAtual);
        });  
        jbTriangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.TRIANGULO;
            areaDesenho.setTipo(tipoAtual);
        }); 
        jbTransformacoes.addActionListener(e -> {
            popupMenu.show(jbTransformacoes, 0, jbTransformacoes.getHeight());
        }); 
        mover.addActionListener(e -> {
            Graphics g = areaDesenho.getGraphics(); 
            JOptionPane.showMessageDialog(null, "Clique na figura e no lugar para qual deseja mover");     
            tipoAtual = TipoPrimitivo.TRANSLACAO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.redesenhar(g);
        });      
        girar.addActionListener(e -> {
            Graphics g = areaDesenho.getGraphics(); 
            JOptionPane.showMessageDialog(null, "Clique na figura que deseja girar");     
            tipoAtual = TipoPrimitivo.ROTACAO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.redesenhar(g);
        });  
        redimencionar.addActionListener(e -> {
            Graphics g = areaDesenho.getGraphics(); 
            JOptionPane.showMessageDialog(null, "Clique na figura que deseja redimencionar");     
            tipoAtual = TipoPrimitivo.ESCALA;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.redesenhar(g);
        }); 
        jbLimpar.addActionListener(e -> {
            areaDesenho.removeAll();
            jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivoda tela) 
            tipoAtual = TipoPrimitivo.NENHUM;
            areaDesenho.setTipo(tipoAtual);
            repaint();        
        });   
        jbRedesenhar.addActionListener(e -> {
            Graphics g = areaDesenho.getGraphics(); 
            tipoAtual = TipoPrimitivo.NENHUM;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.redesenhar(g);    
        });
        jbDeletar.addActionListener(e -> {
            Graphics g = areaDesenho.getGraphics(); 
            JOptionPane.showMessageDialog(null, "Clique no ponto vermelho para deletar a figura");     
            tipoAtual = TipoPrimitivo.DELETAR;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.redesenhar(g);
        }); 
        jbCor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(null, "Escolha uma cor", msg.getForeground()); 
            if (c != null){ 
                corAtual = c; // pega do chooserColor 
            }
            areaDesenho.setCorAtual(corAtual); // cor atual
        });  
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Espessura: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual);        
        });        

        jbSair.addActionListener(e -> {
            System.exit(0);
        });        
    }
}
