// Part of Hookless: https://hookless.machinezoo.com
package com.machinezoo.hookless.benchmarks;

import java.util.concurrent.*;
import org.openjdk.jmh.annotations.*;
import com.machinezoo.hookless.*;

@State(Scope.Thread)
public class VariableBenchmark {
	private ReactiveVariable<String> variable = new ReactiveVariable<>("test");
	private ReactiveScope scope = new ReactiveScope();
	private ReactiveScope.Computation computation;
	@Setup
	public void setup() {
		computation = scope.enter();
	}
	@TearDown
	public void teardown() {
		computation.close();
	}
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public String observeRepeatedly() {
		return variable.get();
	}
}
