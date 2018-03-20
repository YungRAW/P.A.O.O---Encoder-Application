package laborator3;


public class BinaryEncoder 
{
    public byte startInterval;
    public byte endInterval;
    public byte randomValue;
    
    public BinaryEncoder (byte startRange, byte endRange, byte randValue)
    {
        this.startInterval = startRange;
        this.endInterval = endRange;
        this.randomValue = randValue;
        
    }
    private byte encodeByte(byte inputByte)
    {
        byte retVal = 0;
        int sum = inputByte + randomValue;
        int dif = endInterval - startInterval;
        int reminder = sum % dif +1;
        retVal = (byte)(startInterval + (byte) reminder);
        return retVal;
                
        
    }
    public byte[] encode (byte[] inputData)
    {        
        byte[] outputData = new byte[inputData.length];
        
        for(int i = 0; i < inputData.length; i++)
        {
            outputData[i] = encodeByte(inputData[i]);
        }        
        
        return outputData;             
    }
}
