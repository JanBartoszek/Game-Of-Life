package com.Board.BoardController;

import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoop {

    private BoardController boardController;
    private boolean gameActive;
    private int speed = 1000;
    private int minSpeed = 50;
    private int maxSpeed = 2000;
    private int speedInterval = 50;
    private ScheduledExecutorService service;
    private PropertyChangeSupport support;



    public GameLoop(BoardController boardController) {
        this.boardController = boardController;
        this.support = new PropertyChangeSupport(this);
    }

    public int getSpeed() {
        return speed;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void stopThread(){
        gameActive = false;
        service.shutdown();
        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resumeThread(){
        if (!gameActive){
            gameActive = true;
            loop();
        } else {
            return;
        }
    }

    public void speedUp(){
        stopThread();
        if (speed > minSpeed){
            support.firePropertyChange("speed", String.valueOf(this.speed) , String.valueOf(this.speed - speedInterval));
            speed -= speedInterval;
        }
        resumeThread();
    }

    public void slowDown(){
        stopThread();
        if (speed < maxSpeed){
            support.firePropertyChange("speed", String.valueOf(this.speed) , String.valueOf(this.speed + speedInterval));
            speed += speedInterval;
        }
        resumeThread();
    }

    public void loop() {
        service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(runTheLoop(), 0, speed, TimeUnit.MILLISECONDS);
    }

    private Runnable runTheLoop(){
        Runnable runnable = () -> {
            try {
                Platform.runLater(() -> boardController.newGeneration());
            }
            catch (Exception e){
                System.out.println(e);
            }
        };
        return runnable;
    }

}
