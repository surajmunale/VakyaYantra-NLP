/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandhis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Priya
 */
public class test {
   
    public static void main(String args[])
    {
//         yanasandhi vs = new yanasandhi();
//        String word ="इत�?याह";// इत�?यादि अत�?याचार देव�?यालाय गत�?यवरोध यद�?यप�?यन�?ग
//        
//        //यद�?यपि has prob
//        
////        word=vs.process(word);
////       System.out.println("Vyanjan sandhi split = "+word);
//        visargaSandhi vs = new visargaSandhi();
//        System.out.println(vs.process("कोस�?मिन�?")); इत�?याह
//         vyanjan v = new vyanjan();
//         System.out.print(v.process("जगन�?नाथ"));
////        swara v = new swara();
////        try {
////            System.out.print(v.process("मृद�?व�?यतिरेकेण "));
////        } catch (SQLException ex) {
////            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
        mulitipleSplit ms = new mulitipleSplit();
        ArrayList<String> solution=ms.process("महालयास�?ति");
        System.out.println("Result");
        for(int i=0;i<solution.size();i++)
        {
            System.out.println(solution.get(i));
        }
    }
}
