/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps_java;

import java.util.Random;

/**
 *
 * @author Kevin Alvarez
 */
public class Dado {
    private Integer resultado;
    
    public void lanzarDado(){
    Random ran = new Random();
    resultado = ran.nextInt(6)+1;
}
    
    public Integer valor(){
        return resultado;
    }
}
