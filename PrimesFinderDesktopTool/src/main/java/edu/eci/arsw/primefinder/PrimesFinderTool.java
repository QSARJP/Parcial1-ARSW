package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.PrintConversionEvent;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

    public static void main(String[] args) {

        int maxPrim = 100;
        List<Thread> listThread = new ArrayList<>();
        int count = 4;
        int patch = maxPrim / count;
        int prueba = 0;
        int i = 0;
        PrimesResultSet prs = new PrimesResultSet("john");

        while (i < maxPrim) {

            prueba += patch;

            BigInteger stat = BigInteger.valueOf(i);
            BigInteger ends = BigInteger.valueOf(prueba);
            System.out.println(stat + "" + ends);
            Thread priFinder = new PrimeFinder(stat, ends, prs);
            listThread.add(priFinder);
            i += patch;
        }

        for (Thread e : listThread) {
            e.start();
            try {
                e.join();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                }
        }
        System.out.println("Prime numbers found:");
        System.out.println(prs.getPrimes());
                
                    
                   
        /* try {
        
            //check every 10ms if the idle status (10 seconds without mouse
            //activity) was reached. 
            Thread.sleep(10);
            if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                System.out.println("Idle CPU ");
            }
            else{
                System.out.println("User working again!");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
            
                        
            
            
            
            
	}
	
}


