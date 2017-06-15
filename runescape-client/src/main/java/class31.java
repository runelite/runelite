import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class31 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1242188241
   )
   final int field453;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -690253097
   )
   final int field454;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1083779109
   )
   final int field455;
   @ObfuscatedName("n")
   static Widget field457;

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "1776279019"
   )
   static final void method277(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method1072();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.method1072();
            Client.field997.field2320 = var1;
            Client.field997.field2322 = var2;
            Client.field997.field2321 = 1;
            Client.field997.field2323 = 1;
            class73 var10 = Client.field997;
            int var11 = class66.method1025(var4, var5, var9, var10, Client.collisionMaps[var0.field884], true, Client.field945, Client.field1034);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method1073(Client.field945[var12], Client.field1034[var12], var3);
               }

            }
         }
      }
   }

   class31(int var1, int var2, int var3) {
      this.field455 = var1;
      this.field453 = var2;
      this.field454 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)[LSpritePixels;",
      garbageValue = "0"
   )
   static SpritePixels[] method278(IndexDataBase var0, int var1, int var2) {
      return !class1.method3(var0, var1, var2)?null:CombatInfoListHolder.method1583();
   }
}
