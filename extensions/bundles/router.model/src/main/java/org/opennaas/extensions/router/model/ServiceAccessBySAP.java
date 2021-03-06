/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12
 * 09:21:06 CET 2011.
 */

package org.opennaas.extensions.router.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class ServiceAccessBySAP as well as methods comparable to
 * the invokeMethods defined for this class. This Class implements the ServiceAccessBySAPBean Interface. The CIM class ServiceAccessBySAP is described
 * as follows:
 * 
 * CIM_ServiceAccessBySAP is an association that identifies the access points for a Service. For example, a printer might be accessed by NetWare,
 * MacIntosh or Windows ServiceAccessPoints, which might all be hosted on different Systems.
 */
@XmlSeeAlso({
		ProvidesEndpoint.class
})
public class ServiceAccessBySAP extends Dependency implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2484086333370614074L;

	/**
	 * This constructor creates a ServiceAccessBySAPBeanImpl Class which implements the ServiceAccessBySAPBean Interface, and encapsulates the CIM
	 * class ServiceAccessBySAP in a Java Bean. The CIM class ServiceAccessBySAP is described as follows:
	 * 
	 * CIM_ServiceAccessBySAP is an association that identifies the access points for a Service. For example, a printer might be accessed by NetWare,
	 * MacIntosh or Windows ServiceAccessPoints, which might all be hosted on different Systems.
	 */
	public ServiceAccessBySAP() {
	};

	/**
	 * This method create an Association of the type ServiceAccessBySAP between one Service object and ServiceAccessPoint object
	 */
	public static ServiceAccessBySAP link(Service
			antecedent, ServiceAccessPoint dependent) {

		return (ServiceAccessBySAP) Association.link(ServiceAccessBySAP.class, antecedent, dependent);
	}// link

} // Class ServiceAccessBySAP
