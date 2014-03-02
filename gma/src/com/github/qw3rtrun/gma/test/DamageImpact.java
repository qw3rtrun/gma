package com.github.qw3rtrun.gma.test;

import org.axonframework.commandhandling.CommandBus;

import checkers.nullness.quals.NonNull;

import com.github.qw3rtrun.gma.core.Context;
import com.github.qw3rtrun.gma.core.ContextBoard;
import com.github.qw3rtrun.gma.core.ImpactArbitrary;
import com.github.qw3rtrun.gma.core.KnowledgeBase;

public class DamageImpact extends ImpactArbitrary<Unit, Context> {

	public DamageImpact(CommandBus commandBus, KnowledgeBase knowledgeBase,
			ContextBoard board) {
		super(commandBus, knowledgeBase, board);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected @NonNull Class<Unit> getProducerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected @NonNull Class<Context> getConsumerClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
