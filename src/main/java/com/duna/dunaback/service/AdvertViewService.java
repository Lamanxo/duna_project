package com.duna.dunaback.service;

import com.duna.dunaback.entities.AdvertView;
import com.duna.dunaback.enums.AdvertType;
import com.duna.dunaback.exceptions.notfound.NotFoundException;
import com.duna.dunaback.repositories.AdvertViewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertViewService {
    private final AdvertViewRepo advertViewRepo;

    public AdvertView getAdvertViewByIdAndType(Long advertId, AdvertType advertType) {
        return findAdvertViewOrException(advertId, advertType);
    }

    public void incrementView(Long advertId, AdvertType advertType) {
        AdvertView advertView = getAdvertViewByIdAndType(advertId, advertType);
        advertView.setViewsCount(advertView.getViewsCount() + 1);
        advertViewRepo.save(advertView);
    }

    public Long getViewsByAdvertIdAndType(Long advertId, AdvertType advertType) {
        return advertViewRepo.countAdvertViewByAdvertIdAndAdvertType(advertId,advertType);
    }

    public void addNewAdvertView(Long advertId, AdvertType advertType) {
        AdvertView advertView = new AdvertView();
        advertView.setAdvertId(advertId);
        advertView.setAdvertType(advertType);
        advertView.setViewsCount(1L);
        advertViewRepo.save(advertView);
    }

    private AdvertView findAdvertViewOrException(Long advertId, AdvertType advertType) {
        return advertViewRepo.findByAdvertIdAndAdvertType(advertId, advertType).orElseThrow(() ->
                new NotFoundException("Views info not found"));
    }
}
