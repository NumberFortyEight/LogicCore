package components.repository;


import components.entity.InputValue;

import java.util.List;

public class InputValuesRepositoryImpl implements InputValuesRepository {

    public List<InputValue> getInputValuesList() {
        return List.of(
                new InputValue("Александр", "топот"),
                new InputValue("Александр", "годот"),
                new InputValue("Роза", "смс"),
                new InputValue("Роза", "Top spot"),
                new InputValue("Иван", "А роза упала на лапу азора"),
                new InputValue("Иван", "А леди у ног его - ну и дела"),
                new InputValue("Хек", "А леди у ног его - ну и дела"),
                new InputValue("Хек", "Цени в себе свинец"),
                new InputValue("Хек", "Eva, can I see bees in a cave?"),
                new InputValue("Роза", "No lemon, no melon"),
                new InputValue("Дмитрий", "Потоп"),
                new InputValue("Дмитрий", "Неуч учуен"),
                new InputValue("Дмитрий", "Лев осовел"));
    }
}
