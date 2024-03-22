//package com.example.mariaConnection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import java.time.LocalDateTime;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//public class DataLoader2 implements CommandLineRunner {
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PostIngredientRepository postIngredientRepository;
//
//    private AtomicInteger userCount = new AtomicInteger(0);
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        // 사용자의 수 가져오기
//        int count = userCount.incrementAndGet();
//
//        // 예시 유저 생성
//        User user = new User();
//        user.setNickname("example_nickname" + count);
//        user.setRating(1);
//        user.setProfile("Example profile1");
//        userRepository.save(user);
//
//        // 예시 포스트 생성
//
//
//        Post post = new Post();
//        post.setTitle("Post 1"); // 제목을 현재 가격을 사용하여 설정
//        post.setPrice(1); // 현재 가격 설정
//        post.setUser(user);
//        post.setCreatedAt(LocalDateTime.now());
//        postRepository.save(post);
//
//        PostIngredient ingredient1 = new PostIngredient();
//        ingredient1.setName("Ingredient a");
//        ingredient1.setUrl("http://example.com/ingredienta");
//        ingredient1.setPost(post);
//
//        PostIngredient ingredient2 = new PostIngredient();
//        ingredient2.setName("Ingredient b");
//        ingredient2.setUrl("http://example.com/ingredientb");
//        ingredient2.setPost(post);
//
//        // 포스트 재료 저장
//        postIngredientRepository.save(ingredient1);
//        postIngredientRepository.save(ingredient2);
//    }
//
//}