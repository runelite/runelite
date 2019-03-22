/*    */ package net.runelite.client.plugins.rememberclan;
/*    */ 
/*    */ import net.runelite.client.config.Config;
/*    */ import net.runelite.client.config.ConfigGroup;
/*    */ import net.runelite.client.config.ConfigItem;
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
/*    */ @ConfigGroup("rememberclan")
/*    */ public abstract interface RememberClanConfig
/*    */   extends Config
/*    */ {
/*    */   @ConfigItem(position=1, keyName="clanname", name="Clan Name", description="Clanname to always remember")
/*    */   default String clanname()
/*    */   {
/* 44 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\rememberclan\RememberClanConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */