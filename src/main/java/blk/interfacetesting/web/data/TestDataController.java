package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;
import blk.interfacetesting.service.data.TestDataService;
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
 * @date 2018/1/18
 */
@Validated
@RequestMapping("/testData")
@RestController
@CrossOrigin(origins = "*")
public class TestDataController {
    private TestDataService testDataService;

    @Autowired
    public TestDataController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<IftbTestData>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<IftbTestData>>(testDataService.specialSearchList());
        }
        return new PageResultBean<List<IftbTestData>>(testDataService.specialSearchList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<IftbTestData> getOne(
            @NotNull(message = "{testData.itdId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{testData.itdId.illegal}") String itdId) {
        return new ResultBean<IftbTestData>(testDataService.query(Integer.parseInt(itdId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid IftbTestData testData, BindingResult result) {
        testDataService.add(testData);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("itdId", testData.getItdId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid IftbTestData testData, BindingResult result) {
        testDataService.update(testData);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid IftbTestData testData, BindingResult result) {
        IftbTestDataCriteria criteria = new IftbTestDataCriteria();
        criteria.createCriteria().andItdIdEqualTo(testData.getItdId());
        testDataService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("itdId", testData.getItdId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, String>> checkName(@NotBlank(message = "{urlManagement.itdName.illegal}") String itdName) {
        boolean result = testDataService.checkName(itdName);
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("valid", "true");
        } else {
            map.put("valid", "false");
        }
        return new ResultBean<Map<String, String>>(map);
    }

    @RequestMapping(value = "/getListByMtcId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<IftbTestData>> getListByMtcId(
            @NotNull(message = "{testCase.mtcId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{testCase.mtcId.illegal}") String mtcId) {
        return new PageResultBean<List<IftbTestData>>(testDataService.getListByMtcId(Integer.parseInt(mtcId)));
    }
}
