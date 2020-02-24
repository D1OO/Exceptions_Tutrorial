package net.shvdy;

public class Main {

    public static void main(String[] args) {
        t1();
        //t2();
        //t3();
        t4();
        t5();
        t6();
       // t7();
        t8();
        System.out.println(t9());
        System.out.println(t11());
        System.out.println(t12());
    }


    public static void t1() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }

    public static void t2() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new Error();
            }
            System.err.print(" 1");
        } catch (Exception e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }

    public static void t3() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {
                throw new Error();
            } // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }

    public static void t4() {
        try {
        } catch (Exception e) {
      //  } catch (RuntimeException e) {
        }
    }

    public static void t5() {
        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }

    public static void t6() {
        try {
            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }

    public static void t7() {
        try {
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }

    public static void t8() {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }

    public static int t9() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    public static int t11() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }


    public static int t12() {
        try {
            return 0;
        } finally {
            throw new RuntimeException();
        }
    }
}
