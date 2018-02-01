package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IftbExecuteMain implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{executeMain.iemId.illegal}")
    @Min(value = 1, message = "{executeMain.iemId.illegal}")
    private Integer iemId;

    @Digits(integer = 11, fraction = 0, message = "{project.mpId.illegal}")
    @Min(value = 1, message = "{project.mpId.illegal}")
    private Integer mpId;

    @NotBlank(message = "{executeMain.urlPrefix.illegal}")
    private String urlPrefix;

    private String cSystem;

    private String description;

    private String codeVersion;

    @NotBlank(message = "{executeMain.iemName.illegal}")
    private String iemName;

    private String iemType;

    private String iemCode;

    private Integer iemStatus;

    private String iemCreatetime;

    private String iemCreateuser;

    private String iemUpdatetime;

    private String iemUpdateuser;

    private String mpName;

    private static final long serialVersionUID = 1L;
}