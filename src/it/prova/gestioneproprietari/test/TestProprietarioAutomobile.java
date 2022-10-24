package it.prova.gestioneproprietari.test;

import java.text.SimpleDateFormat;
import java.util.List;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.model.Proprietario;
import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {
			
			testCrudProprietario(proprietarioService);
		
			testCrudAutomobile(automobileService, proprietarioService);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			EntityManagerUtil.shutdown();
		}

	}
	
	private static void testCrudProprietario(ProprietarioService proprietarioService) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(".......testCrudProprietario inizio.............");

		
		Proprietario proprietario1 = new Proprietario("mario", "rossi", "jdhasjkkda",
				new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1990"));
		Proprietario proprietario2 = new Proprietario("mario", "bianchi", "dasgfds",
				new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1995"));
		proprietarioService.inserisciNuovo(proprietario1);
		proprietarioService.inserisciNuovo(proprietario2);
		
		

		List<Proprietario> listaProprietari = proprietarioService.listAllProprietari();
		if (listaProprietari.size() != 2)
			throw new RuntimeException("Test fallito: insert non andato a buon fine");
		Long idProprietario1 = proprietario1.getId();

		
		String nome = "luca";
		proprietario1.setNome(nome);
		proprietarioService.aggiorna(proprietario1);

		if (!proprietario1.getNome().equals("luca"))
			throw new RuntimeException("Test fallito: aggiornamento non andato a buon fine");

		
		proprietarioService.rimuovi(proprietario1);
		if (proprietarioService.caricaSingoloProprietario(idProprietario1) != null)
			throw new RuntimeException("Test fallito: rimozione non andato a buon fine");

		System.out.println(".......testCrudProprietario fine: PASSED.............");

	}
	
	private static void testCrudAutomobile(AutomobileService automobileService, ProprietarioService proprietarioService)
			throws Exception {

		// TODO Auto-generated method stub
		System.out.println(".......testCrudAutomobile inizio.............");

		
		Proprietario proprietario1 = new Proprietario("mario", "rossi", "jdhasjkkda",
				new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1990"));
		Proprietario proprietario2 = new Proprietario("mario", "bianchi", "dasgfds",
				new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1995"));
		proprietarioService.inserisciNuovo(proprietario1);
		proprietarioService.inserisciNuovo(proprietario2);

		
		Automobile automobile1 = new Automobile("suzuki", "k500", "dasdf", 2020);
		automobile1.setProprietario(proprietario1);

		automobileService.inserisciNuova(automobile1);
		List<Automobile> listaAutomobili = automobileService.listAllAutomobili();
		if (listaAutomobili.size() != 1)
			throw new RuntimeException("Test fallito: insert non andato a buon fine");
		

		automobile1.setModello("800t");
		automobileService.aggiorna(automobile1);

		if (!automobile1.getModello().equals("800t"))
			throw new RuntimeException("Test fallito: aggiornamento non andato a buon fine");

		
		automobileService.rimuovi(automobile1.getId());
		proprietarioService.rimuovi(proprietario1);
		proprietarioService.rimuovi(proprietario2);
		if (automobileService.caricaSingolaAutomobile(automobile1.getId()) != null){
			throw new RuntimeException("Test fallito: rimozione non andato a buon fine");
		}

		System.out.println(".......testCrudAutomobile fine: PASSED.............");
	}

}
