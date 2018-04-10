import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_ticketcashIn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ticket/cashIn.gsp" }
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
invokeTag('parameter','sitemesh',12,['name':("EVENTUUID"),'value':(event.uuid)],-1)
printHtmlPart(2)
invokeTag('require','r',13,['modules':("ticket")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (ticket.cashedIn)) {
printHtmlPart(5)
}
else {
printHtmlPart(2)
if(true && (unfinishedRaces.size() == 0)) {
printHtmlPart(6)
invokeTag('displayDollarsAndCentsFromCents','racenight',23,['cents':(ticket.payoutInCents)],-1)
printHtmlPart(7)
for( bet in (bets) ) {
printHtmlPart(8)
expressionOut.print(bet.description)
printHtmlPart(9)
invokeTag('displayDollarsAndCentsFromCents','racenight',36,['cents':(bet.costInCents)],-1)
printHtmlPart(9)
invokeTag('displayDollarsAndCentsFromCents','racenight',37,['cents':(bet.payoutInCents)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('link','g',42,['action':("payout"),'class':("button"),'params':([ticketUUID: ticket.uuid]),'onclick':("return confirm('This will set the ticket as paid our for \$${ticket.payoutInCents/100}.')")],4)
printHtmlPart(2)
}
else {
printHtmlPart(13)
for( race in (unfinishedRaces) ) {
printHtmlPart(14)
expressionOut.print(race)
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(4)
}
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',48,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444893201000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [49, 49, 49, 49, 49, 49, 1, 1, 1, 1, 1, 1, 1, 2, 4, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 17, 18, 19, 19, 19, 23, 23, 30, 30, 33, 33, 36, 36, 37, 37, 37, 37, 42, 42, 42, 42, 42, 42, 45, 45, 46, 47, 47, 47, 47, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49],
	sourceName = "cashIn.gsp"
)
class ___LineNumberPlaceholder { }
