package com.duna.dunaback.entities;

import com.duna.dunaback.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "advert_dump")
public class AdvertDump {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_id")
    private Long ownerId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_type")
    private AdvertType advertType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transaction_type")
    private TransactionTypeDump transactionType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "shift_type")
    private ShiftType shiftType;
    @Column(name = "title")
    private String title;
    @Column(name = "address_lat")
    private Double addressLat;
    @Column(name = "address_lon")
    private Double addressLon;
    @Column(name = "waste_type")
    private String wasteType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "danger_class")
    private DangerClass dangerClass;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "dump_transport")
    private DumpTransport dumpTransport;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "measure_in")
    private MeasureIn measureIn;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_type")
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_status")
    private AdvertStatus advertStatus;

    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "is_banned")
    private boolean isBanned;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
