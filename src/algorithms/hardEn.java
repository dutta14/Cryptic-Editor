/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Parth
 */
public class hardEn implements mainInt{
    
    @Override
    public String encrypt(String x) {
       
        String y="";
        for(int i=0;i<x.length();i+=4)
            y+=x.charAt(i);
        for(int i=1;i<x.length();i+=2)
            y+=x.charAt(i);
        for(int i=2;i<x.length();i+=4)
            y+=x.charAt(i);
        return y;
    }

    @Override
    public String decrypt(String x) {
        
        String y="";
        int len=x.length();
        int mid=len/2,top,bot=(len-mid)/2,i,j,k;
        top=(len-mid)%2==0?(len-mid)/2:(len-mid)/2+1;
        i=0;
        j=i+top;
        k=j+mid;
        while(k<x.length())
        {
            y=y+x.charAt(i++)+x.charAt(j++)+x.charAt(k++);
            //System.out.println(""+k+" "+y);
            y+=k<x.length()?x.charAt(j++):"";
        }
        if(y.length()!=x.length())
        {
            y+=x.charAt(i);
            if(y.length()!=x.length())
            {
                y+=x.charAt(j);
            }
        }
        return y;
    }
    
}
