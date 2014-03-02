package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;

public class ImpactProduceEvent<P extends Context, C extends Context> {
	private final @NonNull P producer;
	private final @NonNull Impact<P, C> impact;
	private final @NonNull C consumer;
	public ImpactProduceEvent(@NonNull P producer, @NonNull Impact<P, C> impact, @NonNull C consumer) {
		super();
		this.producer = producer;
		this.impact = impact;
		this.consumer = consumer;
	}
	
	public P getProducer() {
		return producer;
	}

	public Impact<P, C> getImpact() {
		return impact;
	}

	public C getConsumer() {
		return consumer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((consumer == null) ? 0 : consumer.hashCode());
		result = prime * result + ((impact == null) ? 0 : impact.hashCode());
		result = prime * result
				+ ((producer == null) ? 0 : producer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImpactProduceEvent<?, ?> other = (ImpactProduceEvent<?, ?>) obj;
		if (consumer == null) {
			if (other.consumer != null)
				return false;
		} else if (!consumer.equals(other.consumer))
			return false;
		if (impact == null) {
			if (other.impact != null)
				return false;
		} else if (!impact.equals(other.impact))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		return true;
	}



}
