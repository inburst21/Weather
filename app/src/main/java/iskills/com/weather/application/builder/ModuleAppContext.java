package iskills.com.weather.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * lennyhicks
 * 2/28/18
 */

@Module
public class ModuleAppContext {

    private final Context context;

    public ModuleAppContext(Context aContext) {
        this.context = aContext;
    }

    @ScopeApp
    @Provides
    Context provideAppContext() {
        return context;
    }

}
