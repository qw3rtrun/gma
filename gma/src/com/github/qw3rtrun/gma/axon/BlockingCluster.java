package com.github.qw3rtrun.gma.axon;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.axonframework.domain.EventMessage;
import org.axonframework.eventhandling.AbstractCluster;
import org.axonframework.eventhandling.EventListener;
import org.axonframework.eventhandling.MultiplexingEventProcessingMonitor;

public class BlockingCluster extends AbstractCluster {

	private final @NotNull ExecutorService exec;

	public BlockingCluster(String name, ExecutorService exec) {
		super(name);
		this.exec = exec;
	}

	@SuppressWarnings("rawtypes")
	protected Callable<Void> task(List<EventMessage> events,
			EventListener listener, MultiplexingEventProcessingMonitor monitor) {
		return () -> {
			events.forEach((e) -> {
				monitor.prepareForInvocation(e, listener);
				try {
					listener.handle(e);
					monitor.onEventProcessingCompleted(asList(e));
				} catch (Exception exc) {
					monitor.onEventProcessingFailed(asList(e), exc);
					throw exc;
				}
			});
			return null;
		};
	}


	@Override
	protected void doPublish(List<EventMessage> events,
			Set<EventListener> eventListeners,
			MultiplexingEventProcessingMonitor eventProcessingMonitor) {
		List<Callable<Void>> works = eventListeners.parallelStream()
				.<Callable<Void>> map((l) -> null).collect(toList());
		events.forEach(e -> eventProcessingMonitor.prepare(e));
		exec.invokeAll(works).forEach(f -> f.get());
	}
}
