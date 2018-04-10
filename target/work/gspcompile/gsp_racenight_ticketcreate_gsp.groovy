import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_ticketcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ticket/create.gsp" }
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
expressionOut.print(ticketUUID)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
for( raceBean in (raceBeans) ) {
printHtmlPart(7)
expressionOut.print(raceBean.race.name)
printHtmlPart(8)
for( horse in (raceBean.horses) ) {
printHtmlPart(9)
expressionOut.print(raceBean.race.id)
printHtmlPart(10)
expressionOut.print(horse.id)
printHtmlPart(11)
expressionOut.print(horse.name)
printHtmlPart(12)
expressionOut.print(horse.number)
printHtmlPart(13)
expressionOut.print(raceBean.race.name)
printHtmlPart(14)
expressionOut.print(horse.number)
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (raceBeans.size() == 0)) {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(raceBeans.size() == 0 ? "hidden" : "")
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',53,['action':("confirm"),'params':([ticketUUID: ticketUUID]),'class':("button create-ticket"),'onclick':("printDiv('printableArea')")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1447823122000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7, 9, 9, 11, 11, 13, 22, 22, 22, 22, 24, 24, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 29, 30, 30, 30, 33, 33, 35, 35, 53, 53, 53, 70, 70, 70, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "create.gsp"
)
class ___LineNumberPlaceholder { }
