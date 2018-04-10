import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_raceindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/race/index.gsp" }
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
invokeTag('require','r',12,['modules':("races")],-1)
printHtmlPart(2)
invokeTag('parameter','sitemesh',13,['name':("EVENTUUID"),'value':(event.uuid)],-1)
printHtmlPart(4)
expressionOut.print(race.id)
printHtmlPart(5)
expressionOut.print(placedHorses)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(com.enums.ChangeableNameDomainClassEnum.RACE)
printHtmlPart(8)
expressionOut.print(race.id)
printHtmlPart(9)
expressionOut.print(race.name)
printHtmlPart(10)
invokeTag('displayDollarsAndCentsFromCents','racenight',24,['cents':(betsInCents)],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',28,['class':("button"),'action':("displayOdds"),'id':(race.id)],2)
printHtmlPart(2)
invokeTag('render','g',30,['template':("../includes/race"),'model':([race: race, horses: horses])],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',30,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448350018000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [31, 31, 31, 31, 31, 31, 1, 1, 1, 1, 1, 1, 1, 2, 4, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 16, 16, 17, 22, 22, 22, 24, 24, 24, 24, 24, 24, 24, 28, 28, 30, 30, 30, 30, 30, 30, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31],
	sourceName = "index.gsp"
)
class ___LineNumberPlaceholder { }
