package components.repository;


import components.entity.InputValue;

import java.util.List;

public class InputValuesRepositoryImpl implements InputValuesRepository {

    public List<InputValue> getInputValuesList() {
        return List.of(
                new InputValue("Александр", "топот"),
                new InputValue("Иван", "А рорза упала на лапу азора"),
                new InputValue("Дмитрий", "Потоп"),
                new InputValue("Хек", "розы"));
    }
}
