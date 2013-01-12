package edu.mvc.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.mvc.model.entities.NamedEntity;

public final class JSFHelper {

	private JSFHelper() {
		
	}

	public static Map<String, Long> convertListToDDLMap(List<? extends NamedEntity> lstNamedEntity) {
		return convertListToDDLMap(lstNamedEntity, false);
	}

	public static Map<String, Long> convertListToDDLMap(List<? extends NamedEntity> lstNamedEntity, boolean blnDescripcion) {
		Map<String, Long> mapResult = new LinkedHashMap<String, Long>();
		for(NamedEntity namedEntity : lstNamedEntity) {
			String strKey = (blnDescripcion) ? namedEntity.getDescripcion() : namedEntity.getNombreCorto();
			mapResult.put(strKey, namedEntity.getId());
		}
		return mapResult;
	}
}
