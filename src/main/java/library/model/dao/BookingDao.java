package library.model.dao;

import library.exceptions.DaoException;
import library.model.entities.Booking;

import java.util.List;

/**
 * Functions specific to Booking class
 */
public interface BookingDao extends AbstractSuperDao<Booking> {
    List<Booking> findDeliveredByUserID(long id) throws DaoException;
}