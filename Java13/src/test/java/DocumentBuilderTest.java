import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.assertj.core.api.Assertions.assertThat;

public class DocumentBuilderTest {

    @Test
    void testNewFactoryInstance() throws ParserConfigurationException {
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder oldDocumentBuilder = dbf.newDocumentBuilder();

        RecursiveComparisonConfiguration conf = new RecursiveComparisonConfiguration();
        conf.ignoreFields("domParser");

        assertThat(newDocumentBuilder)
                .usingRecursiveComparison(conf)
                .isEqualTo(oldDocumentBuilder);
    }

}
