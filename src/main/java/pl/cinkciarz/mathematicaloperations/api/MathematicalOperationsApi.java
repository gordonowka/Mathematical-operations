package pl.cinkciarz.mathematicaloperations.api;

import pl.cinkciarz.mathematicaloperations.model.MathematicalOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/maths")
public interface MathematicalOperationsApi {

    @GetMapping
    ResponseEntity getMathematicalOperations();

    @PostMapping("/addition")
    ResponseEntity addition(@RequestBody MathematicalOperation mathematicalOperation);

    @PostMapping("/subtraction")
    ResponseEntity subtraction(@RequestBody MathematicalOperation mathematicalOperation); // odejmowanie

    @PostMapping("/multiplication")
    ResponseEntity multiplication(@RequestBody MathematicalOperation mathematicalOperation); // mnożenie

    @PostMapping("/division")
    ResponseEntity division(@RequestBody MathematicalOperation mathematicalOperation); //dzielenie

    @PostMapping("/exponentiation")
    ResponseEntity exponentiation(@RequestBody MathematicalOperation mathematicalOperation); // potęgowanie

    @PostMapping("/factorial")
    ResponseEntity factorial(@RequestBody MathematicalOperation mathematicalOperation); // silnia
}
