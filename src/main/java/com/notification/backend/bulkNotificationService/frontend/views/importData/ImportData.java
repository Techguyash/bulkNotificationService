package com.notification.backend.bulkNotificationService.frontend.views.importData;

import com.notification.backend.bulkNotificationService.backend.Service.FileUploader;
import com.notification.backend.bulkNotificationService.frontend.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

@Route(value = ImportData.ROUTE,layout = MainLayout.class)
@RouteAlias(value = "",layout = MainLayout.class)
public class ImportData extends VerticalLayout
{
    public  static final String ROUTE="importdata";
    public static final String TITLE="Import Data";

    @Autowired
    FileUploader fileUploader;

    public ImportData() {
        final InputStream[] inputStream = new InputStream[1];
        try {
            TextField category = new TextField("Category");
            category.setRequired(true);
            category.setErrorMessage("Category name contain min 3 characters");
            category.setAutofocus(true);
            category.setRequiredIndicatorVisible(true);
            category.setClearButtonVisible(true);
            category.setMinLength(3);
            TextField descriptionFld = new TextField("Description");

            descriptionFld.setRequiredIndicatorVisible(true);
            descriptionFld.setClearButtonVisible(true);
            descriptionFld.setMinLength(3);
            descriptionFld.setErrorMessage("Mandatory field must contain 3 characters");

            MemoryBuffer memoryBuffer = new MemoryBuffer();
            Upload uploadFileComponent = new Upload(memoryBuffer);
            uploadFileComponent.setDropAllowed(true);
            uploadFileComponent.setAutoUpload(true);
            uploadFileComponent.setDropLabel(new H6("Drop your file here"));
            uploadFileComponent.addSucceededListener(succeededEvent -> {
                inputStream[0] = memoryBuffer.getInputStream();
            });

            Button uploadButton = new Button("Upload");
            uploadButton.addClickListener(buttonClick -> {
                try {
                    int fileData = fileUploader.getFileData(inputStream[0], category.getValue());
                    if(fileData>0)
                    {

                        category.setValue("");
                        category.setInvalid(false);
                        descriptionFld.setValue("");
                        descriptionFld.setInvalid(false);
                        uploadSuccess(uploadFileComponent,memoryBuffer,fileData);
                    }
                } catch (IOException e)
                {
                    Notification.show("Records uploaded Failed",5, Notification.Position.BOTTOM_CENTER);
                    e.printStackTrace();
                }
            });
            add(new VerticalLayout(category,descriptionFld,uploadFileComponent,uploadButton));

        }

       catch (Exception e)
       {
           Notification.show("Records uploaded Failed",5, Notification.Position.BOTTOM_CENTER);
           e.printStackTrace();
       }
    }

    private void uploadSuccess(Upload uploadFileComponent,MemoryBuffer memoryBuffer,int fileData)
    {

        Notification.show(fileData+" Records uploaded successfully",5000, Notification.Position.BOTTOM_CENTER);
    }

}
