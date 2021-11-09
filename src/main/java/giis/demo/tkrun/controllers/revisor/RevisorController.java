package giis.demo.tkrun.controllers.revisor;

import java.util.ArrayList;
import java.util.List;

import giis.demo.tkrun.controllers.entities.ArticuloEntity;
import giis.demo.tkrun.controllers.entities.RevisionEntity;
import giis.demo.tkrun.controllers.entities.RevisorEntity;
import giis.demo.tkrun.controllers.entities.SugerenciaEntity;
import giis.demo.tkrun.models.articulo.ArticuloModel;
import giis.demo.tkrun.models.dtos.RevisorDto;
import giis.demo.tkrun.models.revision.RevisionModel;
import giis.demo.tkrun.models.revisor.RevisorModel;
import giis.demo.tkrun.views.revisor.RevisorMenu;
import giis.demo.util.EntityAssembler;

public class RevisorController {

    // private EditorView view; No hay vista todavía asi que esta todo comentado
    private RevisionModel model;
    // private RevisionModel revisionModel;
    private ArticuloModel articuloModel;
    private RevisorModel revisoresModel;
    private RevisorMenu rm;
    private int idRevisor;

    // public AutorController(AutorModel m, EditorView v) {
    // this.model = m;
    // this.view = v;
    // no hay inicializacion especifica del modelo, solo de la vista
    // this.initView();
    // }

    public RevisorController(int idRevisor) {
	this.model = new RevisionModel();
	this.articuloModel = new ArticuloModel();
	this.revisoresModel = new RevisorModel();
	this.idRevisor = idRevisor;
	// no hay inicializacion especifica del modelo, solo de la vista
	this.initView();
    }

    public RevisorController() {
	this.model = new RevisionModel();
	this.articuloModel = new ArticuloModel();
	this.revisoresModel = new RevisorModel();
    }

    private void initView() {

	rm = new RevisorMenu(idRevisor);
	rm.setVisible(true);

    }

    public RevisionEntity getArticulosSinRevisar(int id, int idArt) {

	return EntityAssembler.toRevisionEntity(model.visualizarSinRevisar(id, idArt));
    }

    public List<ArticuloEntity> getTituloArticulosSinRevisar(int id) {

	return EntityAssembler.toArticuloEntityList(model.articulosSinRevisar(id));
    }

    public void actualizarRevision(String comAutor, String comEditor, String decision, boolean enviarAlEditor, int id,
	    int idArt) {

	model.revisarArticulo(comAutor, comEditor, decision, enviarAlEditor, idArt, id);
    }

    public List<ArticuloEntity> getArticulosAsignados(int id) {
	return EntityAssembler.toArticuloEntityList(articuloModel.getArticulosAsignados(id));
    }

    public RevisorEntity findRevisor(String nombre, String correo, String especialidad) {
	return EntityAssembler.toRevisorEntity(model.findRevisor(nombre, correo, especialidad));
    }

    public List<RevisorEntity> findSugeridos(int idArticulo) {
	List<SugerenciaEntity> ids = EntityAssembler.toSugerenciaEntityList(model.findSugeridos(idArticulo));
	List<RevisorEntity> revisores = new ArrayList<RevisorEntity>();
	for (SugerenciaEntity id : ids) {
	    revisores.add(EntityAssembler.toRevisorEntity(model.findById(id.getIdRevisor())));
	}

	return revisores;
    }

    public void addRevisor(RevisorDto revisorDto) {
	revisoresModel.addRevisor(revisorDto);
    }
}
