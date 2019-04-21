public class Applicant {
    
    private String fName;
    private String lName;
    private String state;
    private int age;
    private double hsGpa;
    private float gpaScale;
    private int satScore;
    private int actScore;
    //number of fellonies in the past five years
    private int numFellonies;
    private String decision;
    
    public Applicant(String fName, String lName, int age, double hsGpa,
                    float gpaScale, int satScore, String state, int actScore, int numFellonies) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.hsGpa = hsGpa;
        this.gpaScale = gpaScale;
        this.satScore = satScore;
        this.state = state;
        this.actScore = actScore;
        this.numFellonies = numFellonies;
        this.decision = "pending";
    }
    
    public Applicant(String fName, String lName, int age, double hsGpa,
            float gpaScale, int satScore, String state, int numFellonies) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.hsGpa = hsGpa;
        this.gpaScale = gpaScale;
        this.satScore = satScore;
        this.state = state;
        this.actScore = -1;
        this.numFellonies = numFellonies;
        this.decision = "pending";
    }
    
    public Applicant(String fName, String lName, int age, double hsGpa,
            float gpaScale, String state, int actScore, int numFellonies) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.hsGpa = hsGpa;
        this.gpaScale = gpaScale;
        this.satScore = -1;
        this.state = state;
        this.actScore = actScore;
        this.numFellonies = numFellonies;
        this.decision = "pending";
    }
    
    public String getfName() {
        return fName;
    }
    
    public String getlName() {
        return lName;
    }
    
    public String getState() {
        return state;
    }
    
    public int getAge() {
        return age;
    }
    
    public double gethsGPA() {
        return hsGpa;
    }
    
    public float getGpaScale() {
        return gpaScale;
    }
    
    public int getsatScore() {
        return satScore;
    }
    
    public int getactScore() {
        return actScore;
    }
    
    public int getNumFel() {
        return numFellonies;
    }
    
    public String getDecision() {
        return decision;
    }
    
    public void setDecision(String dec) {
        decision = dec;
    }
}