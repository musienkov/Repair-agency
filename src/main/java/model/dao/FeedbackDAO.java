package model.dao;

import model.entity.Feedback;

import java.util.List;

public interface FeedbackDAO extends GenericDAO<Feedback>{
    public List<Feedback> findAllFeedbackByMasterId(long manager_id);
}
