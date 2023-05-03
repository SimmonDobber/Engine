import assets.Assets;
import assets.font.Font;
import display.Display;
import scene.Scene;

import static assets.AssetsBean.getAssets;
import static display.DisplayBean.getDisplay;
import static scene.SceneBean.getScene;

public class Initializer {

	private static Initializer initializer;
	private final Assets assets;
	private final Display display;
	private final Scene scene;

	private Initializer() {
		this.assets = getAssets();
		this.display = getDisplay();
		this.scene = getScene();
	}

	public static Initializer getInitializer() {
		if (initializer == null) {
			initializer = new Initializer();
		}
		return initializer;
	}

	public void initialize() {
	}

	private void initializeColors() {
	}

	private void initializeFonts() {
		this.assets.addFont("HBE24", "/HelveticaBoldExtended24.png", Font.getExtendedAlphabet());
		this.assets.addFont("HBE32", "/HelveticaBoldExtended32.png", Font.getExtendedAlphabet());
		this.assets.addFont("HBE48", "/HelveticaBoldExtended48.png", Font.getExtendedAlphabet());
	}

	private void initializeScenes() {
	}

	private void initializeGlobalControllers() {
	}

	private void initializeLoginControllers() {
	}

	private void initializeGuiControllers() {
	}

	public static void main(String[] args) {
		new Initializer().initialize();
	}

}