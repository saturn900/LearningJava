package jdev.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Егор on 25.11.2017.
 */
@RestController
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    private long previous;

    @Autowired
    FileService FileService;

    @RequestMapping(value = "points", method = RequestMethod.POST)
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        long current = System.currentTimeMillis();
        //log.info((current - previous) + dataPeekService.take().toJson());
        //previous = current;
        logger.info((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        FileService.writeInFile((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        return point;
    }
}
