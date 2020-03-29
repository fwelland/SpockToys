package fhw

import spock.lang.*

class ContainerPojoSpec
    extends Specification
{

    def "basic ContainerPojo Spec" ()
    {
        given: 
            def cp = new ContainerPojo()
            
        when:
            cp.setAttribute("Test")
            
        then: 
            "Test" == cp.attribute
            "default from ContainerPojo construction" == cp.pojo.attribute
    }
            
    def "Using GroovyMock to mock Pojo constructor in a container object"()
    {
        given:
            def mockedPojo = GroovyMock(Pojo, global: true)      
            mockedPojo.getAttribute() >> "BEANS!"
            
        when:
            def cp = new ContainerPojo()
            
        then: 
            "BEANS!" == cp.pojo.attribute            
    }            
       
    def "just clobber the constructed 'inner' pojo w/o mocking the constructor"()
    {
        given:
            def cp = new ContainerPojo()
            def mockPojo = Mock(Pojo)
            mockPojo.getAttribute() >> "from a mock"
            cp.pojo  = mockPojo
            
        when: 
            cp.setAttribute("Test")
            
        then: 
            "Test" == cp.attribute
            "from a mock" == cp.pojo.attribute
    }    
}
