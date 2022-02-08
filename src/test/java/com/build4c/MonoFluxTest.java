package com.build4c;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
	
	@Test
	public void test_mono() {
		Mono<?> justString = Mono
				.just("build4c")
//				.then(Mono.error(new RuntimeException("Exception Here")))
				.log();
		justString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	}

	@Test
	public void test_flux() {
		Flux<?> justString = Flux
				.just("build4c","is","very","creative","abcd")
				.concatWithValues("1231")
//				.then(Mono.error(new RuntimeException("Exception Here")))
				.log();
		justString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	}
	
}
