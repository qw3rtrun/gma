package com.github.qw3rtrun.gma.core;

import javax.validation.constraints.NotNull;

import checkers.nullness.quals.NonNull;

public interface Impact<P extends Context, C extends Context> {
	public @NotNull Command[] prepare(@NonNull P producer, @NonNull C consumer);
}
