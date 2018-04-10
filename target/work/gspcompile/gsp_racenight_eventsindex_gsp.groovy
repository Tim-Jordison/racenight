import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_eventsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/events/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('parameter','sitemesh',10,['name':("EVENTUUID"),'value':(event.uuid)],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
invokeTag('require','r',13,['modules':("event")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(event.name)
printHtmlPart(6)
expressionOut.print(event.payoutRate*100)
printHtmlPart(7)
expressionOut.print(event.betPriceInCents / 100)
printHtmlPart(8)
for( raceBean in (raceBeans) ) {
printHtmlPart(9)
invokeTag('render','g',28,['template':("../includes/raceStub"),'model':([raceBean: raceBean])],-1)
printHtmlPart(2)
}
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',29,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444889638000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [29, 29, 29, 29, 29, 29, 1, 1, 1, 1, 1, 1, 1, 2, 4, 10, 10, 10, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 15, 15, 15, 17, 19, 19, 20, 21, 25, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29],
	sourceName = "index.gsp"
)
class ___LineNumberPlaceholder { }
