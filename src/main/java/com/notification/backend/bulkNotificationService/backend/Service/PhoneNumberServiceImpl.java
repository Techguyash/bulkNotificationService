package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.PhoneNumber;
import com.notification.backend.bulkNotificationService.backend.repo.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService
{
    PhoneNumberRepo phoneNumberRepo;

    @Autowired
    public PhoneNumberServiceImpl(PhoneNumberRepo phoneNumberRepo)
    {
        this.phoneNumberRepo = phoneNumberRepo;
    }

    @Override
    public PhoneNumber createPhoneData(PhoneNumber phoneDTO) throws Exception
    {
        return phoneNumberRepo.save(phoneDTO);

    }

    @Override
    public PhoneNumber updatePhoneData(PhoneNumber phoneDTO) throws Exception
    {
        return phoneNumberRepo.save(phoneDTO);
    }

    @Override
    public PhoneNumber getPhoneData(long id) throws Exception
    {
        return phoneNumberRepo.findById(id).get();
    }

    @Override
    public List<PhoneNumber> getALlPhoneData() throws Exception
    {
        return phoneNumberRepo.findAll();
    }

    @Override
    public List<PhoneNumber> getAllByCategory(Category category) throws Exception
    {
        return phoneNumberRepo.findAllBycategory(category);
    }
}
