/*
 * Copyright 2010-2011 the original author or authors.
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

package cn.lhfei.monitor.resources;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 23, 2019
 */

public abstract class BaseResource {
	protected Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private ThreadLocal<RestHighLevelClient> clientThread = new ThreadLocal<RestHighLevelClient>() {
		RestHighLevelClient client = null;
		
		@Override
		protected RestHighLevelClient initialValue() {
			client = new RestHighLevelClient(RestClient.builder(
					new HttpHost("192.168.133.144", 9200, "http"),
					new HttpHost("192.168.133.154", 9200, "http"), 
					new HttpHost("192.168.133.163", 9200, "http"),
					new HttpHost("192.168.133.171", 9200, "http"), 
					new HttpHost("192.168.134.158", 9200, "http"),
					new HttpHost("192.168.134.206", 9200, "http"), 
					new HttpHost("192.168.134.221", 9200, "http")));
			return client;
		}

	};

	protected RestHighLevelClient buildClient() {
		return clientThread.get();
	}
	
	 @Autowired
	 protected RestHighLevelClient client;
}
