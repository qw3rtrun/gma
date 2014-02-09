package com.github.qw3rtrun.gma.test;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.github.qw3rtrun.gma.core.SingleContext;

public class UnitAggregate extends AbstractAnnotatedAggregateRoot<String> implements SingleContext<Unit> {

	private static final long serialVersionUID = 2530134482647458407L;

	@AggregateIdentifier
	private String id;

	private int healthPoint;

	private int attackDamage;

	private int defensePoint;

	public UnitAggregate() {
		super();
	}

	public UnitAggregate(String id, int healthPoint, int attackDamage, int defense) {
		super();
		this.id = id;
		this.healthPoint = healthPoint;
		this.attackDamage = attackDamage;
		this.defensePoint = defense;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getDefense() {
		return defensePoint;
	}

	public void setDefense(int defense) {
		this.defensePoint = defense;
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
		UnitAggregate other = (UnitAggregate) obj;
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
				+ ", attackDamage=" + attackDamage + ", defense=" + defensePoint
				+ "]";
	}

	@Override
	public Unit get() {
		return new Unit.Context(id, healthPoint, attackDamage, defensePoint); 
	}
	
}
