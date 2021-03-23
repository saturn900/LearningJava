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

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) { // выглядит нормально, надо только правильно прописать ComponentScan чтобы этот контроллер инициализировался
        // прием выглядит нормально, должен принмиать, можно проверить утилитой curl, но можно и не проверять, а сразу из трекера кидать, или смотрите видео :)
        long current = System.currentTimeMillis();
        logger.info((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        FileService.writeInFile((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        return point;
    }

    //можно добавить метод с аннотацией PostConstruct и в нем вывод в лог, чтобы проверить что данный контроллер инициализируется спрингом
}
