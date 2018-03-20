package iskills.com.weather.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.weather.di.scope.ScopeActivity;
import iskills.com.weather.ui.main.ActivityMain;
import iskills.com.weather.ui.main.ModuleActivityMain;

/**
 * lennyhicks
 * 3/15/18
 */

@Module
public abstract class ActivityBuilder {

    @ScopeActivity
    @ContributesAndroidInjector(modules = ModuleActivityMain.class)
    abstract ActivityMain bindMainActivity();

}
