package io.scvis.proto;

import java.util.HashMap;
import java.util.Map;

public class HashTable<R, C, V> implements Table<R, C, V> {

	private final Map<R, Map<C, V>> fields = new HashMap<>();

	private Map<C, V> getColumn(R row) {
		return fields.computeIfAbsent(row, r -> new HashMap<>());
	}

	@Override
	public V get(R row, C column) {
		return getColumn(row).get(column);
	}

	@Override
	public V set(R row, C column, V value) {
		return getColumn(row).put(column, value);
	}
}