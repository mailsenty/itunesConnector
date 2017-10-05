
package org.mule.modules.itunes.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.itunes.ItunesConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>ItunesConnectorProcessAdapter</code> is a wrapper around {@link ItunesConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-10-05T12:24:16-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class ItunesConnectorProcessAdapter
    extends ItunesConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<ItunesConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, ItunesConnectorCapabilitiesAdapter> getProcessTemplate() {
        final ItunesConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,ItunesConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, ItunesConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, ItunesConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
