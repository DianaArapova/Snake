package com.snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Food {
    private Rectangle NotAlcoholicFood;
    private Rectangle AlcoholicFood;
    private Rectangle DiedFood;
    public Image picNotAlcoholicFood;
    public Image picAlcoholicFood;
    public Image picDeadlyFood;
    private Random random;

    public Food()
    {
        NotAlcoholicFood  = new Rectangle();
        AlcoholicFood = new Rectangle();
        DiedFood = new Rectangle();
        random = new Random();
        generateAllFood();
        loadImages();
    }

    public Rectangle getNotAlcoholicFood() {
        return NotAlcoholicFood;
    }

    public Rectangle getAlcoholicFood() {
        return AlcoholicFood;
    }

    public Rectangle getDiedFood() {
        return DiedFood;
    }

    public Rectangle generateFood()
    {
        Rectangle food = new Rectangle();
        food.setX(random.nextInt(
                Tools.getMaxX()));
        food.setY(random.nextInt(
                Tools.getMaxX()));
        return food;
    }

    public void generateNotAlcoholicFood()
    {
        NotAlcoholicFood = generateFood();
        while (NotAlcoholicFood.Equals(DiedFood)
                || NotAlcoholicFood.Equals(AlcoholicFood))
        {
            NotAlcoholicFood = generateFood();
        }
    }

    public void generateAlcoholicFood()
    {
        AlcoholicFood = generateFood();
        while (AlcoholicFood.Equals(DiedFood)
                || AlcoholicFood.Equals(NotAlcoholicFood))
        {
            AlcoholicFood = generateFood();
        }
    }
    public void generateAllFood()
    {
        NotAlcoholicFood = generateFood();
        AlcoholicFood = generateFood();
        while (AlcoholicFood.Equals(NotAlcoholicFood))
        {
            AlcoholicFood = generateFood();
        }
        DiedFood = generateFood();
        while (DiedFood.Equals(NotAlcoholicFood)
                || DiedFood.Equals(AlcoholicFood))
        {
            DiedFood = generateFood();
        }
    }

    private void loadImages(){
        ImageIcon na = new ImageIcon("pic\\food.png");
        picNotAlcoholicFood = na.getImage();

        ImageIcon af = new ImageIcon("pic\\alcoholFood.png");
        picAlcoholicFood = af.getImage();

        ImageIcon df = new ImageIcon("pic\\deadlyFood.png");
        picDeadlyFood = df.getImage();
    }
}


