package com.sameer.utility;

import com.sameer.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<UserInfo,Integer> {
}
