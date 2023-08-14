package com.kajol.Batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import com.kajol.DAO.Industry;
import com.kajol.DAO.MyJPARepo;

import lombok.AllArgsConstructor;

import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfiguration {

	@Autowired
	 public MyJPARepo repo;
	private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<Industry> reader()
	{
		FlatFileItemReader<Industry> itemReader=new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/Uploads_Annual-csv.csv"));
		itemReader.setName("csv-reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(Linemapper());
		return itemReader;
	}

	private LineMapper<Industry> Linemapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Industry> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		BeanWrapperFieldSetMapper<Industry> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("year_ind","code_ind","name_ind","size_ind","veriable_ind","value_ind","unit_ind");
		fieldSetMapper.setTargetType(Industry.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
	@Bean
	public IndustryProcessor createProcessor()
	{
		return new IndustryProcessor();
	}
	
	@Bean
	public RepositoryItemWriter<Industry> writer()
	{
		RepositoryItemWriter<Industry> itemWriter=new RepositoryItemWriter<Industry>();
		itemWriter.setRepository(repo);
		itemWriter.setMethodName("save");
		return itemWriter;
	}
	
	@Bean
	public Step step()
	{
		return stepBuilderFactory.get("step-1").<Industry, Industry>chunk(10)
				  .reader(reader())
				  .processor(createProcessor())
				  .writer(writer())
				  .taskExecutor(taskExecutor())
				  .build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}

	@Bean
	public Job job()
	{
		return jobBuilderFactory.get("industry-import")
				                .flow(step())
				                .end().build();
	}
	
}
