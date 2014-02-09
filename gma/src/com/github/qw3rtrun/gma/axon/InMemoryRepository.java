package com.github.qw3rtrun.gma.axon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.constraints.NotNull;

import org.axonframework.domain.AggregateRoot;
import org.axonframework.repository.AggregateNotFoundException;
import org.axonframework.repository.ConflictingAggregateVersionException;
import org.axonframework.repository.LockManager;
import org.axonframework.repository.LockingRepository;

import checkers.nullness.quals.NonNull;

@SuppressWarnings("rawtypes")
public class InMemoryRepository<T extends AggregateRoot> extends
		LockingRepository<T> {

	private final Map<Object, T> map = new ConcurrentHashMap<Object, T>();

	public InMemoryRepository(@NonNull Class<T> aggregateType) {
		super(aggregateType);
	}

	public InMemoryRepository(@NonNull Class<T> aggregateType,
			@NonNull LockManager lockManager) {
		super(aggregateType, lockManager);
	}

	@Override
	protected void doSaveWithLock(@NonNull T aggregate) {
		Object key = aggregate.getIdentifier();
		map.merge(key, aggregate, (old, _new) -> aggregate);
	}

	@Override
	protected void doDeleteWithLock(@NonNull T aggregate) {
		map.remove(aggregate.getIdentifier());
	}

	@Override
	protected @NotNull
	T doLoad(@NotNull Object aggregateIdentifier, Long expectedVersion) {
		T loaded = map.get(aggregateIdentifier);
		if (loaded == null)
			throw new AggregateNotFoundException(aggregateIdentifier,
					"Not found");
		if (expectedVersion != null && loaded.getVersion() != null
				&& !expectedVersion.equals(loaded.getVersion()))
			throw new ConflictingAggregateVersionException(aggregateIdentifier,
					expectedVersion, loaded.getVersion());
		return loaded;
	}
}
