package com.github.qw3rtrun.gma.axon;

import java.util.concurrent.Executors;

import org.axonframework.eventhandling.Cluster;
import org.axonframework.eventhandling.ClusterSelector;
import org.axonframework.eventhandling.ClusteringEventBus;
import org.axonframework.eventhandling.EventListener;
import org.axonframework.eventhandling.SimpleCluster;
import org.axonframework.eventhandling.async.AsynchronousCluster;
import org.axonframework.eventhandling.async.SequentialPerAggregatePolicy;

import com.github.qw3rtrun.gma.core.Board;

import checkers.nullness.quals.NonNull;

/**
 * Шина событий для gma. Состоит из 2х кластеров. На первый кластер вешаются
 * Доски (Boards), события обрабатываются на них первыми. На второй кластер -
 * Арбитры, Flow и прочие саги.
 * 
 * @author qw3rt_000
 *
 */

public class GmaEventBus extends ClusteringEventBus {

	public GmaEventBus() {
		super(new ClusterSelector() {
			final private @NonNull Cluster first = new SimpleCluster("first");
			final private @NonNull Cluster second = new AsynchronousCluster(
					"first",
					Executors.newCachedThreadPool(),
					new SequentialPerAggregatePolicy());
			
			@Override
			public Cluster selectCluster(EventListener eventListener) {
				if (eventListener instanceof Board)
					return first;
				return second;
			}
		});
	}
}
