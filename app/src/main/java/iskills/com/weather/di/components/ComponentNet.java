package iskills.com.weather.di.components;

import javax.inject.Singleton;

import dagger.Component;
import iskills.com.weather.di.modules.ModuleApp;
import iskills.com.weather.di.modules.ModuleNet;

/**
 * lennyhicks
 * 3/15/18
 */
@Singleton
@Component(modules = {ModuleNet.class, ModuleApp.class})
interface ComponentNet {
}
