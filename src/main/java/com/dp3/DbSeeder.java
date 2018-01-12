package com.dp3;

import java.util.ArrayList;
import java.util.List;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dp3.dao.StockRepository;
import com.dp3.dao.UserRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Usuario;
import com.dp3.domain.Wine;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private StockRepository stockRepository;
	private UserRepository usersRepository;
	private WineRepository wineRepository;
	private CellarRepository cellarRepository;


	public DbSeeder(StockRepository stockRepository, UserRepository usersRepository, WineRepository wineRepository, CellarRepository cellarRepository) {
		this.stockRepository = stockRepository;
		this.usersRepository = usersRepository;
		this.wineRepository = wineRepository;
		this.cellarRepository = cellarRepository;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		this.usersRepository.deleteAll();
		this.stockRepository.deleteAll();
		this.wineRepository.deleteAll();
		this.cellarRepository.deleteAll();


		List<Usuario> users = new ArrayList<Usuario>();
		
		Usuario user = new Usuario();
		
		user.setUsername("nico@nico.com");
		user.setPassword("casheja");
		user.setNombre("Nicolás");
		user.setApellido("Osowski");
		user.setRol("ADMIN");
		
		users.add(user);
		
		user = new Usuario();
		user.setUsername("cuki@cuki.com");
		user.setPassword("casheja");
		user.setNombre("Ariel");
		user.setApellido("Cukierkorm");
		user.setRol("SELLER");
		users.add(user);
		
		this.usersRepository.save(users);
		
		/*List<Stock> stocks = new ArrayList<Stock>();
		
		Cellar cellar = new Cellar("Catena Zapata", "Lujan de Cuyo, Mendoza", 
				"Fundada en 1902, Bodega Catena Zapata es reconocida por su rol pionero en haber hecho resurgir la variedad Malbec y haber descubierto los terroirs de altura extrema al pie de los Andes.");
		stocks.add(new Wine("Toro viej", 20, "malbec", cellar));
		
		stocks.add(new Wine("Vino toro", 20, "malbec", cellar));
		
		stocks.add(new Wine("Lopez", 20, "malbec", cellar));
		
		cellar = new Cellar("López", "Mendoza", "Representa un caso excepcional dentro de la industria vitivinícola argentina iniciada en 1898 continúa hoy en manos de la familia fundadora. Más de 118 años de tradición ofreciendo la misma calidad de siempre, labrando una historia desde el trabajo y el amor al detalle. Su fundador José López Rivas llegó en 1886 proveniente del pueblo de Algarrobo en Málaga, España, donde cultivaba junto a su familia predios con viñas y olivos. Decidió instalar sus viñedos en el país y escapar así de una devastadora plaga, la filoxera, que afectaba a las vides en Europa.");
		
		stocks.add(new Wine("Termidor", 20, "malbec", cellar));
		stocks.add(new Wine("Uvita", 20, "malbec", cellar));
		
		this.stockRepository.save(stocks);*/
	}
}