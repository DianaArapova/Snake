package com.snake.model.snakeAction;
import com.snake.model.Food;
import com.snake.model.Snake;
import com.snake.model.Tools;
import com.snake.model.snakeAction.*;

public class Consequences {
    private Strategy EatFood;
    private Strategy EatAlcoholicFood;
    private Strategy SnakeDies;
    private Strategy MoveSnake;

    public Consequences(Snake snake, Food food, Tools tools)
    {
        EatFood = new EatFood(snake, food, tools);
        EatAlcoholicFood = new EatAlcoholicFood(snake, food, tools);
        SnakeDies = new SnakeDies(snake, food, tools);
        MoveSnake = new MoveSnake(snake, food, tools);
    }

    public void recountConsequences()
    {
        MoveSnake.execute();
        EatFood.execute();
        EatAlcoholicFood.execute();
        SnakeDies.execute();
    }


}
