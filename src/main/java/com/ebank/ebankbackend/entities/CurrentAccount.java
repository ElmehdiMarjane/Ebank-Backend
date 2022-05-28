package com.ebank.ebankbackend.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends Account{

    private double overDraft;





}
