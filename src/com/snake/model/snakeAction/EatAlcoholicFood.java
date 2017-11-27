package com.snake.model.snakeAction;

import com.snake.model.*;

public class EatAlcoholicFood implements Strategy {
    private Snake MySnake;
    private Food SnakeFood;
    private Tools tools;

    public EatAlcoholicFood(Snake snake, Food food, Tools tools)
    {
        MySnake = snake;
        SnakeFood = food;
        this.tools = tools;
    }

    @Override
    public boolean isReadyToExecute() {
        return MySnake.getSnakeHead().getX() == SnakeFood.getAlcoholicFood().getX()
                && MySnake.getSnakeHead().getY() == SnakeFood.getAlcoholicFood().getY();
    }

    @Override
    public void execute() {
        if (isReadyToExecute()) {
            Rectangle partOfSnake;
            if (MySnake.getBody().size() != 0) {
                partOfSnake = new Rectangle(
                        MySnake.getBody().get(MySnake.getBody().size() - 1).getX(),
                        MySnake.getBody().get(MySnake.getBody().size() - 1).getY()
                );
            } else {
                partOfSnake = new Rectangle(
                        MySnake.getSnakeHead().getX(),
                        MySnake.getSnakeHead().getY()
                );
            }

            MySnake.getBody().add(partOfSnake);
            SnakeFood.generateAlcoholicFood();
            tools.setTotalScore(tools.getTotalScore() + 2 * Tools.getScoreForFood());
            MySnake.setAlcohol(MySnake.getAlcohol() * -1);
        }
    }
}
