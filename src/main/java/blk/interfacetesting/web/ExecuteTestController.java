package blk.interfacetesting.web;

import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.common.CmtbAttachment;
import blk.interfacetesting.service.IBaseService;
import blk.interfacetesting.service.common.AttachmentService;
import blk.interfacetesting.service.common.ExecuteTestService;
import blk.interfacetesting.service.common.ParseDataFileService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/16
 */
@Validated
@RequestMapping(value = "/executeTest")
@RestController
@CrossOrigin(origins = "*")
public class ExecuteTestController {
    private AttachmentService attachmentService;

    private ParseDataFileService parseDataFileService;

    private ExecuteTestService executeTestService;

    @Autowired
    public ExecuteTestController(ParseDataFileService parseDataFileService, ExecuteTestService executeTestService, AttachmentService attachmentService) {
        this.parseDataFileService = parseDataFileService;
        this.executeTestService = executeTestService;
        this.attachmentService = attachmentService;
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> execute(
            @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        executeTestService.execute(Integer.parseInt(iemId));
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/dbInit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> dbInit(@NotBlank(message = "{executeTest.dataBaseName.illegal}") String dataBaseName) {
        parseDataFileService.dbInit(dataBaseName);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/parseDataFile", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> parseDataFile(@RequestPart("fileData") MultipartFile file, String isOverWrite) {
        if (null == file) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("errorCode", "file.isnull");
            map.put("errorMsg", "文件不为空");
            return ResultBean.fail(map);
        }
        CmtbAttachment attachment = attachmentService.save(file);
        Map<String, Object> resultMap = parseDataFileService.parseDataFile(file, StringUtils.equals(isOverWrite, "true"));
        return new ResultBean<Map<String, Object>>(resultMap);
    }

    @RequestMapping(value = "/totalTestDataCount", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Integer> findTotalTestDataCount(
            @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        return new ResultBean<Integer>(executeTestService.findTotalTestDataCount(Integer.parseInt(iemId)));
    }

    @RequestMapping(value = "/executedTestDataCount", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Integer> findExecutedDataCount(
            @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        return new ResultBean<Integer>(executeTestService.findExecutedDataCount(Integer.parseInt(iemId)));
    }

    @RequestMapping(value = "/validateExpectResult", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<String> validateExpectResult(
            @NotNull(message = "{executeTest.expectResult.illegal}") String expectResult) {
        return new ResultBean<String>(parseDataFileService.validateExpectResult(expectResult));

    }
}
