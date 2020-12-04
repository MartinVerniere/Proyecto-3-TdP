package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.Juego;
import Logica.ImagenesLogica.Imagen;
import Logica.ImagenesLogica.Imagen_mapa;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	private Thread hiloEntidades;
	private Timer hiloPuntaje;
	private JPanel miMapa;

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
		setBounds(100, 100, 623, 808);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.miMapa=new JPanel();
		Inicializarpaneles();
		juego=new Juego(this);
		
		
		hiloPuntaje=new Timer();
		hiloEntidades=new HiloEntidades(juego, contentPane,hiloPuntaje);	
	}
	private void Inicializarpaneles() {
		
		this.miMapa.setBounds(10, 59, 587, 700);
		contentPane.add(this.miMapa);
		this.miMapa.setLayout(null);
		this.miMapa.setVisible(false);
		this.miMapa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JPanel panelinformacion = new JPanel();
		panelinformacion.setBounds(10, 11, 587, 37);
		contentPane.add(panelinformacion);
		panelinformacion.setLayout(null);
		panelinformacion.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		Inicializarlabelspanel(panelinformacion,this.miMapa);
	}
		
	
	private void Inicializarlabelspanel(JPanel panelinformacion, JPanel mapa) {
		// TODO Auto-generated method stub
		
		JLabel labelMapa = new JLabel();
		String[] imagenes = new String[] {"/Imagenes/pixel-mapa.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		labelMapa=new JLabel(imagen);
		labelMapa.setBounds(0,0, imagen.getIconWidth(), imagen.getIconHeight());
		labelMapa.setSize(mapa.getSize());		
		mapa.add(labelMapa);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setBounds(450, 7, 59, 23);
		panelinformacion.add(lblPuntaje);
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel puntajeactual = new JLabel("0");
		puntajeactual.setBounds(508, 7, 69, 23);
		panelinformacion.add(puntajeactual);
		puntajeactual.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(326, 7, 59, 23);
		panelinformacion.add(lblTiempo);
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel tiempoactual = new JLabel("00:00:00");
		tiempoactual.setBounds(381, 7, 65, 23);
		panelinformacion.add(tiempoactual);
		tiempoactual.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		Inicializarbotones(puntajeactual, mapa, panelinformacion, tiempoactual);
	}

	private void Inicializarbotones(JLabel labelpuntajeactual, JPanel mapa, JPanel panelinformacion, JLabel labeltiempoactual) {
		// TODO Auto-generated method stub
		
		TimerTask tarea=new TimerTask() {
			@Override
			public void run() {
				String tiempo=juego.getTiempo();
				String puntaje=String.valueOf(juego.getpuntaje());
				
				labeltiempoactual.setText(tiempo);
				labelpuntajeactual.setText(puntaje);
			}	
		};
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requestFocus();
				btnJugar.setVisible(false);
				juego.reiniciarTiempo();
				hiloPuntaje.schedule(tarea, 0, 1000);
				mapa.setVisible(true);
				
				hiloEntidades.start();
				
				addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) { 
						System.out.println(e.getKeyChar());
						juego.input(juego.getJugador(), e);
					}
					
					public void keyReleased(KeyEvent e) {
						
					}

					public void keyTyped(KeyEvent e) {
						;
					}
				});
			}
		});
		btnJugar.setBounds(10, 7, 92, 23);
		panelinformacion.add(btnJugar);
	}
	
	public void eliminarlabel(JLabel l) {
		miMapa.remove(l);
		miMapa.revalidate();
		miMapa.repaint();
	}
	public void agregarlabel(JLabel l) {
		miMapa.add(l,0);
		miMapa.revalidate();
		miMapa.repaint();
	}
	
	public int getanchomapa() {	return this.miMapa.getWidth(); }
	public int getaltomapa() { return this.miMapa.getHeight(); }
}
