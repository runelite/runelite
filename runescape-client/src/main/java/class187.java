import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class187 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1668735407
   )
   public static int field2768;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1156265605
   )
   public int field2769 = 0;
   @ObfuscatedName("x")
   static class182 field2770;
   @ObfuscatedName("c")
   public static NodeCache field2771 = new NodeCache(64);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1800200084"
   )
   void method3453(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3457(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2119481572"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class150.field2042 = null;
            class97.field1643 = null;
            class85.field1471 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field471 = 0;
            Client.field565 = 0;
         }

         if(var0 != 20 && var0 != 40 && class8.field88 != null) {
            class8.field88.method2115();
            class8.field88 = null;
         }

         if(Client.gameState == 25) {
            Client.field371 = 0;
            Client.field389 = 0;
            Client.field368 = 1;
            Client.field369 = 0;
            Client.field453 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class105.method2066(CollisionData.canvas, class99.field1655, class0.field2, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class105.method2066(CollisionData.canvas, class99.field1655, class0.field2, false, 4);
            } else {
               class18.method213();
            }
         } else {
            class105.method2066(CollisionData.canvas, class99.field1655, class0.field2, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "227599132"
   )
   void method3457(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2769 = var1.readUnsignedShort();
      }

   }
}
