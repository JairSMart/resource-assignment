// src/main/java/mx/ipn/escom/resourceassignment/service/ResourceService.java
package mx.ipn.escom.resourceassignment.service;

import org.springframework.stereotype.Service;
import mx.ipn.escom.resourceassignment.model.ResourceAssignment;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ResourceService {
  private Map<Long,ResourceAssignment> store = new HashMap<>();
  private AtomicLong seq = new AtomicLong();

  public ResourceAssignment assign(ResourceAssignment r) {
    r.setId(seq.incrementAndGet());
    store.put(r.getId(), r);
    return r;
  }

  public Collection<ResourceAssignment> listAll() {
    return store.values();
  }
}
