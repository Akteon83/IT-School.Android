package com.example.it_schoolandroid;

import java.util.Random;

public class TaskCreator {
    Random random = new Random();
    private int answer;
    private String task;

    public void createNewTask(int difficulty) {
        int first;
        int second;
        switch (random.nextInt(4)) {
            case 0:
                first = random.nextInt(40 + difficulty * 50) + 10;
                second = random.nextInt(40 + difficulty * 50) + 10;
                task = first + " + " + second + " =";
                answer = first + second;
                break;
            case 1:
                first = random.nextInt(40 + difficulty * 50) + 10;
                second = random.nextInt(first);
                task = first + " - " + second + " =";
                answer = first - second;
                break;
            case 2:
                first = random.nextInt(8 + difficulty * 5) + 2;
                second = random.nextInt(8 + difficulty * 5) + 2;
                task = first + " * " + second + " =";
                answer = first * second;
                break;
            case 3:
                answer = random.nextInt(8 + difficulty * 5) + 2;
                second = random.nextInt(8 + difficulty * 5) + 2;
                first = second * answer;
                task = first + " : " + second + " =";
        }
    }

    public String getTask() {
        return task;
    }

    public int getAnswer() {
        return answer;
    }

    public int getFakeAnswer() {
        int fakeAnwser = answer + random.nextInt(answer) - answer / 2;
        if (fakeAnwser == answer) {
            ++fakeAnwser;
        }
        return fakeAnwser;
    }
}
