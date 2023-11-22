package org.example;


public class HiloSencillito{



    public static void main(String[] args) {

        Thread par = new Thread(){
          public void run(){
              for (int i = 2; i < 20; i+=2)
                  System.out.println(i);
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };
        Thread impar = new Thread(){
          public void run(){
              for (int i = 1; i < 20; i+=2){
                  System.out.println(i);
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
          }
        };

        impar.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        par.start();

        Thread infinito = new Thread(){
            public void run(){
                while(true) {
                    System.out.println("tic");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        Thread infinita = new Thread(){
            public void run(){
                while(true) {
                    System.out.println("tac");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        infinito.start();
        infinita.start();

    }
}