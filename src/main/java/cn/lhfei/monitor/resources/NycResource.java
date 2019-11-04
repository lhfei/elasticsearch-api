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
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cn.lhfei.monitor.model.YellowTripdata;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 *         Created on Oct 22, 2019
 */
@RestController
@RequestMapping("/")
public class NycResource extends BaseResouce {
	private static final Gson gson = new Gson();

	@RequestMapping(value = "/yellow_tripdata", method = { RequestMethod.GET })
	public List<YellowTripdata> search() throws IOException {
		List<YellowTripdata> result = new ArrayList<>();
		RestHighLevelClient client = null;
		SearchResponse searchResponse = null;
		try {
			client = buildClient();
			
			SearchRequest searchRequest = new SearchRequest("yellow_tripdata"); 
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
			searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
			searchRequest.source(searchSourceBuilder);
			
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			
			searchResponse.getHits().forEach(searchHit -> {
				result.add(gson.fromJson(searchHit.getSourceAsString(), YellowTripdata.class));
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}

		return result;
	}
}
