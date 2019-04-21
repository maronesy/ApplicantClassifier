
public interface AdmissionStrategy{
    
    // every strategy class should implement the following methods, however there will be
    // other methods in each strategy class implementing the accept/reject criteria
    
    public String decision();

    public boolean accepted();
    
    public boolean rejected();
    
    public String rejectReason();
                
}