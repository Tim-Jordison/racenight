import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_includes_horse_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/includes/_horse.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(horse.number)
printHtmlPart(1)
expressionOut.print(com.enums.ChangeableNameDomainClassEnum.HORSE)
printHtmlPart(2)
expressionOut.print(horse.id)
printHtmlPart(3)
expressionOut.print(horse.name)
printHtmlPart(4)
if(true && (race.finished)) {
printHtmlPart(5)
expressionOut.print(horse.placement ?: "dnf")
printHtmlPart(6)
}
else {
printHtmlPart(7)
expressionOut.print(horse.id)
printHtmlPart(8)
expressionOut.print(horse.placement ?: "not set")
printHtmlPart(9)
expressionOut.print(horse.id)
printHtmlPart(10)
expressionOut.print(horse.name)
printHtmlPart(11)
expressionOut.print(horse.id)
printHtmlPart(12)
expressionOut.print(horse.placement ? "hidden" : "")
printHtmlPart(13)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444879052000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 5, 5, 5, 5, 5, 5, 7, 7, 8, 8, 9, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "_horse.gsp"
)
class ___LineNumberPlaceholder { }
