package com.StatefulApplication.StatefulApplication.repository;

import com.StatefulApplication.StatefulApplication.model.RegistrationUser;
import com.StatefulApplication.StatefulApplication.model.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<RegistrationUser,Integer> {
    @Query("select s.gmail from RegistrationUser s where s.gmail = ?1")
    String findByUserGmail(String gmail);
    @Query("select s.password from RegistrationUser s where s.password=?1")
    String  findByUserpassword(String password);
    @Modifying
    @Transactional
    @Query("UPDATE RegistrationUser r SET r.uuid =:uuid WHERE r.gmail =:gmail")
    int updateUuid (@Param("uuid") String uuid, @Param("gmail") String gmail);
    @Query("select s.uuid from RegistrationUser s where s.uuid = ?1")
    String  findByuserUuid(String uuid);
    @Modifying
    @Transactional
    @Query("update RegistrationUser r  set r.uuid = null where r.uuid = uuid")
    int updateuuid (String uuid );
}
