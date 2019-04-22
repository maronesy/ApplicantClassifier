public class Applicant {
    
    private String fName;
    private String lName;
    private int age;
    private float hsGpa;
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
    public Applicant(String fName, String lName, int age, float hsGpa,
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
    public Applicant(String fName, String lName, int age, float hsGpa,
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
    public Applicant(String fName, String lName, int age, float hsGpa,
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
     * Getter method for first name    
     * @return: The first name variable fName
     */
    public String getfName() {
        return fName;
    }
    
    /**
     * Getter method for last name
     * @return: The last name variable lName
     */
    public String getlName() {
        return lName;
    }
    
    /**
     * Getter method for the applicant's state
     * @return: The state variable
     */
    public String getState() {
        return state;
    }
    
    /**
     * Getter method for the applicant's age
     * @return: The age variable
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Getter method for the applicant's high school gpa
     * @return: The GPA variable
     */
    public float gethsGPA() {
        return hsGpa;
    }
    
    /**
     * Getter method for the applicant's GPA scale
     * @return: The GPA scale variable 
     */
    public float getGpaScale() {
        return gpaScale;
    }
    
    /**
     * Getter method for the applicant's SAT score
     * @return: The SAT score variable
     */
    public int getsatScore() {
        return satScore;
    }
    
    /**
     * Getter method for the applicant's ACT score
     * @return: The ACT score variable
     */
    public int getactScore() {
        return actScore;
    }
    
    /**
     * Getter method for the applicant's felonies in the past 5 years
     * @return: The number of felonies variable 
     */
    public int getNumFel() {
        return numFelonies;
    }
    
    /**
     * Getter method for the applicant's admission decision
     * @return: The admission decision variable
     */
    public String getDecision() {
        return decision;
    }
    
    /**
     * Setter method for the applicant's admission decision
     * @param dec: The decision made based on the admission criteria in the strategy class 
     */
    public void setDecision(String dec) {
        decision = dec;
    }
}