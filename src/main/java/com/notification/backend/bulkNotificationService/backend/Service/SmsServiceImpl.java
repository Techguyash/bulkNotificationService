package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.PhoneNumber;
import com.notification.backend.bulkNotificationService.backend.model.SmsDTO;
import com.notification.backend.bulkNotificationService.backend.model.SmsRequest;
import com.notification.backend.bulkNotificationService.backend.util.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmsServiceImpl implements SmsService
{
    @Autowired
    private  TwilioSmsService twilioSmsService;
    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private CategoryService categoryService;



    @Override
    public  List<String> sendSMS(SmsDTO smsDTO) throws  Exception
    {


        Category category = categoryService.findByName(smsDTO.getCategoryName());
        List<PhoneNumber> allNumber = phoneNumberService.getAllByCategory(category);

        int count=0;
        List<String> successNumber=new ArrayList<>();
        for(PhoneNumber phoneNumber : allNumber)
        {
            SmsRequest smsRequest=new SmsRequest(phoneNumber.getPhoneNumber(), smsDTO.getMessage());
            try
            {
                if(twilioSmsService.sendTwilioSMS(smsRequest))
                {
                    successNumber.add(phoneNumber.getPhoneNumber());
                }
            }
            catch (IllegalArgumentException e)
            {
                //TODO: failed handler
            }
        }


        return successNumber;
    }
}
