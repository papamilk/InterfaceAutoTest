package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import blk.interfacetesting.service.data.URLManagementService;
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
@RequestMapping("/url")
@RestController
@CrossOrigin(origins = "*")
public class URLManagementController {
    private URLManagementService urlManagementService;

    @Autowired
    public URLManagementController(URLManagementService urlManagementService) {
        this.urlManagementService = urlManagementService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<MstbURLManagement>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<MstbURLManagement>>(urlManagementService.getList());
        }
        return new PageResultBean<List<MstbURLManagement>>(urlManagementService.getList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<MstbURLManagement> getOne(
            @NotNull(message = "{urlManagement.mumId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{urlManagement.mumId.illegal}") String mumId) {
        return new ResultBean<MstbURLManagement>(urlManagementService.query(Integer.parseInt(mumId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid MstbURLManagement urlManagement, BindingResult result) {
        urlManagementService.add(urlManagement);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mumId", urlManagement.getMumId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid MstbURLManagement urlManagement, BindingResult result) {
        urlManagementService.update(urlManagement);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid MstbURLManagement urlManagement, BindingResult result) {
        MstbURLManagementCriteria criteria = new MstbURLManagementCriteria();
        criteria.createCriteria().andMumIdEqualTo(urlManagement.getMumId());
        urlManagementService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mumId", urlManagement.getMumId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, String>> checkName(@NotBlank(message = "{urlManagement.mumName.illegal}") String mumName) {
        boolean result = urlManagementService.checkName(mumName);
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("valid", "true");
        } else {
            map.put("valid", "false");
        }
        return new ResultBean<Map<String, String>>(map);
    }
}
