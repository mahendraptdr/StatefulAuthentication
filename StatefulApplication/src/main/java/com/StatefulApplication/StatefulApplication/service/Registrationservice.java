package com.StatefulApplication.StatefulApplication.service;

import com.StatefulApplication.StatefulApplication.model.RegistrationUser;
import com.StatefulApplication.StatefulApplication.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Registrationservice {
    @Autowired
    ProjectRepo repo;
    public void register(RegistrationUser users)
    {
        repo.save(users);
    }
}
