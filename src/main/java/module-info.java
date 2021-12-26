// Part of Hookless: https://hookless.machinezoo.com
open module com.machinezoo.hookless.benchmarks {
	exports com.machinezoo.hookless.benchmarks;
	requires com.machinezoo.stagean;
	requires com.machinezoo.noexception;
	requires com.machinezoo.hookless;
	/*
	 * JMH library is not a module and not planned to be a module. There's no way to request this from JMH maintainers.
	 */
	requires jmh.core;
}
