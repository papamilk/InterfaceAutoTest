package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;
import blk.interfacetesting.service.data.TestDataDependencyService;
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
@RequestMapping("/dataDependency")
@RestController
@CrossOrigin(origins = "*")
public class TestDataDependencyController {
    private TestDataDependencyService testDataDependencyService;

    @Autowired
    public TestDataDependencyController(TestDataDependencyService testDataDependencyService) {
        this.testDataDependencyService = testDataDependencyService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<IftbTestDataDependency>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<IftbTestDataDependency>>(testDataDependencyService.getListWithItdName());
        }
        return new PageResultBean<List<IftbTestDataDependency>>(testDataDependencyService.getListWithItdName(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<IftbTestDataDependency> getOne(
            @NotNull(message = "{dataDependency.itddId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{dataDependency.itddId.illegal}") String itddId) {
        return new ResultBean<IftbTestDataDependency>(testDataDependencyService.query(Integer.parseInt(itddId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid IftbTestDataDependency testDataDependency, BindingResult result) {
        testDataDependencyService.add(testDataDependency);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("itddId", testDataDependency.getItddId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid IftbTestDataDependency testDataDependency, BindingResult result) {
        testDataDependencyService.update(testDataDependency);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid IftbTestDataDependency testDataDependency, BindingResult result) {
        IftbTestDataDependencyCriteria criteria = new IftbTestDataDependencyCriteria();
        criteria.createCriteria().andItddIdEqualTo(testDataDependency.getItddId());
        testDataDependencyService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("itddId", testDataDependency.getItddId());
        return new ResultBean<Map<String, Integer>>(map);
    }

}
