package com.notification.backend.bulkNotificationService.backend.Service;


import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberService
{
    PhoneNumber createPhoneData(PhoneNumber phoneDTO) throws Exception;
    PhoneNumber updatePhoneData(PhoneNumber phoneDTO) throws Exception;
    PhoneNumber getPhoneData(long id) throws Exception;
    List<PhoneNumber> getALlPhoneData() throws Exception;
    List<PhoneNumber> getAllByCategory(Category category) throws Exception;
}
