package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.model.Proprietario;


public interface ProprietarioService {

	public List<Proprietario> listAllProprietari() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;
	
	//public Proprietario caricaSingoloMunicipioConAbitanti(Long id) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Proprietario proprietarioInstance) throws Exception;
	
	public int contaProprietariAutomobiliAnnoInPoi(Integer annoInput) throws Exception;

	//per injection
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);
	
	
}
