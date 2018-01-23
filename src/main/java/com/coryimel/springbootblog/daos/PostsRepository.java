package com.coryimel.springbootblog.daos;

import com.coryimel.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post,Long> {

}
