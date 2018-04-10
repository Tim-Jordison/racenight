import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_includes_race_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/includes/_race.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(race.id)
printHtmlPart(1)
for( horse in (horses) ) {
printHtmlPart(2)
invokeTag('render','g',20,['template':("/includes/horse"),'model':([horse: horse, race: race])],-1)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (race.finished)) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444878966000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [29, 29, 29, 29, 29, 29, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 14, 14, 20, 20, 20, 20, 22, 22, 24, 25, 25, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29],
	sourceName = "_race.gsp"
)
class ___LineNumberPlaceholder { }
