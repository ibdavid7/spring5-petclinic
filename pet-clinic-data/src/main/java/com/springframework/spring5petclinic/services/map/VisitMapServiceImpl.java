package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Visit;
import com.springframework.spring5petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapServiceImpl extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getOwner().getId() == null || visit.getPet().getPetType() == null ||
                visit.getPet().getPetType().getId() == null) {
            throw new IllegalArgumentException("Using Transient Objects that are not persisted, persist transient " +
                    "objects first");
        }
        return super.save(visit);
    }

}
