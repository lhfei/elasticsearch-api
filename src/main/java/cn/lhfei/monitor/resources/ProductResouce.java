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

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cn.lhfei.monitor.model.Product;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 23, 2019
 */
@RestController
@RequestMapping("/")
public class ProductResouce extends BaseResource {
	private static final Gson gson = new Gson();
	private static final String INDEX_NAME = "products";
	
	@RequestMapping(value = "/product", method = { RequestMethod.POST })
	public IndexResponse create(@RequestBody Product product) throws IOException {
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME)
			    .source(gson.toJson(product), XContentType.JSON);
		
		IndexResponse idxResponse = client.index(indexRequest, RequestOptions.DEFAULT);
		
		return idxResponse;
	}
	
	@RequestMapping(value = "/product/{id:\\w{6,}}", method = { RequestMethod.GET })
	public Map<String, Object> get(@PathVariable(name = "id") String id) throws IOException {
		
		GetRequest getRequest = new GetRequest(INDEX_NAME, id);
		
		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
		
		return getResponse.getSource();
	}
}
