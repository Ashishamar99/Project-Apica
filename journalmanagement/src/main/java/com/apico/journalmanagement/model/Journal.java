package com.apico.journalmanagement.model;

import com.apico.journalmanagement.JournalType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journal")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Journal id which is unique for each journal.")
    private Long id;

    @Schema(description = "User id related to this journal.")
    private String userId;

    @Schema(description = "Message log for this journal entry.")
    private String message;

    @Schema(description = "Journal type specifies what type of entry it is.")
    private JournalType journalType;
}
