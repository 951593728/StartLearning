package staticproxy;


public class Test {

    public static void main(String[] args) {
        StudentDaoImpl studentDao=new StudentDaoImpl();
        Proxy proxy=new Proxy(studentDao);
        proxy.giveMoney();
    }
}
