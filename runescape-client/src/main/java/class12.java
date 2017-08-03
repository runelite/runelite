import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class12 implements Comparator {
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -677751063
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("fx")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "923655251"
   )
   int method58(class14 var1, class14 var2) {
      return var1.field277 < var2.field277?-1:(var2.field277 == var1.field277?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method58((class14)var1, (class14)var2);
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lib;",
      garbageValue = "-559547976"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2224 != null) {
         var4 = new IndexFile(var0, class155.field2224, class155.field2226[var0], 1000000);
      }

      return new IndexData(var4, WorldMapType1.field406, var0, var1, var2, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   public static final boolean method71() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field612 == KeyFocusListener.field614) {
            return false;
         } else {
            DState.field2348 = KeyFocusListener.field616[KeyFocusListener.field612];
            class1.field8 = KeyFocusListener.field608[KeyFocusListener.field612];
            KeyFocusListener.field612 = KeyFocusListener.field612 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "417471230"
   )
   static final void method69(boolean var0) {
      for(int var1 = 0; var1 < Client.field932; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4625()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1216 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field986[var4][var5] == Client.field1038) {
                     continue;
                  }

                  Client.field986[var4][var5] = Client.field1038;
               }

               if(!var2.composition.field3542) {
                  var3 -= Integer.MIN_VALUE;
               }

               class51.region.method2711(class8.plane, var2.x, var2.y, class18.getTileHeight(var2.x + (var2.field1216 * 64 - 64), var2.field1216 * 64 - 64 + var2.y, class8.plane), var2.field1216 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1192);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "65"
   )
   static final void method67(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class62.field739[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Liq;",
      garbageValue = "2"
   )
   public static class252 method60(int var0) {
      class252 var1 = (class252)class252.field3373.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class95.field1464.getConfigData(34, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4425(new Buffer(var2));
         }

         var1.method4424();
         class252.field3373.put(var1, (long)var0);
         return var1;
      }
   }
}
