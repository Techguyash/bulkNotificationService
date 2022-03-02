package com.notification.backend.bulkNotificationService.test;

import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task2 implements Callable<Integer>
{
    public Task2()
    {
    }

    private int i;

    public Task2(int i)
    {
        this.i=i;
    }


    @Override
    public Integer call() throws Exception
    {
        return send(new EmailDTO());
    }

    public boolean send(String mail, String subject, String message, boolean htmlContent)
    {
        return false;
    }


    Task2 sender=null;

    public int send(EmailDTO emailDTO)  throws Exception
    {

        int count = 0;
        List<String> mailList = List.of("h","a","b");


        for (String mail : mailList)
        {
            if (sender.send(mail, emailDTO.getSubject(), emailDTO.getMessage(), emailDTO.isHtmlContent()))
            {
                count++;
            }
        }
        return count;
    }

}

class Main
{
    /*
    * ACb143121637bf54aa32446dac200fd4b3
    * c94ef52667f188027353ec189b24fc0f
    * +18624658551
    * */
    public static void main(String[] args) throws Exception
    {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        LocalTime time=LocalTime.now();
//        executorService.execute(new Task2(1));
//        executorService.execute(new Task2(2));
//        executorService.execute(new Task2(3));
//        executorService.execute(new Task2(4));
//        executorService.execute(new Task2(5));

        executorService.submit(new Task2());


        List<Task2> task2s = List.of(new Task2(1), new Task2(2), new Task2(3), new Task2(4), new Task2(5));
        executorService.invokeAll(task2s);


        executorService.shutdown();
        System.out.println("took :"+ Duration.between(time,LocalTime.now()).toSeconds());

    }

}
