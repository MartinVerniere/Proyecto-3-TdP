package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.Juego;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	private Thread HiloEntidades;
	private Thread HiloTeclado;
	private Timer hiloPuntaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		juego=new Juego();
		
		HiloEntidades=new HiloEntidades(juego);
		HiloTeclado=new HiloTeclado(juego);
		hiloPuntaje=new Timer();
		
		Inicializarpaneles();
			
	}
	private void Inicializarpaneles() {
		// TODO Auto-generated method stub
		JPanel Menu = new JPanel();
		Menu.setBounds(10, 11, 240, 96);
		contentPane.add(Menu);
		Menu.setLayout(null);
		Menu.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JPanel Mapa = new JPanel();
		Mapa.setBounds(259, 11, 699, 508);
		contentPane.add(Mapa);
		Mapa.setLayout(null);
		Mapa.setVisible(false);
		Mapa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 125, 240, 394);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		Inicializarlabelspanel(panel, Mapa, Menu);
	}
	
	private void Inicializarlabelspanel(JPanel panel, JPanel Mapa, JPanel Menu) {
		// TODO Auto-generated method stub
		
		//JLabel labelMapa = new JLabel("");
		//labelMapa.setBounds(10, 11, 698, 508);
		//Mapa.add(labelMapa);	
		//labelMapa.setIcon(this.juego.getMapa().getIcon().getIcon());
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiempo.setBounds(10, 28, 59, 15);
		Menu.add(lblTiempo);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPuntaje.setBounds(10, 66, 59, 15);
		Menu.add(lblPuntaje);
		
		JLabel TiempoActual = new JLabel("00:00:00");
		TiempoActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		TiempoActual.setBounds(79, 28, 151, 15);
		Menu.add(TiempoActual);
		
		JLabel PuntajeActual = new JLabel("0");
		PuntajeActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		PuntajeActual.setBounds(77, 66, 153, 15);
		Menu.add(PuntajeActual);
		
		JLabel lblControles = new JLabel("CONTROLES:");
		lblControles.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblControles.setBounds(7, 280, 223, 19);
		panel.add(lblControles);
		
		JLabel lblMoverDerecha = new JLabel("Mover derecha:");
		lblMoverDerecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMoverDerecha.setBounds(7, 310, 92, 19);
		panel.add(lblMoverDerecha);
		
		JLabel lblFlechaDerecha = new JLabel("Flecha derecha");
		lblFlechaDerecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFlechaDerecha.setBounds(97, 310, 143, 19);
		panel.add(lblFlechaDerecha);
		
		JLabel lblMoverIzquierda = new JLabel("Mover izquierda:");
		lblMoverIzquierda.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMoverIzquierda.setBounds(7, 340, 92, 19);
		panel.add(lblMoverIzquierda);
		
		JLabel lblFlechaIzquierda = new JLabel("Flecha Izquierda");
		lblFlechaIzquierda.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFlechaIzquierda.setBounds(97, 340, 143, 19);
		panel.add(lblFlechaIzquierda);
		
		JLabel lblBarraEspaciadora = new JLabel("Barra Espaciadora");
		lblBarraEspaciadora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBarraEspaciadora.setBounds(97, 370, 143, 19);
		panel.add(lblBarraEspaciadora);
		
		JLabel lblDisparar = new JLabel("Disparar:");
		lblDisparar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDisparar.setBounds(7, 370, 92, 19);
		panel.add(lblDisparar);
		
		Inicializarbotones(TiempoActual, PuntajeActual, Mapa, panel);
	}

	private void Inicializarbotones(JLabel TiempoActual, JLabel PuntajeActual, JPanel mapa, JPanel panel) {
		// TODO Auto-generated method stub
		
		TimerTask tarea=new TimerTask() {
			@Override
			public void run() {
				String tiempo=juego.getTiempo();
				String puntaje=String.valueOf(juego.getpuntaje());
				TiempoActual.setText(tiempo);
				PuntajeActual.setText(puntaje);
			}	
		};
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnJugar.setVisible(false);
				juego.reiniciarTiempo();
				hiloPuntaje.schedule(tarea, 0, 1000);
				mapa.setVisible(true);
				
				//JLabel labelmapa = juego.getMapa().getIcon();
				//labelmapa.setSize(mapa.getSize());
				//mapa.add(labelmapa);
				
				mapa.add(juego.getJugador().getImagen().getIcon(),0);
				mapa.repaint();
				
				//HiloEntidades.start();
				//HiloTeclado.start();
			}
		});
		btnJugar.setBounds(10, 11, 220, 51);
		panel.add(btnJugar);
	}
}
