package com.scaler.Product.Service.Controller;

import com.scaler.Product.Service.Exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

//End point : GET /hello
public class sampleController {
    @GetMapping("/hello")
    public String helloWorld(){
      return "Hello world Nani";
    }
    // End point GET  /hello/{name}
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable("name")String name) throws ProductNotFoundException {
        if(name.equals("HemanthNandyala")){
            throw new ProductNotFoundException("Hemanth Nandyala Not found");
        }
        return "hello" + name;
    }

    //End Point GET show/{sowId}/seat/{seatID}
    @GetMapping("/show/{showId}/seat/{seatId}")
    public String seatID(@PathVariable("showId") String showId, @PathVariable("seatId") int seatId) {
        return "Hemanth show ID is " + showId + "and the seat number is "+ seatId;

    }
}
