package com.github.qw3rtrun.gma.axon;

import static java.util.concurrent.Executors.newWorkStealingPool;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.axonframework.domain.EventMessage;
import org.axonframework.domain.GenericDomainEventMessage;
import org.axonframework.eventhandling.EventListener;
import org.junit.Test;

public class BlockingClusterTest {

	private Object aggregateIdentifier = "default";
	private long sequenceNumber = 0;
	
	private <T> EventMessage<T> asEvent(T object)
	{
		return new GenericDomainEventMessage<T>(aggregateIdentifier, sequenceNumber++, object);
	}
	
	@Test
	public void test() {
		BlockingCluster cluster = new BlockingCluster("", newWorkStealingPool());
		EventListener listener = mock(EventListener.class);
		cluster.subscribe(listener);
		EventMessage<Integer> e = asEvent(1);
		cluster.publish(e);
		verify(listener, only()).handle(e);
	}

}
