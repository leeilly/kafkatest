package com.illy.kafkatest;

import com.illy.kafkatest.domain.Column;
import com.illy.kafkatest.domain.Table;
import com.illy.kafkatest.domain.TableMappingProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTestApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TableMappingProperties tableMappingProperties;

	@Test
	public void testGetArticles() {

		Table table = tableMappingProperties.getTable();
		System.out.println(table.getOrg());
		System.out.println(table.getTarget());


		List<Column> columns = tableMappingProperties.getColumns();

		Column col = new Column();
		for(int i=0; i<columns.size(); i++){
			col = columns.get(i);
			System.out.println(col.getOrg());
			System.out.println(col.getTarget());
		}
		assertThat(columns.size(), is(2));
	}


}
