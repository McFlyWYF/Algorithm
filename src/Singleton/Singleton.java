package Singleton;


public class Singleton {

    /*
    单例模式，饿汉式，线程安全
    */
    public static class Singleton1 {


        private final static Singleton1 s1 = new Singleton1();

        private Singleton1() {

        }

        public static Singleton1 getInstance() {
            return s1;
        }
    }


    /*
    懒汉式，线程不安全
     */
    public static class Singleton2 {

        public static Singleton2 s2 = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (s2 == null) {
                s2 = new Singleton2();
            }
            return s2;
        }

    }


    /*
    单例模式，懒汉式，线程安全，多线程环境下效率不高
     */

    public static class Singleton3 {

        private static Singleton3 s = null;

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            if (s == null) {
                s = new Singleton3();
            }
            return s;
        }
    }

    /*
    单例模式，懒汉式，变种，线程安全
     */

    public static class Singleton4 {
        private static Singleton4 s = null;

        private Singleton4() {
        }

        static {
            s = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return s;
        }
    }

    /*
    单例模式，使用静态内部类，线程安全
     */

    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 s = new Singleton5();
        }

        private Singleton5() {
        }

        public static Singleton5 getInstance() {
            return SingletonHolder.s;
        }
    }

    /*
    静态内部类，使用枚举方式，线程安全
     */
    public enum Singleton6 {
        s;

        public void whateverMethod() {

        }
    }

    /*
    静态内部类，使用双重校验锁，线程安全
     */

    public static class Singleton7 {
        private volatile static Singleton7 s = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (s == null) {
                synchronized (Singleton7.class) {
                    if (s == null) {
                        s = new Singleton7();
                    }
                }
            }
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.s == Singleton6.s);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());

    }
}
