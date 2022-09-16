package qi.shen.service.serivceImpl;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import qi.shen.entity.Resource;
import qi.shen.service.ResourceService;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class ResourceImplTest {

    @Autowired
    ResourceService resourceService;

    @Test
    void findAll() {
        List<Resource> list = resourceService.findAll();
        ArrayList<Resource> rootList = new ArrayList<>();

        for (Resource resource : list) {
            if (resource.getParentId() == 0) {
                findChild(list, resource);
                rootList.add(resource);
            }
        }


        List<Resource> list1 = buildTree(list, 0);
        System.out.println("1");
    }


    private void  findChild(List<Resource> resourceList, Resource root) {
        ArrayList<Resource> children = new ArrayList<>();
        for (Resource resource : resourceList) {
            if (root.getId() == resource.getParentId()) {
                children.add(resource);
            }
        }
        if (children.size() == 0) {
            return;
        }
        root.setChildren(children);
        for (Resource child : children) {
            findChild(resourceList, child);
        }
    }

    private <T extends Resource> Map<Integer, List<T>> initTreeMap(List<T> root) {
        Map<Integer, List<T>> treeMap = new HashMap<>();
        for (T t : root) {
            if (treeMap.containsKey(t.getParentId())) {
                treeMap.get(t.getParentId()).add(t);
            } else {
                List<T> childList = new ArrayList<>();
                childList.add(t);
                treeMap.put(t.getParentId(), childList);
            }
        }
        return treeMap;
    }

    private <T extends Resource> List<T> assembleTreeList(Map<Integer, List<T>> map, Integer key) {
        List<T> rs = new ArrayList<T>();
        for (T r : map.get(key)) {
            rs.add(r);
            if (map.containsKey(r.getId())) {
                rs.addAll(assembleTreeList(map, r.getId()));
            }
        }
        return rs;
    }


    private List<Resource> buildTree(List<Resource> list, Integer parentId) {
        return list.stream().filter(a->a.getParentId() == parentId).map(a->{
            List<Resource> childList = buildTree(list, a.getId());
            if (childList != null && childList.size() > 0) {
                a.setChildren(childList);
            }
            return a;
        }).collect(Collectors.toList());
    }

    //递归查子菜单
//    private List<MenuTree> build(List<Menu> menuList, Integer parentId) {
//        return menuList.stream().filter(menu -> menu.getParentId().intValue() == parentId.intValue()).map(menu -> {
//            MenuTree menuTree = BeansUtil.convert(menu, MenuTree.class);
//            List<MenuTree> childList = build(menuList, menuTree.getId());
//            if (childList != null && childList.size() > 0) {
//                menuTree.setChildren(childList);
//            }
//            return menuTree;
//        }).collect(Collectors.toList());
//    }


}