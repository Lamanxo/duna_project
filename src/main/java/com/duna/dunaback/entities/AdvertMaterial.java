package com.duna.dunaback.entities;

import com.duna.dunaback.entities_mini.MaterialFractions;
import com.duna.dunaback.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class AdvertMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "owner_id")
    private Long ownerId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_type")
    private AdvertType advertType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transaction_type")
    private TransactionTypeMaterial transactionType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "shift_type")
    private ShiftType shiftType;
    @Column(name = "title")
    private String title;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;
    @Column(name = "address_lat")
    private Double addressLat;
    @Column(name = "address_lon")
    private Double addressLon;
    @Column(name = "material_type")
    private String materialType;
    @ManyToMany
    @JoinTable(
            name = "advert_material_fractions",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "fraction_id")
    )
    private List<MaterialFractions> fractions;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "dump_transport")
    private DumpTransport dumpTransport;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "measure_in")
    private MeasureIn measureIn;
    @Column(name = "amount")
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_type")
    private PaymentType paymentType;
    @Column(name = "price")
    private Double price;
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
