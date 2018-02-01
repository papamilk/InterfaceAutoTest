package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.MstbURLParameters;
import blk.interfacetesting.modle.data.MstbURLParametersCriteria;
import blk.interfacetesting.service.data.URLParameterService;
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
@RequestMapping("/urlParam")
@RestController
@CrossOrigin(origins = "*")
public class URLParameterController {
    private URLParameterService urlParameterService;

    @Autowired
    public URLParameterController(URLParameterService urlParameterService) {
        this.urlParameterService = urlParameterService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<MstbURLParameters>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<MstbURLParameters>>(urlParameterService.getList());
        }
        return new PageResultBean<List<MstbURLParameters>>(urlParameterService.getList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<MstbURLParameters> getOne(
            @NotNull(message = "{urlParam.mupId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{urlParam.mupId.illegal}") String mupId) {
        return new ResultBean<MstbURLParameters>(urlParameterService.query(Integer.parseInt(mupId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid MstbURLParameters urlParameters, BindingResult result) {
        urlParameterService.add(urlParameters);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mupId", urlParameters.getMupId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid MstbURLParameters urlParameters, BindingResult result) {
        urlParameterService.update(urlParameters);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid MstbURLParameters urlParameters, BindingResult result) {
        MstbURLParametersCriteria criteria = new MstbURLParametersCriteria();
        criteria.createCriteria().andMupIdEqualTo(urlParameters.getMupId());
        urlParameterService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mupId", urlParameters.getMupId());
        return new ResultBean<Map<String, Integer>>(map);
    }
}
