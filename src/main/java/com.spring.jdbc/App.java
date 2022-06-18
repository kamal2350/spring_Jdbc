package com.spring.jdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //spring jdbc=>JdbcTemplate	
//                ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//        JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
//        String query=	"insert into table1(tName,Tcity) values(?,?)";
//        int result= template.update(query,"garima","delhi");
//        System.out.println(result);
                ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);
                StudentDao studentDao= context.getBean("studentDaoImp",StudentDao.class);
                Student student= new Student();
                student.setId(6);
                student.setCity("hamirpur");
                student.setName("tushar");
//                int r=studentDao.insert(student);
//                Student s= new Student(2,"Kartik", "malana");
//                int c=studentDao.update(s);
//                System.out.println(c);
                
//                deletion
                
               int id=2;
               studentDao.delete(id);
//               Student s=studentDao.getData(2);
//               System.out.println(s);
               List<Student> s1=studentDao.getAllData(2);
               System.out.println(s1);
               
                
        
    }
}
