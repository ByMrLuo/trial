package com.trial.algorithm;

/**
 * @description: Abc依次打印
 * @date: 2022/2/24 16:45
 * @author: luoziwen
 */
public class Demo {

    private static volatile  int COUNT = 30;

    public static void main(String[] args) {
        Maj maj = new Maj();
        Thread a = new Thread(new Task(maj, "A"));
        Thread b = new Thread(new Task(maj, "B"));
        Thread c = new Thread(new Task(maj, "C"));
        a.start();
        b.start();
        c.start();
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            try {
                while (COUNT > 0){
                    if(COUNT%3==0){
                        if(letter.equals("A")){
                            synchronized(maj){
                                System.out.print(letter);
                                COUNT--;
                                maj.notifyAll();
                                maj.wait();
                            }
                        }

                    }else if(COUNT%3==2){
                        if(letter.equals("B")){
                            synchronized(maj){
                                System.out.print(letter);
                                COUNT--;
                                maj.notifyAll();
                                maj.wait();
                            }
                        }
                    }else if(COUNT%3==1){
                        if(letter.equals("C")){
                            synchronized(maj){
                                System.out.print(letter+",");
                                COUNT--;
                                maj.notifyAll();
                                maj.wait();
                            }
                        }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        private Maj maj;

        private String letter;

        public Maj getMaj() {
            return maj;
        }

        public void setMaj(Maj maj) {
            this.maj = maj;
        }

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public Task(Maj maj, String letter) {
            this.maj = maj;
            this.letter = letter;
        }

        public Task() {
        }
    }

    static class Maj{

    }
}
