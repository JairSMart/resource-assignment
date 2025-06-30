// src/main/java/mx/ipn/escom/resourceassignment/controller/ResourceController.java
package mx.ipn.escom.resourceassignment.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import mx.ipn.escom.resourceassignment.model.ResourceAssignment;
import mx.ipn.escom.resourceassignment.service.ResourceService;
import java.util.Collection;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

  private final ResourceService svc;
  public ResourceController(ResourceService svc) { this.svc = svc; }

  @PostMapping
  public ResponseEntity<ResourceAssignment> assign(@RequestBody ResourceAssignment r) {
    return ResponseEntity.ok(svc.assign(r));
  }

  @GetMapping
  public Collection<ResourceAssignment> all() {
    return svc.listAll();
  }
}
