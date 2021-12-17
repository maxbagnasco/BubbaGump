
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Raqueta {
						private int y, alto, largo;
 
public Raqueta(int alto) {
							y = 0;
							largo = 70;
							this.alto = alto;
						}

public void moverRaquetaabajo1() {
									if (y -40> -207) {  
														y = y -40;
													}
								}

public void moverRaquetaarriba1() {
									if (y +largo+40< alto-242 ) { 
																	y = y +40;
																}
									}

public void pintarRaqueta1(Graphics2D g) {

										g.fillRoundRect(14, 207-y, 20,largo,25,25);
											}

public Rectangle limiteRaqueta1(){
										return new Rectangle(14,207-y,  20,largo);
	}
	
}

