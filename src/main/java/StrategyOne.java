import java.util.ArrayList;

class StrategyOne implements AdmissionStrategy{
    
    protected Applicant app;
    
    public StrategyOne(Applicant app) {
        this.app = app;
    }

    public String decision() {
        // TODO Auto-generated method stub
        if (accepted()) {
            app.setDecision("instant accept");
            return "instant accept";
        } else if (rejected()) {
            app.setDecision("instant reject");
            // System.out.println(rejectReason());
            return "instant reject, " + "reason: " + rejectReason();
        } else {
            app.setDecision("further review");
            return "further review";
        }
    }
    
    public boolean accepted() {
        // TODO Auto-generated method stub
        if (ageMet() && gpaMet() && satactMet() && !rejected()) return true;
        else return false;
    }

    public boolean rejected() {
        // TODO Auto-generated method stub
        if (!felloniesMet() || gpaNotMet() || app.getAge() < 0 || !validateFirstName() || !validateLastName()) {
            return true;
        }
        else return false;
    }
    
    public String rejectReason() {
        
        ArrayList<String> rejectList=new ArrayList<String>();
        
        if (!felloniesMet()) rejectList.add("1) At Least one Fellony in the past 5 years");
        if (gpaNotMet()) rejectList.add("2) High School GPA was below 70%");
        if (app.getAge() < 0) rejectList.add("3) A negative value for age was entered") ;
        if (!validateFirstName()) rejectList.add("4) First Name was not in the valid form");
        if (!validateLastName()) rejectList.add("5) Last Name was not in the valid form") ;
        
        return rejectList.toString();
    }

    public boolean ageMet() {
        // TODO Auto-generated method stub
        int age = app.getAge();
        return age >= 17 && age < 26 && app.getState().equals("California") || age > 80;
    }

    public boolean gpaMet() {
        // TODO Auto-generated method stub
        return gpaPercentage() >= 90;
    }

    public boolean gpaNotMet() {
        return gpaPercentage() < 70;
    }
    
    public boolean satactMet() {
        // TODO Auto-generated method stub
        return app.getsatScore() > 1920 || app.getactScore() > 27;
    }


    public boolean felloniesMet() {
        // TODO Auto-generated method stub
        return app.getNumFel() < 1;
    }
    
    // validate first name
    public boolean validateFirstName() {
        // TODO Auto-generated method stub
        return app.getfName().matches("[A-Z][a-z]*");
    }

    // validate last name
    public boolean validateLastName() {
        // TODO Auto-generated method stub
        return app.getlName().matches("[A-Z][a-z]*");
    }
    
    public double gpaPercentage() {
        return (app.gethsGPA()/app.getGpaScale())*100;
    }
}