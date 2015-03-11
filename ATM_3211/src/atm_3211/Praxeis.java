/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_3211;

/**
 *
 * @author alexandra
 */
public class Praxeis{
private int poso=2000;

   
 
  public void katathesi(int posoKatat){
      poso=poso+ posoKatat;
    }
  
  public void analipsi(int posoAnal){
      if(poso>=posoAnal){
          poso=poso-posoAnal;
          System.out.print(poso);
   
 }}

    /**
     *
     */
    public int getPoso(){
      return poso;
      
  }
    public void savePoso(){
    this.poso=poso;}
} 
    
 

