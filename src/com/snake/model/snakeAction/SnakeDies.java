package com.snake.model.snakeAction;

import com.snake.model.Food;
import com.snake.model.Snake;
import com.snake.model.Tools;

public class SnakeDies implements Strategy {
    private Snake MySnake;
    private Food SnakeFood;
    private Tools tools;

    public SnakeDies(Snake snake, Food food, Tools tools)
    {
        MySnake = snake;
        SnakeFood = food;
        this.tools = tools;
    }

    @Override
    public boolean isReadyToExecute() {
        int maxX = Tools.getMaxX();
        int maxY = Tools.getMaxY();


        if (MySnake.getSnakeHead().getX() < 0 || MySnake.getSnakeHead().getY() < 0
                || MySnake.getSnakeHead().getX() >= maxX || MySnake.getSnakeHead().getY() >= maxY) {
            return true;
        }

        for (int j = 1; j < MySnake.getBody().size(); j++) {
            if (MySnake.getSnakeHead().getX() == MySnake.getBody().get(j).getX() &&
                    MySnake.getSnakeHead().getY() == MySnake.getBody().get(j).getY()) {
                return true;
            }
        }

        if (MySnake.getSnakeHead().getX() == SnakeFood.getDiedFood().getX() &&
                MySnake.getSnakeHead().getY() == SnakeFood.getDiedFood().getY())
            return true;

        return false;
    }

    @Override
    public void execute() {
        if (isReadyToExecute())
        {
            tools.setIsGameOver(true);
            MySnake.setAlcohol(1);
        }
    }
}
