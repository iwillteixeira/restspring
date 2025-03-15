package br.com.springrest.springrest.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrest.springrest.SpringrestApplication;
import br.com.springrest.springrest.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SpringrestApplication springrestApplication;

    private final GreatingController greatingController;

    MathController(GreatingController greatingController, SpringrestApplication springrestApplication) {
        this.greatingController = greatingController;
        this.springrestApplication = springrestApplication;
    }
    //http://localhost:8080/math/sum/3/5
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/subtraction/3/5
    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    //http://localhost:8080/math/multiplication/3/5
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    //http://localhost:8080/math/division/3/5
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/pow/3/5
    @GetMapping("/pow/{numberOne}/{numberTwo}")
    public Double pow(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
    
        return Math.pow(convertToDouble(numberOne),convertToDouble(numberTwo));
    }


    private Double convertToDouble(String strNumber) throws Exception{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",",".");
        return Double.valueOf(number);

    }

    private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));

    }
    //http://localhost:8080/math/subtraction/3/5
    //http://localhost:8080/math/division/3/5
}
