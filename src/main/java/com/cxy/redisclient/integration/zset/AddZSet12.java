package com.cxy.redisclient.integration.zset;

import java.util.Map;

import com.cxy.redisclient.domain.RedisVersion;

public class AddZSet12 extends AddZSet {

	public AddZSet12(int id, int db, String key, Map<String, Double> values) {
		super(id, db, key, values);
	}

	@Override
	public RedisVersion getVersion() {
		return RedisVersion.REDIS_1_2;
	}

	@Override
	protected void command() {
		super.command();
		for(Map.Entry<String, Double> value: values.entrySet())
			jedis.zadd(key, value.getValue(), value.getKey());
	}

}
