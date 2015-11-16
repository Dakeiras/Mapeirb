package com.example.enseirb.timtim.mapeirb.dao;

import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;

public interface IPOICollectionDAO {
    void retrievePOICollection(final IPOICollectionDAOListener listener);
}
