package jp.co.frevoworks.kintai.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String userName;
  @Column
  private String mailAddress;
  @Column
  private String password;
  @Column
  private String lineId;

  @ManyToOne
  private Tenant tenant;

  public User() {

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  public String getPassword() {
    // TODO 自動生成されたメソッド・スタブ
    return password;
  }

  @Override
  public String getUsername() {
    // TODO 自動生成されたメソッド・スタブ
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO 自動生成されたメソッド・スタブ
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO 自動生成されたメソッド・スタブ
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO 自動生成されたメソッド・スタブ
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO 自動生成されたメソッド・スタブ
    return true;
  }
}
