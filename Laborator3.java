
package laborator3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

        
public class Laborator3 {

    public static void main(String[] args) 
    {       
        
        BufferedReader reader = getInputReader();
        BufferedOutputStream outStream = getOutputStream();
        
        if (reader != null)
        {
            if (outStream != null)
            {
                
                TextEncoder txtEncoder = new TextEncoder(new BinaryEncoder((byte)128, (byte)255, (byte)130));
                TextStreamEncoder txtStreamEncoder = new TextStreamEncoder(reader, txtEncoder);
                try
                {
                    txtStreamEncoder.encode(outStream);
                }
                catch(IOException e)
                {
                    System.out.println("Cannot encode stream. " + e.getMessage());
                }
                
                try
                {                
                    outStream.close();
                }
                catch(IOException e)
                {
                    System.out.println("Cannot close the output stream." + e.getMessage());
                }
            }
        
            try
            {
                reader.close();
            }
            catch(IOException e)
            {
                System.out.println("Input text reader cannot be closed." + e.getMessage());
            }
        }
        
    }
    
    private static BufferedReader getInputReader()
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader("inputText.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Input file cannot be opened. " + e.getMessage());
        }
        
        return reader;
    }
    
    private static BufferedOutputStream getOutputStream()
    {
        BufferedOutputStream outStream = null;
        try
        {
            outStream = new BufferedOutputStream(new FileOutputStream("outputText.bin"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot open the output file." + e.getMessage());
        }
            
                
        return outStream;
    }
}


