package pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Database {

	INSTANCE;

	private Map<Integer,Type> types =new HashMap();
	private Map<Type, Map<Type, Double>> efectivities=new HashMap();
	private Map<Integer, Attack> attacks=new HashMap();
	private Map<Integer, Specie> species=new HashMap();
	
	Database(){
		loadTypes();
		loadEfectivities();
		loadAttacks();
		loadSpecies();
	}

	private void loadTypes() {
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("src/database/FicheroTipos.csv"))){
			types = objReader.lines()
							 .map(s -> s.split(";"))
							 .collect(Collectors.toMap( array -> Integer.parseInt(array[0]),  array -> new Type(Integer.parseInt(array[0]), array[1])));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadEfectivities() {
	
		try(BufferedReader objReader=new BufferedReader(new FileReader("src/database/FicheroEfectividades.csv"))){
			efectivities = objReader.lines()
									.map(s -> s.split(";"))
									.collect(Collectors.groupingBy( array -> types.get(Integer.parseInt(array[0])), 
											Collectors.toMap( array -> types.get(Integer.parseInt(array[1])), array -> Double.parseDouble(array[2]))));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadAttacks() {
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("src/database/FicheroMovimientos.csv"))){
			attacks = objReader.lines()
							   .map(s -> s.split(";"))
							   .collect(Collectors.toMap( array -> Integer.parseInt(array[0]), 
									  array -> (new Attack(array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4], types.get(Integer.parseInt(array[5])), efectivities.get(types.get(Integer.parseInt(array[5])))))));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadSpecies() {
		
		try(BufferedReader objReader=new BufferedReader(new FileReader("src/database/FicheroEspecies.csv"))){
			species = objReader.lines()
							   .map(s -> s.split(";"))
							   .collect(Collectors.toMap( array -> Integer.parseInt(array[0]), 
									  array -> (new Specie(array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]),
											  				Integer.parseInt(array[6]), Integer.parseInt(array[7]), types.get(Integer.parseInt(array[8])), array[9].equals("")?null:types.get(Integer.parseInt(array[9])), 
											  				List.of(attacks.get(Integer.parseInt(array[10])), attacks.get(Integer.parseInt(array[11])), attacks.get(Integer.parseInt(array[12])), attacks.get(Integer.parseInt(array[13])))
											  				))));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public Map<Integer, Type> getTypes() {
		return types;
	}

	public Map<Type, Map<Type, Double>> getEfectivities() {
		return efectivities;
	}

	public Map<Integer, Attack> getAttacks() {
		return attacks;
	}

	public Map<Integer, Specie> getSpecies() {
		return species;
	}

}