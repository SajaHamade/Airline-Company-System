package I4404.Project.AirlineCompanySystem.MealFactory;

import I4404.Project.AirlineCompanySystem.MealFactory.ConcreateMealClasses.MeatMeal;
import I4404.Project.AirlineCompanySystem.MealFactory.ConcreateMealClasses.VeganMeal;
import I4404.Project.AirlineCompanySystem.MealFactory.ConcreateMealClasses.VegetarianMeal;

public class MealFactory {
    public static Meal getMeal(String mealPreference) {
        switch (mealPreference.toUpperCase()) {
            case "VEGETARIAN":
                return new VegetarianMeal();
            case "VEGAN":
                return new VeganMeal();
            case "MEATS":
                return new MeatMeal();
            default:
                throw new IllegalArgumentException("Invalid meal preference: " + mealPreference);
        }
    }
}
