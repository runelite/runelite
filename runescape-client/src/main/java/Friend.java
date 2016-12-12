import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1743365343
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 583031109
   )
   @Export("world")
   int world;
   @ObfuscatedName("e")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("h")
   static ModIcon field148;
   @ObfuscatedName("n")
   boolean field149;
   @ObfuscatedName("bw")
   static class184 field150;
   @ObfuscatedName("ag")
   static class184 field152;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   boolean field157;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "68"
   )
   static void method166(int var0) {
      Client.field562 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class63.method1131();
      if(Client.gameState >= 25) {
         FrameMap.method1689();
      }

      GameEngine.field1775 = true;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(LWidget;IIS)V",
      garbageValue = "-2368"
   )
   static void method167(Widget var0, int var1, int var2) {
      if(var0.field2213 == 0) {
         var0.relativeX = var0.field2288;
      } else if(var0.field2213 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2288;
      } else if(var0.field2213 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2288;
      } else if(var0.field2213 == 3) {
         var0.relativeX = var1 * var0.field2288 >> 14;
      } else if(var0.field2213 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.field2288 * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2288 * var1 >> 14);
      }

      if(var0.field2214 == 0) {
         var0.relativeY = var0.field2218;
      } else if(var0.field2214 == 1) {
         var0.relativeY = var0.field2218 + (var2 - var0.height) / 2;
      } else if(var0.field2214 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2218;
      } else if(var0.field2214 == 3) {
         var0.relativeY = var0.field2218 * var2 >> 14;
      } else if(var0.field2214 == 4) {
         var0.relativeY = (var0.field2218 * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var0.field2218 * var2 >> 14);
      }

      if(Client.field456 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo2;",
      garbageValue = "110"
   )
   public static CombatInfo2 method168(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2837.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2832.method3211(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method3469(new Buffer(var2));
         }

         CombatInfo2.field2837.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1589458219"
   )
   static void method169(Sequence var0, int var1, int var2, int var3) {
      if(Client.field528 < 50 && Client.field527 != 0) {
         if(null != var0.field3055 && var1 < var0.field3055.length) {
            int var4 = var0.field3055[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field529[Client.field528] = var5;
               Client.field409[Client.field528] = var6;
               Client.field439[Client.field528] = 0;
               Client.field533[Client.field528] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field483[Client.field528] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field528;
            }
         }
      }
   }
}
