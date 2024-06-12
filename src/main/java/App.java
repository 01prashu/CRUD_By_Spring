import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.dao.ImplementInterfaceDao;
import com.spring.dao.JavaConfig;
import com.spring.model.Product;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
		Product prod1 = new Product();
		prod1.setProductName("Air Frshner");
		prod1.setProductDescription("High Quality Product Freshner");
		prod1.setProductPrice(889);
		
		System.out.println(prod1);
		int r= implDao.Add(prod1);
		System.out.println(r);
		List<Product> l = implDao.GetAllProduct();
		System.out.println(l);
		
	}
}
