import java.util.ArrayList;

class StrategyOne implements AdmissionStrategy{
    
    private Applicant app;
    
    /**
     * This constructor takes the applicant whose data will be 
     * analyzed for admission based on the first strategy/criteria
     * 
     * @param app: Applicant to be considered for admission
     */
    public StrategyOne(Applicant app) {
        this.app = app;
    }
    
    /**
     * This method returns admission decision based on whether 
     * the applicant met the accept/reject criteria or not
     * 
     * @return: Admission decision
     */
    public String decision() {
        if (accepted()) {
            app.setDecision("instant accept");
            return "instant accept";
        } else if (rejected()) {
            app.setDecision("instant reject");
            return "instant reject, reason: " + rejectReason();
        } else {
            app.setDecision("further review");
            return "further review";
        }
    }
    
    /**
     * This method returns a boolean indicating whether 
     * the applicant has met the instant accept criteria
     * 
     * @return: boolean indicating acceptance status
     */
    public boolean accepted() {
        if (ageMet() && gpaMet() && satactMet() && !rejected()) return true;
        else return false;
    }

    /**
     * This method returns a boolean indicating whether 
     * the applicant has met the instant reject criteria
     * 
     * @return: boolean indicating rejection status
     */
    public boolean rejected() {
        if (!felloniesMet() || gpaNotMet() || app.getAge() < 0 || !validateFirstName() || !validateLastName()) {
            return true;
        }
        else return false;
    }
    
    /**
     * This method returns a string which stores the 
     * reason the applicant was instantly rejected 
     * 
     * @return: The reason applicant was rejected as an string
     */
    public String rejectReason() {
        
        ArrayList<String> rejectList=new ArrayList<String>();
        
        if (!felloniesMet()) rejectList.add("1) At Least one Fellony in the past 5 years");
        if (gpaNotMet()) rejectList.add("2) High School GPA was below 70%");
        if (app.getAge() < 0) rejectList.add("3) A negative value for age was entered") ;
        if (!validateFirstName()) rejectList.add("4) First Name was not in the valid form");
        if (!validateLastName()) rejectList.add("5) Last Name was not in the valid form") ;
        
        return rejectList.toString();
    }

    /**
     * This method determines whether the applicant meets the age/state requirements
     * 
     * @return: boolean true if the criterion is met and false if not
     */
    public boolean ageMet() {
        int age = app.getAge();
        return age >= 17 && age < 26 && app.getState().equals("California") || age > 80;
    }

    /**
     * This method determines whether the applicant meets 
     * the gpa requirements for instant acceptance
     * 
     * @return: boolean true if the criterion is met and false if not
     */
    public boolean gpaMet() {
        return gpaPercentage() >= 90;
    }

    /**
     * This method determines whether the applicant meets 
     * the gpa criterion for instant rejection
     * 
     * @return: boolean true if the criterion is met and false if not
     */
    public boolean gpaNotMet() {
        return gpaPercentage() < 70;
    }
    
    /**
     * This method determines whether the applicant meets the SAT and/or ACT requirements
     * 
     * @return: boolean true if criterion is met and false if not
     */
    public boolean satactMet() {
        return app.getsatScore() > 1920 || app.getactScore() > 27;
    }

    /**
     * This method determines whether the applicant has 
     * one or more felonies in the past five years
     * 
     * @return: boolean true it the criterion is met and false if not
     */
    public boolean felloniesMet() {
        return app.getNumFel() < 1;
    }
    
    /**
     * This method determines whether the applicant's first name starts with 
     * an upper case letter and the rest of it's letters are lower case or not
     * 
     * @return: boolean true if yes and boolean false if no
     */
    public boolean validateFirstName() {
        return app.getfName().matches("[A-Z][a-z]*");
    }

    /**
     * This method determines whether the applicant's last name starts with 
     * an upper case letter and the rest of it's letters are lower case or not
     * 
     * @return: boolean true if the criterion is met and false if not
     */
    public boolean validateLastName() {
        return app.getlName().matches("[A-Z][a-z]*");
    }
    
    /**
     * This method calculates the applicant's gpa percentage
     * 
     * @return: the gpa percentage as a double
     */
    public double gpaPercentage() {
        return (app.gethsGPA()/app.getGpaScale())*100;
    }
}