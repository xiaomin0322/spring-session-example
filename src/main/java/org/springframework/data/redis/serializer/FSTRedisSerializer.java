/*
 * Copyright 2011-2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.serializer;

import java.nio.charset.Charset;

import org.springframework.util.Assert;

import ser.JRedisSerializationUtils;

/**
 * Simple String to byte[] (and back) serializer. Converts Strings into bytes and vice-versa using the specified charset
 * (by default UTF-8).
 * <p/>
 * Useful when the interaction with the Redis happens mainly through Strings.
 * <p/>
 * Does not perform any null conversion since empty strings are valid keys/values.
 * 
 * @author Costin Leau
 * @param <T>
 */
public class FSTRedisSerializer<T> implements RedisSerializer<T> {


	public FSTRedisSerializer() {
	}

	public T deserialize(byte[] bytes) {
		return (T)JRedisSerializationUtils.unserialize(bytes);
	}

	public byte[] serialize(Object obj) {
		return JRedisSerializationUtils.serialize(obj);
	}
}
