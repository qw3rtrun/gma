package com.github.qw3rtrun.gma.core;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.axonframework.domain.EventMessage;
import org.axonframework.domain.GenericDomainEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.joda.time.DateTime;

import checkers.nullness.quals.NonNull;

public class TimeModulator {
	
	public final static long PERIOD = 100;
	
	private final AtomicLong current = new AtomicLong(new DateTime(0, 1, 1, 0, 0).getMillis());

	private final @NonNull EventBus eventBus;
	private final @NonNull ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(
			1);

	public TimeModulator(@NonNull EventBus eventBus) {
		super();
		this.eventBus = eventBus;
		scheduler.scheduleWithFixedDelay(() -> eventBus.publish(tick()), 0,
				PERIOD, TimeUnit.MILLISECONDS);
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	EventMessage<TickEvent> tick() {
		return GenericDomainEventMessage.asEventMessage(new TickEvent(new DateTime(current.addAndGet(PERIOD)), PERIOD));
	}

}
