import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Raqueta2 {
	private int y, alto, largo;
  
public Raqueta2(int alto) {
							y = 0;
							largo = 70;
							this.alto = alto;
							}

public void moverRaquetaabajo2() {
									if (y - 20 > -207 ) {
														y = y - 20;
													}
									}

public void moverRaquetaarriba2() {
									if (y + largo +20 < alto - 242) {
																	y = y + 20;
																}
									}

public void pintarRaqueta2(Graphics2D g) {

											g.fillRoundRect(614,207-y, 20,largo,25,25);
		
										}
	
public Rectangle limiteRaqueta2(){
									return new Rectangle(614,207-y, 20,largo);
		
								}
}




	