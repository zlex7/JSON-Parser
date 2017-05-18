import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JSON {

	private HashMap<String, Object> objects = new HashMap<String, Object>();
	//private HashMap<String, String> strings = new HashMap<String, String>();
	//private HashMap<String, Double> numbers = new HashMap<String, Double>();
	//private HashMap<String, Boolean> booleans = new HashMap<String, Boolean>();
	//private HashMap<String, Object[]> arrays = new HashMap<String, Object[]>();

	public JSON getObj(String key) {

		return (JSON)objects.get(key);
	}

	public JSON setObj(String key, JSON value) {

		objects.put(key, value);

		return this;
	}

	public void getAllObjs(Collection<JSON> data) {

		data.addAll(objects.values().stream().filter(j -> j instanceof JSON).map(j -> (JSON) j).collect(Collectors.toList()));

	}

	public Object[] getArray(String key) {

		return (Object[])objects.get(key);

	}

	public JSON setArray(String key, Object[] value) {

		objects.put(key, value);

		return this;

	}

	public void getAllArrays(Collection<Object[]> data) {

		data.addAll(objects.values().stream().filter(j -> j instanceof Object[]).map(a -> (Object[]) a).collect(Collectors.toList()));

	}

	public String getString(String key) {

		return (String)objects.get(key);

	}

	public JSON setString(String key, String value) {

		objects.put(key, value);
		
		return this;
	}

	public void getAllStrings(Collection<String> data) {

		data.addAll(objects.values().stream().filter(s -> s instanceof String).map(s -> (String) s).collect(Collectors.toList()));

	}

	public double getNumber(String key) {

		return (double)objects.get(key);

	}

	public JSON setNumber(String key, double value) {

		objects.put(key, value);
		
		return this;
	}

	public void getAllNumbers(Collection<Double> data) {

		data.addAll(objects.values().stream().filter(d -> d instanceof String).map(d -> (double) d).collect(Collectors.toList()));


	}

	public boolean getBoolean(String key) {

		return (boolean)objects.get(key);

	}

	public JSON setBoolean(String key, boolean value) {

		objects.put(key, value);
		
		return this;
	}

	public void getAllBooleans(Collection<Boolean> data) {

		data.addAll(objects.values().stream().filter(b -> b instanceof String).map(b -> (boolean) b).collect(Collectors.toList()));


	}

	public boolean hasKey(String key) {

		return objects.containsKey(key);

	}
	
	
	public String stringify(int recursivity){
		
		String formatted = "{\n";
		
		for(int i=0;i<recursivity;i++){
			formatted+="\t";
		}
		
		
		System.out.println("KEYSET: " + objects.keySet());
		
		for(Map.Entry<String, Object> o : objects.entrySet()){
			
			//System.out.println("ENTRY: " + o.toString());
			
			
			//System.out.println("KEY VALUE:  " + o.getKey());
			
			formatted += "\"" + o.getKey() + "\" : ";
			
			Object value = o.getValue();
			
			if(value instanceof JSON){
				
				formatted+=((JSON) value).stringify(recursivity+1);
			
			}
			
			else if(value instanceof Object[]){
				
				formatted += Arrays.toString((Object[])value);
				
			}
			
			else if(value instanceof String){
				
				formatted+= "\"" + value + "\"";
				
			}
			
			else{
				
				formatted += value;
				
			}
			
			formatted += ",\n";
			
			for(int i=0;i<recursivity;i++){
				formatted+="\t";
			}
			
			
		}
		
		formatted += "}";
		
		return formatted;
		
	}
	public String toString(){
		
		//return "[ objects: " + objects.toString() + " ]";
		
		return stringify(1);
		
		
	}

}
