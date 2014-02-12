package com.github.qw3rtrun.gma.core;

import javax.validation.constraints.NotNull;

public interface SingleContext<T extends Context> {
	public @NotNull T get();
}
