package com.github.qw3rtrun.gma.core;

import checkers.nullness.quals.NonNull;

import com.github.qw3rtrun.gma.test.Unit;

public interface Context {
	public @NonNull String getId();
	
	default public boolean equalsContext(@NonNull Context other) {
		if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	default public boolean isSame(@NonNull Unit other) {
		return getId().equals(other.getId());
	}

	public static class Impl implements Context {
		private final @NonNull String id;

		public Impl(@NonNull String id) {
			super();
			this.id = id;
		}

		@Override
		public @NonNull String getId() {
			return id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Impl other = (Impl) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName()+" [id=" + id + "]";
		}
	}
}
