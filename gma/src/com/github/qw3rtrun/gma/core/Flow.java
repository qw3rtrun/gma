package com.github.qw3rtrun.gma.core;

import org.joda.time.DateTime;

public interface Flow<P extends Context, C extends Context>  extends Knowledge {
	
	public Impact<P, C> getImpact(DateTime tick, long dhelta);
		
}
