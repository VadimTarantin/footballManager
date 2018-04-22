package com.football.manager.controller.prediction;

import com.football.manager.dto.input.InputDataForTaskFromForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PredictionController {

    public static final String PAGE_ADD_DATA_FOR_PREDICTION = "predictions/addDataForPredictions";
    private static final String SUCCESS = "Все получилось";
    private static final String FAIL = "Что-то пошло не так, попробуйте еще раз";

    @RequestMapping(path = "addDataForPredictions", method = RequestMethod.GET)
    public String getPageForAddDataForPrediction(ModelMap modelMap) {
        modelMap.put("inputDataForTaskFromForm", new InputDataForTaskFromForm());
        return PAGE_ADD_DATA_FOR_PREDICTION;
    }

    @RequestMapping(path = "addDataForPredictions", method = RequestMethod.POST)
    public String postFromPageDataForPrediction(@Valid @ModelAttribute("inputDataForTaskFromForm") InputDataForTaskFromForm inputDataForTaskFromForm,
                                                BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.put("answer", FAIL);
        } else {
            modelMap.put("answer", SUCCESS);
            modelMap.put("inputDataForTaskFromForm", new InputDataForTaskFromForm());
        }
        return PAGE_ADD_DATA_FOR_PREDICTION;
    }

}