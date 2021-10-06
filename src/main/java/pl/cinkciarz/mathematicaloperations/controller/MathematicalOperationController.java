package pl.cinkciarz.mathematicaloperations.controller;

import pl.cinkciarz.mathematicaloperations.api.MathematicalOperationsApi;
import pl.cinkciarz.mathematicaloperations.model.MathematicalOperation;
import pl.cinkciarz.mathematicaloperations.persistance.service.MathematicalOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathematicalOperationController implements MathematicalOperationsApi {

    @Autowired
    private MathematicalOperationService service;

    @Override
    public ResponseEntity getMathematicalOperations() {
        List<MathematicalOperation> allOperations = service.getMathematicalOperations();
        return ResponseEntity.status(HttpStatus.OK). body(allOperations);
    }

    @Override
    public ResponseEntity addition(MathematicalOperation mathematicalOperation) {
        MathematicalOperation additionOperation = service.additionOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(additionOperation);
    }

    @Override
    public ResponseEntity subtraction(MathematicalOperation mathematicalOperation) {
        MathematicalOperation subtractionOperation = service.subtractionOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(subtractionOperation);
    }

    @Override
    public ResponseEntity multiplication(MathematicalOperation mathematicalOperation) {
        MathematicalOperation multiplicationOperation = service.multiplicationOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(multiplicationOperation);
    }

    @Override
    public ResponseEntity division(MathematicalOperation mathematicalOperation) {
        MathematicalOperation divisionOperation = service.divisionOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(divisionOperation);
    }

    @Override
    public ResponseEntity exponentiation(MathematicalOperation mathematicalOperation) {
        MathematicalOperation exponentiationOperation = service.exponentiationOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(exponentiationOperation);
    }

    @Override
    public ResponseEntity factorial(MathematicalOperation mathematicalOperation) {
        MathematicalOperation factorialOperation = service.factorialOperation(mathematicalOperation);
        return ResponseEntity.status(HttpStatus.CREATED).body(factorialOperation);
    }
}