package com.mongo.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongo.demo.entities.Comment;
import com.mongo.demo.entities.Post;
import com.mongo.demo.entities.User;
import com.mongo.demo.repositories.CommentRepository;
import com.mongo.demo.repositories.PostRepository;
import com.mongo.demo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();	
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viajem","Vou viajar, abrços!");
		Post post2 = new Post(null,sdf.parse("22/04/2019"), "Bom dia ", "Acordei feliz");
		
		Comment comm1 = new Comment(null,"boa viagem!", sdf.parse("21/03/2018"));
		Comment comm2 = new Comment(null,"bom dia pra vc tbm!", sdf.parse("22/04/2019"));
		
		commentRepository.saveAll(Arrays.asList(comm1,comm2));
		
		post1.getComments().add(comm1);
		post2.getComments().add(comm2);
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().add(post1);
		maria.getPosts().add(post2);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

	
	
	
}
