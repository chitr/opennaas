package org.opennaas.core.resources.protocol;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.opennaas.core.protocols.sessionmanager.ListResponse;

/**
 * Manages all the sessions with a single device, identified by device_id
 * 
 * @author eduardgrasa
 * 
 */
@Path("/")
public interface IProtocolSessionManager {

	/**
	 * DeviceID uniquely identifies a device from another within an IaaS container. It is a string generated by the administrator
	 * 
	 * @return
	 */
	public String getResourceID();

	/**
	 * Returns all the ids of the protocol sessions.
	 * 
	 * @return
	 */
	@GET
	@Path("/session/")
	@Produces(MediaType.APPLICATION_XML)
	public ListResponse getAllProtocolSessionIdsWS();

	public Set<String> getAllProtocolSessionIds();

	/**
	 * Obtain a protocol session. A new protocol session will be created with the given context. The session will be pooled and reused if the same
	 * protocol is requested again.
	 * 
	 * @param protocolSessionContext
	 *            the context to use for the creation of this session.
	 * @param lock
	 *            If the session will be locked. If false, the session returned should be used read-only. If true, remember to call releaseSession()
	 *            on it when done.
	 * @return The created protocol session.
	 * @throws ProtocolException
	 */
	public IProtocolSession obtainSession(ProtocolSessionContext protocolSessionContext, boolean lock) throws ProtocolException;

	/**
	 * Obtain a protocol session. The pool will be checked for suitable sessions. If found, one will be returned (waiting to obtain the lock if
	 * needed), otherwise, a new one will be created. This new created session will use a previously registered context with the appropriate protocol.
	 * 
	 * @param protocolSessionContext
	 *            the context to use for the creation of this session.
	 * @param lock
	 *            If the session will be locked. If false, the session returned should be used read-only. If true, remember to call releaseSession()
	 *            on it when done.
	 * @return The protocol session.
	 * @throws ProtocolException
	 */
	public IProtocolSession obtainSessionByProtocol(String protocol, boolean lock) throws ProtocolException;

	/**
	 * Obtain a protocol session. The pool will be checked for this session. If found, one will be returned (waiting to obtain the lock if needed). If
	 * a Session with the given session Id is not found, null will be returned.
	 * 
	 * @param protocolSessionContext
	 *            the context to use for the creation of this session.
	 * @param lock
	 *            If the session will be locked. If false, the session returned should be used read-only. If true, remember to call releaseSession()
	 *            on it when done.
	 * @return The protocol session.
	 * @throws ProtocolException
	 */
	public IProtocolSession getSessionById(String sessionId, boolean lock) throws ProtocolException;

	/**
	 * Return a session to the pool. This will release the internal lock on the session.
	 * 
	 * @param session
	 *            The session to release.
	 * @throws ProtocolException
	 */
	public void releaseSession(IProtocolSession session) throws ProtocolException;

	/**
	 * Return a session to the pool. This will release the internal lock on the session.
	 * 
	 * @param session
	 *            The session Id to release.
	 * @throws ProtocolException
	 */
	public void releaseSession(String sessionId) throws ProtocolException;

	/**
	 * Registers a new context on this session manager. The context will be used if a session with the context's protocol is requested.
	 * 
	 * Only one context per protocol is accepted. Older registered context for given context's protocol (if any) will be unregistered.
	 * 
	 * @param context
	 * @throws ProtocolException
	 *             If trying to register a context for a protocol that is not supported. Or unregistering older context fails.
	 */
	@POST
	@Path("/context/register")
	void registerContext(ProtocolSessionContext context) throws ProtocolException;

	/**
	 * Unregisters a previously registered context. This context will no longer used to create new sessions. All sessions using this context are
	 * terminated.
	 * 
	 * @param context
	 *            The context that will be unregistered.
	 * @throws ProtocolException
	 *             If there is an error terminating sessions
	 */
	@POST
	@Path("/context/unregister")
	@Consumes(MediaType.APPLICATION_XML)
	void unregisterContext(ProtocolSessionContext context) throws ProtocolException;

	/**
	 * Unregisters a previously registered context. This context will no longer used to create new sessions. All sessions using this context are
	 * terminated.
	 * 
	 * @param protocol
	 *            The protocol of the context that will be unregistered.
	 * @throws ProtocolException
	 *             If there is an error terminating sessions
	 */
	@DELETE
	@Path("/context/{protocol}")
	void unregisterContext(@PathParam("protocol") String protocol) throws ProtocolException;

	/**
	 * Returns the list of registered contexts.
	 * 
	 * @return
	 */
	@GET
	@Path("/context/")
	@Produces(MediaType.APPLICATION_XML)
	List<ProtocolSessionContext> getRegisteredContexts();

	/**
	 * Destroys the given session, effectively disconnecting the protocol and releasing the lock.
	 * 
	 * @param sessionID
	 *            The session to destroy.
	 * @throws ProtocolException
	 */
	@DELETE
	@Path("/session/{sessionId}")
	void destroyProtocolSession(@PathParam("sessionId") String sessionID) throws ProtocolException;

	/**
	 * Check if a given session Id is locked.
	 * 
	 * @param sessionId
	 *            The session to lock.
	 * @return
	 * @throws ProtocolException
	 */
	@GET
	@Path("/session/{sessionId}/locked")
	boolean isLocked(@PathParam("sessionId") String sessionId) throws ProtocolException;

}
