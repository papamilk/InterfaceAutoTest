package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;
import blk.interfacetesting.service.data.ExecuteMainService;
import org.apache.commons.collections.CollectionUtils;
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
@RequestMapping("/executeMain")
@RestController
@CrossOrigin(origins = "*")
public class ExecuteMainController {
    private ExecuteMainService executeMainService;

    @Autowired
    public ExecuteMainController(ExecuteMainService executeMainService) {
        this.executeMainService = executeMainService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<IftbExecuteMain>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<IftbExecuteMain>>(executeMainService.getListWithMpName());
        }
        return new PageResultBean<List<IftbExecuteMain>>(executeMainService.getListWithMpName(Integer.parseInt(begin), Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<IftbExecuteMain> getOne(
            @NotNull(message = "{executeMain.iemId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{executeMain.iemId.illegal}") String iemId) {
        return new ResultBean<IftbExecuteMain>(executeMainService.query(Integer.parseInt(iemId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid IftbExecuteMain executeMain, BindingResult result) {
        executeMainService.add(executeMain);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("iemId", executeMain.getIemId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid IftbExecuteMain executeMain, BindingResult result) {
        executeMainService.update(executeMain);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid IftbExecuteMain executeMain, BindingResult result) {
        IftbExecuteMainCriteria criteria = new IftbExecuteMainCriteria();
        criteria.createCriteria().andIemIdEqualTo(executeMain.getIemId());
        executeMainService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("iemId", executeMain.getIemId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, String>> checkName(@NotBlank(message = "{executeMain.iemName.illegal}") String iemName) {
        boolean result = executeMainService.checkName(iemName);
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("valid", "true");
        } else {
            map.put("valid", "false");
        }
        return new ResultBean<Map<String, String>>(map);
    }
}
