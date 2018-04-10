import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_racenight_racedisplayOdds_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/race/displayOdds.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(resource(dir: 'images/custom', file: 'tcr_favicon_85x85.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(7)
invokeTag('parameter','sitemesh',17,['name':("EVENTUUID"),'value':(event.uuid)],-1)
printHtmlPart(8)
expressionOut.print(race.id)
printHtmlPart(9)
expressionOut.print(updateInterval)
printHtmlPart(10)
invokeTag('require','r',21,['modules':("base, oddsTable, table, homescreen")],-1)
printHtmlPart(2)
invokeTag('layoutResources','r',22,[:],-1)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(race.s3ImageLocation)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(resource(dir:'images/custom', file:"triple_crown_racing_logo_741x101.png"))
printHtmlPart(15)
})
invokeTag('link','g',33,['url':("/")],2)
printHtmlPart(16)
expressionOut.print(race.name)
printHtmlPart(17)
invokeTag('displayDollarsAndCentsFromCents','racenight',35,['cents':(event.betPriceInCents)],-1)
printHtmlPart(18)
invokeTag('layoutResources','r',35,[:],-1)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',35,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448601282000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

@org.codehaus.groovy.grails.web.transform.LineNumber(
	lines = [37, 37, 37, 37, 37, 37, 1, 1, 1, 1, 1, 1, 1, 2, 4, 11, 11, 11, 12, 12, 12, 12, 12, 12, 13, 13, 14, 14, 14, 14, 15, 15, 16, 16, 17, 17, 17, 18, 18, 19, 19, 21, 22, 22, 23, 23, 23, 23, 29, 29, 29, 30, 31, 31, 31, 33, 33, 33, 33, 33, 33, 35, 35, 35, 35, 35, 35, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37],
	sourceName = "displayOdds.gsp"
)
class ___LineNumberPlaceholder { }
