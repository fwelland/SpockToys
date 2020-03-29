package fhw

import spock.lang.*

class PrinterSpec
    extends Specification
{
    
    def "basic Printer test" ()
    {
        given: 
            println "g"
            
        when:
            println "w"
            
        then: 
            println "t"
    }
    
    
}
