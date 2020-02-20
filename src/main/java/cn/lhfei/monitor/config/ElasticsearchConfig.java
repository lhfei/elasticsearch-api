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

package cn.lhfei.monitor.config;

import java.util.Objects;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.util.StringUtils;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 22, 2019
 */
@Configuration
public class ElasticsearchConfig {
    @Bean
    public RestClientBuilder restClientBuilder() {
      HttpHost[] hosts = indexConfig.getNodes().stream()
          .map(this::makeHttpHost)
          .filter(Objects::nonNull)
          .toArray(HttpHost[]::new);
      return RestClient.builder(hosts);
    }
    
	@Bean
	public RestHighLevelClient highLevelClient(RestClientBuilder restClientBuilder) {
		return new RestHighLevelClient(restClientBuilder);
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(highLevelClient(restClientBuilder()));
	}
	
	private HttpHost makeHttpHost(String host) {
		if(!StringUtils.isEmpty(host.trim())) {
			return new HttpHost(host.trim(), indexConfig.getPort(), indexConfig.getProtocol());
		}
		return null;
	}
	
	@Autowired
    private IndexConfig indexConfig;
}

