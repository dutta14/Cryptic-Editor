/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Parth
 */
public class medEn implements mainInt {
    
    @Override
    public String encrypt(String x) {
       
        String y="";
        String z="textnotyours";
        int j=0;
        for(int i=0;i<x.length();i++)
        {
            if(Character.isLowerCase(x.charAt(i)))
            {
                y+=(char)((x.charAt(i)-97+z.charAt(j)-97)%26+97);
                j=(j+1)%z.length();
            }
            if(Character.isUpperCase(x.charAt(i)))
            {
                y+=(char)((x.charAt(i)-65+z.charAt(j)-97)%26+97);
                j=(j+1)%z.length();

            }
            if(!Character.isLetter(x.charAt(i)))
            {
                y+=x.charAt(i);
            }
        }
        return y;
       
    }

    @Override
    public String decrypt(String x) {
        
        String y="";
        String z="textnotyours";
        int j=0;
        for(int i=0;i<x.length();i++)
        {
            if(Character.isLowerCase(x.charAt(i)))
            {
                y+=(char)((x.charAt(i)-97+(26-z.charAt(j)+97))%26+97);
                j=(j+1)%z.length();
            }
            if(!Character.isLetter(x.charAt(i)))
            {
                y+=x.charAt(i);
            }
        }
        return y;
    }
    
}
