package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private Juego miJuego;
	private Thread hiloEntidades;
	private Timer hiloPuntaje;
	private JPanel miMapa;
	private JLabel labelMapa;
	private String[] imagenesmapa;
	

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
		miJuego=new Juego(this);
		
		
		hiloPuntaje=new Timer();
		hiloEntidades=new HiloEntidades(miJuego, contentPane,hiloPuntaje);	
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
		
		this.labelMapa = new JLabel();
		imagenesmapa = new String[] {"/Imagenes/pixel-mapa-1.png","/Imagenes/pixel-mapa-2.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenesmapa[0]));
		this.labelMapa=new JLabel(imagen);
		this.labelMapa.setBounds(0,0, imagen.getIconWidth(), imagen.getIconHeight());
		this.labelMapa.setSize(mapa.getSize());		
		mapa.add(this.labelMapa);
		
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
		
		JLabel lblCV = new JLabel("Carga Viral: ");
		lblCV.setBounds(10, 11, 100, 14);
		miMapa.add(lblCV,0);
		lblCV.setForeground(Color.RED);
		lblCV.setFont(new Font("Tahoma", Font.BOLD, 15));	
		
		JLabel lblCargaViral = new JLabel("0");
		lblCargaViral.setBounds(101, 11, 100, 14);
		miMapa.add(lblCargaViral,0);
		lblCargaViral.setForeground(Color.RED);
		lblCargaViral.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Inicializarbotones(puntajeactual, mapa, panelinformacion, tiempoactual, lblCargaViral);
	}

	private void Inicializarbotones(JLabel labelpuntajeactual, JPanel mapa, JPanel panelinformacion, JLabel labeltiempoactual, JLabel lblCargaViral) {
		
		TimerTask tarea=new TimerTask() {
			@Override
			public void run() {
				String tiempo=miJuego.getTiempo();
				String puntaje=String.valueOf(miJuego.getpuntaje());
				String CV=String.valueOf(miJuego.getJugador().getcargaviral());
				
				labeltiempoactual.setText(tiempo);
				labelpuntajeactual.setText(puntaje);
				lblCargaViral.setText(CV);
			}	
		};
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				miJuego.Inicializar();
				requestFocus();
				btnJugar.setVisible(false);
				miJuego.reiniciarTiempo();
				hiloPuntaje.schedule(tarea, 0, 1000);
				mapa.setVisible(true);
				
				hiloEntidades.start();
				
				addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) { 
						System.out.println(e.getKeyChar());
						miJuego.input(miJuego.getJugador(), e);
					}
					
					public void keyReleased(KeyEvent e) {	}

					public void keyTyped(KeyEvent e) {	}
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
	
	public void cambiarmapa() {
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenesmapa[1]));
		this.labelMapa.setIcon(imagen);
		this.labelMapa.setBounds(0,0, imagen.getIconWidth(), imagen.getIconHeight());
		this.labelMapa.setSize(this.miMapa.getSize());		
		this.labelMapa.repaint();
	}
}
