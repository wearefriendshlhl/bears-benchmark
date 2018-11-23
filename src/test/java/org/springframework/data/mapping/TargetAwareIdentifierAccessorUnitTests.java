/*
 * Copyright 2017-2018 the original author or authors.
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
package org.springframework.data.mapping;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * Unit tests for {@link TargetAwareIdentifierAccessor}.
 *
 * @author Oliver Gierke
 * @author Mark Paluch
 * @soundtrack Anika Nilles - Greenfield (Pikalar)
 */
public class TargetAwareIdentifierAccessorUnitTests {

	@Test // DATACMNS-1015
	public void throwsExceptionContainingInformationAboutTargetIfIdentifierAbsent() {

		Object sample = new Object();

		IdentifierAccessor accessor = new TargetAwareIdentifierAccessor(sample) {

			@Override
			public Object getIdentifier() {
				return null;
			}
		};

		assertThatExceptionOfType(IllegalStateException.class)//
				.isThrownBy(accessor::getRequiredIdentifier)//
				.withMessageContaining(sample.toString());
	}
}
