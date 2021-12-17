import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola  {

	
private int x,y,direccionX,direccionY,alto,ancho;

public int diametro;
 
public int velocidad = 8;
 
	
 public Bola(int ancho , int alto) {
	
		this.ancho=ancho;
		this.alto=alto;
		x=20;
		y=20;
		direccionX=velocidad;					
		direccionY=velocidad;
		diametro=20;
 
		} 
	
	
	public void moverBola(){
		


		
		if(x+direccionX > ancho - 40){
			direccionX=-velocidad;
		}
		if(x+direccionX < 0){
			direccionX=velocidad;
		}
			
		if(y + direccionY > alto - 80){
			direccionY= -velocidad;
		}
		
		if(y + direccionY <  25){
			direccionY= velocidad;
		}
			
		
		x=x+direccionX;
		y=y+direccionY;
		

	 
	}
	public void pintarBola(Graphics2D g){
		
		g.fillOval(5+x,30+y,diametro,diametro);	
		
		   
	}
	public Rectangle limiteBola(){ 					
		
		return new Rectangle(5+x,30+y, diametro,diametro );  
		
	}
	
	public void rebotaBola(){
	
	if(x + direccionX > 30){
		
		direccionX =direccionX - velocidad;
	 
	}else{
		
		direccionX=direccionX + velocidad;
	}
	
		
	}
	public boolean TocaFondo(){ 	
		

		if (x + direccionX > ancho-40 || x + direccionX < 20){
			return true;
		}else{
		return false;
	}
	}
}