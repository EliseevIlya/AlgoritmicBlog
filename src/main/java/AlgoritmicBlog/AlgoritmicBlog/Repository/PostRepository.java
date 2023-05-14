package AlgoritmicBlog.AlgoritmicBlog.Repository;

import AlgoritmicBlog.AlgoritmicBlog.BD.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}

