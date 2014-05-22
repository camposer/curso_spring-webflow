package converter;

import org.springframework.core.convert.converter.Converter;

public class StringToInteger implements Converter<String, Integer> {

	@Override
	public Integer convert(String arg0) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(arg0);
		} catch (Exception e) {}
		
		return retorno;
	}

}
