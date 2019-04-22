/**
 * The Strategy Design Pattern interface
 * @author Souhayl
 *
 */

public interface AdmissionStrategy{
    
    /**
     * Admission Strategy interface:
     * 
     * Every strategy class which implements this interface will have to 
     * implement the following methods, however there will be other methods 
     * in each strategy class implementing the accept/reject criteria.
     * 
     * Did not add the rest of the methods implemented in StrategyOne because based 
     * on the future accept/reject criteria they might not be needed at all, so no 
     * reason to force the programmer to implement them.
     * 
     */
    
    public String decision();

    public boolean accepted();
    
    public boolean rejected();
    
    public String rejectReason();
                
}