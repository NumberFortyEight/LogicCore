import components.GameCore;
import components.entity.InputValue;
import components.repository.InputValuesRepository;
import components.repository.InputValuesRepositoryImpl;

public class Main {

    private static final InputValuesRepository valuesRepository = new InputValuesRepositoryImpl();

    public static void main(String[] args) {
        GameCore gameCore = new GameCore();
        gameCore.setInputValues(valuesRepository.getInputValuesList());
        gameCore.setInputValues(new InputValue("Вася", "топор"));
        System.out.println(gameCore.getTopFive());
    }
}
