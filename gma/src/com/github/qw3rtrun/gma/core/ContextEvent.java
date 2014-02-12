package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;

public class ContextEvent<T extends Context> implements SingleContext<T>{
	
	private final @NonNull T context;
	public ContextEvent(@NonNull T context) {
		super();
		this.context = context;
	}
	public String getId() {
		return get().getId();
	}
	public T get() {
		return context;
	} 
	
}
