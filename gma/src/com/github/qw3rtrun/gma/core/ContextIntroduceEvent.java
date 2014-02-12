package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;

public class ContextIntroduceEvent<T extends Context> extends ContextEvent<T> {

	public ContextIntroduceEvent(@NonNull T context) {
		super(context);
	}

}
