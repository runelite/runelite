import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class66 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static final class66 field811;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static final class66 field806;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static final class66 field807;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static final class66 field810;
   @ObfuscatedName("bc")
   static String field805;

   static {
      field811 = new class66();
      field806 = new class66();
      field807 = new class66();
      field810 = new class66();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "-63"
   )
   static int method1091(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class84.intStack[--class84.intStackSize];
         var4 = class266.method4862(var3);
      } else {
         var4 = var2?class269.field3661:DecorativeObject.field2164;
      }

      if(var0 == 1000) {
         class84.intStackSize -= 4;
         var4.originalX = class84.intStack[class84.intStackSize];
         var4.originalY = class84.intStack[class84.intStackSize + 1];
         var4.field2715 = class84.intStack[class84.intStackSize + 2];
         var4.field2629 = class84.intStack[class84.intStackSize + 3];
         class255.method4531(var4);
         class5.clientInstance.method1198(var4);
         if(var3 != -1 && var4.type == 0) {
            Player.method1171(Item.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class84.intStackSize -= 4;
         var4.originalWidth = class84.intStack[class84.intStackSize];
         var4.field2635 = class84.intStack[class84.intStackSize + 1];
         var4.field2627 = class84.intStack[class84.intStackSize + 2];
         var4.buttonType = class84.intStack[class84.intStackSize + 3];
         class255.method4531(var4);
         class5.clientInstance.method1198(var4);
         if(var3 != -1 && var4.type == 0) {
            Player.method1171(Item.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class84.intStack[--class84.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class255.method4531(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2702 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2685 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1233158631"
   )
   static void method1090(int var0, String var1) {
      int var2 = class97.field1493;
      int[] var3 = class97.field1494;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != class54.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(56);
               Client.secretPacketBuffer1.method3276(0);
               Client.secretPacketBuffer1.putShortLE(var3[var5]);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(29);
               Client.secretPacketBuffer1.method3276(0);
               Client.secretPacketBuffer1.putLEInt(var3[var5]);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(217);
               Client.secretPacketBuffer1.method3208(var3[var5]);
               Client.secretPacketBuffer1.method3199(0);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(253);
               Client.secretPacketBuffer1.method3199(0);
               Client.secretPacketBuffer1.method3208(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         WorldMapType3.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
