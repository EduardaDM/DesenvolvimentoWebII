package br.com.emazureck.spring_jpa_mysql.repository;

import br.com.emazureck.spring_jpa_mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
