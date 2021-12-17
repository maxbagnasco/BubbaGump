 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class Juegos<bolita> extends javax.swing.JFrame implements KeyListener {
	

	private JPanel panel;
	private Bola bolita;
	private Raqueta raquetita1;
	private Raqueta2 raquetita2;
	
	private int golpes,golpes2 ;
	
	private JLabel labelcontador;
	private JLabel labelcontador2;
	
	public JLabel posicionx;
	public JLabel posiciony;
	
 	
	private JLabel fondo;

 

	public static void main(String[] args) throws InterruptedException {
		           
				 
					Juegos<?>  frame = new Juegos<Object>();
		            frame.setVisible(true);
		           	while(true){
									frame.repaint();
									frame.jugar();
									Thread.sleep(60); 
								}
	}


	public   Juegos() { 						
		
		setTitle("Ping Pong Bubba Gump");		
		setResizable(false); 					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 630, 450);
		
		panel = new JPanel();
		 
		
		setContentPane(panel);
		
		panel.setLayout(null);
		
		
		((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("tablero.jpg")); 		
       
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icono.png"));
        setIconImage(icon);
        
        
        labelcontador = new JLabel("0");								
        labelcontador.setForeground(Color.BLACK);						
        labelcontador.setFont(new Font("Monospaced", Font.BOLD, 20));	
        labelcontador.setBounds(103, 0, 73, 18);							
        panel.add(labelcontador);										
        
        labelcontador2 = new JLabel("0");								
        labelcontador2.setForeground(Color.BLACK);						
        labelcontador2.setFont(new Font("Monospaced", Font.BOLD,20));	
        labelcontador2.setBounds(485, 0, 56, 18);						
        panel.add(labelcontador2);										
              
      
  
        		
        fondo = new JLabel();	
        
       	fondo.setIcon(imagen);											
        
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        
        fondo.setBounds(0, 0, 630, 450);								
        
   
        this.setSize(645, 489);						
        this.setLocationRelativeTo(null);
		
        bolita=new Bola(getWidth(),getHeight());						
       
        
        raquetita1=new Raqueta(getHeight());							
		raquetita2=new Raqueta2(getHeight());							
		addKeyListener(this);										    
		golpes=0;														
		golpes2=0;														
	}
	
	
	
	public void  paint(Graphics g ){
		
		super.paint(g);
		
		Graphics2D g2d=(Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,(RenderingHints.VALUE_ANTIALIAS_ON));
		
		g2d.setColor(Color.WHITE);											
		bolita.pintarBola(g2d);
		g2d.setColor(Color.RED);										
		raquetita1.pintarRaqueta1(g2d);
		g2d.setColor(Color.YELLOW);										
		raquetita2.pintarRaqueta2(g2d);
		
		
	}
	
 


	public void jugar(){
	
		bolita.moverBola();
		
		 
		 if(colision()){
			 			bolita.rebotaBola();			
			 			golpes=golpes+1;				
			 			labelcontador.setText(String.valueOf(golpes/2));
			
		}
		if(colision2()){
						bolita.rebotaBola();			
						golpes2=golpes2+1;				
						labelcontador2.setText(String.valueOf(golpes2/2));
			
		}
		if(bolita.TocaFondo()){							
			
			FinJuego();									
		}
		
	 	
		
		
	}
	public boolean colision(){
		
		return bolita.limiteBola().intersects(raquetita1.limiteRaqueta1());
	}
	public boolean colision2(){
		return bolita.limiteBola().intersects(raquetita2.limiteRaqueta2());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_A){
		raquetita1.moverRaquetaarriba1();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_Z){
		raquetita1.moverRaquetaabajo1();
		}


		if(e.getKeyCode()==KeyEvent.VK_UP){
		raquetita2.moverRaquetaarriba2();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
		raquetita2.moverRaquetaabajo2();
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}
	

	public void FinJuego() {
		if(golpes>golpes2){
			JOptionPane.showMessageDialog(this, "El jugador 1 ganó", "Fin del Juego", JOptionPane.YES_NO_OPTION);
			System.exit(0);
		}else{
			if(golpes<golpes2){
		JOptionPane.showMessageDialog(this, "El jugador 2 ganó", "Fin del Juego", JOptionPane.YES_NO_OPTION);
		System.exit(0);
			}else{
				JOptionPane.showMessageDialog(this, "Empate", "Fin del Juego", JOptionPane.YES_NO_OPTION);
				System.exit(0);
			}
		}
	}
}








