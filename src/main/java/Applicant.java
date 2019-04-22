

public class Applicant {
    
    // required parameters
    private String fName;
    private String lName;
    private String state;
    private int age;
    private float hsGpa;
    private float gpaScale;
    private int numFelonies;
    private String decision;

    // optional parameters
    private int satScore;
    private int actScore;
    
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
    private Applicant(ApplicantBuilder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.state = builder.state;
        this.age = builder.age;
        this.hsGpa = builder.hsGpa;
        this.satScore = builder.satScore;
        this.gpaScale = builder.gpaScale;
        this.actScore = builder.actScore;
        this.numFelonies = builder.numFelonies;
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
    
  //Builder Class
    public static class ApplicantBuilder{

        // required parameters
        private String fName;
        private String lName;
        private String state;
        private int age;
        private float hsGpa;
        private float gpaScale;
        private int numFelonies;
        private String decision;

        // optional parameters
        private int satScore;
        private int actScore;
        
        public ApplicantBuilder(String fName, String lName, String state, int age, float hsGpa,
                float gpaScale, int numFelonies){
            this.fName = fName;
            this.lName = lName;
            this.state = state;
            this.age = age;
            this.hsGpa = hsGpa;
            this.gpaScale = gpaScale;
            this.numFelonies = numFelonies;
            this.decision = "pending";
        }

        public ApplicantBuilder setSAT(int satScore) {
            this.satScore = satScore;
            return this;
        }

        public ApplicantBuilder setACT(int actScore) {
            this.actScore = actScore;
            return this;
        }
        
        public Applicant build(){
            return new Applicant(this);
        }

    }

}