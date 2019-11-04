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

package cn.lhfei.monitor.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 22, 2019
 */
@ApiModel(description = "Http Response body")
public class RestResponseModel implements Serializable {
	private static final long serialVersionUID = -7937053865105797752L;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static RestResponseModel success(String message, Object data) {
		RestResponseModel restMessgae = new RestResponseModel();
		restMessgae.setCode("200");
		restMessgae.setMessage(message);
		restMessgae.setData(data);
		return restMessgae;
	}

	public static RestResponseModel fail(String message, Object data) {
		RestResponseModel restMessgae = new RestResponseModel();
		restMessgae.setCode("500");
		restMessgae.setMessage(message);
		restMessgae.setData(data);
		return restMessgae;
	}

	@ApiModelProperty(value = "Http Response Message")
	private String message;
	@ApiModelProperty(value = "Http Status Code")
	private String code;
	@ApiModelProperty(value = "Response body")
	private Object data;
}
