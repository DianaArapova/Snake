package com.snake.model;

import com.snake.model.snakeAction.Consequences;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Snake {
    private Rectangle SnakeHead;
    private List<Rectangle> Body;
    private int Alcohol;
    private Consequences cons;
    private Image SnakeHeadPic;
    private Image SnakeBodyPic;

    public Rectangle getSnakeHead() {
        return SnakeHead;
    }

    public void setSnakeHead (int x, int y) {
        SnakeHead.setX(x);
        SnakeHead.setY(y);
    }

    public List<Rectangle> getBody() {
        return Body;
    }

    public Rectangle getBodyPart(int index){
        return Body.get(index);
    }

    public void setBodyPart(int index, int x, int y) {
        Body.get(index).setX(x);
        Body.get(index).setY(y);
    }

    public int getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(int alcohol) { Alcohol = alcohol; }

    public Image getSnakeHeadPic() { return SnakeHeadPic; }

    public Image getSnakeBodyPic() { return SnakeBodyPic; }

    public Snake(Food snakeFood, Tools tools)
    {
        SnakeHead = new Rectangle(15, 15);
        Body = createBody();
        Alcohol = 1;
        cons = new Consequences(this, snakeFood, tools);
        loadImages();
    }

    private ArrayList<Rectangle> createBody()
    {
        return new ArrayList<>();
    }

    private void loadImages(){
        ImageIcon sh = new ImageIcon("pic\\snakeHead.png");
        SnakeHeadPic = sh.getImage();

        ImageIcon sb = new ImageIcon("pic\\snakeBody.png");
        SnakeBodyPic = sb.getImage();
    }

    public void makeStep()
    {
        cons.recountConsequences();
    }
}
