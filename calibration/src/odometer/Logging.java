package odometer;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logging {
	
	private static FileHandler fh;
	private static Logger logger;
	
	static {
		try {
			fh = new FileHandler("/home/aruvi/prodapt/Odometer.log");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fh.setFormatter(new SimpleFormatter());
		
		
	}
	
	@Around("execution(* *(..)) && @annotation(odometer.annotations.NeedsLogging)")
	public Object logMethods(ProceedingJoinPoint pjp) throws Throwable{
		logger = Logger.getLogger(pjp.getClass().getName());
		logger.addHandler(fh);
		logger.setLevel(Level.FINEST);
		
		
		String methodSignature = pjp.getSignature().getName();
		logger.fine("Entering " + methodSignature);
		Object result;
		try {
			result = pjp.proceed(pjp.getArgs());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "trouble found", e);
			throw e;
		} finally {
			logger.fine("Exiting " + methodSignature);
		}
		return result;
	}

}
