package jp.co.frevoworks.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.co.frevoworks.kintai.dto.LoginUser;
import jp.co.frevoworks.kintai.entity.User;
import jp.co.frevoworks.kintai.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {

    if (StringUtils.isEmpty(mailAddress)) {
      throw new UsernameNotFoundException("mailaddress is empty");
    }

    User user = userRepository.findByMailAddress(mailAddress);

    // ユーザー情報を取得できなかった場合
    if (user == null) {
      throw new UsernameNotFoundException("User not found for login id: " + mailAddress);
    }

    // ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
    return new LoginUser(user);
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

}
