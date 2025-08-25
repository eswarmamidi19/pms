package com.pms.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    @Nonnull
    public Integer bookingId;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    public Customer customer;

    @Column(name = "booking_status")
    @Nonnull
    public String bookingStatus;

    public Booking(){}
    public Booking(Integer bookingId, String name, String address, String phoneNumber, String receiverName, String receiverAddress, Integer receiverPin, String receiverPhoneNumber, Integer parcelWeightInGrams, String parcelContentDesc, String parcelDeliveryType, String parcelPackingPreference, LocalDateTime parcelPickUpTime, LocalDateTime parcelDropTime, Integer serviceCost, LocalDateTime parcelPaymentTime, Customer customer , String bookingStatus) {
        this.bookingId = bookingId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPin = receiverPin;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.parcelWeightInGrams = parcelWeightInGrams;
        this.parcelContentDesc = parcelContentDesc;
        this.parcelDeliveryType = parcelDeliveryType;
        this.parcelPackingPreference = parcelPackingPreference;
        this.parcelPickUpTime = parcelPickUpTime;
        this.parcelDropTime = parcelDropTime;
        this.serviceCost = serviceCost;
        this.parcelPaymentTime = parcelPaymentTime;
        this.customer = customer;
        this.bookingStatus = bookingStatus;
    }

    public Booking(String name, String address, String phoneNumber, String receiverName, String receiverAddress, Integer receiverPin, String receiverPhoneNumber, Integer parcelWeightInGrams, String parcelContentDesc, String parcelDeliveryType, String parcelPackingPreference, LocalDateTime parcelPickUpTime, LocalDateTime parcelDropTime, Integer serviceCost, LocalDateTime parcelPaymentTime, Customer customer, String bookingStatus) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPin = receiverPin;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.parcelWeightInGrams = parcelWeightInGrams;
        this.parcelContentDesc = parcelContentDesc;
        this.parcelDeliveryType = parcelDeliveryType;
        this.parcelPackingPreference = parcelPackingPreference;
        this.parcelPickUpTime = parcelPickUpTime;
        this.parcelDropTime = parcelDropTime;
        this.serviceCost = serviceCost;
        this.parcelPaymentTime = parcelPaymentTime;
        this.customer = customer;
        this.bookingStatus = bookingStatus;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public Integer getReceiverPin() {
        return receiverPin;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public Integer getParcelWeightInGrams() {
        return parcelWeightInGrams;
    }

    public String getParcelContentDesc() {
        return parcelContentDesc;
    }

    public String getParcelDeliveryType() {
        return parcelDeliveryType;
    }

    public String getParcelPackingPreference() {
        return parcelPackingPreference;
    }

    public LocalDateTime getParcelPickUpTime() {
        return parcelPickUpTime;
    }

    public LocalDateTime getParcelDropTime() {
        return parcelDropTime;
    }

    public Integer getServiceCost() {
        return serviceCost;
    }

    public LocalDateTime getParcelPaymentTime() {
        return parcelPaymentTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public void setReceiverPin(Integer receiverPin) {
        this.receiverPin = receiverPin;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public void setParcelWeightInGrams(Integer parcelWeightInGrams) {
        this.parcelWeightInGrams = parcelWeightInGrams;
    }

    public void setParcelContentDesc(String parcelContentDesc) {
        this.parcelContentDesc = parcelContentDesc;
    }

    public void setParcelDeliveryType(String parcelDeliveryType) {
        this.parcelDeliveryType = parcelDeliveryType;
    }

    public void setParcelPackingPreference(String parcelPackingPreference) {
        this.parcelPackingPreference = parcelPackingPreference;
    }

    public void setParcelPickUpTime(LocalDateTime parcelPickUpTime) {
        this.parcelPickUpTime = parcelPickUpTime;
    }

    public void setParcelDropTime(LocalDateTime parcelDropTime) {
        this.parcelDropTime = parcelDropTime;
    }

    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    public void setParcelPaymentTime(LocalDateTime parcelPaymentTime) {
        this.parcelPaymentTime = parcelPaymentTime;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
