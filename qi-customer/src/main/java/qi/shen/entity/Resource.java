package qi.shen.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName t_resource
 */
@Data
public class Resource implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 1：菜单  2：目录  3:权限
     */
    private Integer type;

    /**
     * 
     */
    private String link;

    /**
     * 
     */
    private Integer idx;

    /**
     * 是否展示
     */
    private Integer isShow;

    /**
     * 
     */
    private String permissionCode;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

    List<Resource> children;

    private static final long serialVersionUID = 1L;


}