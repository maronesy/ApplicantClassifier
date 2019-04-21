import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StrategyOneTest{
    
    @Test
    public void metTest() {
        
        Applicant app = new Applicant("Souhayl", "Maronesy", 23, 3.7, 4, 1990, "California", 29, 0);
        
        StrategyOne stOne = new StrategyOne(app);
        
        // assert statements
        assertTrue(stOne.validateFirstName());
        assertTrue(stOne.validateLastName());
        assertTrue(stOne.ageMet());
        assertTrue(stOne.gpaMet());
        assertFalse(stOne.gpaNotMet());       
        assertTrue(stOne.satactMet());   
        assertTrue(stOne.felloniesMet());
    }    
    
    @Test
    public void notMetTest() {
        
        Applicant app = new Applicant("SouHayl", "maronesy", 43, 3.3, 4, 1900, "Washington", 23, 1);
        
        StrategyOne stOne = new StrategyOne(app);

        // assert statements
        assertFalse(stOne.validateFirstName());
        assertFalse(stOne.validateLastName());
        assertFalse(stOne.ageMet());
        assertFalse(stOne.gpaMet());
        assertFalse(stOne.gpaNotMet());       
        assertFalse(stOne.satactMet());   
        assertFalse(stOne.felloniesMet());     
    } 
}