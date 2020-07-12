// Part of Hookless: https://hookless.machinezoo.com
package com.machinezoo.hookless.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import com.machinezoo.hookless.*;

public class VariableBenchmark {
	private ReactiveVariable<String> variable = new ReactiveVariable<>("test");
	@Benchmark public String observeRepeatedly() {
		return variable.get();
	}
}
