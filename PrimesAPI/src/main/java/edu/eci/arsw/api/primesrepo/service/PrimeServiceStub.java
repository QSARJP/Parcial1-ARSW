package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.PrimePersistenceException;
import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

/**
 * @author Santiago Carrillo 2/22/18.
 */

@Component("primeServiceStub")
public class PrimeServiceStub implements PrimeService {
    private final Map<String, FoundPrime> primes = new HashMap<>();

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws PrimePersistenceException {
        synchronized(primes){
            if (primes.containsValue(foundPrime) || primes.containsKey(foundPrime.getPrime()) ) {
                throw new PrimePersistenceException("The given prime already exists");
            }else{
                primes.put(foundPrime.getPrime(),foundPrime);
            }
        }
    }

    @Override
    public List<FoundPrime> getFoundPrimes() throws PrimePersistenceException
    {
        List<FoundPrime> newPimes = new ArrayList<>();
        synchronized(primes){
            for (Entry<String, FoundPrime> entry : primes.entrySet()) {

                newPimes.add(entry.getValue());
    
            }
            if (newPimes.isEmpty()){
                throw new PrimePersistenceException("Error 404: No se encontro primos  ");
            }else {
                return newPimes;
            }

        }
        
    }

    @Override
    public FoundPrime getPrime( String prime )throws PrimePersistenceException
    {
        synchronized(primes){
            if (primes.containsKey(prime)) {
                return primes.get(prime);
            }else{
                
                throw new PrimePersistenceException("No se econtro el primo");
            }
        }
        
    }
}
