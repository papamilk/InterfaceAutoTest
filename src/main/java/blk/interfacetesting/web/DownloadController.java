package blk.interfacetesting.web;

import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.component.TestDataFileValidator;
import blk.interfacetesting.service.common.DownloadService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.*;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/25
 */
@Validated
@RequestMapping(value = "/download")
@RestController
@CrossOrigin(origins = "*")
public class DownloadController {
    private TestDataFileValidator testDataFileValidator;

    private DownloadService downloadService;

    @Autowired
    public DownloadController(TestDataFileValidator testDataFileValidator, DownloadService downloadService) {
        this.testDataFileValidator = testDataFileValidator;
        this.downloadService = downloadService;
    }

    @RequestMapping(value = "/dataTemplate", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> downloadTemplate(HttpServletResponse response) {
        downloadService.getTemplate(response);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/testDataFile", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> downloadTestDataFile(HttpServletResponse response,
                                       @NotNull(message = "{project.mpId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{project.mpId.illegal}") String mpId,
                                       @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition","attachment; filename=data.xlsx");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        try {
            Workbook workbook = testDataFileValidator.validate(Integer.parseInt(mpId), Integer.parseInt(iemId));
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/resultReport", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultBean<Map<String, Object>> resultReport(HttpServletResponse response,
            @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        downloadService.generateResultReportExcel(Integer.parseInt(iemId), response);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/logFile", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultBean<Map<String, Object>> logFile(HttpServletResponse response) {
        downloadService.logFile(response);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }
}
