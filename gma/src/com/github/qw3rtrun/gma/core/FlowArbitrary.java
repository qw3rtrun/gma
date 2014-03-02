package com.github.qw3rtrun.gma.core;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.joda.time.DateTime;

public class FlowArbitrary<P extends Context, C extends Context> extends AbstractAnnotatedSaga {

	private static final long serialVersionUID = 3111451317317166413L;
	
	private CommandBus commandBus;
	
	public CommandBus getCommandBus() {
		return commandBus;
	}

	public void setCommandBus(CommandBus commandBus) {
		this.commandBus = commandBus;
	}
	
	@StartSaga
	
	public void startFlow(FlowProduceIvent<P, C> producer)
	{
		
	}

	@SagaEventHandler(associationProperty = "tick")
	public final void onTick(TickEvent event) {
		onTick(event.getCurrentTime(), event.getDhelta());
	}
	
}
