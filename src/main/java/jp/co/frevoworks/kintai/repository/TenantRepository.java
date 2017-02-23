package jp.co.frevoworks.kintai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.frevoworks.kintai.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
