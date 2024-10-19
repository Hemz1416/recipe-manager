controll

package com.example.HelloSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public List<RecipeModel> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/add")
    public RecipeModel addRecipe(@RequestBody RecipeModel newRecipe) {
        return recipeService.addRecipe(newRecipe);
    }

    @PutMapping("/rate/{id}")
    public void rateRecipe(@PathVariable Long id, @RequestParam double rating) {
        recipeService.rateRecipe(id, rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    // Optionally, if you want a separate endpoint to serve the HTML file:
    @GetMapping("/recipes")
    public String viewRecipes() {
        return "view-recipes"; // This should match the name of your HTML file without the extension
    }
}
