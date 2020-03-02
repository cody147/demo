package id.cody.base.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Component范围限制为用户生命周期
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {

}
