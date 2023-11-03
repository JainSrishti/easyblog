package com.easyblog.main.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;


@Document(indexName = "Articles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Articles {

    @Id
    private Integer id;

    private String title;

    private String content;

    private Integer likesCount;

     private Date createdAt;

   private Date updatedAt;

    private Integer userid;

    private Boolean isPublished;

}

