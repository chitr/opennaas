package org.opennaas.core.resources.shell;

import java.util.List;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.opennaas.core.resources.IResourceIdentifier;
import org.opennaas.core.resources.IncorrectLifecycleStateException;
import org.opennaas.core.resources.ResourceException;
import org.opennaas.core.resources.ResourceManager;


/**
 * Start one or more resources
 * 
 * @author Scott Campbell (CRC)
 * 
 */
@Command(scope = "resource", name = "start", description = "Start one or more resources")
public class StartResourceCommand extends GenericKarafCommand {

	@Argument(index = 0, name = "resourceType:resourceName", description = "A space delimited list of resource type:name to be started", required = true, multiValued = true)
	private List<String>	resourceIDs;

	@Override
	protected Object doExecute() throws Exception {
		initcommand("resource start");

		try {
			ResourceManager manager = (ResourceManager) getResourceManager();
			for (String id : resourceIDs) {

				if (!splitResourceName(id))
					return null;

				IResourceIdentifier identifier = null;
				try {
					identifier = manager.getIdentifierFromResourceName(argsRouterName[0], argsRouterName[1]);
					if (identifier != null) {
						printInfo("Starting Resource: "
								+ argsRouterName[1]);
						manager.startResource(identifier);
						counter++;
						printInfo("Resource " + argsRouterName[1] + " started.");
					} else {
						printError("The resource " + argsRouterName[1] +
										" is not found on repository.");
					}
				} catch (ResourceException e) {
					if (e.getCause() instanceof IncorrectLifecycleStateException)
						printError("Cannot start resource " + argsRouterName[1] + " from state: " + ((IncorrectLifecycleStateException) e.getCause())
								.getResourceState());
					else
						printError(e);
					printError("Resource " + argsRouterName[1] + " was not started");

				}

				printSymbol(horizontalSeparator);
			}
			printInfo("Started " + counter + " resource/s from " + resourceIDs.size());

		} catch (Exception e) {
			printError("An error occurred starting the resource.");
			printError(e);
		}
		endcommand();
		return null;

	}
}