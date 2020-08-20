/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.spring.namespace.factorybean;

import org.apache.shardingsphere.spring.namespace.fixture.ShardingSphereFixtureAlgorithm;
import org.apache.shardingsphere.spring.namespace.fixture.ShardingSphereFixtureAlgorithmImpl;
import org.apache.shardingsphere.spring.namespace.fixture.factorybean.ShardingSphereAlgorithmFixtureFactoryBean;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class ShardingSphereAlgorithmFactoryBeanTest {
    
    @Test
    public void assertGetObject() {
        Properties props = new Properties();
        props.setProperty("fixture.value", "foo");
        ShardingSphereAlgorithmFactoryBean<ShardingSphereFixtureAlgorithm> factoryBean = new ShardingSphereAlgorithmFixtureFactoryBean("FIXTURE", props);
        ShardingSphereFixtureAlgorithmImpl actual = (ShardingSphereFixtureAlgorithmImpl) factoryBean.getObject();
        assertThat(actual.getValue(), is("foo"));
    }
    
    @Test
    public void assertIsSingleton() {
        assertTrue(new ShardingSphereAlgorithmFixtureFactoryBean("FIXTURE", new Properties()).isSingleton());
    }
}
