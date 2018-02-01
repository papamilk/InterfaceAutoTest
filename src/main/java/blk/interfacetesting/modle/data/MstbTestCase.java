package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MstbTestCase implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{testCase.mtcId.illegal}")
    @Min(value = 1, message = "{testCase.mtcId.illegal}")
    private Integer mtcId;

    @Digits(integer = 11, fraction = 0, message = "{project.mpId.illegal}")
    @Min(value = 1, message = "{project.mpId.illegal}")
    private Integer mpId;

    @Min(value = 0, message = "{testCase.stopTime.illegal}")
    private Integer stopTime;

    @NotBlank(message = "{testCase.mtcNumber.illegal}")
    private String mtcNumber;

    @NotBlank(message = "{testCase.mtcName.illegal}")
    private String mtcName;

    private String mtcDependency;

    private Integer mtcType;

    private String mtcStatus;

    private String mtcCreatetime;

    private String mtcCreateuser;

    private String mtcUpdatetime;

    private String mtcUpdateuser;

    private static final long serialVersionUID = 1L;
}