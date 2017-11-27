package com.snake.model;

public class Rectangle
{
    private int X;
    private int Y;

    public int getX()
    {
        return X;
    }

    public void setX(int x)
    {
        X = x;
    }

    public int getY()
    {
        return Y;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public Rectangle()
    {
        X = 0;
        Y = 0;
    }

    public Rectangle(int x, int y)
    {
        X = x;
        Y = y;
    }

    public boolean Equals(Rectangle r)
    {
        if (r == null)
            return false;
        return (X == r.X) && (Y == r.Y);
    }
}
