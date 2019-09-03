package com.alocar.backend.persistance.dao;

import com.alocar.backend.persistance.model.FavoriteSongs;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Andrei Vatavu on 9/3/2019
 */

public interface FavoriteSongsRepository extends CrudRepository<FavoriteSongs, Integer> {

    List<FavoriteSongs> findByUserId(String userId);

}
