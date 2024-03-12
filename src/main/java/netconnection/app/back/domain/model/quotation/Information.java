package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;

public class Information {
    private String title;
    private String description;

    public Information (String _title, String _description){
        this.setDescription(_description);
        this.setTitle(_title);

    }

    private void setTitle(String title) {
        if(StringUtils.isEmpty(title)) throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    private void setDescription(String description) {
        if(StringUtils.isEmpty(title)) throw new IllegalArgumentException("Title must not be empty");

        this.description = description;
    }
}
