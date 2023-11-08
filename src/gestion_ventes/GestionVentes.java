package gestion_ventes;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Point;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class GestionVentes extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField PrixtextField;
	private JTextField Nbr_pc_textField;
	private JLabel lbl_total_prx;
	private JLabel lbl_total_prod;
	private JComboBox comboxProduits;
	
	

	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVentes frame = new GestionVentes();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//declarations
    String[] produits= {"","stylo","crayon","cahier 50 pages","chier 150 pages","gomme","marqueur"};
	double prix;
	int nbrpc;
	double total_prx =0;
	int total_prd = 0;
	String prdSelectionné;
	
	DefaultListModel liste_prod;
	DefaultListModel liste_prx;
	
	public GestionVentes() {
		
			
		liste_prod = new DefaultListModel();
		liste_prx = new DefaultListModel();
	
		
		
		
	          
		
		
		
		
		
		setTitle("Système de ventes ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Bureau\\Downloads\\téléchargement.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 460);
		contentPane_1 = new JPanel();
		contentPane_1.setMaximumSize(new Dimension(10, 10));
		contentPane_1.setLocation(new Point(10, 10));
		contentPane_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(11, 40, 642, 51);
		contentPane_1.add(panel);
		panel.setLayout(null);
		
		JComboBox comboxProduits = new JComboBox();
		comboxProduits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if(key==KeyEvent.VK_ENTER) {
					PrixtextField.requestFocus();
					
				}
			}
		});
		comboxProduits.setBounds(27, 29, 132, 22);
		panel.add(comboxProduits);
		
		JLabel lblNewLabel = new JLabel("Choisir un produit");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 0, 132, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prix/Pc");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(247, 7, 112, 14);
		panel.add(lblNewLabel_1);
		
		
		
		PrixtextField = new JTextField();
		
		
		PrixtextField.setBounds(257, 29, 102, 22);
		panel.add(PrixtextField);
		PrixtextField.setColumns(10);
		
		Nbr_pc_textField = new JTextField();
		
		// specify the type of input to numbers (Nr_pc)
		Nbr_pc_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if(!Character.isDigit(key)) {
					e.consume();
				}
					
			}
			
		});
		
		// specify the type of input to numbers (Prix)
				PrixtextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char key = e.getKeyChar();
						if(!Character.isDigit(key)) {
							e.consume();
						}
						char key1 = e.getKeyChar();
						if(key1==KeyEvent.VK_ENTER && !(PrixtextField.getText()).equals(""))  {
							Nbr_pc_textField.requestFocus();
							
						}
					}
					
					});
						
					
					
				
		Nbr_pc_textField.setColumns(10);
		Nbr_pc_textField.setBounds(481, 30, 138, 21);
		panel.add(Nbr_pc_textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre de pièces");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(481, 7, 124, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 166, -2, 51);
		contentPane_1.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 116, 565, 270);
		contentPane_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Liste des achats");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(34, 11, 183, 26);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Liste des prix");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(344, 11, 183, 26);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lbl_total_prod = new JLabel("");
		lbl_total_prod.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		lbl_total_prod.setOpaque(true);
		lbl_total_prod.setBackground(new Color(255, 255, 255));
		lbl_total_prod.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_total_prod.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total_prod.setBounds(37, 233, 173, 26);
		panel_2.add(lbl_total_prod);
		
		JLabel lbl_total_prx = new JLabel("");
		lbl_total_prx.setBackground(new Color(255, 255, 255));
		lbl_total_prx.setOpaque(true);
		lbl_total_prx.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		lbl_total_prx.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_total_prx.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total_prx.setBounds(351, 233, 173, 26);
		panel_2.add(lbl_total_prx);
		
		JList list = new JList();
		list.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		list.setBounds(37, 38, 173, 196);
		panel_2.add(list);
		
		JList list_1 = new JList();
		list_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		list_1.setBounds(351, 38, 173, 196);
		panel_2.add(list_1);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setBounds(50, 383, 120, 31);
		btnajouter.setBorderPainted(false);
		btnajouter.setBackground(new Color(58, 209, 70));
		btnajouter.setForeground(new Color(255, 255, 255));
		btnajouter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnajouter.addActionListener(new ActionListener() {
			public void ajouter() {
				prdSelectionné = comboxProduits.getSelectedItem().toString();
				list.setModel(liste_prod);
				
				
				if(liste_prod.contains(prdSelectionné)) {
					JOptionPane.showMessageDialog(null,"Ce produit est déjà dans la liste !!","Message Informatif",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(prdSelectionné.equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner un produit","Message Informatif",JOptionPane.INFORMATION_MESSAGE);
				}
				else if((PrixtextField.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Entrez le prix du produit !!","Attention !",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if((Nbr_pc_textField.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Entrez le nombre de pieces!!","Attention !",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					
					liste_prod.addElement(prdSelectionné);
					prix = Double.parseDouble(PrixtextField.getText());
					nbrpc = Integer.parseInt(Nbr_pc_textField.getText());
					double montant=prix*nbrpc;
					list_1.setModel(liste_prx);
					liste_prx.addElement(montant);
					total_prd++;
					lbl_total_prod.setText(String.valueOf(total_prd));
					total_prx = Double.parseDouble(lbl_total_prx.getText());
					lbl_total_prx.setText(String.valueOf(montant+=total_prx));
					comboxProduits.setSelectedIndex(0);
					PrixtextField.setText("");
					Nbr_pc_textField.setText("");
					
				
					
				}
				
			
			}
			public void actionPerformed(ActionEvent e) {
				ajouter();
			}
			
		});
		contentPane_1.add(btnajouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(201, 383, 120, 31);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!list.isSelectionEmpty()) {
				int index_prod = list.getSelectedIndex();	
				liste_prod.remove(index_prod);
				total_prd--;
				lbl_total_prod.setText(String.valueOf(total_prd));
				
				double prix_selectionné =Double.parseDouble(liste_prx.getElementAt(index_prod).toString());
				double montant_1 = Double.parseDouble(lbl_total_prx.getText());
				lbl_total_prx.setText(String.valueOf(montant_1-prix_selectionné));
				
				liste_prx.remove(index_prod);
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Selectionnez un produit à supprimer !!","Message Informatif",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSupprimer.setBorderPainted(false);
		btnSupprimer.setBackground(new Color(253, 15, 21));
		contentPane_1.add(btnSupprimer);
		
		JButton btnRénitialiser = new JButton("Rénitialiser");
		btnRénitialiser.setBounds(351, 383, 120, 31);
		btnRénitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liste_prod.clear();
				liste_prx.clear();
				lbl_total_prx.setText("0");
				total_prd=0;
				lbl_total_prod.setText(String.valueOf(total_prd));
				comboxProduits.setSelectedItem(produits[0]);
				Nbr_pc_textField.setText("");
				PrixtextField.setText("");
			}
		});
		btnRénitialiser.setForeground(Color.WHITE);
		btnRénitialiser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRénitialiser.setBorderPainted(false);
		btnRénitialiser.setBackground(new Color(99, 96, 100));
		contentPane_1.add(btnRénitialiser);
		
		JButton btnNewButton_2_1 = new JButton("Ajouter un nouveau produit");
		btnNewButton_2_1.setBounds(40, 4, 241, 37);
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_2_1.setBackground(new Color(58,209,70));
				btnNewButton_2_1.setForeground( Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2_1.setBackground(Color.black);
				btnNewButton_2_1.setForeground( Color.white);
			}
			
		});
		btnNewButton_2_1.setMargin(new Insets(1, 14, 1, 14));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nv_prd = JOptionPane.showInputDialog(null,"Entrer le nouveau produit : " ,"Ajout d'un produit",JOptionPane.DEFAULT_OPTION);
				if(!nv_prd.equals("")) {
					comboxProduits.addItem(nv_prd);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vous n'avez rien entré ! Assurez vous d'entrer un produit");
				}
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBackground(new Color(0, 0, 0));
		contentPane_1.add(btnNewButton_2_1);
		
		
		lbl_total_prod.setText(String.valueOf(total_prd));
		lbl_total_prx.setText(String.valueOf(total_prx));
		
		JButton btn_prd_epuisé = new JButton("Produit épuisé");
		btn_prd_epuisé.setBounds(374, 4, 241, 37);
		btn_prd_epuisé.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_prd_epuisé.setBackground(new Color(235,15,21));
				btn_prd_epuisé.setForeground( Color.black);
			}
			public void mouseExited(MouseEvent e) {
				btn_prd_epuisé.setBackground(Color.black);
				btn_prd_epuisé.setForeground( Color.white);
			}
		});
		btn_prd_epuisé.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prdSelectionné = comboxProduits.getSelectedItem().toString();
				
				int index_prdSelectionné = comboxProduits.getSelectedIndex(); 
				if(index_prdSelectionné != 0) {
						comboxProduits.removeItemAt(index_prdSelectionné);
					for (int i=0 ; i<produits.length;i++) {
						if(i==index_prdSelectionné) {
							produits[i]="";
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Sélectionnez un produit épuisé", "Message Informatif", JOptionPane.INFORMATION_MESSAGE);
				}
			
			
				
			    
				
			}
		});
		btn_prd_epuisé.setMargin(new Insets(1, 14, 1, 14));
		btn_prd_epuisé.setForeground(Color.WHITE);
		btn_prd_epuisé.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_prd_epuisé.setBorderPainted(false);
		btn_prd_epuisé.setBackground(Color.BLACK);
		contentPane_1.add(btn_prd_epuisé);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				print1(panel_2);
			}});

			
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnImprimer.setBorderPainted(false);
		btnImprimer.setBackground(new Color(255, 145, 34));
		btnImprimer.setBounds(495, 383, 120, 31);
		contentPane_1.add(btnImprimer);
		
		
		for(int i=0;i<produits.length;i++) {
			
			comboxProduits.addItem(produits[i]);
			
		}
		
	}
	private void print1(JPanel panel_2) {
		PrinterJob printerjob = PrinterJob.getPrinterJob();
		printerjob.setJobName("Imprimer la facture");
		printerjob.setPrintable(new Printable() {
			public int print(Graphics graphics , PageFormat pageformat,int pageindex) throws PrinterException	{
				if(pageindex > 0) {
					return Printable.NO_SUCH_PAGE;
					
				}
				Graphics2D graphics2D = (Graphics2D)graphics;
				
				graphics2D.translate(pageformat.getImageableX()*2, pageformat.getImageableY()*2);
				graphics2D.scale(0.8,0.8);
				panel_2.paint(graphics2D);
				return Printable.PAGE_EXISTS;
			}
			
		
	
});
		boolean returningResult = printerjob.printDialog();
		if(returningResult) {
			try {
				printerjob.print();
			}
			catch(PrinterException printerException) {
				JOptionPane.showMessageDialog(null,"print error");
			}
				
			}
		}
}
