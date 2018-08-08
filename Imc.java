/*
Jiuly Alexandra Rojas
hhtps://jiuly.com.ve
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Imc extends Applet implements ActionListener {
TextField tfEstatura,tfPeso, tfGenero;//entradas de texto
Label lEstatura,lPeso, lGenero;//label de los textos de entrada
Button boton;
double resultado;//variable para mostrar el resultado
private String clasificacion;
private String genero;

//método constructor,donde se crean los objetos a dibujar en el applet
public Imc() {
//Damos la instruccion que no se usará ningun layout para poder dibujar con setBounds
this.setLayout((null));

//setBounds(posicionx, posiciony, ancho, alto)
lEstatura= new Label("Estatura (mt): ");
lEstatura.setBounds(20, 20, 100, 20);
lPeso= new Label("Peso (kg): ");
lPeso.setBounds(20, 40, 100, 20);
lGenero= new Label("Genero (H o M): ");
lGenero.setBounds(20, 60, 100, 20);
tfEstatura = new TextField();
tfEstatura.setBounds(120, 20, 100, 20);
tfPeso = new TextField();
tfPeso.setBounds(120, 40, 100, 20);
tfGenero = new TextField();
tfGenero.setBounds(120, 60, 100, 20);
boton = new Button("Calcula");
boton.setBounds(120,100,100,20);
//agregamos los elementos a la pantalla
add(lEstatura);
add(lPeso);
add(lGenero);
add(tfEstatura);
add(tfEstatura);
add(tfPeso);
add(tfGenero);
add(boton);
boton. addActionListener(this); // se le añade al boton la facilidad de ser escuchado
	
}
//método paint en el cual se pone lo que se quiere dibujar
public void paint(Graphics g) {
	
	this.setSize(300, 300);

	
	double peso = Double.parseDouble(tfPeso.getText());
	double altura = Double.parseDouble(tfEstatura.getText());
	genero = tfGenero.getText(); 
	
	resultado = peso/(altura*altura);
	resultado = (double) Math.round(resultado * 100) / 100;
	
	 clasificar();
   //  return clasificacion;
	
	g.drawString("Su Indice de Masa corporal es = "+resultado, 20, 150);
	
	g.drawString("Atendiendo al IMC, tiene: "+clasificacion, 20, 170);
	 
	  
  
	//dibuja el cuadrado
}
// método para realizar las opciones al oprimir un botón
public void actionPerformed(ActionEvent ae) {
	
	repaint(); 
	
}
 private void clasificar() {
	 
	 switch (genero){
		 case "H":
			if (resultado < 20.0) {
				clasificacion = "Bajo Peso";
			} else if (resultado >= 20.1 && resultado <= 24.90) {
				clasificacion = "Normal";
			} else if (resultado >= 25.00 && resultado <= 29.90) {
				clasificacion = "Obesidad Leve";
			} else if (resultado >= 30.00 && resultado <= 40.00) {
				clasificacion = "Obesidad Severa";
			} else if (resultado > 40.00) {
				clasificacion = "Obesidad muy severa";
			} 
		 break;
		 
		 case "M":
		 	if (resultado < 20.0) {
				clasificacion = "Bajo Peso";
			} else if (resultado >= 20.1 && resultado <= 23.90) {
				clasificacion = "Normal";
			} else if (resultado >= 24.00 && resultado <= 28.90) {
				clasificacion = "Obesidad Leve";
			} else if (resultado >= 29.00 && resultado <= 37.00) {
				clasificacion = "Obesidad Severa";
			} else if (resultado > 37.00) {
				clasificacion = "Obesidad muy severa";
			} 
		 
		 break;
		 
		 default:
		 
		 clasificacion= "Solo escriba H o M"; 
		 
		 break;
		 
		 
		 
	 }
	 

    }

}
