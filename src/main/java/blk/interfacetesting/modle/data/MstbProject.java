package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MstbProject implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{project.mpId.illegal}")
    @Min(value = 1, message = "{project.mpId.illegal}")
    private Integer mpId;

    @NotBlank(message = "{project.mpName.illegal}")
    private String mpName;

    private String mpDescription;

    private String mpUrlPrefixion;

    private String mpStatus;

    private String mpCreatetime;

    private String mpCreateuser;

    private String mpUpdatetime;

    private String mpUpdateuser;

    private static final long serialVersionUID = 1L;
}