package iskills.com.weather.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * lennyhicks
 * 3/18/18
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeActivity {
}
