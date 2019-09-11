/*
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watson.health.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

import com.ibm.watson.health.fhir.model.annotation.Binding;
import com.ibm.watson.health.fhir.model.annotation.Constraint;
import com.ibm.watson.health.fhir.model.type.Annotation;
import com.ibm.watson.health.fhir.model.type.BackboneElement;
import com.ibm.watson.health.fhir.model.type.CareTeamStatus;
import com.ibm.watson.health.fhir.model.type.Code;
import com.ibm.watson.health.fhir.model.type.CodeableConcept;
import com.ibm.watson.health.fhir.model.type.ContactPoint;
import com.ibm.watson.health.fhir.model.type.Extension;
import com.ibm.watson.health.fhir.model.type.Id;
import com.ibm.watson.health.fhir.model.type.Identifier;
import com.ibm.watson.health.fhir.model.type.Meta;
import com.ibm.watson.health.fhir.model.type.Narrative;
import com.ibm.watson.health.fhir.model.type.Period;
import com.ibm.watson.health.fhir.model.type.Reference;
import com.ibm.watson.health.fhir.model.type.String;
import com.ibm.watson.health.fhir.model.type.Uri;
import com.ibm.watson.health.fhir.model.util.ValidationSupport;
import com.ibm.watson.health.fhir.model.visitor.Visitor;

/**
 * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of 
 * care for a patient.
 */
@Constraint(
    id = "ctm-1",
    level = "Rule",
    location = "CareTeam.participant",
    description = "CareTeam.participant.onBehalfOf can only be populated when CareTeam.participant.member is a Practitioner",
    expression = "onBehalfOf.exists() implies (member.resolve() is Practitioner)"
)
@Generated("com.ibm.watson.health.fhir.tools.CodeGenerator")
public class CareTeam extends DomainResource {
    private final List<Identifier> identifier;
    @Binding(
        bindingName = "CareTeamStatus",
        strength = "required",
        description = "Indicates the status of the care team.",
        valueSet = "http://hl7.org/fhir/ValueSet/care-team-status|4.0.0"
    )
    private final CareTeamStatus status;
    @Binding(
        bindingName = "CareTeamCategory",
        strength = "example",
        description = "Indicates the type of care team.",
        valueSet = "http://hl7.org/fhir/ValueSet/care-team-category"
    )
    private final List<CodeableConcept> category;
    private final String name;
    private final Reference subject;
    private final Reference encounter;
    private final Period period;
    private final List<Participant> participant;
    @Binding(
        bindingName = "CareTeamReason",
        strength = "example",
        description = "Indicates the reason for the care team.",
        valueSet = "http://hl7.org/fhir/ValueSet/clinical-findings"
    )
    private final List<CodeableConcept> reasonCode;
    private final List<Reference> reasonReference;
    private final List<Reference> managingOrganization;
    private final List<ContactPoint> telecom;
    private final List<Annotation> note;

    private volatile int hashCode;

    private CareTeam(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        status = builder.status;
        category = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.category, "category"));
        name = builder.name;
        subject = builder.subject;
        encounter = builder.encounter;
        period = builder.period;
        participant = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.participant, "participant"));
        reasonCode = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.reasonCode, "reasonCode"));
        reasonReference = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.reasonReference, "reasonReference"));
        managingOrganization = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.managingOrganization, "managingOrganization"));
        telecom = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.telecom, "telecom"));
        note = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.note, "note"));
        ValidationSupport.requireChildren(this);
    }

    /**
     * Business identifiers assigned to this care team by the performer or other systems which remain constant as the 
     * resource is updated and propagates from server to server.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier}.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * Indicates the current state of the care team.
     * 
     * @return
     *     An immutable object of type {@link CareTeamStatus}.
     */
    public CareTeamStatus getStatus() {
        return status;
    }

    /**
     * Identifies what kind of team. This is to support differentiation between multiple co-existing teams, such as care plan 
     * team, episode of care team, longitudinal care team.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getCategory() {
        return category;
    }

    /**
     * A label for human use intended to distinguish like teams. E.g. the "red" vs. "green" trauma teams.
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getName() {
        return name;
    }

    /**
     * Identifies the patient or group whose intended care is handled by the team.
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getSubject() {
        return subject;
    }

    /**
     * The Encounter during which this CareTeam was created or to which the creation of this record is tightly associated.
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getEncounter() {
        return encounter;
    }

    /**
     * Indicates when the team did (or is intended to) come into effect and end.
     * 
     * @return
     *     An immutable object of type {@link Period}.
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Identifies all people and organizations who are expected to be involved in the care team.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Participant}.
     */
    public List<Participant> getParticipant() {
        return participant;
    }

    /**
     * Describes why the care team exists.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getReasonCode() {
        return reasonCode;
    }

    /**
     * Condition(s) that this care team addresses.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference}.
     */
    public List<Reference> getReasonReference() {
        return reasonReference;
    }

    /**
     * The organization responsible for the care team.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference}.
     */
    public List<Reference> getManagingOrganization() {
        return managingOrganization;
    }

    /**
     * A central contact detail for the care team (that applies to all members).
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactPoint}.
     */
    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    /**
     * Comments made about the CareTeam.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Annotation}.
     */
    public List<Annotation> getNote() {
        return note;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            !identifier.isEmpty() || 
            (status != null) || 
            !category.isEmpty() || 
            (name != null) || 
            (subject != null) || 
            (encounter != null) || 
            (period != null) || 
            !participant.isEmpty() || 
            !reasonCode.isEmpty() || 
            !reasonReference.isEmpty() || 
            !managingOrganization.isEmpty() || 
            !telecom.isEmpty() || 
            !note.isEmpty();
    }

    @Override
    public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, elementIndex, this);
            if (visitor.visit(elementName, elementIndex, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(status, "status", visitor);
                accept(category, "category", visitor, CodeableConcept.class);
                accept(name, "name", visitor);
                accept(subject, "subject", visitor);
                accept(encounter, "encounter", visitor);
                accept(period, "period", visitor);
                accept(participant, "participant", visitor, Participant.class);
                accept(reasonCode, "reasonCode", visitor, CodeableConcept.class);
                accept(reasonReference, "reasonReference", visitor, Reference.class);
                accept(managingOrganization, "managingOrganization", visitor, Reference.class);
                accept(telecom, "telecom", visitor, ContactPoint.class);
                accept(note, "note", visitor, Annotation.class);
            }
            visitor.visitEnd(elementName, elementIndex, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CareTeam other = (CareTeam) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(status, other.status) && 
            Objects.equals(category, other.category) && 
            Objects.equals(name, other.name) && 
            Objects.equals(subject, other.subject) && 
            Objects.equals(encounter, other.encounter) && 
            Objects.equals(period, other.period) && 
            Objects.equals(participant, other.participant) && 
            Objects.equals(reasonCode, other.reasonCode) && 
            Objects.equals(reasonReference, other.reasonReference) && 
            Objects.equals(managingOrganization, other.managingOrganization) && 
            Objects.equals(telecom, other.telecom) && 
            Objects.equals(note, other.note);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, 
                meta, 
                implicitRules, 
                language, 
                text, 
                contained, 
                extension, 
                modifierExtension, 
                identifier, 
                status, 
                category, 
                name, 
                subject, 
                encounter, 
                period, 
                participant, 
                reasonCode, 
                reasonReference, 
                managingOrganization, 
                telecom, 
                note);
            hashCode = result;
        }
        return result;
    }

    @Override
    public Builder toBuilder() {
        return new Builder().from(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends DomainResource.Builder {
        private List<Identifier> identifier = new ArrayList<>();
        private CareTeamStatus status;
        private List<CodeableConcept> category = new ArrayList<>();
        private String name;
        private Reference subject;
        private Reference encounter;
        private Period period;
        private List<Participant> participant = new ArrayList<>();
        private List<CodeableConcept> reasonCode = new ArrayList<>();
        private List<Reference> reasonReference = new ArrayList<>();
        private List<Reference> managingOrganization = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
            super();
        }

        /**
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * The base language in which the resource is written.
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * 
         * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * 
         * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * Business identifiers assigned to this care team by the performer or other systems which remain constant as the 
         * resource is updated and propagates from server to server.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     External Ids for this team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Identifier... identifier) {
            for (Identifier value : identifier) {
                this.identifier.add(value);
            }
            return this;
        }

        /**
         * Business identifiers assigned to this care team by the performer or other systems which remain constant as the 
         * resource is updated and propagates from server to server.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     External Ids for this team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * Indicates the current state of the care team.
         * 
         * @param status
         *     proposed | active | suspended | inactive | entered-in-error
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder status(CareTeamStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Identifies what kind of team. This is to support differentiation between multiple co-existing teams, such as care plan 
         * team, episode of care team, longitudinal care team.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param category
         *     Type of team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder category(CodeableConcept... category) {
            for (CodeableConcept value : category) {
                this.category.add(value);
            }
            return this;
        }

        /**
         * Identifies what kind of team. This is to support differentiation between multiple co-existing teams, such as care plan 
         * team, episode of care team, longitudinal care team.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param category
         *     Type of team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder category(Collection<CodeableConcept> category) {
            this.category = new ArrayList<>(category);
            return this;
        }

        /**
         * A label for human use intended to distinguish like teams. E.g. the "red" vs. "green" trauma teams.
         * 
         * @param name
         *     Name of the team, such as crisis assessment team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Identifies the patient or group whose intended care is handled by the team.
         * 
         * @param subject
         *     Who care team is for
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * The Encounter during which this CareTeam was created or to which the creation of this record is tightly associated.
         * 
         * @param encounter
         *     Encounter created as part of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
            return this;
        }

        /**
         * Indicates when the team did (or is intended to) come into effect and end.
         * 
         * @param period
         *     Time period team covers
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Identifies all people and organizations who are expected to be involved in the care team.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param participant
         *     Members of the team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder participant(Participant... participant) {
            for (Participant value : participant) {
                this.participant.add(value);
            }
            return this;
        }

        /**
         * Identifies all people and organizations who are expected to be involved in the care team.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param participant
         *     Members of the team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder participant(Collection<Participant> participant) {
            this.participant = new ArrayList<>(participant);
            return this;
        }

        /**
         * Describes why the care team exists.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param reasonCode
         *     Why the care team exists
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reasonCode(CodeableConcept... reasonCode) {
            for (CodeableConcept value : reasonCode) {
                this.reasonCode.add(value);
            }
            return this;
        }

        /**
         * Describes why the care team exists.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param reasonCode
         *     Why the care team exists
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reasonCode(Collection<CodeableConcept> reasonCode) {
            this.reasonCode = new ArrayList<>(reasonCode);
            return this;
        }

        /**
         * Condition(s) that this care team addresses.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param reasonReference
         *     Why the care team exists
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reasonReference(Reference... reasonReference) {
            for (Reference value : reasonReference) {
                this.reasonReference.add(value);
            }
            return this;
        }

        /**
         * Condition(s) that this care team addresses.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param reasonReference
         *     Why the care team exists
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reasonReference(Collection<Reference> reasonReference) {
            this.reasonReference = new ArrayList<>(reasonReference);
            return this;
        }

        /**
         * The organization responsible for the care team.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param managingOrganization
         *     Organization responsible for the care team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder managingOrganization(Reference... managingOrganization) {
            for (Reference value : managingOrganization) {
                this.managingOrganization.add(value);
            }
            return this;
        }

        /**
         * The organization responsible for the care team.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param managingOrganization
         *     Organization responsible for the care team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder managingOrganization(Collection<Reference> managingOrganization) {
            this.managingOrganization = new ArrayList<>(managingOrganization);
            return this;
        }

        /**
         * A central contact detail for the care team (that applies to all members).
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param telecom
         *     A contact detail for the care team (that applies to all members)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(ContactPoint... telecom) {
            for (ContactPoint value : telecom) {
                this.telecom.add(value);
            }
            return this;
        }

        /**
         * A central contact detail for the care team (that applies to all members).
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param telecom
         *     A contact detail for the care team (that applies to all members)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(Collection<ContactPoint> telecom) {
            this.telecom = new ArrayList<>(telecom);
            return this;
        }

        /**
         * Comments made about the CareTeam.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param note
         *     Comments made about the CareTeam
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder note(Annotation... note) {
            for (Annotation value : note) {
                this.note.add(value);
            }
            return this;
        }

        /**
         * Comments made about the CareTeam.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param note
         *     Comments made about the CareTeam
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder note(Collection<Annotation> note) {
            this.note = new ArrayList<>(note);
            return this;
        }

        /**
         * Build the {@link CareTeam}
         * 
         * @return
         *     An immutable object of type {@link CareTeam}
         */
        @Override
        public CareTeam build() {
            return new CareTeam(this);
        }

        protected Builder from(CareTeam careTeam) {
            super.from(careTeam);
            identifier.addAll(careTeam.identifier);
            status = careTeam.status;
            category.addAll(careTeam.category);
            name = careTeam.name;
            subject = careTeam.subject;
            encounter = careTeam.encounter;
            period = careTeam.period;
            participant.addAll(careTeam.participant);
            reasonCode.addAll(careTeam.reasonCode);
            reasonReference.addAll(careTeam.reasonReference);
            managingOrganization.addAll(careTeam.managingOrganization);
            telecom.addAll(careTeam.telecom);
            note.addAll(careTeam.note);
            return this;
        }
    }

    /**
     * Identifies all people and organizations who are expected to be involved in the care team.
     */
    public static class Participant extends BackboneElement {
        @Binding(
            bindingName = "CareTeamParticipantRole",
            strength = "example",
            description = "Indicates specific responsibility of an individual within the care team, such as \"Primary physician\", \"Team coordinator\", \"Caregiver\", etc.",
            valueSet = "http://hl7.org/fhir/ValueSet/participant-role"
        )
        private final List<CodeableConcept> role;
        private final Reference member;
        private final Reference onBehalfOf;
        private final Period period;

        private volatile int hashCode;

        private Participant(Builder builder) {
            super(builder);
            role = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.role, "role"));
            member = builder.member;
            onBehalfOf = builder.onBehalfOf;
            period = builder.period;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained 
         * social worker counselor", "Caregiver", etc.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept}.
         */
        public List<CodeableConcept> getRole() {
            return role;
        }

        /**
         * The specific person or organization who is participating/expected to participate in the care team.
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getMember() {
            return member;
        }

        /**
         * The organization of the practitioner.
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getOnBehalfOf() {
            return onBehalfOf;
        }

        /**
         * Indicates when the specific member or organization did (or is intended to) come into effect and end.
         * 
         * @return
         *     An immutable object of type {@link Period}.
         */
        public Period getPeriod() {
            return period;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                !role.isEmpty() || 
                (member != null) || 
                (onBehalfOf != null) || 
                (period != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(role, "role", visitor, CodeableConcept.class);
                    accept(member, "member", visitor);
                    accept(onBehalfOf, "onBehalfOf", visitor);
                    accept(period, "period", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Participant other = (Participant) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(role, other.role) && 
                Objects.equals(member, other.member) && 
                Objects.equals(onBehalfOf, other.onBehalfOf) && 
                Objects.equals(period, other.period);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    role, 
                    member, 
                    onBehalfOf, 
                    period);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private List<CodeableConcept> role = new ArrayList<>();
            private Reference member;
            private Reference onBehalfOf;
            private Period period;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained 
             * social worker counselor", "Caregiver", etc.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param role
             *     Type of involvement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder role(CodeableConcept... role) {
                for (CodeableConcept value : role) {
                    this.role.add(value);
                }
                return this;
            }

            /**
             * Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained 
             * social worker counselor", "Caregiver", etc.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param role
             *     Type of involvement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder role(Collection<CodeableConcept> role) {
                this.role = new ArrayList<>(role);
                return this;
            }

            /**
             * The specific person or organization who is participating/expected to participate in the care team.
             * 
             * @param member
             *     Who is involved
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder member(Reference member) {
                this.member = member;
                return this;
            }

            /**
             * The organization of the practitioner.
             * 
             * @param onBehalfOf
             *     Organization of the practitioner
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder onBehalfOf(Reference onBehalfOf) {
                this.onBehalfOf = onBehalfOf;
                return this;
            }

            /**
             * Indicates when the specific member or organization did (or is intended to) come into effect and end.
             * 
             * @param period
             *     Time period of participant
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder period(Period period) {
                this.period = period;
                return this;
            }

            /**
             * Build the {@link Participant}
             * 
             * @return
             *     An immutable object of type {@link Participant}
             */
            @Override
            public Participant build() {
                return new Participant(this);
            }

            protected Builder from(Participant participant) {
                super.from(participant);
                role.addAll(participant.role);
                member = participant.member;
                onBehalfOf = participant.onBehalfOf;
                period = participant.period;
                return this;
            }
        }
    }
}
