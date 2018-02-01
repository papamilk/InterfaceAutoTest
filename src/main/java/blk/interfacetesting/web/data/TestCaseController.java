package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import blk.interfacetesting.service.data.TestCaseService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/22
 */
@Validated
@RequestMapping("/testCase")
@RestController
@CrossOrigin(origins = "*")
public class TestCaseController {
    private TestCaseService testCaseService;

    @Autowired
    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<MstbTestCase>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<MstbTestCase>>(testCaseService.getList());
        }

        return new PageResultBean<List<MstbTestCase>>(testCaseService.getList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<MstbTestCase> getOne(
            @NotNull(message = "{testCase.mtcId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{testCase.mtcId.illegal}") String mtcId) {
        return new ResultBean<MstbTestCase>(testCaseService.query(Integer.parseInt(mtcId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid MstbTestCase testCase, BindingResult result) {
        testCaseService.add(testCase);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mtcId", testCase.getMtcId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid MstbTestCase testCase, BindingResult result) {
        testCaseService.update(testCase);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid MstbTestCase testCase, BindingResult result) {
        MstbTestCaseCriteria criteria = new MstbTestCaseCriteria();
        criteria.createCriteria().andMtcIdEqualTo(testCase.getMtcId());
        testCaseService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mtcId", testCase.getMtcId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, String>> checkName(@NotBlank(message = "{testCase.mtcName.illegal}") String mtcName) {
        boolean result = testCaseService.checkName(mtcName);
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("valid", "true");
        } else {
            map.put("valid", "false");
        }
        return new ResultBean<Map<String, String>>(map);
    }
}
