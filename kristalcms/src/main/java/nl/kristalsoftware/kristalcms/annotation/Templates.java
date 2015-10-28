package nl.kristalsoftware.kristalcms.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sjoerdadema on 16-09-15.
 */
@Qualifier
@Target({FIELD, METHOD, PARAMETER, TYPE})
@Retention(RUNTIME)
public @interface Templates {
}
