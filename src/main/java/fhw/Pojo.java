package fhw;


public class Pojo
{

    private String attribute; 

    public Pojo()
    {
        Printer.println("Pojo constructor called");
    }

    public String getAttribute()
    {
        return attribute;
    }

    public void setAttribute(String attribute)
    {
        this.attribute = attribute;
    }
        
}
