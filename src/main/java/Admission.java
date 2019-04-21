public class Admission {
    
    
    public Admission() {
        
    }
    
    public String decision(AdmissionStrategy admSt) {
        return admSt.decision();
    }
}