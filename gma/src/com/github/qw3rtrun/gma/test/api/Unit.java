package com.github.qw3rtrun.gma.test.api;

import javax.validation.constraints.NotNull;

import checkers.nullness.quals.NonNull;

public interface Unit extends com.github.qw3rtrun.gma.core.Context {

	public int getHealthPoint();

	public int getAttackDamage();

	public int getDefensePoint();

	default public boolean equalsContext(@NonNull Unit other) {
		if (!getId().equals(other.getId()))
			return false;
		if (getAttackDamage() != other.getAttackDamage())
			return false;
		if (getHealthPoint() != other.getHealthPoint())
			return false;
		if (getDefensePoint() != other.getDefensePoint())
			return false;
		return true;
	}

	public static class Impl implements Unit {
		private final @NonNull String id;
		private final int healthPoint;
		private final int attackDamage;
		private final int defensePoint;

		public Impl(@NotNull String id, int healthPoint, int attackDamage,
				int defensePoint) {
			super();
			this.id = id;
			this.healthPoint = healthPoint;
			this.attackDamage = attackDamage;
			this.defensePoint = defensePoint;
		}

		@Override
		public @NonNull String getId() {
			return id;
		}

		@Override
		public int getHealthPoint() {
			return healthPoint;
		}

		@Override
		public int getAttackDamage() {
			return attackDamage;
		}

		@Override
		public int getDefensePoint() {
			return defensePoint;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + attackDamage;
			result = prime * result + defensePoint;
			result = prime * result + healthPoint;
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
			if (attackDamage != other.attackDamage)
				return false;
			if (defensePoint != other.defensePoint)
				return false;
			if (healthPoint != other.healthPoint)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Unit [id=" + id + ", healthPoint=" + healthPoint
					+ ", attackDamage=" + attackDamage + ", defensePoint="
					+ defensePoint + "]";
		}
	}
}
