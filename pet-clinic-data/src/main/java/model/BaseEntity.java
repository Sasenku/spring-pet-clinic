package model;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable{
    private Long id;
}
