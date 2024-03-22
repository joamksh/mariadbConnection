package com.example.mariaConnection;

//import com.example.mariaConnection.loader.MypageDataLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MariaConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MariaConnectionApplication.class, args);
	}


//	@Autowired
//	private MypageDataLoader mypageDataLoader;


	// 애플리케이션 시작 시 데이터 로드 실행
//	@PostConstruct
//	public void loadDataOnStartup() {
//		mypageDataLoader.loadData();
//	}
}
