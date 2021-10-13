package giis.demo.tkrun.models.editor;

import java.util.List;

import giis.demo.tkrun.controllers.entities.ArticuloEntity;
import giis.demo.tkrun.models.dtos.ArticuloDto;
import giis.demo.tkrun.models.dtos.RevisorDto;
import giis.demo.util.Database;

public class EditorModel {

	private Database db = new Database();

	/**
	 * Obtiene la lista de revisores disponibles en forma de objetos
	 */
	public List<RevisorDto> getRevisoresDisponibles() {
		// validaciones (en este caso nada)
		String sql = "SELECT id, nombre, estado from revisores where estado='disponible'";

		return db.executeQueryPojo(RevisorDto.class, sql);

	}
	
	public List<ArticuloDto> getArticulos(){
		String sql = "SELECT idArticulo, titulo, primerAutor, estado, resumen, palabrasClave, ficheroFuente, cartaPresentacion,"
				+ " CV, firma, revisado from Articulo";
		
		return db.executeQueryPojo(ArticuloDto.class, sql);
	}
}
