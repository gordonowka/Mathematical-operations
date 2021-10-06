package pl.cinkciarz.mathematicaloperations.persistance.service;

import pl.cinkciarz.mathematicaloperations.error.BadDividendException;
import pl.cinkciarz.mathematicaloperations.error.NotNaturalNumberException;
import pl.cinkciarz.mathematicaloperations.model.MathematicalOperation;
import pl.cinkciarz.mathematicaloperations.persistance.entity.MathematicalOperationEntity;
import pl.cinkciarz.mathematicaloperations.persistance.repository.MathematicalOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathematicalOperationService {

    @Autowired
    private MathematicalOperationsRepository repository;

    public List<MathematicalOperation> getMathematicalOperations() {
        return MathematicalOperationConverter.entityToModel(repository.findAll());
    }

    public MathematicalOperation additionOperation(MathematicalOperation mathematicalOperation) {
        double result = mathematicalOperation.getFirstNumber() + mathematicalOperation.getSecondNumber();
        mathematicalOperation.setResult(result);
        mathematicalOperation.setOperation('+');
        MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
        return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
    }

    public MathematicalOperation subtractionOperation(MathematicalOperation mathematicalOperation) {
        double result = mathematicalOperation.getFirstNumber() - mathematicalOperation.getSecondNumber();
        mathematicalOperation.setResult(result);
        mathematicalOperation.setOperation('-');
        MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
        return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
    }

    public MathematicalOperation multiplicationOperation(MathematicalOperation mathematicalOperation) {
        double result = mathematicalOperation.getFirstNumber() * mathematicalOperation.getSecondNumber();
        mathematicalOperation.setResult(result);
        mathematicalOperation.setOperation('*');
        MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
        return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
    }

    public MathematicalOperation divisionOperation(MathematicalOperation mathematicalOperation) {
        if (mathematicalOperation.getSecondNumber() != 0) {
            double result = mathematicalOperation.getFirstNumber() / mathematicalOperation.getSecondNumber();
            mathematicalOperation.setResult(result);
            mathematicalOperation.setOperation('/');
            MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
            return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
        }
        throw new BadDividendException("Remember damn don't divide by zero");
    }

    public MathematicalOperation exponentiationOperation(MathematicalOperation mathematicalOperation) {
        double result = mathematicalOperation.getFirstNumber() * mathematicalOperation.getFirstNumber();
        mathematicalOperation.setResult(result);
        mathematicalOperation.setOperation('^');
        MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
        return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
    }

    public MathematicalOperation factorialOperation(MathematicalOperation mathematicalOperation) {
        double checkIfNumberIsNatural = mathematicalOperation.getFirstNumber() * 10 % 10;
        if (mathematicalOperation.getFirstNumber() < 1 || checkIfNumberIsNatural != 0) {
            throw new NotNaturalNumberException("The number should be natural");
        } else {
            double result = 1;
            for (int idx = 1; idx < mathematicalOperation.getFirstNumber() + 1; idx++) {
                result *= idx;
            }
            mathematicalOperation.setResult(result);
            mathematicalOperation.setOperation('!');
            MathematicalOperationEntity mathematicalOperationEntity = MathematicalOperationConverter.modelToEntity(mathematicalOperation);
            return MathematicalOperationConverter.entityToModel(repository.save(mathematicalOperationEntity));
        }
    }
}
