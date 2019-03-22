/*    */ package net.runelite.client.plugins.vanguards;
/*    */ 
/*    */ import net.runelite.client.config.Config;
/*    */ import net.runelite.client.config.ConfigGroup;
/*    */ import net.runelite.client.config.ConfigItem;
/*    */ 
/*    */ 
/*    */ @ConfigGroup("vanguards")
/*    */ public abstract interface VanguardsConfig
/*    */   extends Config
/*    */ {
/*    */   @ConfigItem(keyName="showHealth", name="Show Vanguard Health", description="Shows vanguard health percent", position=1)
/*    */   default boolean showHealth()
/*    */   {
/* 15 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   @ConfigItem(keyName="showTile", name="Show Vanguard Color", description="Shows vanguard color on floor", position=1)
/*    */   default boolean showTile()
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lightsaber\Desktop\lyzrdRl.jar!\net\runelite\client\plugins\vanguards\VanguardsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */