import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        obj.setMessage("world hello");
        HelloChina obj2 = (HelloChina) context.getBean("helloChina");
        obj2.getMessage();
        obj2.getCount();
        // JVM关闭时会调用豆子的destroy方法
        context.registerShutdownHook();
    }
}
