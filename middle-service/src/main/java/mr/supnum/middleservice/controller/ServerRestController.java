package mr.supnum.middleservice.controller;

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
public class ServerRestController {

	private final SoapServerService soapServerService;

	public ServerRestController(SoapServerService soapServerService) {
		this.soapServerService = soapServerService;
	}

	// POST /api/servers - Créer un serveur
	@PostMapping
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
	public ResponseEntity<Boolean> getServerStatus(@PathVariable Long id) {
		try {
			GetServerStatusResponse response = soapServerService.getServerStatus(id);
			return ResponseEntity.ok(response.isStatus());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// POST /api/servers/{id}/start - Démarrer un serveur
	@PostMapping("/{id}/start")
	public ResponseEntity<ServerDTO> startServer(@PathVariable Long id) {
		try {
			StartServerResponse response = soapServerService.startServer(id);
			ServerDTO serverDTO = toServerDTO(response.getServer());
			return ResponseEntity.ok(serverDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// POST /api/servers/{id}/stop - Arrêter un serveur
	@PostMapping("/{id}/stop")
	public ResponseEntity<ServerDTO> stopServer(@PathVariable Long id) {
		try {
			StopServerResponse response = soapServerService.stopServer(id);
			ServerDTO serverDTO = toServerDTO(response.getServer());
			return ResponseEntity.ok(serverDTO);
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
		dto.setStatus(server.isStatus());
		return dto;
	}
}

