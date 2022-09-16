package qi.shen.dao;

import org.springframework.stereotype.Repository;
import qi.shen.entity.Resource;

import java.util.List;

@Repository
public interface ResourceDao {

    List<Resource> findAll();
}
