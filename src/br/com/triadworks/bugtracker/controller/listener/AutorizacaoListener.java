package br.com.triadworks.bugtracker.controller.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.triadworks.bugtracker.controller.UsuarioWeb;

public class AutorizacaoListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		//Verifica a página que ele quer acessar
		String paginaAcessada = context.getViewRoot().getViewId();
		if("/login.xhtml".equals(paginaAcessada)){
			return;
		}
		
		//Recupera o usuário da sessão
		UsuarioWeb usuarioWeb = context.getApplication()
								.evaluateExpressionGet(context, "#{usuarioWeb}", UsuarioWeb.class);
		
		//Se o usuário não tiver logado, manda pra login
		if(!usuarioWeb.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/login?faces-redirect=true");
		
			//Pula pra fase render response
			context.renderResponse();
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
