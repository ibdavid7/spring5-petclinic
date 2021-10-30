package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Specialty;
import com.springframework.spring5petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapServiceImpl extends AbstractMapService<Specialty, Long>
        implements SpecialityService {

}
