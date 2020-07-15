// Part of Hookless: https://hookless.machinezoo.com
package com.machinezoo.hookless.benchmarks;

import java.util.concurrent.*;
import org.openjdk.jmh.annotations.*;
import com.machinezoo.hookless.*;
import com.machinezoo.stagean.*;

@DraftCode("measure more operations")
@State(Scope.Thread)
public class VariableBenchmark {
	/*
	 * Perform variable reads within reactive scope as otherwise the dependency tracking code would be skipped.
	 */
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
	/*
	 * Measure repeated reads of the same variable within one reactive scope.
	 * Since dependency set of any computation is usually small, first-time reads are rare unless the computation is very short.
	 * If many reads are performed during the computation, they must be repeated reads.
	 * It is therefore correct to measure repeated reads rather than first-time reads.
	 */
	private ReactiveVariable<String> observed = new ReactiveVariable<>("test");
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public String observeRepeatedly() {
		return observed.get();
	}
	/*
	 * Measure unobserved writes, i.e. writes to a reactive variable without any attached triggers.
	 * Just like with reads, if writes dominate relatively heavy operation, they must be repeated writes and thus mostly unobserved.
	 */
	private ReactiveVariable<String> written = new ReactiveVariable<>("test");
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@OperationsPerInvocation(2)
	public void writeUnobserved() {
		written.set("value A");
		written.set("value B");
	}
}
