package com.github.qw3rtrun.gma.test;

import checkers.nullness.quals.NonNull;

public class CmdUnitIntroduce {
	public @NonNull String id;
	public int healthPoint;
	public int damagePoint;
	public int defensePoint;
	
	public CmdUnitIntroduce(@NonNull String id, int healthPoint,
			int damagePoint, int defensePoint) {
		super();
		this.id = id;
		this.healthPoint = healthPoint;
		this.damagePoint = damagePoint;
		this.defensePoint = defensePoint;
	}

	@Override
	public String toString() {
		return "CmdUnitIntroduce [id=" + id + ", healthPoint=" + healthPoint
				+ ", damagePoint=" + damagePoint + ", defensePoint="
				+ defensePoint + "]";
	}

}
