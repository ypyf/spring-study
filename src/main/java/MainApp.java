import net.clickwifi.cloud.auth.CloudAuth;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CloudAuth auth = (CloudAuth)context.getBean("cloudAuth");
        auth.login();
        auth.logout();

        // JVM关闭时会调用豆子的destroy方法
        context.registerShutdownHook();
    }
}
