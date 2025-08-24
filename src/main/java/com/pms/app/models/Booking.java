package com.pms.app.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Column(name = "sender_name")
    @Nonnull
    public String name;

    @Column(name = "address")
    @Nonnull
    public String address;

    @Column(name = "contact_phone_number")
    @Nonnull
    public String phoneNumber;

    @Column(name = "receiver_name")
    @Nonnull
    public String receiverName;

    @Column(name = "receiver_address")
    @Nonnull
    public String receiverAddress;
    @Column(name = "receiver_pin")
    @Nonnull
    public Integer receiverPin;
    @Column(name="receiver_phone_number")
    @Nonnull
    public String receiverPhoneNumber;
    @Column(name="parcel_weight_grams")
    @Nonnull
    public Integer parcelWeightInGrams;

    @Column(name="parcel_content_desc")
    @Nonnull
    public String parcelContentDesc;

    @Column(name="parcel_delivery_type")
    @Nonnull
    public String parcelDeliveryType;

    @Column(name="parcel_packing_preference")
    @Nonnull
    public String parcelPackingPreference;


    @Column(name = "parcel_pickup_time")
    public LocalDateTime parcelPickUpTime;

    @Column(name = "parcel_drop_time")
    public LocalDateTime parcelDropTime;

    @Column(name = "service_cost")
    public Integer serviceCost;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    public LocalDateTime parcelPaymentTime;





}
