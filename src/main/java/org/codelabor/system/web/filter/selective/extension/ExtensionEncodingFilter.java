/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.web.filter.selective.extension;

import org.codelabor.system.web.filter.selective.SelectiveEncodingFilter;
import org.codelabor.system.web.util.URIPatternMatcherUtils;

/**
 * 확장자인식 인코딩 필터
 * 
 * @author Shin Sang-jae
 * 
 */
public class ExtensionEncodingFilter extends SelectiveEncodingFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#isFilterRequired(java.lang
	 * .String)
	 */
	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByExtension(includePatterns,
				excludePatterns, requestURI);
	}
}
