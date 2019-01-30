package com.liferay.commerce.kris.renderer;


import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.content.render.list.entry.CPContentListEntryRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kpatefield
 */
@Component(
	immediate = true,
	property = {
			"commerce.product.content.list.entry.renderer.key=" + ClassicElectricSearchResultCPContentListEntryRenderer.KEY,
			"commerce.product.content.list.entry.renderer.order=1000",
			"commerce.product.content.list.entry.renderer.portlet.name=" + CPPortletKeys.CP_PUBLISHER_WEB,
			"commerce.product.content.list.entry.renderer.portlet.name=" + CPPortletKeys.CP_SEARCH_RESULTS,
			"commerce.product.content.list.entry.renderer.type=grouped",
			"commerce.product.content.list.entry.renderer.type=simple",
			"commerce.product.content.list.entry.renderer.type=virtual"
	},
	service = CPContentListEntryRenderer.class
)
public class ClassicElectricSearchResultCPContentListEntryRenderer implements CPContentListEntryRenderer {

	public static final String KEY = "search-result-classic";

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getLabel(Locale locale) {
		return "Search Results - Classic Electric";
	}

	@Override
	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/render/list_entry/search_result_classic.jsp");
	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.commerce.kris.renderer)"
	)
	private ServletContext _servletContext;

}