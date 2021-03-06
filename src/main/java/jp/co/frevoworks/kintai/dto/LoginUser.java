package jp.co.frevoworks.kintai.dto;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.frevoworks.kintai.entity.User;

public class LoginUser extends org.springframework.security.core.userdetails.User {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * ログインユーザー
   */
  private final User user;

  /**
   * コンストラクタ
   * 
   * @param user
   */
  public LoginUser(User user) {
    // スーパークラスのユーザーID、パスワードに値をセットする
    // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
    super(user.getMailAddress(), user.getPassword(),
        AuthorityUtils.createAuthorityList("ROLE_USER"));
    this.user = user;
  }

  /**
   *
   * @return
   */
  public User getUser() {
    return user;
  }
}
