//package com.snake.tests;
//import com.snake.Game;
//import com.snake.model.Direction;
//import com.snake.model.Rectangle;
//import com.snake.model.Snake;
//import com.snake.model.Tools;
//import org.junit.Test;
//import junit.framework.Assert;
//
//
//public class Tests {
//    @Test
//    public void testMoveHeadOfSnake()
//    {
//        Game game = new Game();
//        game.getBody().movePlayer(game.getTools());
//
//        Assert.assertEquals(game.getBody().getBody().size(), 0);
//        Assert.assertEquals(game.getBody().getSnakeHead().getX(), 15);
//        Assert.assertEquals(game.getBody().getSnakeHead().getY(), 14);
//    }
//
//    @Test
//    public void testMoveSnakeWithTwoParts()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.eat();
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.getBody().size(), 1);
//        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
//        Assert.assertEquals(snake.getSnakeHead().getY(), 14);
//
//        Assert.assertEquals(snake.getBody().get(0).getX(), 15);
//        Assert.assertEquals(snake.getBody().get(0).getY(), 15);
//    }
//
//    @Test
//    public void testMoveWithChangeDirection()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        Tools tool = new Tools();
//        tool.setDirection(Direction.Left);
//        game.setTools(tool);
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.getBody().size(), 0);
//        Assert.assertEquals(snake.getSnakeHead().getX(), 14);
//        Assert.assertEquals(snake.getSnakeHead().getY(), 15);
//    }
//    @Test
//    public void testWhenSnakeDieGameWillOver()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        game.getFood().setDiedFood(new Rectangle(15, 14));
//
//        Assert.assertEquals(game.getTools().getIsGameOver(), true);
//    }
//
//    @Test
//    public void testMoveLongSnake()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        for (int i = 0; i < 5; i++)
//            snake.eat();
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.getBody().size(), 5);
//        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
//        Assert.assertEquals(snake.getSnakeHead().getY(), 14);
//    }
//
//    @Test
//    public void testDieWhenTouchWall()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.isSnakeDie(), false);
//
//        for (int i = 0; i < 30; i++)
//        {
//            snake.movePlayer(game.getTools());
//        }
//        Assert.assertEquals(snake.isSnakeDie(), true);
//    }
//
//    @Test
//    public void testDieWhenEatHimself()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        for (int i = 0; i < 5; i++)
//            snake.eat();
//        snake.movePlayer(game.getTools());
//
//        Tools tool = new Tools();
//        tool.setDirection(Direction.Left);
//        game.setTools(tool);
//        snake.movePlayer(game.getTools());
//
//        tool.setDirection(Direction.Down);
//        game.setTools(tool);
//        snake.movePlayer(game.getTools());
//
//        tool.setDirection(Direction.Right);
//        game.setTools(tool);
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.isSnakeDie(), true);
//    }
//
//    @Test
//    public void testDieSnakeEatDiedFood()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        game.getFood().setDiedFood(new Rectangle(15, 14));
//
//        Assert.assertEquals(snake.isSnakeDie(), true);
//    }
//
//    @Test
//    public void whenSnakeEatsFoodLengthIncreases()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//        snake.eat();
//
//        Assert.assertEquals(snake.getBody().size(), 1);
//    }
//
//    @Test
//    public void whenSnakeEatsAlcoholicFoodLengthIncreases()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        game.getFood().setAlcoholicFood(new Rectangle(15, 14));
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.getBody().size(), 1);
//    }
//
//    @Test
//    public void testWantEat()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        game.getFood().setNotAlcoholicFood(new Rectangle(15, 14));
//
//        Assert.assertEquals(snake.isSnakeEat(), true);
//    }
//
//    @Test
//    public void testWantEatAlcoholicFood()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        game.getFood().setAlcoholicFood(new Rectangle(15, 14));
//
//        Assert.assertEquals(snake.isSnakeAlcohol(), true);
//    }
//
//    @Test
//    public void testSnakeEatAlcoholicFoodAndDirectionChange()
//    {
//        Game game = new Game();
//        Snake snake = game.getBody();
//        snake.movePlayer(game.getTools());
//
//        game.getFood().setAlcoholicFood(new Rectangle(15, 14));
//
//        snake.movePlayer(game.getTools());
//
//        Assert.assertEquals(snake.getBody().size(), 0);
//        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
//        Assert.assertEquals(snake.getSnakeHead().getY(), 13);
//    }
//}