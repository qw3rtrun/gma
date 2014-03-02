package com.github.qw3rtrun.gma.axon;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SchedulerTest {

	@Test
	public void test() throws InterruptedException {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(0);
		exec.scheduleAtFixedRate(() -> {System.out.println("call");}, 0, 1000, TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
	}

}
