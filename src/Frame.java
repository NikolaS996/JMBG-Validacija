import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame {

	private JFrame frame;
	private static JTextField txtIme;
	private static JTextField txtPrezime;
	private static JTextField txtJmbg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame("JMBG Validacija");
					window.setBounds(100,100,450,450);

					JMenuBar menuBar = new JMenuBar();
					window.setJMenuBar(menuBar);

					JMenu mnOpcije = new JMenu("Opcije");
					menuBar.add(mnOpcije);

					JMenu mnIzadji = new JMenu("Iza\u0111i");
					
					mnOpcije.add(mnIzadji);

					JMenu mnPomo = new JMenu("Pomo\u0107");
					mnPomo.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							PomocDialog pomoc = new PomocDialog();
							pomoc.setVisible(true);
						}
					});
					
					menuBar.add(mnPomo);
					window.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

					JPanel panel = new JPanel();
					window.getContentPane().add(panel);
					GridBagLayout gbl_panel = new GridBagLayout();
					gbl_panel.columnWidths = new int[]{0, 0, 108, 0, 0, 0};
					gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 20, 0, 44, 0, 0, 0, 0};
					gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
					gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
					panel.setLayout(gbl_panel);

					JLabel lblIme = new JLabel("Ime:");
					GridBagConstraints gbc_lblIme = new GridBagConstraints();
					gbc_lblIme.insets = new Insets(0, 0, 5, 5);
					gbc_lblIme.gridx = 0;
					gbc_lblIme.gridy = 1;
					panel.add(lblIme, gbc_lblIme);

					txtIme = new JTextField();
					GridBagConstraints gbc_txtIme = new GridBagConstraints();
					gbc_txtIme.anchor = GridBagConstraints.WEST;
					gbc_txtIme.fill = GridBagConstraints.VERTICAL;
					gbc_txtIme.insets = new Insets(0, 0, 5, 5);
					gbc_txtIme.gridx = 2;
					gbc_txtIme.gridy = 1;
					panel.add(txtIme, gbc_txtIme);
					txtIme.setColumns(10);

					JLabel lblPrezime = new JLabel("Prezime:");
					GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
					gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
					gbc_lblPrezime.gridx = 0;
					gbc_lblPrezime.gridy = 3;
					panel.add(lblPrezime, gbc_lblPrezime);

					txtPrezime = new JTextField();
					GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
					gbc_txtPrezime.anchor = GridBagConstraints.WEST;
					gbc_txtPrezime.insets = new Insets(0, 0, 5, 5);
					gbc_txtPrezime.gridx = 2;
					gbc_txtPrezime.gridy = 3;
					panel.add(txtPrezime, gbc_txtPrezime);
					txtPrezime.setColumns(10);

					JLabel lblJmbg = new JLabel("JMBG:");
					GridBagConstraints gbc_lblJmbg = new GridBagConstraints();
					gbc_lblJmbg.insets = new Insets(0, 0, 5, 5);
					gbc_lblJmbg.gridx = 0;
					gbc_lblJmbg.gridy = 5;
					panel.add(lblJmbg, gbc_lblJmbg);

					txtJmbg = new JTextField();
					GridBagConstraints gbc_txtJmbg = new GridBagConstraints();
					gbc_txtJmbg.anchor = GridBagConstraints.WEST;
					gbc_txtJmbg.insets = new Insets(0, 0, 5, 5);
					gbc_txtJmbg.gridx = 2;
					gbc_txtJmbg.gridy = 5;
					panel.add(txtJmbg, gbc_txtJmbg);
					txtJmbg.setColumns(10);

					JButton btnValidiraj = new JButton("Validiraj");

					GridBagConstraints gbc_btnValidiraj = new GridBagConstraints();

					gbc_btnValidiraj.insets = new Insets(0, 0, 5, 5);
					gbc_btnValidiraj.gridx = 0;
					gbc_btnValidiraj.gridy = 7;
					panel.add(btnValidiraj, gbc_btnValidiraj);

					JButton btnOtkazi = new JButton("Otka\u017Ei");
					btnOtkazi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
								window.setVisible(false);
								//window.cancel();
								window.dispose();
							}
						
					});
					mnIzadji.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent arg0) {
							window.setVisible(false);
							window.dispose();
						}
					});
					GridBagConstraints gbc_btnOtkazi = new GridBagConstraints();
					gbc_btnOtkazi.insets = new Insets(0, 0, 5, 5);
					gbc_btnOtkazi.gridx = 2;
					gbc_btnOtkazi.gridy = 7;
					panel.add(btnOtkazi, gbc_btnOtkazi);

					JTextArea txtIspis = new JTextArea();
					GridBagConstraints gbc_txtIspis = new GridBagConstraints();
					gbc_txtIspis.gridheight = 3;
					gbc_txtIspis.gridwidth = 3;
					gbc_txtIspis.insets = new Insets(0, 0, 5, 5);
					gbc_txtIspis.fill = GridBagConstraints.BOTH;
					gbc_txtIspis.gridx = 0;
					gbc_txtIspis.gridy = 9;
					panel.add(txtIspis, gbc_txtIspis);
					txtIspis.setVisible(false);
					window.setVisible(true);

					JRootPane rootPane = SwingUtilities.getRootPane(btnValidiraj);
					rootPane.setDefaultButton(btnValidiraj);

					btnValidiraj.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String jmbg = txtJmbg.getText();
							if(jmbg.isEmpty() || txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty()){
								txtIspis.setVisible(false);
								txtIspis.setText(null);
								JOptionPane.showMessageDialog(null, "Morate popuniti sva polja.", "Greška", JOptionPane.ERROR_MESSAGE);
							} else
								if(!jmbg.matches("[0-9]+")) {
									JOptionPane.showMessageDialog(null, "JMBG mora sadržati isključivo brojeve.", "Greška", JOptionPane.ERROR_MESSAGE);;								
								}else
									if(jmbg.length() != 13) {
										JOptionPane.showMessageDialog(null, "JMBG mora sadržati tačno 13 brojeva.", "Greška", JOptionPane.ERROR_MESSAGE);;
									}
									else {
										int len = jmbg.length();
										String DD = jmbg.substring(0, 2);
										String MM = jmbg.substring(2, 4);
										String GGG = jmbg.substring(4, 7);
										String RR = jmbg.substring(7,9);
										String BBB = jmbg.substring(9, 12);
										String K = jmbg.substring(len - 1, len);
										
										int dd = Integer.parseInt(DD);
										int mm = Integer.parseInt(MM);
										int ggg = Integer.parseInt(GGG);
										
										if(ggg < 100)
											ggg+=2000;
										else
											ggg+=1000;
										
										if(!validateDate(dd,mm,ggg)) {
											JOptionPane.showMessageDialog(null, "Uneseni datum nije validan. Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
										}else {
											String ime = txtIme.getText();
											String prezime = txtPrezime.getText();
											String pol;
											if(Integer.parseInt(BBB) <500)
												pol = "Muško";
											else
												pol = "Žensko";

											String regija = "";
											
											int rr = Integer.parseInt(RR);
											
											switch(rr) {
											case 1:
									            regija = "stranci u BiH";
									            break;
									        case 2:
									            regija = "stranci u Crnoj Gori";
									            break;
									        case 3:
									            regija = "stranci u Hrvatskoj";
									            break;
									        case 4:
									            regija = "stranci u Makedoniji";
									            break;
									        case 5:
									            regija = "stranci u Sloveniji";
									            break;
									        case 6:
									            regija = "nedefinisano regija rodjenja";
									            break;
									        case 7:
									            regija = "stranci u Srbiji (bez pokrajina)";
									            break;
									        case 8:
									            regija = "stranci u Vojvodini";
									            break;
									        case 9:
									            regija = "stranci na Kosovu i Metohiji";
									            break;
									        case 10:
									            regija = "Bosna i Hercegovina - Banja Luka";
									            break;
									        case 11:
									            regija = "Bosna i Hercegovina - Bihać";
									            break;
									        case 12:
									            regija = "Bosna i Hercegovina - Doboj";
									            break;
									        case 13:
									            regija = "Bosna i Hercegovina - Goražde";
									            break;
									        case 14:
									            regija = "Bosna i Hercegovina - Livno";
									            break;
									        case 15:
									            regija = "Bosna i Hercegovina - Mostar";
									            break;
									        case 16:
									            regija = "Bosna i Hercegovina - Prijedor";
									            break;
									        case 17:
									            regija = "Bosna i Hercegovina - Sarajevo";
									            break;
									        case 18:
									            regija = "Bosna i Hercegovina - Tuzla";
									            break;
									        case 19:
									            regija = "Bosna i Hercegovina - Zenica";
									            break;
									        case 20:
									            regija = "Crna Gora";
									            break;
									        case 21:
									            regija = "Crna Gora - Podgorica";
									            break;
									        case 22:
									            regija = "Crna Gora";
									            break;
									        case 23:
									            regija = "Crna Gora";
									            break;
									        case 24:
									            regija = "Crna Gora";
									            break;
									        case 25:
									            regija = "Crna Gora";
									            break;
									        case 26:
									            regija = "Crna Gora - Nikšić";
									            break;
									        case 27:
									            regija = "Crna Gora";
									            break;
									        case 28:
									            regija = "Crna Gora";
									            break;
									        case 29:
									            regija = "Crna Gora - Pljevlja";
									            break;
									        case 30:
									            regija = "Hrvatska - Osijek, Slavonija region";
									            break;
									        case 31:
									            regija = "Hrvatska - Bjelovar, Virovitica, Koprivnica, Pakrac, Podravina region";
									            break;
									        case 32:
									            regija = "Hrvatska - Varaždin, Međimurje region";
									            break;
									        case 33:
									            regija = "Hrvatska - Zagreb";
									            break;
									        case 34:
									            regija = "Hrvatska - Karlovac";
									            break;
									        case 35:
									            regija = "Hrvatska - Gospić, Lika region";
									            break;
									        case 36:
									            regija = "Hrvatska - Rijeka, Pula, Istra and Primorje";
									            break;
									        case 37:
									            regija = "Hrvatska - Sisak, Banovina region";
									            break;
									        case 38:
									            regija = "Hrvatska - Split, Zadar, Dubrovnik, Dalmacija region";
									            break;
									        case 39:
									            regija = "Hrvatska";
									            break;
									        case 41:
									            regija = "Makedonija - Bitola";
									            break;
									        case 42:
									            regija = "Makedonija - Kumanovo";
									            break;
									        case 43:
									            regija = "Makedonija - Ohrid";
									            break;
									        case 44:
									            regija = "Makedonija - Prilep";
									            break;
									        case 45:
									            regija = "Makedonija - Skopje";
									            break;
									        case 46:
									            regija = "Makedonija - Strumica";
									            break;
									        case 47:
									            regija = "Makedonija - Tetovo";
									            break;
									        case 48:
									            regija = "Makedonija - Veles";
									            break;
									        case 49:
									            regija = "Makedonija - Štip";
									            break;
									        case 50:
									            regija = "Slovenija";
									            break;
									        case 70:
									            regija = "Centralna Srbija";
									            break;
									        case 71:
									            regija = "Srbija - Beograd region";
									            break;
									        case 72:
									            regija = "Srbija - Šumadija";
									            break;
									        case 73:
									            regija = "Srbija - Niš region";
									            break;
									        case 74:
									            regija = "Srbija - Južna Morava";
									            break;
									        case 75:
									            regija = "Srbija - Zaječar";
									            break;
									        case 76:
									            regija = "Srbija - Podunavlje";
									            break;
									        case 77:
									            regija = "Srbija - Podrinje i Kolubara";
									            break;
									        case 78:
									            regija = "Srbija - Kraljevo region";
									            break;
									        case 79:
									            regija = "Srbija - Užice region";
									            break;
									        case 80:
									            regija = "Autonomna Pokrajina Vojvodina - Novi Sad region";
									            break;
									        case 81:
									            regija = "Autonomna Pokrajina Vojvodina - Sombor region";
									            break;
									        case 82:
									            regija = "Autonomna Pokrajina Vojvodina - Subotica region";
									            break;
									        case 83:
									            regija = "Autonomna Pokrajina Vojvodina";
									            break;
									        case 84:
									            regija = "Autonomna Pokrajina Vojvodina";
									            break;
									        case 85:
									            regija = "Autonomna Pokrajina Vojvodina - Zrenjanin region";
									            break;
									        case 86:
									            regija = "Autonomna Pokrajina Vojvodina - Pančevo region";
									            break;
									        case 87:
									            regija = "Autonomna Pokrajina Vojvodina - Kikinda region";
									            break;
									        case 88:
									            regija = "Autonomna Pokrajina Vojvodina - Ruma region";
									            break;
									        case 89:
									            regija = "Autonomna Pokrajina Vojvodina - Sremska Mitrovica region";
									            break;
									        case 90:
									            regija = "Autonomna Pokrajina Kosovo i Metohija";
									            break;
									        case 91:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Priština region ";
									            break;
									        case 92:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Kosovska Mitrovica region";
									            break;
									        case 93:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Peć region";
									            break;
									        case 94:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Đakovica region";
									            break;
									        case 95:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Prizren region";
									            break;
									        case 96:
									            regija = "Autonomna Pokrajina Kosovo i Metohija - Kosovsko Pomoravski okrug";
									            break;
									        case 97:
									            regija = "Autonomna Pokrajina Kosovo i Metohija";
									            break;
									        case 98:
									            regija = "Autonomna Pokrajina Kosovo i Metohija";
									            break;
									        case 99:
									            regija = "Autonomna Pokrajina Kosovo i Metohija";
									            break;
									        default:
									        	regija = "Nedefinisana";
									            break;
											}

											int A = Integer.parseInt(jmbg.substring(0,1));
											int B = Integer.parseInt(jmbg.substring(1,2));
											int V = Integer.parseInt(jmbg.substring(2,3));
											int G = Integer.parseInt(jmbg.substring(3,4)); 
											int D = Integer.parseInt(jmbg.substring(4,5));
											int Đ = Integer.parseInt(jmbg.substring(5,6));
											int E = Integer.parseInt(jmbg.substring(6,7));
											int Ž = Integer.parseInt(jmbg.substring(7,8));
											int Z = Integer.parseInt(jmbg.substring(8,9));
											int I = Integer.parseInt(jmbg.substring(9,10));
											int J = Integer.parseInt(jmbg.substring(10,11));
											int k = Integer.parseInt(jmbg.substring(11,12));
											
											int L = 11 - ((7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Đ+k)) % 11);
											
											if(regija.equals("Nedefinisana"))
											{
												txtIspis.setText(null);
												txtIspis.setVisible(false);
												JOptionPane.showMessageDialog(null, "Regija nije odgovarajuća. Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
											}else if(L > 0 && L < 10)
											{
												String ispis = ime + " " + prezime + "\n"
														+ "Datum rođenja: " + DD + "." + MM + "." + ggg + ".\n"
														+ "Mesto rođenja: " + regija + "\n"
														+ "Pol: " + pol + "\n" 
														+ "Jedinstveni broj: " + BBB;
												txtIspis.setText(ispis);
												txtIspis.setVisible(true);
											}
											else if(L > 9){
												txtIspis.setText(null);
												txtIspis.setVisible(false);
												JOptionPane.showMessageDialog(null, "JMBG nije validan. Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
											}
											else {
												txtIspis.setText(null);
												txtIspis.setVisible(false);
												JOptionPane.showMessageDialog(null, "Greška.", "Greška", JOptionPane.ERROR_MESSAGE);
											}

											
										}
									}

						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static boolean validateDate(int dan, int mesec, int godina) {
		Set<Integer> tridesetJedanDan = new HashSet<>();
		tridesetJedanDan.add(1);
		tridesetJedanDan.add(3);
		tridesetJedanDan.add(5);
		tridesetJedanDan.add(7);
		tridesetJedanDan.add(8);
		tridesetJedanDan.add(10);
		tridesetJedanDan.add(12);

		Set<Integer> tridesetDana = new HashSet<>();
		tridesetDana.add(4);
		tridesetDana.add(6);
		tridesetDana.add(9);
		tridesetDana.add(11);
		
		if(mesec > 12 || mesec < 1)
			return false;
		else if (tridesetJedanDan.contains(mesec)) {
			if (dan > 31 || dan < 1)
				return false;
		} else if (tridesetDana.contains(mesec)) {
			if (dan > 30 || dan < 1)
				return false;
		} else {
			
			if (godina % 4 == 0) {
				if (dan > 29 || dan < 1)
					return false;
			} else {
				if (dan > 28 || dan < 1)
					return false;
			}
		}
		return true;
	}

}
