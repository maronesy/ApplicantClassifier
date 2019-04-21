import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdmissionTest{
    
    @Test
    public void furtherReviewTestOne() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("Souhayl", "Maronesy", 33, 3.4, 4, 1990, "California", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");       
    }    
    
    @Test
    public void furtherReviewTestTwo() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("Souhayl", "Maronesy", 23, 3.7, 4, 1990, "Washington", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    } 
    
    @Test
    public void furtherReviewTestThree() {
        
        Admission adm = new Admission();
        
        // applicant with no act score
        Applicant app = new Applicant("Souhayl", "Maronesy", 23, 3.7, 4, 1980, "Washington", 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    } 
    
    @Test
    public void instantAcceptTestOne() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("John", "Davis", 20, 3.7, 4, 1990, "California", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");      
    }  
    
    @Test
    public void instantAcceptTestTwo() {
        
        Admission adm = new Admission();
        
        // applicant with no act score
        Applicant app = new Applicant("Jimmy", "Johnson", 82, 3.7, 4, 1990, "Texas", 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");       
    } 
    
    @Test
    public void instantAcceptTestThree() {
        
        Admission adm = new Admission();
        
        // applicant with no sat score
        Applicant app = new Applicant("Jimmy", "Johnson", 82, 3.7, 4, "Texas", 30, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");      
    } 
    
    @Test
    public void instantRejectTestOne() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("tom", "ParKer", -19, 2.0, 4, 1900, "New York", 20, 4);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);
        
        String rejectReason = "instant reject, reason: [1) At Least one Fellony in the past 5 years, 2) High School GPA was below 70%, 3) A negative value for age was entered, 4) First Name was not in the valid form, 5) Last Name was not in the valid form]";

        // assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);      
    }  
    
    @Test
    public void instantRejectTestTwo() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("Tom", "Parker", -19, 3.8, 4, 1930, "New York", 20, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        // assert statements
        String rejectReason = "instant reject, reason: [3) A negative value for age was entered]";

        // assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    }  
    
    @Test
    public void instantRejectTestThree() {
        
        Admission adm = new Admission();
        
        Applicant app = new Applicant("Tom", "Parker", 25, 3.8, 4, 1930, "New York", 20, 2);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        // assert statements
        String rejectReason = "instant reject, reason: [1) At Least one Fellony in the past 5 years]";

        // assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    } 
    
}