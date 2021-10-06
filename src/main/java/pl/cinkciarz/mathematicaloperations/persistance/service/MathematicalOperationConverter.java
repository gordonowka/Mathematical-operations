package pl.cinkciarz.mathematicaloperations.persistance.service;

import pl.cinkciarz.mathematicaloperations.model.MathematicalOperation;
import pl.cinkciarz.mathematicaloperations.persistance.entity.MathematicalOperationEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class MathematicalOperationConverter {

    public static MathematicalOperationEntity modelToEntity(MathematicalOperation model) {
        MathematicalOperationEntity entity = new MathematicalOperationEntity();
        BeanUtils.copyProperties(model, entity);
        return entity;
    }

    public static MathematicalOperation entityToModel(MathematicalOperationEntity entity) {
        MathematicalOperation model = new MathematicalOperation();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public static List<MathematicalOperation> entityToModel(List<MathematicalOperationEntity> entities) {
        List<MathematicalOperation> result = new ArrayList<>();
        for (MathematicalOperationEntity entity:entities) {
            result.add(entityToModel(entity));
        }
        return result;
    }
}
