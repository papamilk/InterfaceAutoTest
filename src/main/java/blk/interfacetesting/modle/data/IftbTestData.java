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
public class IftbTestData implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{testData.itdId.illegal}")
    @Min(value = 1, message = "{testData.itdId.illegal}")
    private Integer itdId;

    @Digits(integer = 11, fraction = 0, message = "{executeMain.iemId.illegal}")
    @Min(value = 1, message = "{executeMain.iemId.illegal}")
    private Integer iemId;

    @Digits(integer = 11, fraction = 0, message = "{urlManagement.mumId.illegal}")
    @Min(value = 1, message = "{urlManagement.mumId.illegal}")
    private Integer mumId;

    @Digits(integer = 11, fraction = 0, message = "{testCase.mtcId.illegal}")
    @Min(value = 1, message = "{testCase.mtcId.isnull}")
    private Integer mtcId;

    @NotBlank(message = "{testData.itdNumber.illegal}")
    private String itdNumber;

    @NotBlank(message = "{testData.itdName.illegal}")
    private String itdName;

    @NotBlank(message = "{testData.itdCols.illegal}")
    private String itdCols;

    @NotBlank(message = "{testData.itdValues.illegal}")
    private String itdValues;

    @NotBlank(message = "{testData.itdParamTypes.illegal}")
    private String itdParamTypes;

    private Integer itdType;

    private Integer itdExpectTime;

    @NotBlank(message = "{testData.itdExpectResult.illegal}")
    private String itdExpectResult;

    private String itdExpectResultType;

    private String itdSql;

    private String itdSqlExpectResult;

    private String itdStatus;

    private String itdCreatetime;

    private String itdCreateuser;

    private String itdUpdatetime;

    private String itdUpdateuser;

    private String mumName;

    private String mtcName;

    private String mdpName;

    private String mdpFormula;

    /**
     * 依赖数据对象,add by Saul
     *
     */
    private String itddddependency;

}