/*
 * Copyright 2011-2018 the original author or authors.
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
package io.lettuce.core.output;

import java.nio.ByteBuffer;

import io.lettuce.core.codec.RedisCodec;

/**
 * Boolean output. The actual value is returned as an integer where 0 indicates false and 1 indicates true, or as a null bulk
 * reply for script output.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Will Glozer
 * @author Mark Paluch
 */
public class BooleanOutput<K, V> extends CommandOutput<K, V, Boolean> {

    public BooleanOutput(RedisCodec<K, V> codec) {
        super(codec, null);
    }

    @Override
    public void set(long integer) {
        output = (integer == 1) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void set(ByteBuffer bytes) {
        output = (bytes != null) ? Boolean.TRUE : Boolean.FALSE;
    }
}
