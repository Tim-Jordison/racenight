import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_includes_raceStub_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/includes/_raceStub.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(raceBean.race.finished ? "finished" : "")
printHtmlPart(1)
expressionOut.print(raceBean.race.id)
printHtmlPart(2)
createTagBody(1, {->
expressionOut.print(raceBean.race.name)
})
invokeTag('link','g',3,['class':("text-link"),'controller':("race"),'action':("index"),'id':(raceBean.race.id)],1)
printHtmlPart(3)
expressionOut.print(raceBean.race.id)
printHtmlPart(4)
expressionOut.print(raceBean.race.id)
printHtmlPart(5)
expressionOut.print(raceBean.horseCount)
printHtmlPart(6)
if(true && (raceBean.race.finished)) {
printHtmlPart(7)
expressionOut.print(raceBean.horsesPlacements)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444710107000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 6, 6, 8, 8, 9, 10, 10, 11, 11, 13, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
	sourceName = "_raceStub.gsp"
)
class ___LineNumberPlaceholder { }
