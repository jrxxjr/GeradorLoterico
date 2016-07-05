package br.com.tidicas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** 
 * Classe utilitaria para geração de números para jogos lotéricos   
 *  
 * @author Evaldo Junior
 *
 */
public class Util  {

	/**
	 * Gera números aleatórios para jogos lotéricos 
	 * @return String
	 */
	public static int[] generateNumeros(int jogo, int dezenas) {
		
	       List<Integer> urnaDeBolas = new ArrayList<Integer>(jogo); 
	       for(int i = 1; i<=jogo; i++){

	           urnaDeBolas.add(i); 
	       }    
	       	int[] resultados = new int[dezenas]; 
	       	Random roleta = new Random(); 

		        for(int j = 0 ; j <= dezenas-1; j++) {

		            Collections.shuffle(urnaDeBolas);		            
		            int indexSorteado = roleta.nextInt(urnaDeBolas.size());
		            resultados[j] = urnaDeBolas.remove(indexSorteado);
		            
		        }
		        Arrays.sort(resultados);
		        		        
		        return resultados;
		}     

}