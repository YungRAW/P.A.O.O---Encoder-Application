/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author catalin
 */
public class TextStreamEncoder 
{
    private TextEncoder encoder;
    private BufferedReader textReader;
    
    public TextStreamEncoder(BufferedReader reader, TextEncoder encoder)
    {
        this.encoder = encoder;
        textReader = reader;                
    }
    
    public void encode(BufferedOutputStream outputStream) throws IOException
    {
        String currentLine = null;
        
        while ((currentLine = textReader.readLine()) != null)
        {
            byte[] encodedData = encoder.encode(currentLine);
            outputStream.write(encodedData);
        }
        outputStream.flush();
        
    }
}
