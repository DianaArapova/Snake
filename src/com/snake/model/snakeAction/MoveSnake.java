package com.snake.model.snakeAction;

import com.snake.Tuple;
import com.snake.model.Direction;
import com.snake.model.Food;
import com.snake.model.Snake;
import com.snake.model.Tools;

import java.util.HashMap;
import java.util.Map;

public class MoveSnake implements Strategy{
    private Snake MySnake;
    private Food SnakeFood;
    private Tools tools;

    public MoveSnake(Snake snake, Food food, Tools tools)
    {
        MySnake = snake;
        SnakeFood = food;
        this.tools = tools;
    }

    @Override
    public boolean isReadyToExecute() {
        return !tools.getIsGameOver();
    }

    public void updateDictForDirection
            (Map<Direction, Tuple> dict)
    {
        dict.put(Direction.Right, new Tuple(1, 0));
        dict.put(Direction.Left, new Tuple(-1, 0));
        dict.put(Direction.Up, new Tuple(0, -1));
        dict.put(Direction.Down, new Tuple(0, 1));
    }

    @Override
    public void execute() {
        Map<Direction, Tuple> dict = new HashMap<>();
        updateDictForDirection(dict);

        for (int i = MySnake.getBody().size() - 1; i >= 0; i--)
        {
            if (i == 0)
            {
                MySnake.setBodyPart(i,
                        MySnake.getSnakeHead().getX(),
                        MySnake.getSnakeHead().getY());
            }
            else
            {
                MySnake.setBodyPart(i,
                        MySnake.getBody().get(i - 1).getX(),
                        MySnake.getBody().get(i - 1).getY());
            }
        }

        MySnake.setSnakeHead(
                MySnake.getSnakeHead().getX() + dict.get(tools.getDirection()).getItem1(),
                MySnake.getSnakeHead().getY() + dict.get(tools.getDirection()).getItem2());

    }
}
