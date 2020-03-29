package fhw

import spock.lang.*

class PojoSpec
    extends Specification
{
    
    def "basic Pojo Spec" ()
    {
        given: 
            def p = new Pojo()
            
        when:
            p.setAttribute("Test")
            
        then: 
            "Test" == p.attribute
    }
    
    def "Using GroovySpy to spy Pojo constructor"()
    {
        given:
            def mockPojo = Mock(Pojo)            
            mockPojo.getAttribute() >> "from the mock"            
            def thing = GroovySpy(Pojo, global: true)             
            new Pojo() >> {mockPojo}
            
        when:
            def p = new Pojo()
            
        then: 
            "from the mock" == p.attribute
    }            
    
    def "Using Groovy Meta Class to simple mock of Pojo constructor"()
    {
        given:
            def mockPojo = Mock(Pojo)          
            mockPojo.getAttribute() >> "from the mock"            
            Pojo.metaClass.constructor = { mockPojo }
            
        when:
            def p = new Pojo()
            
        then: 
            "from the mock" == p.attribute
    }        
}
