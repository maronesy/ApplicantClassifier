import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StrategyOneTest{
    
    @Test
    public void criterionMetTest() {
        
        /**
         * California applicant who meets all the instant accept criteria
         */
         Applicant app = new Applicant.ApplicantBuilder("John", "Davis", "California", 20, 3.7f, 4.0f, 0)
                 .setSAT(1990).setACT(28).build();
        
        StrategyOne stOne = new StrategyOne(app);
        
        /**
         * Assert statements showing that all the criterion have been met
         */
        assertTrue(stOne.validateFirstName());
        assertTrue(stOne.validateLastName());
        assertTrue(stOne.ageMet());
        assertTrue(stOne.gpaMet());
        assertFalse(stOne.gpaNotMet());       
        assertTrue(stOne.satactMet());   
        assertTrue(stOne.felloniesMet());
    }    
    
    @Test
    public void criterionNotMetTest() {
        
        /**
         * Applicant who meets all the reject requirements
         */
        Applicant app = new Applicant.ApplicantBuilder("tom", "ParKer", "New York", -19, 2.0f, 4.0f, 4)
                .setSAT(1900).setACT(20).build();
        
        StrategyOne stOne = new StrategyOne(app);

        /**
         * Asserts statements showing that none of the criterion have been met
         */
        assertFalse(stOne.validateFirstName());
        assertFalse(stOne.validateLastName());
        assertFalse(stOne.ageMet());
        assertFalse(stOne.gpaMet());
        assertTrue(stOne.gpaNotMet());       
        assertFalse(stOne.satactMet());   
        assertFalse(stOne.felloniesMet());     
    } 
}