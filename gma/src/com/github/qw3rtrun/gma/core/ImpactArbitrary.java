package com.github.qw3rtrun.gma.core;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;

public abstract class ImpactArbitrary<P extends Context, C extends Context> {

	private final CommandBus commandBus;

	public ImpactArbitrary(CommandBus commandBus) {
		this.commandBus = commandBus;
	}

	public CommandBus getCommandBus() {
		return commandBus;
	}

	protected void onProduce(ImpactProduceEvent<P, C> event) {
		for (Command cmd : event.getImpact().prepare(event.getProducer(), event.getConsumer()))
			getCommandBus().dispatch(
					GenericCommandMessage.asCommandMessage(cmd));
	}
}
