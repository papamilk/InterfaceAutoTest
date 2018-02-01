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
public class MstbURLManagement implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{urlManagement.mumId.illegal}")
    @Min(value = 1, message = "{urlManagement.mumId.illegal}")
    private Integer mumId;

    @Digits(integer = 11, fraction = 0, message = "{project.mpId.illegal}")
    @Min(value = 1, message = "{project.mpId.illegal}")
    private Integer mpId;

    @Digits(integer = 11, fraction = 0, message = "{executeMain.iemId.illegal}")
    @Min(value = 1, message = "{executeMain.iemId.illegal}")
    private Integer iemId;

    @Digits(integer = 11, fraction = 0, message = "{testCase.mtcId.illegal}")
    @Min(value = 1, message = "{testCase.mtcId.illegal}")
    private Integer mtcId;

    @NotBlank(message = "{urlManagement.mumNumber.illegal}")
    private String mumNumber;

    @NotBlank(message = "{urlManagement.mumName.illegal}")
    private String mumName;

    private Double mumOrder;

    @NotBlank(message = "{urlManagement.mumUrlPath.illegal}")
    private String mumUrlPath;

    @NotBlank(message = "{urlManagement.mumNumber.illegal}")
    private String mumMethodType;

    private String mumStatusCode;

    private String mumStatus;

    private String mumCreatetime;

    private String mumCreateuser;

    private String mumUpdatetime;

    private String mumUpdateuser;
}