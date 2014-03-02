package com.github.qw3rtrun.gma.core;

public abstract class CheckResult {
	
	public final StringKnowledge cause;
	
	public abstract boolean isOk();
	public final boolean IsFail(){
		return !isOk();
	}
	public CheckResult(StringKnowledge cause) {
		super();
		this.cause = cause;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cause == null) ? 0 : cause.hashCode());
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
		CheckResult other = (CheckResult) obj;
		if (cause == null) {
			if (other.cause != null)
				return false;
		} else if (!cause.equals(other.cause))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  (isOk()? "Ok" : "Fail")+" (" + cause + ")";
	}
	
}
