package com.github.qw3rtrun.gma.core;

import org.joda.time.DateTime;

import checkers.nullness.quals.NonNull;

public class TickEvent {
	
	final @NonNull DateTime currentTime;
	final long dhelta;

	public TickEvent(DateTime currentTime, long dhelta) {
		super();
		this.currentTime = currentTime;
		this.dhelta = dhelta;
	}

	public DateTime getCurrentTime() {
		return currentTime;
	}

	public long getDhelta() {
		return dhelta;
	}
	
	public String getTick()
	{
		return "TICK";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentTime == null) ? 0 : currentTime.hashCode());
		result = prime * result + (int) (dhelta ^ (dhelta >>> 32));
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
		TickEvent other = (TickEvent) obj;
		if (currentTime == null) {
			if (other.currentTime != null)
				return false;
		} else if (!currentTime.equals(other.currentTime))
			return false;
		if (dhelta != other.dhelta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TickEvent [currentTime=" + currentTime + ", dhelta=" + dhelta
				+ "]";
	}
}
