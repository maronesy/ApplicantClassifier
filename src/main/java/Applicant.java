public class Applicant {
    
    private String fName;
    private String lName;
    private int age;
    private double hsGpa;
    private float gpaScale;
    private int satScore;
    private String state;
    private int actScore;
    private int numFelonies;
    private String decision;
    
    /**
     * Constructor storing applicant data
     * @param fName: Applicant's first name
     * @param lName: Applicant's last name
     * @param age: Applicant's age
     * @param hsGpa: Applicant's high school GPA
     * @param gpaScale: Scale for applicant's GPA
     * @param satScore: Applicant's SAT score
     * @param state: Applicant's state
     * @param actScore: Applicant's ACT score
     * @param numFellonies: Number of felonies applicant committed within the last 5 years
     */
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
        this.numFelonies = numFellonies;
        this.decision = "pending";
    }
    
    /**
     * Another constructor storing applicant data without ACT score
     */
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
        this.numFelonies = numFellonies;
        this.decision = "pending";
    }
    
    /**
     * Another constructor storing applicant data without SAT score
     */
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
        this.numFelonies = numFellonies;
        this.decision = "pending";
    }
    
    /**
     * getter method for first name    
     * @return: the first name variable fName
     */
    public String getfName() {
        return fName;
    }
    
    /**
     * getter method for last name
     * @return: the last name variable lName
     */
    public String getlName() {
        return lName;
    }
    
    /**
     * getter method for the applicant's state
     * @return: the state variable
     */
    public String getState() {
        return state;
    }
    
    /**
     * getter method for the applicant's age
     * @return: the age variable
     */
    public int getAge() {
        return age;
    }
    
    /**
     * getter method for the applicant's high school gpa
     * @return: the GPA variable
     */
    public double gethsGPA() {
        return hsGpa;
    }
    
    /**
     * getter method for the applicant's GPA scale
     * @return: the GPA scale variable 
     */
    public float getGpaScale() {
        return gpaScale;
    }
    
    /**
     * getter method for the applicant's SAT score
     * @return: the SAT score variable
     */
    public int getsatScore() {
        return satScore;
    }
    
    /**
     * getter method for the applicant's ACT score
     * @return: the ACT score variable
     */
    public int getactScore() {
        return actScore;
    }
    
    /**
     * getter method for the applicant's felonies in the past 5 years
     * @return: the number of felonies variable 
     */
    public int getNumFel() {
        return numFelonies;
    }
    
    /**
     * getter method for the applicant's admission decision
     * @return: the admission decision variable
     */
    public String getDecision() {
        return decision;
    }
    
    /**
     * setter method for the applicant's admission decision
     * @param dec: the decision made based on the admission criteria 
     */
    public void setDecision(String dec) {
        decision = dec;
    }
}