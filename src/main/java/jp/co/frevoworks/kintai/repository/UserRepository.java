package jp.co.frevoworks.kintai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.frevoworks.kintai.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  public User findByMailAddress(String mailAddress);

  public List<User> findByTenantId(Long tenantId);
}
