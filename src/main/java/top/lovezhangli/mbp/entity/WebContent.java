package top.lovezhangli.mbp.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xu He
 * @since 2021-05-06
 */
@Validated
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Accessors(chain = true)
@TableName("tb_content")
public class WebContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotBlank(message = "内容类型不能为空")
    private String contentType;

    @NotBlank(message = "内容不能为空")
    private String content;

    private Integer published;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
