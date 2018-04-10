import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_includes_oddsTable_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/includes/_oddsTable.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(now)
printHtmlPart(1)
for( horse in (horses) ) {
printHtmlPart(2)
expressionOut.print(horse.number)
printHtmlPart(3)
expressionOut.print(horse.name)
printHtmlPart(4)
expressionOut.print(totalBetCount)
printHtmlPart(5)
expressionOut.print(horse.numberOfBets)
printHtmlPart(4)
invokeTag('displayDollarsRounderDownToQuarterFromCents','racenight',15,['cents':(prizePoolInCents / (horse.numberOfBets ?: 1))],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448678545000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 11, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 18, 18, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "_oddsTable.gsp"
)
class ___LineNumberPlaceholder { }
