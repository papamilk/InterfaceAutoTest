package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MstbDynamicParam implements Serializable {
    private Integer mdpId;

    private Integer iemId;

    private Integer itdId;

    private String mdpName;

    private Byte mdpType;

    private String mdpFormula;

    private String mdpDescription;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Byte state;

    private String mdpValue;
}