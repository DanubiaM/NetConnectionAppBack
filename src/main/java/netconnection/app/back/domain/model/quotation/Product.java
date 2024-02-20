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
        this.name = _name;
        this.descrition = _description;
        this.value = _value;
        this.url = _url;
        this.keyWords = _keywords;

        this.validate();
    }

    private void validate() {

        if(StringUtils.isEmpty(this.name)){
            throw new IllegalArgumentException("Name must not be empty");
        }

        if(StringUtils.isEmpty(this.descrition)){
            throw new IllegalArgumentException("Description  must not be empty");
        }
        if(this.value == null ){
            throw new IllegalArgumentException("Value  must not  be empty");
        }
        if(this.value < 0 ){
            throw new IllegalArgumentException("Value  must not be negative ");
        }

        if( StringUtils.isEmpty(this.url)){
            throw new IllegalArgumentException("URL Product not should be empty");
        }


    }


}
