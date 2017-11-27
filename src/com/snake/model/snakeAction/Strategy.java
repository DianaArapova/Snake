package com.snake.model.snakeAction;

public interface Strategy {
    boolean isReadyToExecute();
    void execute();
}
