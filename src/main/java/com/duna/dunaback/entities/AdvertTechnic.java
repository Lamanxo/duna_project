package com.duna.dunaback.entities;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "advert_technic")
public class AdvertTechnic {
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
    private TransactionTypeTechnic transactionType;
    @Column(name = "technic_type")
    private String technicType;
    @ManyToMany
    @JoinTable(
            name = "technic_adverts_equipments",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<TechnicEquipmentLib> equipment;
    @Column(name = "technic_mark")
    private String technicMark;
    @Column(name = "technic_model")
    private String technicModel;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "shift_type")
    private ShiftType shiftType;
    @Column(name = "title")
    private String title;
    @Column(name = "unit_amount")
    private Long unitAmount;
    @Column(name = "rental_from")
    private LocalDateTime rentalFrom;
    @Column(name = "rental_to")
    private LocalDateTime rentalTo;
    @Column(name = "rental_days")
    private Long rentalDaysCount;
    @Column(name = "address_lat")
    private Double addressLat;
    @Column(name = "address_lon")
    private Double addressLon;
    @Column(name = "production_year")
    private Long productionYear;
    @Column(name = "weight")
    private Long weight;
    @Column(name = "height")
    private Long height;
    @Column(name = "volume")
    private Double volume; //обьем техники ковш или емкость
    @Column(name = "passengers_count")
    private Long passengersCount;
    @Column(name = "pipe_length")
    private Double pipeLength; //длина стрелы
    @Column(name = "boom_length")
    private Double boomLength; //длина трубы
    @Column(name = "lifting_capacity")
    private Long liftingCapacity; //грузоподьемность
    @Column(name = "performance")
    private Double performance; //производительность
    @Column(name = "cargo_type")
    private String cargoType;//вид груза
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "roller_type")
    private RollerType rollerType;//Тип вальцов
    @Column(name = "roller_count")
    private Long rollersCount; // Количество вальцов
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "size_type")
    private TechnicSizeType sizeType; //габаритный или нет
    @Column(name = "ossig")
    private Boolean ossig;//наличие лицензии
    @Column(name = "axes_count")
    private Long axesCount;
    @Column(name = "body_length")
    private Double bodyLength;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "trailer_type")
    private TrailerType trailerType; // enum Тип прицепа
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "loading_type")
    private LoadingType loadingType; // enum Тип погрузки
    @Column(name = "second_lat")
    private Double secondAddressLat;
    @Column(name = "second_lon")
    private Double secondAddressLon;
    @Column(name = "distance")
    private Double distance;
    @Column(name = "is_transport")
    private Boolean isTransport;
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_type")
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_unit")
    private PaymentUnit paymentUnit; ///rename to paymentFor
    @Enumerated
    @Column(name = "advert_status")
    private AdvertStatus advertStatus;
    @Column(name = "is_verified")
    private Boolean isVerified;
    @Column(name = "is_banned")
    private Boolean isBanned;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;






}
