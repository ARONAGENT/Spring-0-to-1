    package com.springjourney.Week4Practice.Entities;
    
    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.persistence.EntityListeners;
    import jakarta.persistence.MappedSuperclass;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;
    import org.hibernate.envers.Audited;
    import org.springframework.data.annotation.CreatedBy;
    import org.springframework.data.annotation.CreatedDate;
    import org.springframework.data.annotation.LastModifiedBy;
    import org.springframework.data.annotation.LastModifiedDate;
    import org.springframework.data.jpa.domain.support.AuditingEntityListener;
    
    import java.time.LocalDateTime;
    
    @MappedSuperclass
    @Getter
    @Setter
    @EntityListeners(AuditingEntityListener.class)
    @Audited
    public class AuditableEntity {
        @CreatedBy
        private String createdBy;
    
        @CreatedDate
        @JsonFormat(pattern = "hh:mm:ss|dd-MM-YYYY")
        private LocalDateTime createDate;
    
        @LastModifiedBy
        private String updatedBy;
    
        @LastModifiedDate
        @JsonFormat(pattern = "hh:mm:ss|dd-MM-YYYY")
        private LocalDateTime lastUpdateDate;
    }
