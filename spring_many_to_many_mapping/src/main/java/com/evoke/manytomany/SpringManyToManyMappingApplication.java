package com.evoke.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.nodes.Tag;

import com.evoke.manytomany.entity.Post;
import com.evoke.manytomany.entity.Tags;
import com.evoke.manytomany.repository.PostRepository;
import com.evoke.manytomany.repository.TagsRepository;

@SpringBootApplication
public class SpringManyToManyMappingApplication implements CommandLineRunner{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TagsRepository tagsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringManyToManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Post post = new Post("Hibernate Mapping", "Many to Many Example",
				"Many to Many Example Using Spring");
		
		Post post1 = new Post("Hibernate Mapping", "One to One Example",
				"One to One Example Using Spring");
		
		Tags tag = new Tags("Spring Boot");
		Tags tag1 = new Tags("Hibernate Framework");
		
		// adding tags reference to post
		
		post.getTags().add(tag);
		post.getTags().add(tag1);
		
		// adding post reference to tags
		
		tag.getPosts().add(post);
		tag1.getPosts().add(post);
		
		tag.getPosts().add(post1);
		post1.getTags().add(tag);
		
		
		this.postRepository.save(post);
		this.postRepository.save(post1);
		
		
	}

}
