/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.ecs.transform.v20140526;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse.PriceInfo;
import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse.PriceInfo.Price;
import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse.PriceInfo.Price.ResourcePriceModel;
import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse.PriceInfo.Price.ResourcePriceModel.Rule1;
import com.aliyuncs.ecs.model.v20140526.DescribeRenewalPriceResponse.PriceInfo.Rule;
import com.aliyuncs.transform.UnmarshallerContext;


public class DescribeRenewalPriceResponseUnmarshaller {

	public static DescribeRenewalPriceResponse unmarshall(DescribeRenewalPriceResponse describeRenewalPriceResponse, UnmarshallerContext context) {
		
		describeRenewalPriceResponse.setRequestId(context.stringValue("DescribeRenewalPriceResponse.RequestId"));

		PriceInfo priceInfo = new PriceInfo();

		Price price = new Price();
		price.setOriginalPrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.OriginalPrice"));
		price.setDiscountPrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.DiscountPrice"));
		price.setTradePrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.TradePrice"));
		price.setCurrency(context.stringValue("DescribeRenewalPriceResponse.PriceInfo.Price.Currency"));

		List<ResourcePriceModel> detailInfos = new ArrayList<ResourcePriceModel>();
		for (int i = 0; i < context.lengthValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos.Length"); i++) {
			ResourcePriceModel resourcePriceModel = new ResourcePriceModel();
			resourcePriceModel.setResource(context.stringValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].Resource"));
			resourcePriceModel.setOriginalPrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].OriginalPrice"));
			resourcePriceModel.setDiscountPrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].DiscountPrice"));
			resourcePriceModel.setTradePrice(context.floatValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].TradePrice"));

			List<Rule1> subRules = new ArrayList<Rule1>();
			for (int j = 0; j < context.lengthValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].SubRules.Length"); j++) {
				Rule1 rule1 = new Rule1();
				rule1.setRuleId(context.longValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].SubRules["+ j +"].RuleId"));
				rule1.setDescription(context.stringValue("DescribeRenewalPriceResponse.PriceInfo.Price.DetailInfos["+ i +"].SubRules["+ j +"].Description"));

				subRules.add(rule1);
			}
			resourcePriceModel.setSubRules(subRules);

			detailInfos.add(resourcePriceModel);
		}
		price.setDetailInfos(detailInfos);
		priceInfo.setPrice(price);

		List<Rule> rules = new ArrayList<Rule>();
		for (int i = 0; i < context.lengthValue("DescribeRenewalPriceResponse.PriceInfo.Rules.Length"); i++) {
			Rule rule = new Rule();
			rule.setRuleId(context.longValue("DescribeRenewalPriceResponse.PriceInfo.Rules["+ i +"].RuleId"));
			rule.setDescription(context.stringValue("DescribeRenewalPriceResponse.PriceInfo.Rules["+ i +"].Description"));

			rules.add(rule);
		}
		priceInfo.setRules(rules);
		describeRenewalPriceResponse.setPriceInfo(priceInfo);
	 
	 	return describeRenewalPriceResponse;
	}
}