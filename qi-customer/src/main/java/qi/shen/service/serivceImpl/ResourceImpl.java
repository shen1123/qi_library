package qi.shen.service.serivceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qi.shen.dao.ResourceDao;
import qi.shen.entity.Resource;
import qi.shen.service.ResourceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ResourceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    private <T extends Resource> Map<Integer, List<T>> initTreeMap(List<T> root) {
        Map<Integer, List<T>> treeMap = new HashMap<>();
        for (T t : root) {
            if (treeMap.containsKey(t.getId())) {
                treeMap.get(t.getId()).add(t);
            } else {
                List<T> childList = new ArrayList<>();
                treeMap.put(t.getId(), childList);
            }
        }
        return treeMap;
    }

}
