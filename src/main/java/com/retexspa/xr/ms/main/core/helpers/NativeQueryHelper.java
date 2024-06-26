package com.retexspa.xr.ms.main.core.helpers;

public class NativeQueryHelper {

  public String gerarchiaNativeQuery(){
    return "(WITH RECURSIVE subordinates AS ( "
    + "    SELECT id, padre_id "
    + "    FROM gerarchie "
    + "    WHERE id = :gerarchiaid "
    + "    UNION "
    + "    SELECT e.id, e.padre_id "
    + "    FROM gerarchie e "
    + "        INNER JOIN subordinates s ON s.padre_id = e.id "
    + ") "
    + "SELECT id "
    + "FROM subordinates)";
  }

}
