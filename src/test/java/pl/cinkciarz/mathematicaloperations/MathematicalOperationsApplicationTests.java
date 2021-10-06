package pl.cinkciarz.mathematicaloperations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cinkciarz.mathematicaloperations.error.BadDividendException;
import pl.cinkciarz.mathematicaloperations.error.NotNaturalNumberException;
import pl.cinkciarz.mathematicaloperations.model.MathematicalOperation;
import pl.cinkciarz.mathematicaloperations.persistance.service.MathematicalOperationService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = MathematicalOperationsApplication.class)
class MathematicalOperationsApplicationTests {

    @Autowired
    private MathematicalOperationService service;

    @Test
    public void shouldAddTwoNumbers() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(50);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.additionOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(60);
    }

    @Test
    public void shouldSubtractSecondNumberFromTheFirst() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(50);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.subtractionOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(40);
    }

    @Test
    public void shouldGiveNegativeResultOfSubtract() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(0);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.subtractionOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isLessThan(0);
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(50);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.multiplicationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(500);
    }

    @Test
    public void shouldGiveNegativeResultOfMultiplyOneNegativeAndOnePositiveNumber() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(-50);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.multiplicationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isLessThan(0);
    }

    @Test
    public void shouldGivePositiveResultOfMultiplyTwoNegativeNumbers() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(-50);
        mathematicalOperation.setSecondNumber(-10);
        //when
        service.multiplicationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isGreaterThan(0);
    }

    @Test
    public void shouldGiveNullResultOfMultiplyWhenFirstNumberIsNull() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(0);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.multiplicationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(0);
    }

    @Test
    public void shouldGiveNullResultOfMultiplyWhenSecondNumberIsNull() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(-50);
        mathematicalOperation.setSecondNumber(0);
        //when
        service.multiplicationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(0);
    }

    @Test
    public void shouldDivideFirstNumberByTheSecond() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(50);
        mathematicalOperation.setSecondNumber(10);
        //when
        service.divisionOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(5);
    }

    @Test
    public void shouldExponentFirstNumber() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(50);
        //when
        service.exponentiationOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(2500);
    }

    @Test
    public void shouldCountFactorialOfTheFirstNumber() {
        //given
        MathematicalOperation mathematicalOperation = new MathematicalOperation();
        mathematicalOperation.setFirstNumber(5);
        //when
        service.factorialOperation(mathematicalOperation);
        //then
        assertThat(mathematicalOperation.getResult()).isEqualTo(120);
    }

    @Test
    public void shouldThrowBadDividedException() {
        try {
            MathematicalOperation mathematicalOperation = new MathematicalOperation();
            mathematicalOperation.setFirstNumber(50);
            mathematicalOperation.setSecondNumber(0);
            service.divisionOperation(mathematicalOperation);
        } catch (BadDividendException exception) {
            assertEquals("Remember damn don't divide by zero", exception.getMessage());
        }
    }

    @Test
    public void shouldThrowNotNaturalNumberException() {
        try {
            MathematicalOperation mathematicalOperation = new MathematicalOperation();
            mathematicalOperation.setFirstNumber(0);
            service.factorialOperation(mathematicalOperation);
        } catch (NotNaturalNumberException exception) {
            assertEquals("The number should be natural", exception.getMessage());
        }
    }
}
