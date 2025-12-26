package mr.supnum.middleservice.service;

import mr.supnum.middleservice.wsdl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class SoapServerService {

	private final WebServiceTemplate webServiceTemplate;
	private final ObjectFactory objectFactory;

	@Value("${soap.server.url}")
	private String soapServerUrl;

	public SoapServerService(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
		this.objectFactory = new ObjectFactory();
	}

	public CreateServerResponse createServer(String name, String ipAddress, Boolean status) {
		try {
			CreateServerRequest request = objectFactory.createCreateServerRequest();
			request.setName(name);
			request.setIpAddress(ipAddress);
			// Le XSD n'inclut pas status dans createServerRequest

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (CreateServerResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP createServer: " + e.getMessage(), e);
		}
	}

	public ListServersResponse listServers() {
		try {
			jakarta.xml.bind.JAXBElement<Object> request = objectFactory.createListServersRequest(null);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (ListServersResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP listServers: " + e.getMessage(), e);
		}
	}

	public GetServerStatusResponse getServerStatus(Long serverId) {
		try {
			GetServerStatusRequest request = objectFactory.createGetServerStatusRequest();
			request.setId(serverId);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (GetServerStatusResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP getServerStatus: " + e.getMessage(), e);
		}
	}

	public StartServerResponse startServer(Long serverId) {
		try {
			StartServerRequest request = objectFactory.createStartServerRequest();
			request.setId(serverId);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (StartServerResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP startServer: " + e.getMessage(), e);
		}
	}

	public StopServerResponse stopServer(Long serverId) {
		try {
			StopServerRequest request = objectFactory.createStopServerRequest();
			request.setId(serverId);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (StopServerResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP stopServer: " + e.getMessage(), e);
		}
	}

	public RenameServerResponse renameServer(Long serverId, String newName) {
		try {
			RenameServerRequest request = objectFactory.createRenameServerRequest();
			request.setId(serverId);
			request.setNewName(newName);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (RenameServerResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP renameServer: " + e.getMessage(), e);
		}
	}

	public DeleteServerResponse deleteServer(Long serverId) {
		try {
			DeleteServerRequest request = objectFactory.createDeleteServerRequest();
			request.setId(serverId);

			WebServiceMessageCallback messageCallback = message -> {
				if (message instanceof SoapMessage soapMessage) {
					soapMessage.setSoapAction("");
				}
			};

			return (DeleteServerResponse) webServiceTemplate
					.marshalSendAndReceive(soapServerUrl, request, messageCallback);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'appel au service SOAP deleteServer: " + e.getMessage(), e);
		}
	}
}

