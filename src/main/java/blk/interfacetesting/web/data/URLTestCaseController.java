package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;
import blk.interfacetesting.service.data.URLTestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/urlTestCase")
@RestController
@CrossOrigin(origins = "*")
public class URLTestCaseController {
    private URLTestCaseService urlTestCaseService;

    @Autowired
    public URLTestCaseController(URLTestCaseService urlTestCaseService) {
        this.urlTestCaseService = urlTestCaseService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<IftbURLTestCase>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<IftbURLTestCase>>(urlTestCaseService.getList());
        }
        return new PageResultBean<List<IftbURLTestCase>>(urlTestCaseService.getList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<IftbURLTestCase> getOne(
            @NotNull(message = "{urlTestCase.iutcId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{urlTestCase.iutcId.illegal}") String iutcId) {
        return new ResultBean<IftbURLTestCase>(urlTestCaseService.query(Integer.parseInt(iutcId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(IftbURLTestCase urlTestCase) {
        urlTestCaseService.add(urlTestCase);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("iutcId", urlTestCase.getIutcId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(IftbURLTestCase urlTestCase) {
        urlTestCaseService.update(urlTestCase);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(IftbURLTestCase urlTestCase) {
        IftbURLTestCaseCriteria criteria = new IftbURLTestCaseCriteria();
        criteria.createCriteria().andIutcIdEqualTo(urlTestCase.getIutcId());
        urlTestCaseService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("iutcId", urlTestCase.getIutcId());
        return new ResultBean<Map<String, Integer>>(map);
    }
}
