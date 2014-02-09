package com.github.qw3rtrun.gma.axon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.domain.DomainEventMessage;
import org.axonframework.domain.DomainEventStream;
import org.axonframework.domain.SimpleDomainEventStream;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.EventStreamNotFoundException;

import checkers.nullness.quals.NonNull;

public class InMemoryEventStore implements EventStore {

	private final Map<StoreKey, List<DomainEventMessage<?>>> map = new HashMap<>();

	@Override
	public void appendEvents(@NonNull String type, @NonNull DomainEventStream events) {
		while (events.hasNext()) {
			DomainEventMessage<?> msg = events.next();
			StoreKey key = new StoreKey(type, msg.getIdentifier());
			List<DomainEventMessage<?>> list = getOrAdd(key);
			list.add(msg);
		}
	}

	protected synchronized List<DomainEventMessage<?>> getOrAdd(@NonNull StoreKey key) {
		List<DomainEventMessage<?>> result = map.get(key);
		if (result == null) {
			result = Collections.synchronizedList(new ArrayList<DomainEventMessage<?>>());
			map.put(key, result);
		}
		return result;
	}

	@Override
	public DomainEventStream readEvents(@NonNull String type, @NonNull Object identifier) {
		StoreKey key = new StoreKey(type, identifier);
		if (!map.containsKey(key))
			throw new  EventStreamNotFoundException(type, identifier);
		return new SimpleDomainEventStream(getOrAdd(key));
	}

	protected static class StoreKey {
		public String type;
		public Object identifier;

		public StoreKey(String type, Object identifier) {
			super();
			this.type = type;
			this.identifier = identifier;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((identifier == null) ? 0 : identifier.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			StoreKey other = (StoreKey) obj;
			if (identifier == null) {
				if (other.identifier != null)
					return false;
			} else if (!identifier.equals(other.identifier))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return identifier + "@" + type;
		}
	}

}
