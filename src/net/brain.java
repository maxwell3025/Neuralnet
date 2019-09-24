package net;

public class brain {
	double[][] synapses1 = new double[20][20];
	double[][] synapses2 = new double[20][2];
	double[] nodes = new double[20];
	double[] shifts = new double[20];

	public brain() {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				synapses1[x][y] = Math.random();
			}
		}
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 2; y++) {
				synapses2[x][y] = Math.random();
			}
		}
	}

	public double[] calculate(double[] input) {
		for (int out = 0; out < 20; out++) {
			int stored = 0;
			double[] mults = synapses1[out];
			for (int in = 0; in < 20; in++) {
				stored += mults[in] * input[in];
			}
			nodes[out] = stored;
		}
		double[] output = new double[2];
		for (int out = 0; out < 2; out++) {
			int stored = 0;
			double[] mults = synapses2[out];
			for (int in = 0; in < 20; in++) {
				stored += mults[in] * nodes[in];
			}
			output[out] = stored;
		}
		return output;
	}

}
