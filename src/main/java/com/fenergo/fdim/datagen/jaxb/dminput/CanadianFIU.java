//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.24 at 05:30:03 PM BST 
//


package com.fenergo.fdim.datagen.jaxb.dminput;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CanadianFIU complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CanadianFIU">
 *   &lt;complexContent>
 *     &lt;extension base="{}AbstractInputEntityType">
 *       &lt;attGroup ref="{}CanadianFIUAttrGroup"/>
 *       &lt;anyAttribute processContents='skip'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CanadianFIU")
public class CanadianFIU
    extends AbstractInputEntityType
{

    @XmlAttribute(name = "LocalCounterpartyProvince", required = true)
    protected String localCounterpartyProvince;
    @XmlAttribute(name = "AffiliateOfAResponsibleCanadianPersonProvince", required = true)
    protected String affiliateOfAResponsibleCanadianPersonProvince;
    @XmlAttribute(name = "AdditionalCovenantReportingResponsibilityProvince", required = true)
    protected String additionalCovenantReportingResponsibilityProvince;
    @XmlAttribute(name = "LegalName")
    protected String legalName;
    @XmlAttribute(name = "BankingGroup")
    protected String bankingGroup;
    @XmlAttribute(name = "LEI")
    protected String lei;
    @XmlAttribute(name = "BusinessLine")
    protected String businessLine;
    @XmlAttribute(name = "CanadianRepresentationAgreement")
    protected String canadianRepresentationAgreement;
    @XmlAttribute(name = "LegalEntityType")
    protected String legalEntityType;
    @XmlAttribute(name = "DesignatedBusinessLine")
    protected String designatedBusinessLine;
    @XmlAttribute(name = "CountryOfIncorporation")
    protected String countryOfIncorporation;
    @XmlAttribute(name = "RestrictedTradingSystems")
    protected String restrictedTradingSystems;
    @XmlAttribute(name = "NAICCode")
    protected String naicCode;
    @XmlAttribute(name = "SICCode")
    protected String sicCode;
    @XmlAttribute(name = "RegulatedBy")
    protected String regulatedBy;
    @XmlAttribute(name = "JurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness")
    protected String jurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness;
    @XmlAttribute(name = "LocalCounterparty")
    protected String localCounterparty;
    @XmlAttribute(name = "ReportingDerivativesDealerInCanada")
    protected String reportingDerivativesDealerInCanada;
    @XmlAttribute(name = "ReportingDerivativesDealerInCanadaProvince")
    protected String reportingDerivativesDealerInCanadaProvince;
    @XmlAttribute(name = "AffiliateOfAResponsibleCanadianPerson")
    protected String affiliateOfAResponsibleCanadianPerson;
    @XmlAttribute(name = "AdditionalCovenantReportingResponsibility")
    protected String additionalCovenantReportingResponsibility;
    @XmlAttribute(name = "ConsentToDisclosure")
    protected String consentToDisclosure;
    @XmlAttribute(name = "ReportingPartyRules")
    protected String reportingPartyRules;
    @XmlAttribute(name = "ConsentToAllReportingRequirements")
    protected String consentToAllReportingRequirements;
    @XmlAttribute(name = "MasterAgreementType")
    protected String masterAgreementType;
    @XmlAttribute(name = "MultilateralAgreementForDealers")
    protected String multilateralAgreementForDealers;
    @XmlAttribute(name = "ClearingExemption")
    protected String clearingExemption;
    @XmlAttribute(name = "PCAPrincipalType")
    protected String pcaPrincipalType;
    @XmlAttribute(name = "CanadianReportingRequirementsCompleted")
    protected String canadianReportingRequirementsCompleted;

    /**
     * Gets the value of the localCounterpartyProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalCounterpartyProvince() {
        return localCounterpartyProvince;
    }

    /**
     * Sets the value of the localCounterpartyProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalCounterpartyProvince(String value) {
        this.localCounterpartyProvince = value;
    }

    /**
     * Gets the value of the affiliateOfAResponsibleCanadianPersonProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffiliateOfAResponsibleCanadianPersonProvince() {
        return affiliateOfAResponsibleCanadianPersonProvince;
    }

    /**
     * Sets the value of the affiliateOfAResponsibleCanadianPersonProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffiliateOfAResponsibleCanadianPersonProvince(String value) {
        this.affiliateOfAResponsibleCanadianPersonProvince = value;
    }

    /**
     * Gets the value of the additionalCovenantReportingResponsibilityProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalCovenantReportingResponsibilityProvince() {
        return additionalCovenantReportingResponsibilityProvince;
    }

    /**
     * Sets the value of the additionalCovenantReportingResponsibilityProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalCovenantReportingResponsibilityProvince(String value) {
        this.additionalCovenantReportingResponsibilityProvince = value;
    }

    /**
     * Gets the value of the legalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Sets the value of the legalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalName(String value) {
        this.legalName = value;
    }

    /**
     * Gets the value of the bankingGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankingGroup() {
        return bankingGroup;
    }

    /**
     * Sets the value of the bankingGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankingGroup(String value) {
        this.bankingGroup = value;
    }

    /**
     * Gets the value of the lei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEI() {
        return lei;
    }

    /**
     * Sets the value of the lei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEI(String value) {
        this.lei = value;
    }

    /**
     * Gets the value of the businessLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessLine() {
        return businessLine;
    }

    /**
     * Sets the value of the businessLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessLine(String value) {
        this.businessLine = value;
    }

    /**
     * Gets the value of the canadianRepresentationAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanadianRepresentationAgreement() {
        return canadianRepresentationAgreement;
    }

    /**
     * Sets the value of the canadianRepresentationAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanadianRepresentationAgreement(String value) {
        this.canadianRepresentationAgreement = value;
    }

    /**
     * Gets the value of the legalEntityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityType() {
        return legalEntityType;
    }

    /**
     * Sets the value of the legalEntityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityType(String value) {
        this.legalEntityType = value;
    }

    /**
     * Gets the value of the designatedBusinessLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignatedBusinessLine() {
        return designatedBusinessLine;
    }

    /**
     * Sets the value of the designatedBusinessLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignatedBusinessLine(String value) {
        this.designatedBusinessLine = value;
    }

    /**
     * Gets the value of the countryOfIncorporation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfIncorporation() {
        return countryOfIncorporation;
    }

    /**
     * Sets the value of the countryOfIncorporation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfIncorporation(String value) {
        this.countryOfIncorporation = value;
    }

    /**
     * Gets the value of the restrictedTradingSystems property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictedTradingSystems() {
        return restrictedTradingSystems;
    }

    /**
     * Sets the value of the restrictedTradingSystems property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictedTradingSystems(String value) {
        this.restrictedTradingSystems = value;
    }

    /**
     * Gets the value of the naicCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAICCode() {
        return naicCode;
    }

    /**
     * Sets the value of the naicCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAICCode(String value) {
        this.naicCode = value;
    }

    /**
     * Gets the value of the sicCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSICCode() {
        return sicCode;
    }

    /**
     * Sets the value of the sicCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSICCode(String value) {
        this.sicCode = value;
    }

    /**
     * Gets the value of the regulatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulatedBy() {
        return regulatedBy;
    }

    /**
     * Sets the value of the regulatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulatedBy(String value) {
        this.regulatedBy = value;
    }

    /**
     * Gets the value of the jurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness() {
        return jurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness;
    }

    /**
     * Sets the value of the jurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness(String value) {
        this.jurisdictionOfIncorporationHeadOfficeAndOrPrincipalPlaceOfBusiness = value;
    }

    /**
     * Gets the value of the localCounterparty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalCounterparty() {
        return localCounterparty;
    }

    /**
     * Sets the value of the localCounterparty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalCounterparty(String value) {
        this.localCounterparty = value;
    }

    /**
     * Gets the value of the reportingDerivativesDealerInCanada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingDerivativesDealerInCanada() {
        return reportingDerivativesDealerInCanada;
    }

    /**
     * Sets the value of the reportingDerivativesDealerInCanada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingDerivativesDealerInCanada(String value) {
        this.reportingDerivativesDealerInCanada = value;
    }

    /**
     * Gets the value of the reportingDerivativesDealerInCanadaProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingDerivativesDealerInCanadaProvince() {
        return reportingDerivativesDealerInCanadaProvince;
    }

    /**
     * Sets the value of the reportingDerivativesDealerInCanadaProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingDerivativesDealerInCanadaProvince(String value) {
        this.reportingDerivativesDealerInCanadaProvince = value;
    }

    /**
     * Gets the value of the affiliateOfAResponsibleCanadianPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffiliateOfAResponsibleCanadianPerson() {
        return affiliateOfAResponsibleCanadianPerson;
    }

    /**
     * Sets the value of the affiliateOfAResponsibleCanadianPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffiliateOfAResponsibleCanadianPerson(String value) {
        this.affiliateOfAResponsibleCanadianPerson = value;
    }

    /**
     * Gets the value of the additionalCovenantReportingResponsibility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalCovenantReportingResponsibility() {
        return additionalCovenantReportingResponsibility;
    }

    /**
     * Sets the value of the additionalCovenantReportingResponsibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalCovenantReportingResponsibility(String value) {
        this.additionalCovenantReportingResponsibility = value;
    }

    /**
     * Gets the value of the consentToDisclosure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentToDisclosure() {
        return consentToDisclosure;
    }

    /**
     * Sets the value of the consentToDisclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentToDisclosure(String value) {
        this.consentToDisclosure = value;
    }

    /**
     * Gets the value of the reportingPartyRules property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingPartyRules() {
        return reportingPartyRules;
    }

    /**
     * Sets the value of the reportingPartyRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingPartyRules(String value) {
        this.reportingPartyRules = value;
    }

    /**
     * Gets the value of the consentToAllReportingRequirements property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentToAllReportingRequirements() {
        return consentToAllReportingRequirements;
    }

    /**
     * Sets the value of the consentToAllReportingRequirements property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentToAllReportingRequirements(String value) {
        this.consentToAllReportingRequirements = value;
    }

    /**
     * Gets the value of the masterAgreementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterAgreementType() {
        return masterAgreementType;
    }

    /**
     * Sets the value of the masterAgreementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterAgreementType(String value) {
        this.masterAgreementType = value;
    }

    /**
     * Gets the value of the multilateralAgreementForDealers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultilateralAgreementForDealers() {
        return multilateralAgreementForDealers;
    }

    /**
     * Sets the value of the multilateralAgreementForDealers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultilateralAgreementForDealers(String value) {
        this.multilateralAgreementForDealers = value;
    }

    /**
     * Gets the value of the clearingExemption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearingExemption() {
        return clearingExemption;
    }

    /**
     * Sets the value of the clearingExemption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearingExemption(String value) {
        this.clearingExemption = value;
    }

    /**
     * Gets the value of the pcaPrincipalType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCAPrincipalType() {
        return pcaPrincipalType;
    }

    /**
     * Sets the value of the pcaPrincipalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCAPrincipalType(String value) {
        this.pcaPrincipalType = value;
    }

    /**
     * Gets the value of the canadianReportingRequirementsCompleted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanadianReportingRequirementsCompleted() {
        return canadianReportingRequirementsCompleted;
    }

    /**
     * Sets the value of the canadianReportingRequirementsCompleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanadianReportingRequirementsCompleted(String value) {
        this.canadianReportingRequirementsCompleted = value;
    }

}
