package SystemUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SystemAnnotation {
	@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	
	public @interface systemAnnotation{
		public boolean readOnly() default false;
		
		public String getMethod() default "";
		
		public String setMethod() default "";
		
		public String columnName() default "";
		
		public String tableName() default "";
	}
}