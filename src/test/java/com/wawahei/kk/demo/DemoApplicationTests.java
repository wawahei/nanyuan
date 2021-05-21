package com.wawahei.kk.demo;

import com.wawahei.kk.demo.nanyuan.DemoApplication;
import com.wawahei.kk.demo.nanyuan.common.util.JwtUtils;
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

	@Test
	public void test2(){
		String token = JwtUtils.createToken(1L,"wawahei");
		System.out.println(token);
	}

	@Test
	public void test3(){
		String token = "eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSKk8sT8xIzdTNyU_PzFPSUUqtKFCyMjQzMjQzNzAyttRRKi1OLfJMAYpBmH6JuakIbUq1AJlNL9NIAAAA._fYUH-xad-SKdckgYH_TOaszGgNHIqnDG7PByqCylJpDjlEWnI4-EdqaQ4Iv3IRr4HYCtH8-lQKyqu5i6cur3Q";
		boolean valid = JwtUtils.checkToken(token);
		System.out.println(valid);
	}

}
