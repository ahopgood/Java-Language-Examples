import org.junit.jupiter.api.Test;

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

        assertThat(oldDocumentBuilder.getDOMImplementation())
                .isEqualTo(oldDocumentBuilder.getDOMImplementation());
        assertThat(oldDocumentBuilder.getSchema())
                .isEqualTo(oldDocumentBuilder.getSchema());

    }

}
