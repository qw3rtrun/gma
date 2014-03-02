package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.Nullable;

public interface ContextBoard extends Board {
	public <C extends Context> @Nullable C getContext(String id, Class<C> type);
}
