//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.0 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2025.12.25 à 11:47:06 PM GMT 
//


package mr.supnum.middleservice.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mr.supnum.middleservice.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListServersRequest_QNAME = new QName("http://supnum.com/server", "listServersRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mr.supnum.middleservice.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateServerRequest }
     * 
     */
    public CreateServerRequest createCreateServerRequest() {
        return new CreateServerRequest();
    }

    /**
     * Create an instance of {@link CreateServerResponse }
     * 
     */
    public CreateServerResponse createCreateServerResponse() {
        return new CreateServerResponse();
    }

    /**
     * Create an instance of {@link Server }
     * 
     */
    public Server createServer() {
        return new Server();
    }

    /**
     * Create an instance of {@link ListServersResponse }
     * 
     */
    public ListServersResponse createListServersResponse() {
        return new ListServersResponse();
    }

    /**
     * Create an instance of {@link GetServerStatusRequest }
     * 
     */
    public GetServerStatusRequest createGetServerStatusRequest() {
        return new GetServerStatusRequest();
    }

    /**
     * Create an instance of {@link GetServerStatusResponse }
     * 
     */
    public GetServerStatusResponse createGetServerStatusResponse() {
        return new GetServerStatusResponse();
    }

    /**
     * Create an instance of {@link StartServerRequest }
     * 
     */
    public StartServerRequest createStartServerRequest() {
        return new StartServerRequest();
    }

    /**
     * Create an instance of {@link StartServerResponse }
     * 
     */
    public StartServerResponse createStartServerResponse() {
        return new StartServerResponse();
    }

    /**
     * Create an instance of {@link StopServerRequest }
     * 
     */
    public StopServerRequest createStopServerRequest() {
        return new StopServerRequest();
    }

    /**
     * Create an instance of {@link StopServerResponse }
     * 
     */
    public StopServerResponse createStopServerResponse() {
        return new StopServerResponse();
    }

    /**
     * Create an instance of {@link RenameServerRequest }
     * 
     */
    public RenameServerRequest createRenameServerRequest() {
        return new RenameServerRequest();
    }

    /**
     * Create an instance of {@link RenameServerResponse }
     * 
     */
    public RenameServerResponse createRenameServerResponse() {
        return new RenameServerResponse();
    }

    /**
     * Create an instance of {@link DeleteServerRequest }
     * 
     */
    public DeleteServerRequest createDeleteServerRequest() {
        return new DeleteServerRequest();
    }

    /**
     * Create an instance of {@link DeleteServerResponse }
     * 
     */
    public DeleteServerResponse createDeleteServerResponse() {
        return new DeleteServerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://supnum.com/server", name = "listServersRequest")
    public JAXBElement<Object> createListServersRequest(Object value) {
        return new JAXBElement<Object>(_ListServersRequest_QNAME, Object.class, null, value);
    }

}
