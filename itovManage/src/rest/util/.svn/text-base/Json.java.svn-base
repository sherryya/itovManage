package rest.util;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class Json {
	private ObjectMapper objectMapper;

	public static Json me() {
		return new Json();
	}

	public Json() {
		objectMapper = new ObjectMapper();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属�?
		//objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		//objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		
	}

	public Json filter(String filterName, String properties) {
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName,
				SimpleBeanPropertyFilter.serializeAllExcept(properties));
		objectMapper.setFilters(filterProvider);
		return this;
	}

	public Json addMixInAnnotations(Class<?> target, Class<?> mixinSource) {
		//objectMapper.getSerializationConfig().addMixInAnnotations(target, mixinSource);
		//objectMapper.getDeserializationConfig().addMixInAnnotations(target, mixinSource);
		return this;
	}

	public Json setDateFormate(DateFormat dateFormat) {
		objectMapper.setDateFormat(dateFormat);
		return this;
	}

	public <T> T json2Obj(String json, TypeReference<T> typeReference) {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析json错误");
		}
	}

	public String readAsString(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析对象错误");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> json2List(String json) {
		try {
			return objectMapper.readValue(json, List.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析json错误");
		}
	}
	/**
	 * list map 转 json
	 * @param list
	 * @return
	 */
	public static String listmap_to_json_string(List<Map<String, Object>> list,String count)
	{       
	    JSONArray json_arr=new JSONArray();
	    JSONObject json_obj1=new JSONObject();
	    json_obj1.put("id", count);
	    json_arr.add(json_obj1);
	    for (Map<String, Object> map : list) {
	        JSONObject json_obj=new JSONObject();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            try {
	                json_obj.put(key,value);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }                           
	        }
	        json_arr.add(json_obj);
	    }
	  
	    return json_arr.toString();
	}
	public static String listmap_to_json_string1(List<Map<String, Object>> list,String count,String imax,String pn)
	{       
	    JSONArray json_arr=new JSONArray();
	    JSONObject json_obj1=new JSONObject();
	    json_obj1.put("id", count);
	    json_obj1.put("imax", imax);
	    json_obj1.put("pn", pn);
	    json_arr.add(json_obj1);
	    for (Map<String, Object> map : list) {
	        JSONObject json_obj=new JSONObject();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            try {
	                json_obj.put(key,value);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }                           
	        }
	        json_arr.add(json_obj);
	    }
	  
	    return json_arr.toString();
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
	
	}
}
