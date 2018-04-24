package com.football.manager.controller.prediction;

import com.football.manager.dto.input.InputDataForTaskFromForm;
import com.football.manager.service.domain.TaskService;
import com.football.manager.service.domain.exception.TaskServiceException;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PredictionController {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    public static final String PAGE_ADD_DATA_FOR_PREDICTION = "predictions/addDataForPredictions";
    private static final String SUCCESS = "Все получилось";
    private static final String FAIL = "Что-то пошло не так, попробуйте еще раз";

    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "addDataForPredictions", method = RequestMethod.GET)
    public String getPageForAddDataForPrediction(ModelMap modelMap) {
        modelMap.put("inputDataForTaskFromForm", new InputDataForTaskFromForm());
        return PAGE_ADD_DATA_FOR_PREDICTION;
    }

    @RequestMapping(path = "addDataForPredictions", method = RequestMethod.POST)
    public String postFromPageDataForPrediction(@Valid @ModelAttribute("inputDataForTaskFromForm") InputDataForTaskFromForm inputDataForTaskFromForm,
                                                BindingResult bindingResult, ModelMap modelMap) {
        String answer;
        String errorMessage = null;
        if (bindingResult.hasErrors()) {
            answer = FAIL;
        } else {
            try {
                taskService.addTask(inputDataForTaskFromForm);
                answer = SUCCESS;
            } catch (TaskServiceException e) {
                log.info("Cannot insert data for new task: ", e);
                answer = FAIL;
                errorMessage = e.getMessage();
                modelMap.put("errorMessage", errorMessage);
            }
            modelMap.put("inputDataForTaskFromForm", new InputDataForTaskFromForm());
        }
        modelMap.put("answer", answer);
        return PAGE_ADD_DATA_FOR_PREDICTION;
    }

}