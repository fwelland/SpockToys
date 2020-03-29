package fhw;

public class Printer
{

    private Printer()
    {
        
    }
    
    public static final String println(String s)
    {
        boolean b = "TRUE".equals(System.getProperty("PRINTER_ON")); 
        if(b)
        {
            System.out.println(s); 
        }
        return(s); 
    }
}
