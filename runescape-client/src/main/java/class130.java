import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class130 {
   @ObfuscatedName("w")
   static int[] field2098;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class53.field1138 = null;
            class38.field815 = null;
            class137.field2125 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field522 = 0;
            Client.field468 = 0;
            Client.field401 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class62.field1259) {
            class62.field1259.method3044();
            class62.field1259 = null;
         }

         if(Client.gameState == 25) {
            Client.field405 = 0;
            Client.field335 = 0;
            Client.field336 = 1;
            Client.field337 = 0;
            Client.field535 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               ItemLayer.method2260(class129.canvas, class33.field753, class109.field1922, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               ItemLayer.method2260(class129.canvas, class33.field753, class109.field1922, false, 4);
            } else if(class93.field1615) {
               class232.field3276 = null;
               class33.field721 = null;
               class33.field722 = null;
               class40.field883 = null;
               class13.field195 = null;
               class162.field2660 = null;
               ChatMessages.field276 = null;
               class21.field576 = null;
               class33.field723 = null;
               class156.field2322 = null;
               ItemLayer.field1739 = null;
               class5.field92 = null;
               class26.field637 = null;
               ChatMessages.field277 = null;
               class0.field12 = null;
               ItemLayer.field1734 = null;
               FrameMap.field1816 = null;
               class33.field730 = null;
               field2098 = null;
               World.field659 = null;
               ChatMessages.field270 = null;
               Frames.field1835 = null;
               class40.method771(2);
               class22.method558(true);
               class93.field1615 = false;
            }
         } else {
            ItemLayer.method2260(class129.canvas, class33.field753, class109.field1922, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "182068310"
   )
   public static void method2876(int var0) {
      class143.mouseIdleTicks = var0;
   }
}
