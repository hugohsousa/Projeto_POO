import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Escreva uma descrição da classe SmartSpeaker aqui.
 * 
 * @author (Grupo 12)
 */

public class View extends JFrame implements ActionListener {
     //Variáveis de instância
     private Controller ctl;
     JButton verc = new JButton("Ver a lista das comunidades");
     JButton addc = new JButton("Adicionar uma Comunidade");
     JTextField rc = new JTextField(10);
     JButton submitc = new JButton("Submeter");
     JButton submitch = new JButton("Submeter");
     JButton submitah = new JButton("Submeter");
     JButton addh = new JButton("Adicionar uma Casa");
     JButton verh = new JButton("Ver as casas de uma comunidade");
     JButton turnallon = new JButton("Ligar todos os dispositivos de uma casa");
     JButton turnalloff = new JButton("Desligar todos os dispositivos de uma casa");
     JButton turnoneon = new JButton("Ligar um dispositivo de uma casa");
     JButton turnoneoff = new JButton("Desligar um dispositivo de casa");
     JButton addd = new JButton("Adicionar um Dispositivo");
     JButton verd = new JButton("Ver dispositivos de uma casa");
     JButton adds = new JButton("Adicionar Fornecedor");
     JButton vers = new JButton("Ver Fornecedores");
     JButton changedata = new JButton("Avançar no tempo");
     JButton calccone = new JButton("Ver o consumo de um dispositivo");
     JButton calconeh = new JButton("Ver a fatura de uma casa");
     JButton savestate = new JButton("Guardar Estado");
     JButton loadstate = new JButton("Carregar Estado");


     /**
      * Construtor parametrizado
      * @param ctl Controler que será usado pela view
      */
     public View(Controller ctl) {
          this.ctl = ctl;
     }
     /**
      * Método para iniciar a view e criar o menu
      */
     public void run() {
          JPanel panel = new JPanel(new GridLayout(12,12));

          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(600,600);
          this.setVisible(true);
          panel.add(vers);
          panel.add(adds);
          panel.add(verc);
          panel.add(addc);
          panel.add(verh);
          panel.add(addh);
          panel.add(verd);
          panel.add(verd);
          panel.add(addd);
          panel.add(turnallon);
          panel.add(turnalloff);
          panel.add(turnoneon);
          panel.add(turnoneoff);
          panel.add(changedata);
          panel.add(calccone);
          panel.add(calconeh);
          panel.add(savestate);
          panel.add(loadstate);
          vers.addActionListener(this);
          adds.addActionListener(this);
          verd.addActionListener(this);
          verc.addActionListener(this);
          addc.addActionListener(this);   
          verh.addActionListener(this);
          addh.addActionListener(this);
          verd.addActionListener(this);
          addd.addActionListener(this);
          turnallon.addActionListener(this);
          turnalloff.addActionListener(this);
          turnoneon.addActionListener(this);
          turnoneoff.addActionListener(this);
          changedata.addActionListener(this);
          calccone.addActionListener(this);
          calconeh.addActionListener(this);
          savestate.addActionListener(this);
          loadstate.addActionListener(this);  
          this.add(panel);
     }

     /**
      * Método para tratar dos ações dos botões
      * @param e Evento enviado quando usado um botão
      */
     public void actionPerformed(ActionEvent e) {
          if(e.getSource() == vers) {
               String s = ctl.showSuppliers();
               JOptionPane.showMessageDialog(null,s);
          }
          if(e.getSource() == adds) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:Nome,Custo"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",2);
                    ctl.addSupplier(args);
               }
          }
          if(e.getSource() == verc) {
               String comunidades = ctl.showComunidades();
               JFrame nf = new JFrame();
               nf.setSize(300,300);
               nf.setVisible(true);
               JPanel nw = new JPanel();
               JTextArea text = new JTextArea(comunidades);
               nw.add(text);
               nf.add(nw);
          }
          if(e.getSource() == addc) {
               ctl.addComunidade();
               JOptionPane.showMessageDialog(null, "Comunidade Adicionada");
          }
          if(e.getSource() == verh) {
               JFrame nf = new JFrame();
               nf.setSize(300,300);
               nf.setVisible(true);
               JPanel nw = new JPanel();
               JLabel l = new JLabel("Insira o id da comunidade");
               nw.add(l);
               nw.add(rc);
               nw.add(submitch);
               submitch.addActionListener(this);
               nf.add(nw);
          }
          if(e.getSource() == submitch) {
               String s = ctl.verCasasComunidade(rc.getText());
               JOptionPane.showMessageDialog(null, "Submetido com sucesso\n" + s);
          }
          if(e.getSource() == addh) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Nome,Nif,Fornecedor"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",4);
                    ctl.addHouse(args);
               }
          }
          if(e.getSource() == verd) {
               String input = JOptionPane.showInputDialog(null,"Adiciona o id da comunidade e da casa, separada por vírgulas:"
                                                          ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",2);
                    String s = ctl.showDispositivos(args[0],args[1]);
                    JOptionPane.showMessageDialog(null, s);
               }
          }    
          if(e.getSource() == addd) {
               String input = JOptionPane.showInputDialog(null,"Introduza o id da comunidade, o id casa e a divisão, separados por virgulas",null);
               if ((input != null) && (input.length() > 0)) {
                    String[] ids = input.split(",",3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Escolha um tipo de dispositivo e insira os argumentos desejados como nos exemplos:\n");
                    sb.append("SmartBulb - 1,Codigo do Fabricante,Custo de Instalação,Estado,Consumo,Tonalidade,Tamanho,Consumo Fixo\n");
                    sb.append("SmartCamera - 2,Codigo do Fabricante,Custo de Instalação,Estado,Consumo,Resolução,Tamanho dos Ficheiros\n");
                    sb.append("SmartSpeaker - 3,Codigo do Fabricante,Custo de Instalação,Estado,Consumo,Volume,Radio,Marca\n");
                    sb.append("SmartTv - 4,Codigo do Fabricante,Custo de Instalação,Estado,Canal,Brilho,Volume,Tamanho\n");
                    sb.append("SmartVacuum - 5,Codigo do Fabricante,Custo de Instalação,Estado,Peso do Dispositivo,Peso Atual,Peso Máximo\n");
                    sb.append("SmartAc - 6,Codigo do Fabricante,Custo de Instalação,Estado,Temperatura,Modo");
                    String inputn = JOptionPane.showInputDialog(null,sb.toString(),null);
                    if ((inputn != null) && (inputn.length() > 0)) {
                         String[] args = inputn.split(",",10);
                         ctl.addDispositivo(ids,args);
                    }
               }
          }
          if(e.getSource() == turnallon) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",2);
                    ctl.turnAllOn(args);
               }
          }
          if(e.getSource() == turnalloff) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",2);
                    ctl.turnAllOff(args);
               }
          }
          if(e.getSource() == turnoneon) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa,Id Dispositivo"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",3);
                    ctl.turnOneOn(args);
               }
          }
          if(e.getSource() == turnoneoff) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa,Id Dispositivo"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",3);
                    ctl.turnOneOff(args);
               }
          }
          if(e.getSource() == changedata) {
               String input = JOptionPane.showInputDialog(null,
               "Insira o número de dias que pretende avançar"
              ,null);
               if ((input != null) && (input.length() > 0)) {
                    ctl.changeData(input);
               }
          }
          if(e.getSource() == calccone) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa,Id Dispositivo"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",3);
                    float l = ctl.calcConsumoDispositivo(args);
                    float i = ctl.calcConsumoDispositivoEur(args);
                    JOptionPane.showMessageDialog(null,Float.toString(l)+'\n'+Float.toString(i)+"€");
               }
          }
          if(e.getSource() == calconeh) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira os seguintes argumentos separados por virgulas:\nId da comunidade,Id da Casa"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    String[] args = input.split(",",3);
                    int d = ctl.getDays();
                    float l = ctl.calcConsumoCasa(args);
                    float i = ctl.calcConsumoCasaEur(args);
                    JOptionPane.showMessageDialog(null,"Dias Passados: "+d+'\n'+Float.toString(l)+'\n'+Float.toString(i)+"€");
               }
          }
          if(e.getSource() == loadstate) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira o nome do ficheiro"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    try {
                         ctl.loadFile(input+".txt");
                    } catch (FileNotFoundException e1) {
                         JOptionPane.showMessageDialog(null,"Não existe o ficheiro");
                    } catch (IOException e1) {
                         JOptionPane.showMessageDialog(null,"Não existe o ficheiro");
                    }
               }
          }
          if(e.getSource() == savestate) {
               String input = JOptionPane.showInputDialog(null,
                         "Insira o nome do ficheiro desejado"
                        ,null);
               if ((input != null) && (input.length() > 0)) {
                    try {
                         ctl.saveFile(input+".txt");
                    } catch (IOException e1) {
                         JOptionPane.showMessageDialog(null,"Erro ao guardar");
                    }
               }
          }
     }
}
