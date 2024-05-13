package com.duna.dunaback.dtos.dump;


import com.duna.dunaback.enums.*;
import lombok.Data;

@Data
public class AdvertDumpDtoOut {
    private Long id;
    private Long ownerId;
    private AdvertType advertType;
    private TransactionTypeDump transactionType;
    private ShiftType shiftType;
    private String title;
    private Double addressLat;
    private Double addressLon;
    private String wasteType;
    private DangerClass dangerClass;
    private DumpTransport dumpTransport;
    private MeasureIn measureIn;
    private Double amount;
    private Double price;
    private PaymentType paymentType;
    private AdvertStatus advertStatus;
}
