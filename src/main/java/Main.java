import components.GameCore;
import components.entity.InputValue;
import components.repository.InputValuesRepository;
import components.repository.InputValuesRepositoryImpl;
import components.services.ResultService;

public class Main {

    private static final InputValuesRepository valuesRepository = new InputValuesRepositoryImpl();

    public static void main(String[] args) {
        GameCore gameCore = new GameCore();

        gameCore.setInputValues(valuesRepository.getInputValuesList());
        gameCore.setInputValues(new InputValue("Вася", "топор"));

        ResultService resultService = gameCore.getResultService();
        System.out.println(resultService.getTopFive());
        System.out.println(resultService.getBestResult());
    }
}
