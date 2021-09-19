package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    public Map<Long, T> map = new HashMap<>();

    public void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        return object;
    }

    private Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1L;
        } catch (Exception e) {
            nextId = 1L;
            e.printStackTrace();
        }

        return nextId;
    }

}
