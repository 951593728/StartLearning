package staticproxy;

public class Proxy implements StudentDao {

    private StudentDao studentDao;

    public Proxy(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void giveMoney() {

        System.out.println("先交给班长");
        studentDao.giveMoney();

    }
}
