package view;

import controler.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import static java.lang.Integer.*;
import java.awt.event.*;
import java.awt.*;

public class TelaCadastro implements ActionListener{
	private static JFrame tela;
	private static JRadioButton canina, felina, roedor;
	private ControleDados dados;
	
	JTextField TextoIdade;
	JTextField TextoIdadeAnimal;
	JTextField TextoRaca;
	JTextField TextoNome;
	JTextField TextoNomePet;
	
	JComboBox listaPorte;
	JComboBox listaGenero;
	
	String especie;
	String caracteristicaAnimal;
	
	JLabel jlabTamanhoPelagem, jlabSituacaoDentes, jlabSituacaoFocinho;
	
	JComboBox<String>listaPelagem; 
	JComboBox<String>listaSituacaoDente;
	JComboBox<String>listaSituacaoFocinho;
		
	String generos[] = {"Macho", "Fêmea", "Indefinido"};
	String porte[] = {"Alto", "Médio", "Baixo"};
	
	String pelagem[] = {"Alta", "Média", "Curta"};
	String situacaoDente[] = {"Ótima", "Média", "Ruim"};
	String situacaoFocinho[] = {"Ótimo", "Médio", "Ruim"};
		
	TelaCadastro (ControleDados dados) {
			this.dados = dados;
		
			tela = new JFrame("Tela de Cadastro!"); 
			tela.setSize(660, 800);
			tela.setLayout(null); 
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			tela.setVisible(true); 
				
			titulo();
			construirCadastro();
		    
		}
	
		public void titulo() {
		JLabel jlabTitulo = new JLabel("TELA DE CADASTRO");
		jlabTitulo.setBounds(545, 185, 400, 30);
		
		tela.add(jlabTitulo); 
		}
		
	    public void construirCadastro() {
			nome();
			idade();
			nomePet();
			especie();
			raca();
			altura();
			idadeAnimal();
			genero();
			adicionarAnimal();	
			pelagem();
			situacaoDentes();
			situacaoFocinho();
	    }
		
		public void nome() {
			TextoNome = new JTextField();
			JLabel jlabNome = new JLabel("Digite seu nome: ");
			
			TextoNome.setBounds(560, 250, 200, 30);
			jlabNome.setBounds(460, 250, 100, 30);
			
			tela.add(TextoNome);
			tela.add(jlabNome);
		}
		
		public void idade() {
		    TextoIdade = new JTextField();
			JLabel jlabIdade = new JLabel("Digite sua idade: ");
			
			TextoIdade.setBounds(560, 300, 50, 30);
		    jlabIdade.setBounds(460, 300, 100, 30);
		    
		    tela.add(TextoIdade);
		    tela.add(jlabIdade);
		}
		
		public void nomePet() {
			TextoNomePet = new JTextField();
			JLabel jlabNomePet = new JLabel("Nome do Pet: ");
			
			TextoNomePet.setBounds(560, 400, 200, 30);
			jlabNomePet.setBounds(460, 400, 110, 30);
			
			tela.add(TextoNomePet);
			tela.add(jlabNomePet);
		}
		
		public void especie() {
			JLabel jlabEspecie = new JLabel("Selecione a espécie: ");
			canina = new JRadioButton("Canina");
			felina = new JRadioButton("Felina");
			roedor = new JRadioButton("Roedor");
			
			canina.setBounds(580, 600, 65, 30);
			felina.setBounds(650, 600, 60, 30);
			roedor.setBounds(720, 600, 70, 30);
			jlabEspecie.setBounds(460, 600, 150, 30);
			
			canina.addActionListener(this);
			felina.addActionListener(this);
			roedor.addActionListener(this);
			
			tela.add(jlabEspecie);
			tela.add(canina);
			tela.add(felina);
			tela.add(roedor);
			
			ButtonGroup opcoes = new ButtonGroup();
			opcoes.add(canina);
			opcoes.add(felina);
			opcoes.add(roedor);
		}
		
		public void raca() {
			TextoRaca = new JTextField();
			JLabel jlabRaca = new JLabel("Raça do Pet: ");
			
			TextoRaca.setBounds(560, 500, 200, 30);
			jlabRaca.setBounds(460, 500, 100, 30);
		
			tela.add(jlabRaca);
			tela.add(TextoRaca);
		}
		
		public void altura() {
			JLabel  jlabAltura = new JLabel("Porte do Pet: ");
			listaPorte = new JComboBox<>(porte);
			
			listaPorte.setBounds(560,450, 200, 30);
			jlabAltura.setBounds(460, 450, 150, 30);
			
			tela.add(jlabAltura);
			tela.add(listaPorte);
		}
		
		public void idadeAnimal() {
		    TextoIdadeAnimal = new JTextField();
			JLabel jlabIdadeAnimal = new JLabel("Idade do Pet: ");
			
			TextoIdadeAnimal.setBounds(560, 550, 200, 30);
			jlabIdadeAnimal.setBounds(460, 550, 100, 30);
			
			tela.add(jlabIdadeAnimal);
			tela.add(TextoIdadeAnimal);	
		}
		
		public void genero() {
			JLabel jlabGenero = new JLabel("Gênero do Pet: ");
			listaGenero = new JComboBox<>(generos); 
			
			listaGenero.setBounds(560, 350, 200, 30);
			jlabGenero.setBounds(460, 350, 150, 30);
			
			tela.add(jlabGenero); 	
			tela.add(listaGenero);  	
		}
		
		public void adicionarAnimal() {
			JButton adicionarAnimal = new JButton("Adicionar Pet");
			adicionarAnimal.setBounds(520, 750, 200, 40);
		
			adicionarAnimal.setActionCommand("Adicionar Pet");
	        adicionarAnimal.addActionListener(this);
			
			tela.add(adicionarAnimal);
		}
		
		public void pelagem() {
	        jlabTamanhoPelagem = new JLabel("Tamanho da pelagem: ");
	        jlabTamanhoPelagem.setBounds(460, 650, 150, 30);
	        jlabTamanhoPelagem.setVisible(false);
	        tela.add(jlabTamanhoPelagem);
	        
	        listaPelagem = new JComboBox<>(pelagem);	
			listaPelagem.setBounds(590, 650, 170, 30);
			listaPelagem.setVisible(false);
			tela.add(listaPelagem);
		}
		
		public void situacaoDentes() {
			jlabSituacaoDentes = new JLabel("Situação dos dentes: ");
		    jlabSituacaoDentes.setBounds(460, 650, 150, 30);
		    jlabSituacaoDentes.setVisible(false);
		    tela.add(jlabSituacaoDentes);
		        
	        listaSituacaoDente = new JComboBox<>(situacaoDente);	
	        listaSituacaoDente.setBounds(590, 650, 170, 30);
            listaSituacaoDente.setVisible(false);
			tela.add(listaSituacaoDente); 
		}
		
		public void situacaoFocinho() {
			jlabSituacaoFocinho = new JLabel("Situação do fucinho: ");
			jlabSituacaoFocinho.setBounds(460, 650, 150, 30);
			jlabSituacaoFocinho.setVisible(false);
		    tela.add(jlabSituacaoFocinho);
		        
	        listaSituacaoFocinho = new JComboBox<>(situacaoFocinho);	
	        listaSituacaoFocinho.setBounds(590, 650, 170, 30);
	        listaSituacaoFocinho.setVisible(false);
			tela.add(listaSituacaoFocinho); 
		}
		
		//Evento de ação
		
	public void actionPerformed(ActionEvent ae) { 
		
		if ("Adicionar Pet" == ae.getActionCommand()) {	
		
			  dados = new ControleDados();
			  
			  String nomeDono = TextoNome.getText();
		      int idadeDono = Integer.parseInt(TextoIdade.getText());
			  String nomePet = TextoNomePet.getText();
			  String raca = TextoRaca.getText();
			  String porte = (String) listaPorte.getSelectedItem(); 
		      int idadePet = Integer.parseInt(TextoIdadeAnimal.getText());
			  String genero = (String) listaGenero.getSelectedItem(); 
			  
			  caracteristicaAnimal = (String) listaPelagem.getSelectedItem();
			  
			  boolean add = dados.adicionarAnimal(nomeDono, idadeDono, nomePet, especie, raca, porte, idadePet, genero, caracteristicaAnimal);
			  
			  int index = dados.buscarAnimal(nomePet);
			  
			  if(add){
				new TelaListaAnimais(dados, index);  
				tela.dispose();
			  }else {
			JOptionPane.showMessageDialog(null, "Pet já cadastrado!");
			  }				  
		}
		if(felina.isSelected() == true && canina.isSelected() == false && roedor.isSelected() == false) {
			jlabTamanhoPelagem.setVisible(true);
			listaPelagem.setVisible(true);
			
			jlabSituacaoDentes.setVisible(false);
	        listaSituacaoDente.setVisible(false);
	        jlabSituacaoFocinho.setVisible(false);
	        listaSituacaoFocinho.setVisible(false);
	        
	        caracteristicaAnimal = (String) listaPelagem.getSelectedItem();
	        especie = "felina";
		}
		if(roedor.isSelected() == true && canina.isSelected() == false && felina.isSelected() == false) {
			jlabSituacaoDentes.setVisible(true);
	        listaSituacaoDente.setVisible(true);
		
	        jlabTamanhoPelagem.setVisible(false);
			listaPelagem.setVisible(false);
			jlabSituacaoFocinho.setVisible(false);
			listaSituacaoFocinho.setVisible(false);
			
			caracteristicaAnimal = (String) listaSituacaoDente.getSelectedItem();
			especie= "roedor";
		}
		if(canina.isSelected() == true && roedor.isSelected() == false && felina.isSelected() == false) {
			jlabSituacaoFocinho.setVisible(true);
			listaSituacaoFocinho.setVisible(true);
		
	        jlabTamanhoPelagem.setVisible(false);
			listaPelagem.setVisible(false);
			jlabSituacaoDentes.setVisible(false);
	        listaSituacaoDente.setVisible(false);
	        
	        caracteristicaAnimal = (String) listaSituacaoFocinho.getSelectedItem();
	        especie = "canina";
		}
	}
}
