import java.util.Collection;
import java.util.HashMap;

public class JSON {

	private HashMap<String, JSON> objects = new HashMap<String, JSON>();
	private HashMap<String, String> strings = new HashMap<String, String>();
	private HashMap<String, Double> numbers = new HashMap<String, Double>();
	private HashMap<String, Boolean> booleans = new HashMap<String, Boolean>();
	private HashMap<String, Object[]> arrays = new HashMap<String, Object[]>();

	public JSON getObj(String key) {

		return objects.get(key);
	}

	public JSON setObj(String key, JSON value) {

		objects.put("key", value);

		return this;
	}

	public void getAllObjs(Collection<JSON> data) {

		data.addAll(objects.values());

	}

	public Object[] getArray(String key) {

		return arrays.get(key);

	}

	public JSON setArray(String key, Object[] value) {

		arrays.put(key, value);

		return this;

	}

	public void getAllArrays(Collection<Object[]> data) {

		data.addAll(arrays.values());

	}

	public String getString(String key) {

		return strings.get(key);

	}

	public JSON setString(String key, String value) {

		strings.put(key, value);
		return this;
	}

	public void getAllStrings(Collection<String> data) {

		data.addAll(strings.values());

	}

	public double getNumber(String key) {

		return numbers.get(key);

	}

	public JSON setNumber(String key, double value) {

		numbers.put(key, value);
		return this;
	}

	public void getAllNumbers(Collection<Double> data) {

		data.addAll(numbers.values());

	}

	public boolean getBoolean(String key) {

		return booleans.get(key);

	}

	public JSON setBoolean(String key, boolean value) {

		booleans.put(key, value);
		return this;
	}

	public void getAllBooleans(Collection<Boolean> data) {

		data.addAll(booleans.values());

	}

	public boolean hasKey(String key) {

		return objects.containsKey(key) || strings.containsKey(key)
				|| booleans.containsKey(key) || numbers.containsKey(key);

	}

	public String toString(){
		
		return "[ objects: " + objects.toString() + ", arrays: " + arrays.toString() + ", strings: " 
		+ strings.toString() + ", numbers:" + numbers.toString() + ", booleans: " + booleans.toString();
		
	}

}
