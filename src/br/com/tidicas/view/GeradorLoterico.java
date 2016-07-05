package br.com.tidicas.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import br.com.tidicas.util.TipoJogo;
import br.com.tidicas.util.Util;

/** 
 * Cria uma repositorio para N bolas, e as adciona, uma a uma, da 1 ate a N no repositorio.  
 * Remove uma bola do respositorio, sorteada entre o index 0 e o numero de bolas
 * no respositorio, esse index nao quer dizer quer sera o proprio numero
 * e raramente sera ele e somento o indice da bola que sera sorteada
 * que foi previamente embaralhada.
 *  
 * @author Evaldo Junior
 *
 */

public class GeradorLoterico extends JFrame{
    
	private static final long serialVersionUID = -3783523166826421315L;
	
	private JLabel headerLabel;
	private JLabel bottomLabel;
	private JLabel statusLabel;   
	private static JTextArea outputTextArea;
	private static JScrollPane scrollPane;
	private static JProgressBar progressBar;   
	private static JButton startButton;
	private static JButton exit;
	private static JButton about;
	private Task task;
	
   public GeradorLoterico(){
      prepareGUI();
   }

   public static void main(String[] args){
      new GeradorLoterico();
   }

   private void prepareGUI(){
      setTitle("Gerador de N�meros Aleat�rios para Jogos de Loteria");
      setSize(600,400);      
      setLayout(null);
      setLocationRelativeTo(null);  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });          
      
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("", JLabel.CENTER);
      bottomLabel = new JLabel("", JLabel.CENTER);
      startButton = new JButton("Gerar");
      exit = new JButton("Sair");
      about = new JButton("Sobre");
      
      exit.addActionListener(new ActionListener() {
 	     @Override
 	     public void actionPerformed(ActionEvent e) {
 	    	 System.exit(0);
 	     }});

      JFrame frameDialog = (JFrame)this; 
      about.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		  String arquivo = "README.txt";    		  
    		  String conteudo = "";
    		  
  	    	  try{
  	    		  InputStream in = getClass().getResourceAsStream(arquivo);
  	    	 	  Reader reader = new InputStreamReader(in);
  	    	 	  BufferedReader br = new BufferedReader(reader);
  	    	 		  	    	 		
				  while(br.ready()){
					  conteudo = conteudo + br.readLine() + "\r\n";  	    	 			
				  }
  	    	 	  br.close();
  	    	 	  
  	    	 	}catch(IOException ex){
  	    	 		ex.printStackTrace();
  	    	 	}
  	    	
  	    	JDialog dialog = new JDialog(frameDialog, true);
  	    	JButton close= new JButton("Fechar");
  	    	close.addActionListener(new ActionListener() {
  	  	     @Override
  	  	     public void actionPerformed(ActionEvent e) {
  	  	    	dialog.setVisible(false);
  	  	     }});

  	    	dialog.setTitle("Sobre");
  	    	dialog.setResizable(false);
  	    	JPanel jPanel = new JPanel();
  	    	JTextArea jTextArea = new JTextArea("",20,60);
  	    	JScrollPane jScrollPane = new JScrollPane (jTextArea, 
  					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
  					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  	    	
  	    	jPanel.setLayout(null);
  	    	jPanel.setBounds(20, 15, 450, 400);
  	    	jScrollPane.setBounds(20, 15, 450, 400);
  	    	jTextArea.setBounds(20, 15, 450, 400);
  	    	close.setBounds(200, 430, 80, 20);
  	    	jTextArea.setEditable(false);
  	    	jTextArea.setText(conteudo);  	    	
  	    	jTextArea.setCaretPosition(0);
  	        jPanel.add(jScrollPane);
  	        jPanel.add(close);
  	        dialog.add(jPanel);
  	        dialog.pack();
  	        dialog.setSize(new Dimension(500, 490));
  	        dialog.setLocationRelativeTo(frameDialog);
  	        dialog.setVisible(true);
  	     }});
      
      progressBar = new JProgressBar(0, 100);
      outputTextArea = new JTextArea("",15,40);
      
      scrollPane = new JScrollPane (outputTextArea, 
				JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);      
      
      JPanel panel = new JPanel();
      
      panel.setBounds(0, 80, 600, 500);      
      headerLabel.setBounds(190, -10, 200, 50);      
      startButton.setBounds(250, 30, 70, 20);
      exit.setBounds(520, 10, 70, 20);
      about.setBounds(520, 30, 70, 20);
      progressBar.setBounds(190, 55, 200, 20);
      statusLabel.setBounds(40, 55, 200, 20);
      outputTextArea.setBounds(0, 100, 200, 100);
      scrollPane.setBounds(0, 100, 200, 100);
      bottomLabel.setBounds(190, 120, 200, 100);
      
      add(headerLabel);
      add(statusLabel);
      add(startButton);
      add(exit);
      add(about);
      add(progressBar);      
      panel.add(scrollPane);
      panel.add(bottomLabel);
      add(panel);      
      showProgressBarDemo();  
      setVisible(true);
   }
   
   private void showProgressBarDemo(){
	     headerLabel.setText("Gerador de N�meros Aleat�rios");
	     bottomLabel.setText("Copyright (C) 2016 - Evaldo Junior");
	      
	     progressBar.setValue(0);
	     progressBar.setStringPainted(true);
	      
	     outputTextArea.setEditable(false);
      
	     startButton.addActionListener(new ActionListener() {
	     @Override
	     public void actionPerformed(ActionEvent e) {
	        task = new Task();                
	        task.start();
	        outputTextArea.setText("");
	        
	        outputTextArea.append("Geracao de numeros para a Mega Sena \r\n");
	        outputTextArea.append(Arrays.toString(Util.generateNumeros(Integer.parseInt(TipoJogo.MEGA_SENA.toString()), Integer.parseInt(TipoJogo.MEGA_SENA_DEZENAS.toString()))) + "\r\n");
	    	 
	    	outputTextArea.append("\r\n");
	    	
	    	outputTextArea.append("Geracao de numeros para a Loto Facil \r\n");
	    	outputTextArea.append(Arrays.toString(Util.generateNumeros(Integer.parseInt(TipoJogo.LOTO_FACIL.toString()), Integer.parseInt(TipoJogo.LOTO_FACIL_DEZENAS.toString()))) + "\r\n");
	    	outputTextArea.append("\r\n");
	    	
	    	outputTextArea.append("Geracao de numeros para a Quina \r\n");
	    	outputTextArea.append(Arrays.toString(Util.generateNumeros(Integer.parseInt(TipoJogo.QUINA.toString()), Integer.parseInt(TipoJogo.QUINA_DEZENAS.toString()))) + "\r\n");
	    	outputTextArea.append("\r\n");
	    	
	    	outputTextArea.append("Geracao de numeros para a Lotomania \r\n");
	    	outputTextArea.append(Arrays.toString(Util.generateNumeros(Integer.parseInt(TipoJogo.LOTOMANIA.toString()), Integer.parseInt(TipoJogo.LOTOMANIA_DEZENAS.toString()))) + "\r\n");
	    	outputTextArea.append("\r\n");
	    	
	    	outputTextArea.append("Geracao de numeros para a DuplaSena \r\n");
	    	outputTextArea.append(Arrays.toString(Util.generateNumeros(Integer.parseInt(TipoJogo.DUPLASENA.toString()), Integer.parseInt(TipoJogo.DUPLASENA_DEZENAS.toString()))) + "\r\n");
	    	
	     }});
        
   }

   private class Task extends Thread {    
      public Task(){
      }

      public void run(){
         for(int i =0; i<= 100; i+=10){
            final int progress = i;
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  progressBar.setValue(progress);
                
               }
            });
            try {
               Thread.sleep(20);
            } catch (InterruptedException e) {}
         }
      }
   }
   
   
}