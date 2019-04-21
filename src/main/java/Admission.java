public class Admission {
    
    /**
     * Admission class constructor which takes no parameters
     */
    public Admission() {}
    
    /**
     * Method which calls the decision method of the strategy passed into it as it's argument
     * @param admSt: Instance of one of AdmissionStrategy implementations
     * @return: String representing the admission decision based on the criteria enforced
     * in the strategy class
     */
    public String decision(AdmissionStrategy admSt) {
        return admSt.decision();
    }
}