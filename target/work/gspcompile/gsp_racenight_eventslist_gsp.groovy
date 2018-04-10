import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_eventslist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/events/list.gsp" }
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
printHtmlPart(2)
invokeTag('require','r',12,['modules':("table")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('sortableColumn','g',20,['property':("name"),'title':("Name")],-1)
printHtmlPart(6)
invokeTag('sortableColumn','g',22,['property':("payoutRate"),'title':("Payout Rate")],-1)
printHtmlPart(6)
invokeTag('sortableColumn','g',23,['property':("betPriceInDollarsAndCents"),'title':("Bet Price")],-1)
printHtmlPart(6)
invokeTag('sortableColumn','g',24,['property':("dateCreated"),'title':("Date Created")],-1)
printHtmlPart(7)
loop:{
int i = 0
for( event in (events) ) {
printHtmlPart(8)
expressionOut.print(i % 2 == 0 ? "alt" : "")
printHtmlPart(9)
createTagBody(3, {->
expressionOut.print(event.name)
})
invokeTag('link','g',31,['action':("loginToEvent"),'params':([name: event.name])],3)
printHtmlPart(10)
expressionOut.print(event.payoutRate)
printHtmlPart(10)
expressionOut.print(event.betPriceInCents)
printHtmlPart(10)
expressionOut.print(event.dateCreated)
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',35,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444790179000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [36, 36, 36, 36, 36, 36, 1, 1, 1, 1, 1, 1, 1, 2, 4, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 20, 20, 20, 22, 22, 23, 23, 24, 24, 24, 27, 27, 27, 27, 28, 29, 30, 30, 31, 31, 31, 31, 31, 31, 32, 32, 33, 33, 33, 33, 33, 35, 35, 35, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36],
	sourceName = "list.gsp"
)
class ___LineNumberPlaceholder { }
