/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package safe;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author anindya
 */
public class ReadWrite {
   
    String str,ret="",path;
    
    ReadWrite(String st,File file)
    {
        str=st;
        path=file.toPath().toString();
    }
     
     void writeinto()
     {
	try(FileChannel fChan=(FileChannel)Files.newByteChannel(Paths.get(path),StandardOpenOption.WRITE,StandardOpenOption.CREATE/*,StandardOpenOption.APPEND*/))
        {
	        
	  //ret=obj.encrypt(str);
          int l=str.length();
          ByteBuffer mBuf = ByteBuffer.allocate(l);
          
         
          //Write some bytes into the buffer
          for(int i=0;i<l;i++)
              mBuf.put((byte)(str.charAt(i)));
          
          mBuf.rewind();
          
          fChan.write(mBuf);
        }
        catch(InvalidPathException|IOException e)
        {System.out.println("Error!");}
     }  
      
     String readfrom()
     {
      int count;
        try(SeekableByteChannel fchan = Files.newByteChannel(Paths.get(path)))
                {
                    //Allocate a buffer
                   ret="";
                    ByteBuffer mBuf = ByteBuffer.allocate(50);
                    do {
                        //Read a buffer
                        count=fchan.read(mBuf);
                        //stop when end of file is reached
                        if(count!=-1)
                        {
                            //rewind the buffer so that it can be read.
                            mBuf.rewind();
                            //Read bytes from Buffer and show on screen
                            for(int i=0; i<count; i++)
 				ret+=(char)(mBuf.get());
                            
                        }
                    } while(count!=-1);
               
                }       
        catch(InvalidPathException|IOException e2)
        {System.out.println("Error!");}
    // str=obj.decrypt(ret);
     return ret;
}    
}