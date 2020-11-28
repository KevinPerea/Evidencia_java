/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps_java;

import static java.awt.Color.red;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Kevin Alvarez
 */
public class Juego {
    
    public Boolean inicio = Boolean.TRUE;
    public Integer sum;
    public Integer punto;
    private int dimension_boton;
    
    public void iniciar(){
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        
        JFrame f = new JFrame();
        
        int origen_x = 300;
        int origen_y = 300;
        int dimension_boton = 100;
        
        JLabel mensaje = new JLabel();
        JLabel d1 = new JLabel(); 
        JLabel d2 = new JLabel();
        
        
        mensaje.setFont(new Font("Courier", Font.BOLD,40));
        mensaje.setBounds(226,5,200,200);
        mensaje.setText("CRAPS");
        f.add(mensaje);
        
        
        d1.setIcon(new ImageIcon(getClass().getResource("5.png")));
        //d1.setIcon(new ImageIcon("1.png"));
        d1.setBounds(80,150,200,200);
        
        //d2.setIcon(new ImageIcon("1.png"));
        d2.setIcon(new ImageIcon(getClass().getResource("2.png")));
        d2.setBounds(350,150,200,200);
        
        f.add(d1);
        f.add(d2);
        
    ActionListener procesar_cliks = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            dado1.lanzarDado();
            dado2.lanzarDado();
            
            d1.setIcon(new ImageIcon(getClass().getResource(dado1.valor() + ".png")));
            d2.setIcon(new ImageIcon(getClass().getResource(dado2.valor() + ".png")));
            //d1.setIcon(new ImageIcon(dado1.valor() + ".png"));
            //d2.setIcon(new ImageIcon(dado2.valor() + ".png"));
            
            sum = dado1.valor() + dado2.valor();
            
            if (inicio){
                inicio = Boolean.FALSE;
                
                if(sum == 2 || sum == 3 || sum == 12){
                    JOptionPane.showMessageDialog(null, "Perdiste", "PERDEDOR",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }else if(sum == 7 || sum == 11){
                    JOptionPane.showMessageDialog(null, "Ganaste", "GANADOR",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }else{
                    JLabel txt = new JLabel();
                    punto = sum;
                    JOptionPane.showMessageDialog(null, "Sacaste punto, continua lanzando", "AGAIN",JOptionPane.INFORMATION_MESSAGE);
                    
                    txt.setText("Punto = " + punto);
                    txt.setFont(new Font("Courier", Font.BOLD,30));
                    txt.setBounds(220,350,250,80);
                    f.add(txt);
                    
                }
            }else{
                if(sum == punto){
                   JOptionPane.showMessageDialog(null, "Ganaste", "GANADOR",JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
                   
                }else if(sum == 7){
                    JOptionPane.showMessageDialog(null, "Perdiste", "PERDEDOR",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }else{
                    JOptionPane.showMessageDialog(null, "Sacaste punto, continua lanzando", "AGAIN",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            f.repaint();
            f.revalidate();
            
        }

         
        
    };
    
    JButton b = new JButton();
    b.setText("Lanzar");
    
    b.setBounds(origen_x - dimension_boton/2, 2*origen_y - (3/2)*dimension_boton,dimension_boton,dimension_boton/2);
    b.addActionListener(procesar_cliks);
    f.add(b);
    
    f.setSize(600,600);
    f.setLayout(null);
    
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    
        
        
        
        
    }

   
    
    
    
    
    
}
