package co.com.samtel.service.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BussinessAspect {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Before("execution(String getSaludo(String))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {0} "+joinPoint);
	}
	
	@Before("execution( * co.com.samtel.service.*.get*(..))")
	public void beforeAll(JoinPoint joinPoint) {
		// Advice
		logger.info( joinPoint.getSignature().getName());
		Object[] argumentos = joinPoint.getArgs();
		for(Object item : argumentos) {
			logger.info("Argumento" + item);
		}
		logger.info(" Check for user access all ");
		logger.info(" Allowed execution for all {0} "+joinPoint);
	}
	@Around("execution( * co.com.samtel.service.*.test*(..))")
	public Object alrededor(ProceedingJoinPoint pjp) throws Throwable {
		 long start = System.currentTimeMillis();
         System.out.println("Going to call the method.");
         Object output = pjp.proceed();
         System.out.println("Method execution completed.");
         long elapsedTime = System.currentTimeMillis() - start;
         System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
         return output;
	}

}
