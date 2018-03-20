package laborator3;



public class TextEncoder
{
    private BinaryEncoder encoder = null;
    
    public TextEncoder(BinaryEncoder encoder)
    {
        this.encoder = encoder;
    }

    public byte[] encode(String textToEncode)
    {
        byte[] encodedResult = null;
        
        encodedResult = encoder.encode(textToEncode.getBytes());
        
        return encodedResult;
    }
    
}

