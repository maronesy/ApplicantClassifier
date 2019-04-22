import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdmissionTest{
    
    @Test
    public void instantAcceptTestOne() {
        
        Admission adm = new Admission();
        
        
       /**
        * California applicant who meets the instant accept criteria
        */
        Applicant app = new Applicant("John", "Davis", 20, 3.7f, 4, 1990, "California", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");      
    }  
    
    @Test
    public void instantAcceptTestTwo() {
        
        Admission adm = new Admission();
        
        /**
         *  Out of state applicant who is more that 82 years old and meets the instant accept criteria
         *  Calling the constructor without ACT score
         */
        Applicant app = new Applicant("Jimmy", "Johnson", 82, 3.7f, 4, 1990, "Texas", 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");       
    } 
    
    @Test
    public void instantAcceptTestThree() {
        
        Admission adm = new Admission();
        
        /**
         *  Out of state applicant who is more that 82 years old
         *  Calling the constructor without SAT score
         */
        Applicant app = new Applicant("Jimmy", "Johnson", 82, 3.7f, 4, "Texas", 30, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertTrue(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "instant accept");      
    } 
    
    @Test
    public void instantRejectTestOne() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who meets all the reject requirements
         */
        Applicant app = new Applicant("tom", "ParKer", -19, 2.0f, 4, 1900, "New York", 20, 4);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);
        
        String rejectReason = "instant reject, reason: [1) At Least one Fellony in the past 5 years, "
                + "2) High School GPA was below 70%, 3) A negative value for age was entered, "
                + "4) First Name was not in the valid form, 5) Last Name was not in the valid form]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);      
    }  
    
    @Test
    public void instantRejectTestTwo() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who has entered a negative value for age
         */
        Applicant app = new Applicant("Tom", "Parker", -19, 3.8f, 4, 1930, "New York", 20, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        String rejectReason = "instant reject, reason: [3) A negative value for age was entered]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    }  
    
    @Test
    public void instantRejectTestThree() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who has committed felonies in the past 5 years
         */
        Applicant app = new Applicant("Tom", "Parker", 25, 3.8f, 4, 1930, "New York", 20, 2);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        String rejectReason = "instant reject, reason: [1) At Least one Fellony in the past 5 years]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    } 
    
    @Test
    public void instantRejectTestFour() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who's gpa scores are below 70%
         */
        Applicant app = new Applicant("Tom", "Parker", 25, 2.5f, 4, 1930, "New York", 28, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        String rejectReason = "instant reject, reason: [2) High School GPA was below 70%]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    } 
    
    @Test
    public void instantRejectTestFive() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who's first name is not in the right format
         */
        Applicant app = new Applicant("TOm", "Parker", 25, 3.9f, 4, 1930, "New York", 28, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        String rejectReason = "instant reject, reason: [4) First Name was not in the valid form]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    } 
    
    @Test
    public void instantRejectTestSix() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant who's last name is not in the right format
         */
        Applicant app = new Applicant("Tom", "parker", 25, 3.9f, 4, 1930, "New York", 28, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
                
        String admDec = adm.decision(stOne);

        String rejectReason = "instant reject, reason: [5) Last Name was not in the valid form]";

        // Assert statements
        assertTrue(stOne.rejected());
        assertFalse(stOne.accepted());
        assertEquals(admDec, rejectReason);    
    } 
    
    @Test
    public void furtherReviewTestOne() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant from California but above 26 years of age
         */
        
        Applicant app = new Applicant("Souhayl", "Maronesy", 33, 3.9f, 4, 1990, "California", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");       
    }    
    
    @Test
    public void furtherReviewTestTwo() {
        
        Admission adm = new Admission();
        
        /**
         * Applicant is from out of state and not above 80 years of age
         */
        Applicant app = new Applicant("Souhayl", "Maronesy", 23, 3.7f, 4, 1990, "Washington", 29, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    } 
    
    @Test
    public void furtherReviewTestThree() {
        
        Admission adm = new Admission();
        
        /**
         *  Applicant's gpa is below 90% and above 70%.  
         *  Calling the constructor with ACT scores
         */
        Applicant app = new Applicant("Souhayl", "Maronesy", 89, 3.3f, 4, 1980, "Washington", 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    }   
    
    @Test
    public void furtherReviewTestFour() {
        
        Admission adm = new Admission();
        
        /**
         *  Applicant's SAT and ACT scores both fall below the minimum. 
         */
        Applicant app = new Applicant("Souhayl", "Maronesy", 89, 3.9f, 4, 1880, "Washington", 22, 0);
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    }   
}