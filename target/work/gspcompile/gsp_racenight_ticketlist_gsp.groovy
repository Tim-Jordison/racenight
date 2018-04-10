import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_ticketlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ticket/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('parameter','sitemesh',6,['name':("EVENTUUID"),'value':(event.uuid)],-1)
printHtmlPart(1)
invokeTag('require','r',7,['modules':("ticket")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('displayDollarsAndCentsFromCents','racenight',14,['cents':(totalValue)],-1)
printHtmlPart(6)
invokeTag('displayDollarsAndCentsFromCents','racenight',15,['cents':(totalPaidOut)],-1)
printHtmlPart(7)
expressionOut.print(ticketsPaidOut)
printHtmlPart(8)
invokeTag('displayDollarsAndCentsFromCents','racenight',16,['cents':(totalValue - totalPaidOut)],-1)
printHtmlPart(7)
expressionOut.print(tickets.size() - ticketsPaidOut)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',18,['action':("create"),'class':("button add-ticket")],2)
printHtmlPart(11)
invokeTag('sortableColumn','g',27,['property':("priceInCents"),'action':("list"),'title':("Price")],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("dateActivated"),'action':("list"),'title':("Activated")],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',29,['property':("cashedIn"),'action':("list"),'title':("Status")],-1)
printHtmlPart(13)
for( ticket in (tickets) ) {
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(ticket.uuid)
})
invokeTag('link','g',35,['action':("index"),'id':(ticket.id)],3)
printHtmlPart(15)
invokeTag('displayDollarsAndCentsFromCents','racenight',36,['cents':(ticket.priceInCents)],-1)
printHtmlPart(16)
invokeTag('dateAndTime','racenight',37,['date':(ticket.dateActivated)],-1)
printHtmlPart(17)
if(true && (ticket.cashedIn)) {
printHtmlPart(18)
invokeTag('dateAndTime','racenight',40,['date':(ticket.dateCashedIn)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448603709000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [53, 53, 53, 53, 53, 53, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 7, 7, 8, 8, 8, 10, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 18, 18, 18, 27, 28, 28, 29, 29, 29, 33, 33, 35, 35, 35, 35, 35, 36, 36, 37, 37, 39, 40, 40, 40, 40, 41, 41, 43, 43, 45, 46, 49, 49, 51, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53],
	sourceName = "list.gsp"
)
class ___LineNumberPlaceholder { }
