package test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import main.AppSpring;
import repository.CompteRepository;

import javax.transaction.Transactional;


@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
class TestCompteRepository {
	
	
	//static AnnotationConfigApplicationContext ctx; 
	@Autowired
	CompteRepository compteRepo;

	/*@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		compteRepo = ctx.getBean(CompteRepository.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}*/
	
	@Test
	public void compteRepositoryOk() {
		assertNotNull(compteRepo);
	}

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
