package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo 2/22/18.
 */

@RestController
@RequestMapping(value = "/primes")
public class PrimesController {
    
    @Autowired
	@Qualifier("primeService")
    PrimeServices primeService;

    @RequestMapping( method = GET)
    public ResponseEntity<?>  getPrimes() {
        try {
            return new ResponseEntity<>( primeService.getFoundPrimes(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/{primo}", method = GET)
    public ResponseEntity<?>  getPrimes(@PathVariable("primo") String primo) {
        try {
            return new ResponseEntity<>( primeService.getPrime(primo),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>  addNewPrime( @RequestBody FoundPrime primo) {
        try {
            primeService.addFoundPrime(primo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }


    //TODO implement additional methods provided by PrimeService



}
