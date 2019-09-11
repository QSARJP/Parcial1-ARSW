package edu.eci.arsw.api.primesrepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

@Service("primeService")
public class PrimeServices{


    @Autowired
    @Qualifier("primeServiceStub")
    PrimeService pri = null;


    public void addFoundPrime(FoundPrime foundPrime) throws PrimePersistenceException {
        pri.addFoundPrime(foundPrime);
    }

    public List<FoundPrime> getFoundPrimes() throws PrimePersistenceException
    {
        return pri.getFoundPrimes();
        
    }

    
    public FoundPrime getPrime( String prime ) throws PrimePersistenceException
    {
        return pri.getPrime(prime);
    }



}