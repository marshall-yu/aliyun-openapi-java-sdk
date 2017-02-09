/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.aliyuncs.green.model.v20161206;

import com.aliyuncs.RpcAcsRequest;
import java.util.List;
import com.aliyuncs.http.MethodType;

/**
 * @author auto create
 * @version 
 */
public class TextAntispamDetectionRequest extends RpcAcsRequest<TextAntispamDetectionResponse> {
	
	public TextAntispamDetectionRequest() {
		super("Green", "2016-12-06", "TextAntispamDetection", "green");
		setMethod(MethodType.POST);
	}

	private String dataItems;

	private List<String> customDicts;

	public String getDataItems() {
		return this.dataItems;
	}

	public void setDataItems(String dataItems) {
		this.dataItems = dataItems;
		putQueryParameter("DataItems", dataItems);
	}

	public List<String> getCustomDicts() {
		return this.customDicts;
	}

	public void setCustomDicts(List<String> customDicts) {
		this.customDicts = customDicts;	
		for (int i = 0; i < customDicts.size(); i++) {
			putQueryParameter("CustomDict." + (i + 1) , customDicts.get(i));
		}	
	}

	@Override
	public Class<TextAntispamDetectionResponse> getResponseClass() {
		return TextAntispamDetectionResponse.class;
	}

}