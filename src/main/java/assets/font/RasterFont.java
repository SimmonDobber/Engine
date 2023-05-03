package assets.font;

import java.util.HashMap;
import java.util.Map;

import common.Rasterable;

public class RasterFont implements Font {

	private final Map<Character, Rasterable> symbols;

	RasterFont(String symbols, Rasterable[] rasterables) {
		this.symbols = new HashMap<>();
		for (int i = 0; i < symbols.length(); i++) {
			this.symbols.put(symbols.charAt(i), rasterables[i]);
		}
	}

	@Override
	public Rasterable getSymbolRasterable(char symbol) {
		return this.symbols.get(symbol);
	}
}
