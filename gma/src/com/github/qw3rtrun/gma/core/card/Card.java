package com.github.qw3rtrun.gma.core.card;

import javax.validation.constraints.NotNull;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import checkers.nullness.quals.NonNull;

import com.github.qw3rtrun.gma.core.Context;
import com.github.qw3rtrun.gma.core.ContextEvent;
import com.github.qw3rtrun.gma.core.SingleContext;

public abstract class Card<T extends Context> extends AbstractAnnotatedAggregateRoot<String> implements SingleContext<T> {

	private static final long serialVersionUID = -2874864947093576851L;

	@AggregateIdentifier
	private @NonNull String id;

	public Card() {
		super();
	}

	public Card(@NotNull String id) {
	}

	@EventHandler
	protected void onContext(ContextEvent<? extends Context> event) {
		this.id = event.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Card<?> other = (Card<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + "]";
	}

}
