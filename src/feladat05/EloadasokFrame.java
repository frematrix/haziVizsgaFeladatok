package feladat05;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EloadasokFrame {

	private JFrame frmEloadasok;
	private List<Eloadas> eloadasok;
	private Eloadas eloadas;
	private Eloadas szerkEloadas;
	private DefaultListModel<Eloadas> model;
	private JList listaMegjelenit;
	private JTextField txtCim;
	private JTextField txtRendezo;
	private JTextField txtDatum;
	private JSpinner spinnerDarab;

	public JFrame getFrmEloadasok() {
		return frmEloadasok;
	}

	
	public EloadasokFrame()  {
		initialize();
		try {
			//EloadasABkezelo.kapcsolat();
			EloadasABkezelo.kapcsolat2();
			//eloadasok = EloadasABkezelo.beolvasas();
			eloadasok = EloadasABkezelo.beolvasas2();
			adatmegjelenites();
			
			
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmEloadasok, e.getMessage(), "Hiba!", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	private void adatmegjelenites() {
		
		model = new DefaultListModel<Eloadas>();
		
		for (Eloadas eloadas : eloadasok) {
			
			model.addElement(eloadas);
			
		}
		listaMegjelenit.setModel(model);
	}


	private void initialize() {
		
		frmEloadasok = new JFrame();
		frmEloadasok.setTitle("Színházi előadások");
		frmEloadasok.setBounds(100, 100, 700, 420);
		frmEloadasok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);
		
		listaMegjelenit = new JList();
		listaMegjelenit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				szerkEloadas = (Eloadas)listaMegjelenit.getSelectedValue();
				
				txtCim.setText(szerkEloadas.getEloadasCime());
				txtRendezo.setText(szerkEloadas.getRendezo());
				txtDatum.setText(String.valueOf(szerkEloadas.getBemutato()));
				spinnerDarab.setValue(szerkEloadas.getEloadasSzam());
			}
		});
		listaMegjelenit.setBounds(26, 35, 633, 226);
		frmEloadasok.getContentPane().add(listaMegjelenit);
		
		JButton btnTorles = new JButton("Törlés");
		btnTorles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				torles();
			}
		});
		btnTorles.setBounds(26, 272, 89, 23);
		frmEloadasok.getContentPane().add(btnTorles);
		
		JButton btnUjEloadas = new JButton("Új előadás");
		btnUjEloadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				felvitel();
			}
		});
		btnUjEloadas.setBounds(26, 302, 89, 23);
		frmEloadasok.getContentPane().add(btnUjEloadas);
		
		JLabel lblNewLabel = new JLabel("Cím");
		lblNewLabel.setBounds(162, 272, 49, 14);
		frmEloadasok.getContentPane().add(lblNewLabel);
		
		txtCim = new JTextField();
		txtCim.setBounds(221, 269, 157, 20);
		frmEloadasok.getContentPane().add(txtCim);
		txtCim.setColumns(10);
		
		JLabel lblRendez = new JLabel("Rendező");
		lblRendez.setBounds(162, 306, 49, 14);
		frmEloadasok.getContentPane().add(lblRendez);
		
		txtRendezo = new JTextField();
		txtRendezo.setColumns(10);
		txtRendezo.setBounds(221, 303, 157, 20);
		frmEloadasok.getContentPane().add(txtRendezo);
		
		txtDatum = new JTextField();
		txtDatum.setBounds(516, 272, 143, 20);
		frmEloadasok.getContentPane().add(txtDatum);
		txtDatum.setColumns(10);
		
		JLabel lblDtum = new JLabel("Dátum");
		lblDtum.setBounds(457, 272, 49, 14);
		frmEloadasok.getContentPane().add(lblDtum);
		
		JLabel lblDarab = new JLabel("Darab");
		lblDarab.setBounds(457, 306, 49, 14);
		frmEloadasok.getContentPane().add(lblDarab);
		
		spinnerDarab = new JSpinner();
		spinnerDarab.setBounds(516, 303, 143, 20);
		frmEloadasok.getContentPane().add(spinnerDarab);
		
		JButton btnModositas = new JButton("Módosítás");
		btnModositas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modositas();
			}
		});
		btnModositas.setBounds(26, 336, 89, 23);
		frmEloadasok.getContentPane().add(btnModositas);
		
	}

	protected void modositas() {
		
		Eloadas modEloadas = new Eloadas(txtCim.getText(), txtRendezo.getText(), LocalDate.parse(txtDatum.getText()), 
				(int)spinnerDarab.getValue());
		int index = listaMegjelenit.getSelectedIndex();
		
		if (modEloadas.getEloadasSzam()!=szerkEloadas.getEloadasSzam()) {
			try {
				EloadasABkezelo.modositas(modEloadas);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmEloadasok, e.getMessage());
				e.printStackTrace();
			}
			eloadasok.set(index, modEloadas);
			model.set(index, modEloadas);
			txtCim.setText("");
			txtRendezo.setText("");
			txtDatum.setText("");
			spinnerDarab.setValue(0);
		}
		else {
			JOptionPane.showMessageDialog(frmEloadasok, "Nem történt módosítás!");
		}
	}

	protected void felvitel() {
		
		try {
			if (eloadas==null) {
				Eloadas ujEloadas = new Eloadas(txtCim.getText(), txtRendezo.getText(), LocalDate.parse(txtDatum.getText()), 
						(int)spinnerDarab.getValue());
				
				EloadasABkezelo.felvitel(ujEloadas);
				eloadasok.add(ujEloadas);
				model.addElement(ujEloadas);
				txtCim.setText("");
				txtRendezo.setText("");
				txtDatum.setText("");
				spinnerDarab.setValue(null);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmEloadasok, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	protected void torles() {
		
		if (listaMegjelenit.getSelectedIndex()!=-1 && JOptionPane.showOptionDialog(frmEloadasok, 
				"Biztos törli?", "Adattörlés", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, null, null)==JOptionPane.YES_OPTION) {
			
			try {
				//EloadasABkezelo.torles(eloadasok.get(listaMegjelenit.getSelectedIndex()));
				EloadasABkezelo.torles2(eloadasok.get(listaMegjelenit.getSelectedIndex()));
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(frmEloadasok, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
			}
			eloadasok.remove(listaMegjelenit.getSelectedValue());
			model.remove(listaMegjelenit.getSelectedIndex());
			
		}
		
	}
}
