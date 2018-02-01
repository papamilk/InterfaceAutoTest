package blk.interfacetesting.modle.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TstbResultTestData implements Serializable {

    private Integer trtdId;

    private Integer itdId;

    private Integer truId;

    private String trtdName;

    private String trtdData;

    private String trtdDependName;

    private String trtdTime;

    private Integer trtdComparedResult;

    private String trtdErrorDescription;

    private String trtdErrorDetail;

    private String trtdStatusCode;

    private Integer trtdResult;

    private String trtdSqlExecuteResult;

    private String trtdSqlExpectResult;

    private Integer trtdSqlComparedResult;

    private String trtdStatus;

    private String trtdCreatetime;

    private String trtdCreateuser;

    private String trtdUpdatetime;

    private String trtdUpdateuser;

    private String trtdExecuteResult;

    private static final long serialVersionUID = 1L;
}