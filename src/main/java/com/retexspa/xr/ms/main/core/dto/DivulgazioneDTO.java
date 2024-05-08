package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DivulgazioneDTO {

  private DivulgazioneBaseDTO data;

  public DivulgazioneDTO() {
  }

  public DivulgazioneDTO(DivulgazioneBaseDTO data) {
    this.data = data;
  }

  // Other fields and methods

  // Constructor with String argument
  public DivulgazioneDTO(String jsonString) {
    // Deserialize JSON string to DivulgazioneDTO
    ObjectMapper mapper = new ObjectMapper();
    try {
      DivulgazioneDTO dto = mapper.readValue(jsonString, DivulgazioneDTO.class);
      this.data = dto.getData();
      // Set other fields as needed
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public DivulgazioneBaseDTO getData() {
    return data;
  }

  public void setData(DivulgazioneBaseDTO data) {
    this.data = data;
  }

}
