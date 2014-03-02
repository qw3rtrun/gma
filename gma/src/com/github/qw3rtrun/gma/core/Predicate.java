package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;

@FunctionalInterface
public interface Predicate<T extends Context> {
	public @NonNull CheckResult check(@NonNull T arg);
}
