package interfaceActiveObject;

import java.awt.Button;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.omg.CORBA.PRIVATE_MEMBER;

import canal.Canal;
import diffusion.Diffusion;
import diffusion.DiffusionAtomique;
import diffusion.DiffusionCausal;
import diffusion.DiffusionSequentiel;
import generator.Generator;
import generator.GeneratorImp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import monitor.Monitor;

public class MainViewController {

	@FXML
	private Label labelTitre;

	@FXML
	private ToggleGroup broadcastMethod;

	@FXML
	private Button generate;

	@FXML
	private Label monitor1;

	@FXML
	private Label monitor2;

	@FXML
	private Label monitor3;

	@FXML
	private Label monitor4;

	@FXML
	private RadioButton atomicButton;

	@FXML
	private RadioButton causalButton;

	@FXML
	private RadioButton sequentialButton;

	@FXML
	private RadioButton atomic;
	@FXML
	private RadioButton sequential;
	@FXML
	private RadioButton causal;

	Canal canal1;
	Canal canal2;
	Canal canal3;
	Canal canal4;
	Monitor monitor1Object;
	Monitor monitor2Object;
	Monitor monitor3Object;
	Monitor monitor4Object;
	Generator generator;
	Diffusion diffusion;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public void initialize() {
		diffusion = new DiffusionAtomique();

		this.generator = new GeneratorImp(0, diffusion, new ArrayList<>());
		canal1 = new Canal();
		canal2 = new Canal();
		canal3 = new Canal();
		canal4 = new Canal();
		monitor1Object = new Monitor(canal1, 1);
		monitor2Object = new Monitor(canal2, 2);
		monitor3Object = new Monitor(canal3, 3);
		monitor4Object = new Monitor(canal4, 4);
		canal1.setMonitor(monitor1Object);
		canal2.setMonitor(monitor2Object);
		canal3.setMonitor(monitor3Object);
		canal4.setMonitor(monitor4Object);
		canal1.setGenerator(generator);
		canal2.setGenerator(generator);
		canal3.setGenerator(generator);
		canal4.setGenerator(generator);

		this.monitor1.textProperty().bind(monitor1Object.getIntegerProperty().asString());
		this.monitor2.textProperty().bind(monitor2Object.getIntegerProperty().asString());
		this.monitor3.textProperty().bind(monitor3Object.getIntegerProperty().asString());
		this.monitor4.textProperty().bind(monitor4Object.getIntegerProperty().asString());

		ToggleGroup toggleGroup = new ToggleGroup();
		atomic.setToggleGroup(toggleGroup);
		sequential.setToggleGroup(toggleGroup);
		causal.setToggleGroup(toggleGroup);

		generator.attach(canal1);
		generator.attach(canal2);
		generator.attach(canal3);
		generator.attach(canal4);

	}

	@FXML
	private void chooseAtomic() {
		LOGGER.info("Atomic is selected ");
		diffusion = new DiffusionAtomique();

	}

	@FXML
	private void chooseSequentiel() {
		LOGGER.info("sequetiel is selected ");
		diffusion = new DiffusionSequentiel();
	}

	@FXML
	private void chooseCausal() {
		LOGGER.info("causal is selected ");
		diffusion = new DiffusionCausal();
	}

	@FXML
	private void generate() {
		diffusion.configure(0, generator);
		generator.setDiffusion(diffusion);
		diffusion.execute();
	}

	@FXML
	private void stop() {
		generator.stopDiffusion();
	}

}
