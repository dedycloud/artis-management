package com.enigma.spesification;

import com.enigma.entity.Artist;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class ArtistSpesification {
    public static Specification<Artist> findByCriterias(Artist artist){
        return new Specification<Artist>() {
            @Override
            public Predicate toPredicate(Root<Artist> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();
                if(!StringUtils.isEmpty(artist.getName())){
                    final Predicate namenamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+artist.getName()+"%");
                    predicates.add(namenamePredicate);
                }
                if(!StringUtils.isEmpty(artist.getBornPlace())){
                    final Predicate quantityPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("quantity")),"%"+artist.getBornPlace()+"%");
                    predicates.add(quantityPredicate);
                }
                if(!StringUtils.isEmpty(artist.getDebut())){
                    final Predicate quantityPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("quantity")),"%"+artist.getDebut()+"%");
                    predicates.add(quantityPredicate);
                }
                return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}
