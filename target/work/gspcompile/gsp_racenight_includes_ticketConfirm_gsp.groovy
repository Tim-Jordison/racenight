import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_includes_ticketConfirm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/includes/_ticketConfirm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (ticket.active)) {
printHtmlPart(1)
invokeTag('dateAndTime','racenight',4,['date':(ticket.dateActivated)],-1)
printHtmlPart(2)
if(true && (ticket.cashedIn)) {
printHtmlPart(3)
invokeTag('dateAndTime','racenight',6,['date':(ticket.dateCashedIn)],-1)
printHtmlPart(4)
invokeTag('displayDollarsAndCentsFromCents','racenight',7,['cents':(ticket.payoutInCents)],-1)
printHtmlPart(2)
}
else {
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',10,['class':("button add-ticket"),'action':("cashIn"),'params':([ticketUUID: ticket.uuid])],3)
printHtmlPart(7)
}
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(ticket.uuid)
printHtmlPart(11)
if(true && (ticket.cashedIn)) {
printHtmlPart(12)
}
printHtmlPart(13)
for( bet in (bets) ) {
printHtmlPart(14)
expressionOut.print(bet.description)
printHtmlPart(15)
expressionOut.print(bet.numberOfBets)
printHtmlPart(15)
invokeTag('displayDollarsAndCentsFromCents','racenight',36,['cents':(bet.costInCents)],-1)
printHtmlPart(16)
if(true && (ticket.cashedIn)) {
printHtmlPart(17)
invokeTag('displayDollarsAndCentsFromCents','racenight',38,['cents':(bet.payoutInCents)],-1)
printHtmlPart(16)
}
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(totalBets)
printHtmlPart(20)
invokeTag('displayDollarsAndCentsFromCents','racenight',46,['cents':(ticket.priceInCents)],-1)
printHtmlPart(21)
if(true && (ticket.cashedIn)) {
printHtmlPart(22)
invokeTag('displayDollarsAndCentsFromCents','racenight',49,['cents':(ticket.payoutInCents)],-1)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('render','g',57,['template':("/ticket/print"),'model':([ticket: ticket, bets: bets, event: event])],-1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1447823014000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 15, 15, 16, 16, 26, 26, 28, 28, 32, 32, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 42, 42, 45, 45, 46, 46, 47, 47, 49, 49, 51, 51, 57, 57, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "_ticketConfirm.gsp"
)
class ___LineNumberPlaceholder { }
