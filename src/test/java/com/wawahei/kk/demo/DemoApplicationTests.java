package com.wawahei.kk.demo;

import com.wawahei.kk.demo.nanyuan.DemoApplication;
import com.wawahei.kk.demo.nanyuan.entity.Dict;
import com.wawahei.kk.demo.nanyuan.service.impl.DictServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Resource
	private DictServiceImpl dictService;

	@Test
	public void test1() {
		List<Dict> list = dictService.list(null);
		System.out.println(list.size());
	}

}
