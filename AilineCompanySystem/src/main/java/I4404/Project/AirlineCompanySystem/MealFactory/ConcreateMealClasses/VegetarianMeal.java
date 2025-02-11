package I4404.Project.AirlineCompanySystem.MealFactory.ConcreateMealClasses;

import I4404.Project.AirlineCompanySystem.MealFactory.Meal;

public class VegetarianMeal  implements Meal {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
}
