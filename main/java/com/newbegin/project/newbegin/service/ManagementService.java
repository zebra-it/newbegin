package com.newbegin.project.newbegin.service;

import com.newbegin.project.newbegin.repository.PostRepository;
import com.newbegin.project.newbegin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;



}
