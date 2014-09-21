import geb.spock.GebReportingSpec

class MySpec extends GebReportingSpec {

    def "can search an item number"() {
        when:
        to LoginPage

        and: 
        interact {
            loginForm.j_username = "xxx"
            loginForm.j_password = "xxx"
            loginButton.click()
        }

        then: 
        at HomePage

        when: 
        searchLinks.find("a", text:"Bill of Materials").click()

        then:
        at SearchPage

        when: 	
        itemNumber = "SHN9663B"
        region.find("option", text:"Bom Source MotoPDM").click()
        searchButton.click()

        then:
        at ResultPage

        when:
        searchResults.find("a", text:"SHN9663B") << org.openqa.selenium.Keys.ENTER
        //searchResults.find("a", text:"SHN9663B").click()

        then:
        at BomInfoPage
        $("a", text:"Flat BOM").size() == 1	
 
        when:
        $("a", text:"Flat BOM").click()

        then:
        at BomInfoPage
        $("span", text:"Flat BOM").size() == 1		
        $("div", text:"0387347Y01").size() == 1 
    }
}