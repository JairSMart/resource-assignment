// src/main/java/mx/ipn/escom/resourceassignment/model/ResourceAssignment.java
package mx.ipn.escom.resourceassignment.model;

public class ResourceAssignment {
  private Long id;
  private String resourceName;
  private String assignedTo;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getResourceName() { return resourceName; }
  public void setResourceName(String r) { this.resourceName = r; }
  public String getAssignedTo() { return assignedTo; }
  public void setAssignedTo(String a) { this.assignedTo = a; }
}
