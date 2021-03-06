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
package org.codelabor.system.web.filter;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인코딩 필터
 * 
 * @author Shin Sang-jae
 * 
 */
public class EncodingFilter extends BaseFilterImpl {
	/**
	 * 인코딩 기본값은 UTF-8을 사용한다.
	 */
	protected String encoding = "UTF-8";
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(EncodingFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#init(javax.servlet.FilterConfig
	 * )
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		String tempEncoding = filterConfig.getInitParameter("encoding");
		if (!StringUtils.isEmpty(tempEncoding)) {
			encoding = tempEncoding;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#postprocessFilterChain(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#preprocessFilterChain(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		String requestBeforeEncoding = request.getCharacterEncoding();
		String responseBeforeEncoding = response.getCharacterEncoding();

		if (encoding.equalsIgnoreCase(requestBeforeEncoding)) {
			logger.debug("request character encoding: {}", encoding);
		} else {
			request.setCharacterEncoding(encoding);
			String requestAfterEncoding = request.getCharacterEncoding();
			logger.debug("request character encoding: {} -> {}",
					requestBeforeEncoding, requestAfterEncoding);
		}
		if (encoding.equalsIgnoreCase(responseBeforeEncoding)) {
			logger.debug("response character encoding: {}", encoding);
		} else {
			response.setCharacterEncoding(encoding);
			String responseAfterCharacterEncoding = response
					.getCharacterEncoding();
			logger.debug("response character encoding: {} -> {}",
					responseBeforeEncoding, responseAfterCharacterEncoding);
		}
	}
}
