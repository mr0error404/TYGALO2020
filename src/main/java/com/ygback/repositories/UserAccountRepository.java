package com.ygback.repositories;

import com.ygback.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>
{
    UserAccount findUserAccountByPhoneNumber(String phoneNumber);

}
