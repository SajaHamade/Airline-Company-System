package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.MealFactory.Meal;
import I4404.Project.AirlineCompanySystem.MealFactory.MealFactory;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    public String getMealForPassenger(String mealPreference) {
        Meal meal = MealFactory.getMeal(mealPreference);
        return meal.getMealType();
    }
}
