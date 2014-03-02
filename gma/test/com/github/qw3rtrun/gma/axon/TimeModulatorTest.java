package com.github.qw3rtrun.gma.axon;

import java.util.Arrays;

import org.axonframework.domain.EventMessage;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventListener;
import org.junit.Test;

import com.github.qw3rtrun.gma.core.TimeModulator;

public class TimeModulatorTest {

	@Test
	public void test() throws InterruptedException {
		EventBus stub = new EventBus() {
			@Override
			public void unsubscribe(EventListener eventListener) {
			}
			
			@Override
			public void subscribe(EventListener eventListener) {
			}
			
			@Override
			public void publish(@SuppressWarnings("rawtypes") EventMessage... events) {
				Arrays.asList(events).forEach(System.out::println);
			}
		};
		
		new TimeModulator(stub);
		
		Thread.sleep(1000);
	}

}
