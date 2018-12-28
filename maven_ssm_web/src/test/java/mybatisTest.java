import com.itheima.dao.Productdao;
import com.itheima.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class mybatisTest {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Productdao acBean = ac.getBean(Productdao.class);
        List<Product> beanAll = acBean.findAll();
        for (Product product : beanAll) {
            System.out.println(product);
        }
    }

}
