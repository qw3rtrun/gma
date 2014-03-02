package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;
import checkers.nullness.quals.Nullable;

public interface KnowledgeBase {
	public @Nullable <P extends Context, C extends Context> Impact<P, C> getImpact(
			@NonNull String id, @NonNull Class<P> producer,
			@NonNull Class<C> cousumer);

	public @Nullable <T extends Context> Predicate<T> getPredicate(String id, Class<T> argType);
}
