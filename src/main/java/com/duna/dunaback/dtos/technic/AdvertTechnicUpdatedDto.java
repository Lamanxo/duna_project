package com.duna.dunaback.dtos.technic;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.enums.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AdvertTechnicUpdatedDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private AdvertType advertType = AdvertType.TECHNIC;
    @NotEmpty
    private TransactionTypeTechnic transactionType;
    @NotEmpty
    private String technicType;
    @NotNull
    private List<TechnicEquipmentLib> equipment;
    @NotEmpty
    private String technicMark;
    @NotEmpty
    private String technicModel;
    @NotEmpty
    private ShiftType shiftType;
    @NotEmpty
    private String title;
    @NotEmpty
    private Long unitAmount;
    @NotEmpty
    private LocalDateTime rentalFrom;
    @NotEmpty
    private LocalDateTime rentalTo;
    @NotEmpty
    private Long rentalDaysCount;
    @NotEmpty
    private Double addressLat;
    @NotEmpty
    private Double addressLon;
    @NotEmpty
    private Long productionYear;
    @NotEmpty
    private Boolean isTransport;

    @NotEmpty
    private Long weight;
    @NotEmpty
    private Long height;
    @NotEmpty
    private Long passengersCount;
    @NotEmpty
    private Double volume; //обьем техники ковш или емкость
    @NotEmpty
    private Double pipeLength; //длина стрелы
    @NotEmpty
    private Double boomLength; //длина трубы
    @NotEmpty
    private Long liftingCapacity; //грузоподьемность
    @NotEmpty
    private Double performance; //производительность
    @NotEmpty
    private String cargoType; //вид груза
    @NotEmpty
    private RollerType rollerType;//Тип вальцов
    @NotEmpty
    private Long rollersCount; // Количество вальцов
    @NotEmpty
    private TechnicSizeType sizeType; //габаритный или нет
    @NotEmpty
    private Boolean ossig; //наличие лицензии
    @NotEmpty
    private Long axesCount;
    @NotEmpty
    private Double bodyLength;
    @NotEmpty
    private TrailerType trailerType; // enum Тип прицепа
    @NotEmpty
    private LoadingType loadingType; // enum Тип погрузки
    @NotEmpty
    private Double secondAddressLat;
    @NotEmpty
    private Double secondAddressLon;
    @NotEmpty
    private Double distance;

    @NotEmpty
    private Double price;
    @NotEmpty
    private PaymentType paymentType;
    @NotEmpty
    private PaymentUnit paymentUnit;
    @NotEmpty
    private AdvertStatus advertStatus;

}
