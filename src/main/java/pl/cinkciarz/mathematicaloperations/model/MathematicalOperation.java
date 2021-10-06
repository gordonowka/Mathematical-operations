package pl.cinkciarz.mathematicaloperations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathematicalOperation {
    private double firstNumber;
    private double secondNumber;
    private double result;
    private char operation;
}
