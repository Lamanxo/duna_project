package com.duna.dunaback.dtos.technic;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.enums.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AdvertTechnicDtoOut {
    private Long id;
    private Long ownerId;
    private AdvertType advertType;
    private TransactionTypeTechnic transactionType;
    private String technicType;
    private List<TechnicEquipmentLib> equipment;
    private String technicMark;
    private String technicModel;
    private ShiftType shiftType;
    private String title;
    private Long unitAmount;
    private LocalDateTime rentalFrom;
    private LocalDateTime rentalTo;
    private Long rentalDaysCount;
    private Double addressLat;
    private Double addressLon;
    private Long productionYear;
    private Long weight;
    private Long height;
    private Double volume; //обьем техники ковш или емкость
    private Long passengersCount;
    private Double pipeLength; //длина стрелы
    private Double boomLength; //длина трубы
    private Long liftingCapacity; //грузоподьемность
    private Double performance; //производительность
    private String cargoType;//вид груза
    private RollerType rollerType;//Тип вальцов
    private Long rollersCount; // Количество вальцов
    private TechnicSizeType sizeType; //габаритный или нет
    private Boolean ossig;//наличие лицензии
    private Long axesCount;
    private Double bodyLength;
    private TrailerType trailerType; // enum Тип прицепа
    private LoadingType loadingType; // enum Тип погрузки
    private Double secondAddressLat;
    private Double secondAddressLon;
    private Double distance;
    private Boolean isTransport;
    private Double price;
    private PaymentType paymentType;
    private PaymentUnit paymentUnit; ///rename to paymentFor
    private AdvertStatus advertStatus;
}
