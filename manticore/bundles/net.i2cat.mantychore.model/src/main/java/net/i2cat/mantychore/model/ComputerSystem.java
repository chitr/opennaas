/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12 
 * 09:21:06 CET 2011. 
 */

package net.i2cat.mantychore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class ComputerSystem as well as methods comparable to the
 * invokeMethods defined for this class. This Class implements the ComputerSystemBean Interface. The CIM class ComputerSystem is described as follows:
 * 
 * A class derived from System that is a special collection of ManagedSystemElements. This collection is related to the providing of compute
 * capabilities and MAY serve as an aggregation point to associate one or more of the following elements: FileSystem, OperatingSystem, Processor and
 * Memory (Volatile and/or NonVolatile Storage).
 */
public class ComputerSystem extends System implements Serializable {

	/**
	 * This constructor creates a ComputerSystemBeanImpl Class which implements the ComputerSystemBean Interface, and encapsulates the CIM class
	 * ComputerSystem in a Java Bean. The CIM class ComputerSystem is described as follows:
	 * 
	 * A class derived from System that is a special collection of ManagedSystemElements. This collection is related to the providing of compute
	 * capabilities and MAY serve as an aggregation point to associate one or more of the following elements: FileSystem, OperatingSystem, Processor
	 * and Memory (Volatile and/or NonVolatile Storage).
	 */
	public ComputerSystem() {
	};

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property NameFormat.
	 */

	public enum NameFormat {
		OTHER,
		IP,
		DIAL,
		HID,
		NWA,
		HWA,
		X25,
		ISDN,
		IPX,
		DCC,
		ICD,
		E_164,
		SNA,
		OID_OSI,
		WWN,
		NAA
	}

	private NameFormat	nameFormat;

	/**
	 * This method returns the ComputerSystem.nameFormat property value. This property is described as follows:
	 * 
	 * The ComputerSystem object and its derivatives are Top Level Objects of CIM. They provide the scope for numerous components. Having unique
	 * System keys is required. The NameFormat property identifies how the ComputerSystem Name is generated. The NameFormat ValueMap qualifier defines
	 * the various mechanisms for assigning the name. Note that another name can be assigned and used for the ComputerSystem that better suit a
	 * business, using the inherited ElementName property.
	 * 
	 * @return String current nameFormat property value
	 * @exception Exception
	 */
	public NameFormat getNameFormat() {

		return this.nameFormat;
	} // getNameFormat

	/**
	 * This method sets the ComputerSystem.nameFormat property value. This property is described as follows:
	 * 
	 * The ComputerSystem object and its derivatives are Top Level Objects of CIM. They provide the scope for numerous components. Having unique
	 * System keys is required. The NameFormat property identifies how the ComputerSystem Name is generated. The NameFormat ValueMap qualifier defines
	 * the various mechanisms for assigning the name. Note that another name can be assigned and used for the ComputerSystem that better suit a
	 * business, using the inherited ElementName property.
	 * 
	 * @param String
	 *            new nameFormat property value
	 * @exception Exception
	 */
	public void setNameFormat(NameFormat nameFormat) {

		this.nameFormat = nameFormat;
	} // setNameFormat

	@Override
	public List<String> getChildren() {
		List<String> nameChildren = new ArrayList<String>();

		for (ManagedSystemElement system : getManagedSystemElements()) {
			// Check that it is a logical device | router
			if (system instanceof ComputerSystem) {
				ComputerSystem sys = (ComputerSystem) system;
				nameChildren.add(sys.getName());
			}
		}

		return nameChildren;
	}

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property Dedicated.
	 */

	public enum Dedicated {
		NOT_DEDICATED,
		UNKNOWN,
		OTHER,
		STORAGE,
		ROUTER,
		SWITCH,
		LAYER_3_SWITCH,
		CENTRAL_OFFICE_SWITCH,
		HUB,
		ACCESS_SERVER,
		FIREWALL,
		PRINT,
		I_O,
		WEB_CACHING,
		MANAGEMENT,
		BLOCK_SERVER,
		FILE_SERVER,
		MOBILE_USER_DEVICE,
		REPEATER,
		BRIDGE_EXTENDER,
		GATEWAY,
		STORAGE_VIRTUALIZER,
		MEDIA_LIBRARY,
		EXTENDERNODE,
		NAS_HEAD,
		SELF_CONTAINED_NAS,
		UPS,
		IP_PHONE,
		MANAGEMENT_CONTROLLER,
		CHASSIS_MANAGER,
		HOST_BASED_RAID_CONTROLLER,
		STORAGE_DEVICE_ENCLOSURE,
		DESKTOP,
		LAPTOP,
		VIRTUAL_TAPE_LIBRARY,
		VIRTUAL_LIBRARY_SYSTEM,
		NETWORK_PC_THIN_CLIENT,
		FC_SWITCH,
		ETHERNET_SWITCH,
		DMTF_RESERVED,
		VENDOR_RESERVED
	}

	private Dedicated	dedicated;

	/**
	 * This method returns the ComputerSystem.dedicated property value. This property is described as follows:
	 * 
	 * Enumeration indicating the purpose(s) to which the ComputerSystem is dedicated, if any, and what functionality is provided. For example, one
	 * could specify that the System is dedicated to "Print" (value=11) or acts as a "Hub" (value=8). Also, one could indicate that this is a general
	 * purpose system by indicating 'Not Dedicated' (value=0) but that it also hosts 'Print' (value=11) or mobile phone 'Mobile User Device'
	 * (value=17) services. A clarification is needed with respect to the value 17 ("Mobile User Device"). An example of a dedicated user device is a
	 * mobile phone or a barcode scanner in a store that communicates via radio frequency. These systems are quite limited in functionality and
	 * programmability, and are not considered 'general purpose' computing platforms. Alternately, an example of a mobile system that is 'general
	 * purpose' (i.e., is NOT dedicated) is a hand-held computer. Although limited in its programmability, new software can be downloaded and its
	 * functionality expanded by the user. A value of "Management" indicates this instance is dedicated to hosting system management software. A value
	 * of "Management Controller" indicates this instance represents specialized hardware dedicated to systems management (i.e., a Baseboard
	 * Management Controller (BMC) or service processor). The management scope of a "Management Controller" is typically a single managed system in
	 * which it is contained. A value of "Chassis Manager" indicates this instance represents a system dedicated to management of a blade chassis and
	 * its contained devices. This value would be used to represent a Shelf Controller. A "Chassis Manager" is an aggregation point for management and
	 * may rely on subordinate management controllers for the management of constituent parts. A value of "Host-based RAID Controller" indicates this
	 * instance represents a RAID storage controller contained within a host computer. A value of "Storage Device Enclosure" indicates this instance
	 * represents an enclosure that contains storage devices. A "Virtual Tape Library" is the emulation of a tape library by a Virtual Library System.
	 * A "Virtual Library System" uses disk storage to emulate tape libraries.A "FC Switch" indicates this instance is dedicated to switching layer 2
	 * fibre channel frames. An "Ethernet Switch" indicates this instance is dedicated to switching layer 2 ethernet frames.
	 * 
	 * @return int current dedicated property value
	 * @exception Exception
	 */
	public Dedicated getDedicated() {

		return this.dedicated;
	} // getDedicated

	/**
	 * This method sets the ComputerSystem.dedicated property value. This property is described as follows:
	 * 
	 * Enumeration indicating the purpose(s) to which the ComputerSystem is dedicated, if any, and what functionality is provided. For example, one
	 * could specify that the System is dedicated to "Print" (value=11) or acts as a "Hub" (value=8). Also, one could indicate that this is a general
	 * purpose system by indicating 'Not Dedicated' (value=0) but that it also hosts 'Print' (value=11) or mobile phone 'Mobile User Device'
	 * (value=17) services. A clarification is needed with respect to the value 17 ("Mobile User Device"). An example of a dedicated user device is a
	 * mobile phone or a barcode scanner in a store that communicates via radio frequency. These systems are quite limited in functionality and
	 * programmability, and are not considered 'general purpose' computing platforms. Alternately, an example of a mobile system that is 'general
	 * purpose' (i.e., is NOT dedicated) is a hand-held computer. Although limited in its programmability, new software can be downloaded and its
	 * functionality expanded by the user. A value of "Management" indicates this instance is dedicated to hosting system management software. A value
	 * of "Management Controller" indicates this instance represents specialized hardware dedicated to systems management (i.e., a Baseboard
	 * Management Controller (BMC) or service processor). The management scope of a "Management Controller" is typically a single managed system in
	 * which it is contained. A value of "Chassis Manager" indicates this instance represents a system dedicated to management of a blade chassis and
	 * its contained devices. This value would be used to represent a Shelf Controller. A "Chassis Manager" is an aggregation point for management and
	 * may rely on subordinate management controllers for the management of constituent parts. A value of "Host-based RAID Controller" indicates this
	 * instance represents a RAID storage controller contained within a host computer. A value of "Storage Device Enclosure" indicates this instance
	 * represents an enclosure that contains storage devices. A "Virtual Tape Library" is the emulation of a tape library by a Virtual Library System.
	 * A "Virtual Library System" uses disk storage to emulate tape libraries.A "FC Switch" indicates this instance is dedicated to switching layer 2
	 * fibre channel frames. An "Ethernet Switch" indicates this instance is dedicated to switching layer 2 ethernet frames.
	 * 
	 * @param int new dedicated property value
	 * @exception Exception
	 */
	public void setDedicated(Dedicated dedicated) {

		this.dedicated = dedicated;
	} // setDedicated

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property otherDedicatedDescriptions.
	 */
	private String[]	otherDedicatedDescriptions;

	/**
	 * This method returns the ComputerSystem.otherDedicatedDescriptions property value. This property is described as follows:
	 * 
	 * A string describing how or why the system is dedicated when the Dedicated array includes the value 2, "Other".
	 * 
	 * @return String[] current otherDedicatedDescriptions property value
	 * @exception Exception
	 */
	public String[] getOtherDedicatedDescriptions() {

		return this.otherDedicatedDescriptions;
	} // getOtherDedicatedDescriptions

	/**
	 * This method sets the ComputerSystem.otherDedicatedDescriptions property value. This property is described as follows:
	 * 
	 * A string describing how or why the system is dedicated when the Dedicated array includes the value 2, "Other".
	 * 
	 * @param String
	 *            [] new otherDedicatedDescriptions property value
	 * @exception Exception
	 */
	public void setOtherDedicatedDescriptions(String[]
			otherDedicatedDescriptions) {

		this.otherDedicatedDescriptions = otherDedicatedDescriptions;
	} // setOtherDedicatedDescriptions

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property ResetCapability.
	 */

	public enum ResetCapability {
		OTHER,
		UNKNOWN,
		DISABLED,
		ENABLED,
		NOT_IMPLEMENTED
	}

	private ResetCapability	resetCapability;

	/**
	 * This method returns the ComputerSystem.resetCapability property value. This property is described as follows:
	 * 
	 * If enabled (value = 4), the ComputerSystem can be reset via hardware (e.g. the power and reset buttons). If disabled (value = 3), hardware
	 * reset is not allowed. In addition to Enabled and Disabled, other Values for the property are also defined - "Not Implemented" (5), "Other" (1)
	 * and "Unknown" (2).
	 * 
	 * @return int current resetCapability property value
	 * @exception Exception
	 */
	public ResetCapability getResetCapability() {

		return this.resetCapability;
	} // getResetCapability

	/**
	 * This method sets the ComputerSystem.resetCapability property value. This property is described as follows:
	 * 
	 * If enabled (value = 4), the ComputerSystem can be reset via hardware (e.g. the power and reset buttons). If disabled (value = 3), hardware
	 * reset is not allowed. In addition to Enabled and Disabled, other Values for the property are also defined - "Not Implemented" (5), "Other" (1)
	 * and "Unknown" (2).
	 * 
	 * @param int new resetCapability property value
	 * @exception Exception
	 */
	public void setResetCapability(ResetCapability resetCapability) {

		this.resetCapability = resetCapability;
	} // setResetCapability

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property PowerManagementCapabilities.
	 */
	@Deprecated
	public enum PowerManagementCapabilities {
		UNKNOWN,
		NOT_SUPPORTED,
		DISABLED,
		ENABLED,
		POWER_SAVING_MODES_ENTERED_AUTOMATICALLY,
		POWER_STATE_SETTABLE,
		POWER_CYCLING_SUPPORTED,
		TIMED_POWER_ON_SUPPORTED
	}

	@Deprecated
	private PowerManagementCapabilities	powerManagementCapabilities;

	/**
	 * This method returns the ComputerSystem.powerManagementCapabilities property value. This property is described as follows:
	 * 
	 * An enumerated array describing the power management capabilities of the ComputerSystem. The use of this property has been deprecated. Instead,
	 * the Power Capabilites property in an associated PowerManagement Capabilities class should be used.
	 * 
	 * @return int current powerManagementCapabilities property value
	 * @exception Exception
	 */
	@Deprecated
	public PowerManagementCapabilities getPowerManagementCapabilities() {

		return this.powerManagementCapabilities;
	} // getPowerManagementCapabilities

	/**
	 * This method sets the ComputerSystem.powerManagementCapabilities property value. This property is described as follows:
	 * 
	 * An enumerated array describing the power management capabilities of the ComputerSystem. The use of this property has been deprecated. Instead,
	 * the Power Capabilites property in an associated PowerManagement Capabilities class should be used.
	 * 
	 * @param int new powerManagementCapabilities property value
	 * @exception Exception
	 */
	@Deprecated
	public void setPowerManagementCapabilities(PowerManagementCapabilities
			powerManagementCapabilities) {

		this.powerManagementCapabilities = powerManagementCapabilities;
	} // setPowerManagementCapabilities

} // Class ComputerSystem