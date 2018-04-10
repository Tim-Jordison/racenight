import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'images/custom', file: 'tcr_favicon_85x85.png'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(6)
invokeTag('set','g',15,['var':("EVENTUUID"),'value':(pageProperty(name: 'page.EVENTUUID'))],-1)
printHtmlPart(1)
invokeTag('require','r',16,['modules':("base")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',18,[:],-1)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(resource(dir:'images/custom', file:"triple_crown_racing_logo_741x101.png"))
printHtmlPart(10)
})
invokeTag('link','g',24,['url':("/")],2)
printHtmlPart(1)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',25,['class':("button menu-item"),'controller':("events"),'action':("list")],2)
printHtmlPart(1)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',26,['class':("button menu-item"),'controller':("events"),'action':("create")],2)
printHtmlPart(13)
if(true && (EVENTUUID)) {
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',34,['controller':("events"),'action':("index")],3)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',37,['controller':("ticket"),'action':("list")],3)
printHtmlPart(16)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',40,['controller':("ticket"),'action':("create")],3)
printHtmlPart(16)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',43,['controller':("ticket"),'action':("enterTicket")],3)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('layoutBody','g',51,[:],-1)
printHtmlPart(22)
invokeTag('message','g',54,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(23)
invokeTag('layoutResources','r',55,[:],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448349674000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 8, 9, 9, 10, 10, 10, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 14, 14, 15, 16, 16, 17, 17, 18, 18, 19, 19, 19, 20, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 28, 28, 34, 34, 34, 37, 37, 37, 40, 40, 40, 43, 43, 43, 47, 47, 51, 51, 54, 54, 55, 55, 61, 61, 61, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "main.gsp"
)
class ___LineNumberPlaceholder { }
