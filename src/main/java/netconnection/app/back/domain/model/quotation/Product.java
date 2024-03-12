package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.ValueObject;
import netconnection.app.back.domain.model.validation.Notification;

import java.util.List;

public class Product extends ValueObject {

    private String name;
    private String descrition;
    private Float value;
    private String url;
    private List<String> keyWords;

    public Product(String _name, String _description, Float _value, String _url, List<String> _keywords){
        super(new Notification());
        this.setName(_name);
        this.setDescrition(_description);
        this.setValue(_value);
        this.setUrl(_url);
        this.setKeyWords(_keywords);

        valid();
    }

    private void valid() {
        if(this.notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());

    }

    private void setName(String name) {
        if(StringUtils.isEmpty(name)){
            notification.addError("Name  must not be empty");
        }
        this.name = name;
    }

    private void setDescrition(String descrition) {
        if(StringUtils.isEmpty(descrition)){
            notification.addError("Description must not be empty");
        }
        this.descrition = descrition;
    }

    private void setValue(Float value) {
        if(value == null ){
            notification.addError("Value  must not  be empty");
        }
        if(value < 0 ){
            notification.addError("Value  must not be negative ");
        }
        this.value = value;
    }

    private void setUrl(String url) {
        if( StringUtils.isEmpty(url)){
            notification.addError("URL Product not should be empty");
        }
        this.url = url;
    }

    private void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }



}
