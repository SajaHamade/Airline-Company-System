package I4404.Project.AirlineCompanySystem.MealFactory.ConcreateMealClasses;

import I4404.Project.AirlineCompanySystem.MealFactory.Meal;

public class VeganMeal implements Meal {
    @Override
    public String getMealType() {
        return "Vegan";
    }
}
