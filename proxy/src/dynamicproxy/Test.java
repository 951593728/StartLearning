package dynamicproxy;

public class Test {

    public static void main(String[] args) {
        UserDao userDao=new UserDaoImpl();
        UserDao proxyInstance = (UserDao)new ProxyFactory(userDao).getProxyInstance();
        proxyInstance.give();
    }

}
