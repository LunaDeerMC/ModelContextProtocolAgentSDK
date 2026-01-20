/**
 * MCP Agent SDK - Model Context Protocol Agent for Minecraft.
 * <p>
 * This SDK provides annotations and interfaces for Minecraft plugins to expose
 * their capabilities to external AI agents through the Model Context Protocol.
 * </p>
 * 
 * <h2>Core Concepts</h2>
 * <ul>
 *   <li><b>Provider</b>: A class that provides one or more capabilities</li>
 *   <li><b>Context</b>: Read-only query capability</li>
 *   <li><b>Action</b>: Write operation capability</li>
 *   <li><b>Event</b>: Real-time event subscription capability</li>
 * </ul>
 * 
 * <h2>Quick Example</h2>
 * <pre>{@code
 * @McpProvider(id = "my-plugin", name = "My Plugin", version = "1.0.0")
 * public class MyProvider {
 *     
 *     @McpContext(id = "myplugin.data.get", name = "Get Data")
 *     public Data getData(@Param(name = "id", required = true) String id) {
 *         return database.find(id);
 *     }
 *     
 *     @McpAction(id = "myplugin.data.set", name = "Set Data", risk = RiskLevel.MEDIUM)
 *     public void setData(
 *         @Param(name = "id", required = true) String id,
 *         @Param(name = "value", required = true) String value
 *     ) {
 *         database.save(id, value);
 *     }
 * }
 * }</pre>
 * 
 * @see cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations
 * @see cn.lunadeer.mc.modelContextProtocolAgentSDK.api
 * 
 * @author ZhangYuheng
 * @version 1.0.0
 * @since 1.0.0
 */
package cn.lunadeer.mc.modelContextProtocolAgentSDK;
