package pl.morecraft.dev.stm.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.LocalDate;
import pl.morecraft.dev.stm.utils.JsonJodaLocalDateTimeDeserializer;
import pl.morecraft.dev.stm.utils.JsonJodaLocalDateTimeSerializer;

public class PriviligeObjectDTO {

    @JsonSerialize(using = JsonJodaLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonJodaLocalDateTimeDeserializer.class)
    private LocalDate createdDate;

    @JsonSerialize(using = JsonJodaLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonJodaLocalDateTimeDeserializer.class)
    private LocalDate modified_date;

    public PriviligeObjectDTO(LocalDate createdDate, LocalDate modified_date) {
        this.createdDate = createdDate;
        this.modified_date = modified_date;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModified_date() {
        return modified_date;
    }

    public void setModified_date(LocalDate modified_date) {
        this.modified_date = modified_date;
    }

    @Override
    public String toString() {
        return "PriviligeObjectDTO{" +
                "createdDate=" + createdDate +
                ", modified_date=" + modified_date +
                '}';
    }
}
