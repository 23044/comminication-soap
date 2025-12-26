package mr.supnum.middleservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mr.supnum.middleservice.dto.CreateServerRequestDTO;
import mr.supnum.middleservice.dto.RenameServerRequestDTO;
import mr.supnum.middleservice.dto.ServerDTO;
import mr.supnum.middleservice.service.SoapServerService;
import mr.supnum.middleservice.wsdl.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servers")
// @Tag(name = "Server Management", description = "API pour gérer les serveurs via le service SOAP")
public class ServerRestController {

	private final SoapServerService soapServerService;

	public ServerRestController(SoapServerService soapServerService) {
		this.soapServerService = soapServerService;
	}

	// POST /api/servers - Créer un serveur
	@PostMapping
	// @Operation(summary = "Créer un nouveau serveur", description = "Crée un serveur avec le nom et l'adresse IP fournis")
	public ResponseEntity<ServerDTO> createServer(@RequestBody CreateServerRequestDTO request) {
		try {
			// Le XSD n'inclut pas status dans createServerRequest
			CreateServerResponse response = soapServerService.createServer(
					request.getName(),
					request.getIpAddress(),
					null);
			ServerDTO serverDTO = toServerDTO(response.getServer());
			return ResponseEntity.status(HttpStatus.CREATED).body(serverDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// GET /api/servers - Lister tous les serveurs
	@GetMapping
	@Operation(summary = "Lister tous les serveurs", description = "Retourne la liste de tous les serveurs")
	public ResponseEntity<List<ServerDTO>> listServers() {
		try {
			ListServersResponse response = soapServerService.listServers();
			List<ServerDTO> servers = response.getServers().stream()
					.map(this::toServerDTO)
					.collect(Collectors.toList());
			return ResponseEntity.ok(servers);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// GET /api/servers/{id}/status - Obtenir le statut d'un serveur
	@GetMapping("/{id}/status")
	public ResponseEntity<mr.supnum.middleservice.dto.GetServerStatusResponseDTO> getServerStatus(
			@PathVariable Long id) {
		try {
			GetServerStatusResponse response = soapServerService.getServerStatus(id);
			mr.supnum.middleservice.dto.GetServerStatusResponseDTO dto = new mr.supnum.middleservice.dto.GetServerStatusResponseDTO(
					id, response.isStatus());
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// POST /api/servers/{id}/start - Démarrer un serveur
	@PostMapping("/{id}/start")
	public ResponseEntity<mr.supnum.middleservice.dto.StartServerResponseDTO> startServer(@PathVariable Long id) {
		try {
			StartServerResponse response = soapServerService.startServer(id);
			ServerDTO serverDTO = toServerDTO(response.getServer());
			mr.supnum.middleservice.dto.StartServerResponseDTO wrapper = new mr.supnum.middleservice.dto.StartServerResponseDTO(
					serverDTO);
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// POST /api/servers/{id}/stop - Arrêter un serveur
	@PostMapping("/{id}/stop")
	public ResponseEntity<mr.supnum.middleservice.dto.StopServerResponseDTO> stopServer(@PathVariable Long id) {
		try {
			StopServerResponse response = soapServerService.stopServer(id);
			ServerDTO serverDTO = toServerDTO(response.getServer());
			mr.supnum.middleservice.dto.StopServerResponseDTO wrapper = new mr.supnum.middleservice.dto.StopServerResponseDTO(
					serverDTO);
			return ResponseEntity.ok(wrapper);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// PUT /api/servers/{id}/rename - Renommer un serveur
	@PutMapping("/{id}/rename")
	public ResponseEntity<ServerDTO> renameServer(@PathVariable Long id,
			@RequestBody RenameServerRequestDTO request) {
		try {
			RenameServerResponse response = soapServerService.renameServer(id, request.getNewName());
			ServerDTO serverDTO = toServerDTO(response.getServer());
			return ResponseEntity.ok(serverDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// DELETE /api/servers/{id} - Supprimer un serveur
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteServer(@PathVariable Long id) {
		try {
			DeleteServerResponse response = soapServerService.deleteServer(id);
			if (response.isSuccess()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	private ServerDTO toServerDTO(Server server) {
		ServerDTO dto = new ServerDTO();
		dto.setId(server.getId());
		dto.setName(server.getName());
		dto.setIpAddress(server.getIpAddress());
		dto.setRunning(server.isStatus());
		return dto;
	}
}
