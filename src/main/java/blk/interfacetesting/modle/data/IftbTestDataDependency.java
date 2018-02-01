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
public class IftbTestDataDependency implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{dataDependency.itddId.illegal}")
    @Min(value = 1, message = "{dataDependency.itddId.illegal}")
    private Integer itddId;

    @Digits(integer = 11, fraction = 0, message = "{testData.itdId.illegal}")
    @Min(value = 1, message = "{testData.itdId.illegal}")
    private Integer itdId;

    @NotBlank(message = "{dataDependency.itddDependency.illegal}")
    private String itddDependency;

    private String itddType;

    private String itddStatus;

    private String itddCreatetime;

    private String itddCreateuser;

    private String itddUpdatetime;

    private String itddUpdateuser;

    private String itdName;

    private static final long serialVersionUID = 1L;
}