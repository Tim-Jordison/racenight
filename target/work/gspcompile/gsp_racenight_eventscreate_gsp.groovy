import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_eventscreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/events/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (error)) {
printHtmlPart(6)
}
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('field','g',20,['type':("string"),'name':("name"),'placeholder':("Event Name")],-1)
printHtmlPart(2)
invokeTag('field','g',21,['type':("password"),'name':("password"),'placeholder':("Password")],-1)
printHtmlPart(2)
invokeTag('field','g',22,['type':("decimal"),'name':("payoutRate"),'placeholder':("Payout Rate")],-1)
printHtmlPart(2)
invokeTag('field','g',24,['type':("decimal"),'name':("betPriceInDollarsAndCents"),'placeholder':("Ticket Price")],-1)
printHtmlPart(2)
invokeTag('submitButton','g',24,['name':("login"),'value':("Create Event"),'class':("button blue")],-1)
printHtmlPart(4)
})
invokeTag('form','g',24,['controller':("events"),'action':("save")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',25,[:],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444786666000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [25, 25, 25, 25, 25, 25, 1, 1, 1, 1, 1, 1, 1, 2, 4, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 16, 18, 20, 20, 20, 21, 21, 22, 22, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25],
	sourceName = "create.gsp"
)
class ___LineNumberPlaceholder { }
