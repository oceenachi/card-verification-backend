package com.velatech.cardverifier.repository;

import com.velatech.cardverifier.model.CardInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {

    //check distinct
    @Query("SELECT v.cardNum AS cardNum, COUNT(v.cardNum) AS count FROM CardInfo v GROUP BY v.cardNum")
    Page<Map<String, Object>> getUniqueCards(Pageable pageable);

}
