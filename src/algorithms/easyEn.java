/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Parth
 */
public class easyEn implements mainInt {

    @Override
    public String encrypt(String s) {
       
        String ret="";
        int j=2;
        for(char i:s.toCharArray())
        {
            ret+=(char)(i+j);
         
        }
        return ret;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String decrypt(String s) {
        
        String ret="";
        int j=2;
        for(char i:s.toCharArray())
        {
            ret+=(char)(i-j);
        
        }
        return ret;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
