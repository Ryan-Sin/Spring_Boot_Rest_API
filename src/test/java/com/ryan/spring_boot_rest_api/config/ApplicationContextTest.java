package com.ryan.spring_boot_rest_api.config;

import com.ryan.spring_boot_rest_api.controller.UserController;
import com.ryan.spring_boot_rest_api.repository.UserMemoryRepository;
import com.ryan.spring_boot_rest_api.repository.UserRepositoryInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;


public class ApplicationContextTest {

    @Autowired
    UserController userController;

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("등록 된 모든 빈 확인하기")
    void findAllBean() {
        //getBeanDefinitionNames() -> Spring의 등록 된 모든 Bean 이름을 조회한다.
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //getBean() -> Bean 이름으로 Bean 객체 정보를 조회한다.
            Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
            System.out.println("Bean 이름: " + beanDefinitionName + " || Bean 정보: " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 확인하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition(beanDefinitionName);

            /**
             * @description Bean 타입에 따른 조회
             *  ROLE_APPLICATION -> 우리가 직접 등록한 애플리케이션 Bean
             *  ROLE_INFRASTRUCTURE -> 스프링 내부에서 사용하는 Bean
             */
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
                System.out.println("Bean 이름: " + beanDefinitionName + " || Bean 정보: " + bean);
            }
        }
    }

    @Test
    @DisplayName("Bean 이름을 통한 Bean 조회")
    void findBeanByName() {
        //등록한 Bean의 이름은 userRepository
        UserRepositoryInterface userRepository = annotationConfigApplicationContext.getBean("userRepository", UserRepositoryInterface.class);
        System.out.println("userRepository = " + userRepository);

        //UserMemoryRepository 클래스는 UserRepositoryInterface의 구현체이다. 그렇기 때문에 해당 테스트 코드는 성공이다.
        assertThat(userRepository).isInstanceOf(UserMemoryRepository.class);
    }

    @Test
    @DisplayName("Bean 타입으로 Bean 조회")
    void findBeanByType() {
        UserRepositoryInterface userRepository = annotationConfigApplicationContext.getBean(UserRepositoryInterface.class);
        System.out.println("userRepository = " + userRepository);

        //UserMemoryRepository 클래스는 UserRepositoryInterface의 구현체이다. 그렇기 때문에 해당 테스트 코드는 성공이다.
        assertThat(userRepository).isInstanceOf(UserMemoryRepository.class);
    }

    @Test
    @DisplayName("구현체 타입으로 Bean 조회")
    void findBeanByImp() {

        //UserMemoryRepository 클래스는 UserRepositoryInterface의 구현체이다.
        UserMemoryRepository userMemoryRepository = annotationConfigApplicationContext.getBean("userRepository", UserMemoryRepository.class);
        System.out.println("userMemoryRepository = " + userMemoryRepository);

        //Bean 등록시 반환 타입을 Interface로 설정을 했어도 실제 반환하는 데이터를 구현체로 반환하기 때문에 문제가 없다.
        assertThat(userMemoryRepository).isInstanceOf(UserMemoryRepository.class);
    }
}
