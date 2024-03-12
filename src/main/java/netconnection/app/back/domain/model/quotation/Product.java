package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;

import java.util.List;

public class Product {

    private String name;
    private String descrition;
    private Float value;
    private String url;
    private List<String> keyWords;

    public Product(String _name, String _description, Float _value, String _url, List<String> _keywords){
        this.setName(_name);
        this.setDescrition(_description);
        this.setValue(_value);
        this.setUrl(_url);
        this.setKeyWords(_keywords);

    }

    private void setName(String name) {
        if(StringUtils.isEmpty(this.descrition)){
            throw new IllegalArgumentException("Description  must not be empty");
        }
        this.name = name;
    }

    private void setDescrition(String descrition) {
        if(StringUtils.isEmpty(this.name)){
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.descrition = descrition;
    }

    private void setValue(Float value) {
        if(this.value == null ){
            throw new IllegalArgumentException("Value  must not  be empty");
        }
        if(this.value < 0 ){
            throw new IllegalArgumentException("Value  must not be negative ");
        }
        this.value = value;
    }

    private void setUrl(String url) {
        if( StringUtils.isEmpty(this.url)){
            throw new IllegalArgumentException("URL Product not should be empty");
        }
        this.url = url;
    }

    private void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }



}
