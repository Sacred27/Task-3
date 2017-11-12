package R;
 
import static java.lang.System.out;
 import org.rosuda.REngine.REXPMismatchException;
 import org.rosuda.REngine.Rserve.RConnection;
 import org.rosuda.REngine.Rserve.RserveException;
 
 public class R {
 
     public static void main() {
         RConnection connection = null;
         
         try {
             connection = new RConnection();
 
             String vector = "c(1,2,3,4)";
             connection.eval("meanVal=mean(" + vector + ")");
             double mean = connection.eval("meanVal").asDouble();
             out.println("The mean of given vector is=" + mean);
         } catch (RserveException e) {
             e.printStackTrace();
         } catch (REXPMismatchException e) {
             e.printStackTrace();
         }finally{
             connection.close();
         }
     }
 }