package com.github.qw3rtrun.gma.test;

import org.axonframework.repository.Repository;

import checkers.nullness.quals.NonNull;

public class UnitCroupier {

	private Repository<UnitCard> repo;

	public UnitCroupier(Repository<UnitCard> repo) {
		this.repo = repo;
	}

	public Unit introduceUnit(@NonNull String id, int healthPoint,
			int attackDamage, int defensePoint) {
		UnitCard u = new UnitCard(id, healthPoint, attackDamage,
				defensePoint);
		repo.add(u);
		return u.get();
	}
}
