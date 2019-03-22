/*    */ package net.runelite.client.plugins.rememberclan;
/*    */ 
/*    */ import com.google.inject.Provides;
/*    */ import javax.inject.Inject;
/*    */ import net.runelite.api.Client;
/*    */ import net.runelite.api.VarClientStr;
/*    */ import net.runelite.api.events.GameTick;
/*    */ import net.runelite.client.chat.ChatMessageManager;
/*    */ import net.runelite.client.config.ConfigManager;
/*    */ import net.runelite.client.eventbus.Subscribe;
/*    */ import net.runelite.client.plugins.Plugin;
/*    */ import net.runelite.client.plugins.PluginDescriptor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @PluginDescriptor(name="Remember Clan", description="Remember a specific clan!")
/*    */ public class RememberClanPlugin
/*    */   extends Plugin
/*    */ {
/*    */   @Inject
/*    */   private Client client;
/*    */   @Inject
/*    */   private RememberClanConfig config;
/*    */   @Inject
/*    */   private ChatMessageManager chatMessageManager;
/*    */   private boolean loggingIn;
/*    */   
/*    */   @Provides
/*    */   RememberClanConfig provideConfig(ConfigManager configManager)
/*    */   {
/* 66 */     return (RememberClanConfig)configManager.getConfig(RememberClanConfig.class);
/*    */   }
/*    */   
/*    */   @Subscribe
/*    */   public void onGameTick(GameTick event)
/*    */   {
/* 72 */     this.client.setVar(VarClientStr.RECENT_CLAN_CHAT, this.config.clanname());
/*    */   }
/*    */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\rememberclan\RememberClanPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */