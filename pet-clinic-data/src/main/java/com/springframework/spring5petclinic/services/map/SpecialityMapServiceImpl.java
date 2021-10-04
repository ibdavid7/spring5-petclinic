package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Specialty;
import com.springframework.spring5petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapServiceImpl extends AbstractMapService<Specialty, Long>
        implements SpecialityService {

}
