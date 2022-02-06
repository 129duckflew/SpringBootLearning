package cn.duckflew.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleId;

    private Integer permissionId;


}
