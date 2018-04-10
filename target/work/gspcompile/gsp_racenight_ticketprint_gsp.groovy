import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_ticketprint_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ticket/print.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',9,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('require','r',11,['modules':("printSources")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'print.css'))
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(event.name)
printHtmlPart(6)
expressionOut.print(ticket.dateActivated.format("yyyy-MM-dd HH:mm:ss"))
printHtmlPart(7)
for( bet in (bets) ) {
printHtmlPart(8)
expressionOut.print(bet.horse.name)
printHtmlPart(9)
expressionOut.print(bet.horse.number)
printHtmlPart(10)
expressionOut.print(bet.numberOfBets)
printHtmlPart(11)
invokeTag('displayDollarsAndCentsFromCents','racenight',41,['cents':(bet.costInCents)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(bets*.numberOfBets.sum())
printHtmlPart(14)
invokeTag('displayDollarsAndCentsFromCents','racenight',48,['cents':(event.betPriceInCents)],-1)
printHtmlPart(15)
invokeTag('displayDollarsAndCentsFromCents','racenight',48,['cents':(ticket.priceInCents)],-1)
printHtmlPart(16)
expressionOut.print(ticket.uuid)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1447822162000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [53, 53, 53, 53, 53, 53, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 8, 8, 9, 10, 10, 11, 11, 11, 11, 12, 13, 13, 13, 19, 19, 19, 19, 19, 21, 33, 33, 35, 36, 37, 38, 38, 39, 41, 41, 42, 42, 42, 44, 48, 48, 48, 48, 49, 49, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53],
	sourceName = "print.gsp"
)
class ___LineNumberPlaceholder { }
