package fhw;

public class ContainerPojo
{
    private String attribute; 
    private Pojo pojo; 

    public ContainerPojo()
    {
        Printer.println("ContainerPojo constructor called");
        pojo = new Pojo();
        pojo.setAttribute("default from ContainerPojo construction");
        Printer.println("ContainerPojo constructor ending");        
    }
    
    public String getAttribute()
    {
        return attribute;
    }

    public void setAttribute(String attribute)
    {
        this.attribute = attribute;
    }

    public Pojo getPojo()
    {
        return pojo;
    }


}
