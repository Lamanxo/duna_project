package com.duna.dunaback.dtos.technic;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.enums.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AdvertTechnicDtoIn {
    @NotEmpty
    private AdvertType advertType = AdvertType.TECHNIC;
    @NotEmpty
    private TransactionTypeTechnic transactionType;
    @NotEmpty
    private String technicType;
    @NotEmpty
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
    
    private Long weight = 0L;
    private Long height = 0L;
    private Long passengersCount = 0L;
    private Double volume = 0.0; //обьем техники ковш или емкость
    private Double pipeLength = 0.0; //длина стрелы
    private Double boomLength = 0.0; //длина трубы
    private Long liftingCapacity = 0L; //грузоподьемность
    private Double performance = 0.0; //производительность
    private String cargoType = ""; //вид груза
    private RollerType rollerType = RollerType.NOT_SPECIFIED;//Тип вальцов
    private Long rollersCount = 0L; // Количество вальцов
    private TechnicSizeType sizeType = TechnicSizeType.NOT_SPECIFIED; //габаритный или нет
    private Boolean ossig = false; //наличие лицензии
    private Long axesCount = 0L;
    private Double bodyLength = 0.0;
    private TrailerType trailerType = TrailerType.NOT_SPECIFIED; // enum Тип прицепа
    private LoadingType loadingType = LoadingType.NOT_SPECIFIED; // enum Тип погрузки
    private Double secondAddressLat = 0.0;
    private Double secondAddressLon = 0.0;
    private Double distance = 0.0;

    @NotEmpty
    private Double price;
    @NotEmpty
    private PaymentType paymentType;
    @NotEmpty
    private PaymentUnit paymentUnit;
}
