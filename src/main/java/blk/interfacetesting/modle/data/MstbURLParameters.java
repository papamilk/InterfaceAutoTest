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
public class MstbURLParameters implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{urlParam.mupId.illegal}")
    @Min(value = 1, message = "{urlParam.mupId.illegal}")
    private Integer mupId;

    @Digits(integer = 11, fraction = 0, message = "{urlManagement.mumId.illegal}")
    @Min(value = 1, message = "{urlManagement.mumId.illegal}")
    private Integer mumId;

    @NotBlank(message = "{urlParam.mupName.illegal}")
    private String mupName;

    @NotBlank(message = "{urlParam.mupType.illegal}")
    private String mupType;

    private String mupDescription;

    private String mupStatus;

    private String mupCreatetime;

    private String mupCreateuser;

    private String mupUpdatetime;

    private String mupUpdateuser;

    private static final long serialVersionUID = 1L;
}