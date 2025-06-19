package org.scoula.sample.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
class SampleServiceTest {

	@Autowired
	private SampleService service;

	@Test
	void doAdd() throws Exception{
		log.info(service.doAdd("123","456"));
	}

	@Test
	public void addError() throws Exception {
		log.info(service.doAdd("123", "ABC"));
	}
}