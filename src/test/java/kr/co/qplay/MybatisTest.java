package kr.co.qplay;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MybatisTest {
	
	@Inject
	private SqlSessionFactory sqlsession;
	
	@Test
	public void mytest() {
		System.out.println(sqlsession);
	}
	@Test
	public void mytest2() {
		SqlSession session = sqlsession.openSession();
		System.out.println(session);
	}
	
	
	
}
