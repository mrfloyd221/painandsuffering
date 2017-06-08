package com.painandsuffering.model;



import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by mrflo on 26.05.2017.
 */
@AllArgsConstructor
@NoArgsConstructor

public class Order{

   @Getter @Setter private int id;
   @Getter @Setter private int userId;
   @Getter @Setter private int positionId;
   @Getter @Setter private boolean complete;
}
