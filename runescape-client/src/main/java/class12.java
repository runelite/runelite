import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class12 implements Comparator {
   @ObfuscatedName("er")
   static class262 field272;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1751071227
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -853551867
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "28"
   )
   static final int method49(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method52((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1988045950"
   )
   int method52(class14 var1, class14 var2) {
      return var1.field285 < var2.field285?-1:(var1.field285 == var2.field285?0:1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "328045207"
   )
   static int method58(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class83.field1311:Buffer.field2384;
      if(var0 == 1700) {
         class83.intStack[++class83.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class83.intStack[++class83.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++class83.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class83.intStack[++class83.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "126963349"
   )
   public static Varbit method60(int var0) {
      Varbit var1 = (Varbit)Varbit.field3378.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class5.field28.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method4485(new Buffer(var2));
         }

         Varbit.field3378.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1209350070"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class24.field356.method869();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field901 = 0;
            Client.field912 = 0;
         }

         if(var0 != 20 && var0 != 40 && class98.field1523 != null) {
            class98.field1523.method3048();
            class98.field1523 = null;
         }

         if(Client.gameState == 25) {
            Client.field949 = 0;
            Client.field1044 = 0;
            Client.field1119 = 1;
            Client.field947 = 0;
            Client.field923 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class239.method4338(class64.field785, class77.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class239.method4338(class64.field785, class77.indexSprites, false, 4);
            } else {
               World.method1589();
            }
         } else {
            class239.method4338(class64.field785, class77.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
