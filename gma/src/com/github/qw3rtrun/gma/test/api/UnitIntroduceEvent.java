package com.github.qw3rtrun.gma.test.api;

import checkers.nullness.quals.NonNull;

import com.github.qw3rtrun.gma.core.ContextEvent;

public class UnitIntroduceEvent extends ContextEvent<Unit> {

	public UnitIntroduceEvent(@NonNull Unit context) {
		super(context);
	}

}
