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
        Applicant app = new Applicant.ApplicantBuilder("John", "Davis", "California", 20, 3.7f, 4.0f, 0)
                .setSAT(1990).setACT(28).build();
        
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
        Applicant app = new Applicant.ApplicantBuilder("Jimmy", "Johnson", "Texas", 82, 3.7f, 4.0f, 0)
                .setSAT(1990).build();
        
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
        Applicant app = new Applicant.ApplicantBuilder("Jimmy", "Johnson", "Texas", 82, 3.7f, 4.0f, 0)
                .setACT(30).build();
        
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
         * Applicant who meets all the reject criteria
         */
        Applicant app = new Applicant.ApplicantBuilder("tom", "ParKer", "New York", -19, 2.0f, 4.0f, 4)
                .setSAT(1900).setACT(20).build();

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
        Applicant app = new Applicant.ApplicantBuilder("Tom", "Parker", "New York", -19, 3.8f, 4.0f, 0)
                .setSAT(1940).setACT(20).build();
        
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
         * Applicant who has committed one ore more felonies in the past 5 years
         */
        Applicant app = new Applicant.ApplicantBuilder("Tom", "Parker", "California", 23, 3.8f, 4.0f, 2)
                .setSAT(1940).setACT(20).build();
        
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
         * Applicant who's gpa score is below 70%
         */
        Applicant app = new Applicant.ApplicantBuilder("Tom", "Parker", "New York", 25, 2.5f, 4.0f, 0)
                .setSAT(1940).setACT(20).build();
        
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
         * Applicant who's first name is not in the valid form
         */
        Applicant app = new Applicant.ApplicantBuilder("TOm", "Parker", "New York", 25, 3.9f, 4.0f, 0)
                .setSAT(1940).setACT(28).build();
        
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
         * Applicant who's last name is not in the valid form
         */
        Applicant app = new Applicant.ApplicantBuilder("Tom", "parker", "New York", 25, 3.9f, 4.0f, 0)
                .setSAT(1940).setACT(28).build();
        
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
        Applicant app = new Applicant.ApplicantBuilder("Souhayl", "Maronesy", "California", 33, 3.9f, 4.0f, 0)
                .setSAT(1990).setACT(28).build();
        
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
         * Applicant is from out of state and is not above 80 years of age
         */
        Applicant app = new Applicant.ApplicantBuilder("Souhayl", "Maronesy", "Washington", 23, 3.7f, 4f, 0)
                .setSAT(1990).setACT(28).build();
        
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
         *  Calling the constructor without ACT scores
         */
        Applicant app = new Applicant.ApplicantBuilder("Sam", "Maronesy", "Washington", 89, 3.3f, 4f, 0)
                .setSAT(1990).build();
        
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
        Applicant app = new Applicant.ApplicantBuilder("Joe", "Marinos", "Washington", 89, 3.9f, 4f, 0)
                .setSAT(1880).setACT(22).build();
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    }   
    
    @Test
    public void furtherReviewTestFive() {
        
        Admission adm = new Admission();
        
        /**
         *  Applicant's SAT and ACT are both missing, frontend algorithm should not allow Applicant 
         *  to submit his/her form unless at least one of the scores has been entered. However, since
         *  failing both is not a reject criteria we will mark it as further review in the backend in 
         *  case frontend does not catch this scenario. Java compiler will set both scores to 0 by default.
         */
        Applicant app = new Applicant.ApplicantBuilder("Joe", "Marinos", "Washington", 89, 3.9f, 4f, 0)
                .build();
        
        AdmissionStrategy stOne = new StrategyOne(app);
        
        String admDec = adm.decision(stOne);

        // Assert statements
        assertFalse(stOne.accepted());
        assertFalse(stOne.rejected());
        assertEquals(admDec, "further review");      
    }  
}