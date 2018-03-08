import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class154 extends class297 {
   @ObfuscatedName("t")
   final boolean field2113;

   public class154(boolean var1) {
      this.field2113 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "-1486029829"
   )
   int method3146(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2113?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2113?1:-1;
      }

      return this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3146((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILfv;Lfa;I)Z",
      garbageValue = "645028754"
   )
   static final boolean method3150(int var0, int var1, class178 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class177.field2249[var6][var7] = 99;
      class177.field2250[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class177.field2251[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class177.field2253[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class177.field2251[var11];
         var5 = class177.field2253[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3427(1, var4, var5, var3)) {
            UnitPriceComparator.field297 = var4;
            TotalQuantityComparator.field282 = var5;
            return true;
         }

         int var15 = class177.field2250[var16][var17] + 1;
         if(var16 > 0 && class177.field2249[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17] = 2;
            class177.field2250[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class177.field2249[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17] = 8;
            class177.field2250[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class177.field2249[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2251[var18] = var4;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16][var17 - 1] = 1;
            class177.field2250[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class177.field2249[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2251[var18] = var4;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16][var17 + 1] = 4;
            class177.field2250[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class177.field2249[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17 - 1] = 3;
            class177.field2250[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class177.field2249[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17 - 1] = 9;
            class177.field2250[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class177.field2249[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17 + 1] = 6;
            class177.field2250[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class177.field2249[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17 + 1] = 12;
            class177.field2250[var16 + 1][var17 + 1] = var15;
         }
      }

      UnitPriceComparator.field297 = var4;
      TotalQuantityComparator.field282 = var5;
      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-29452785"
   )
   public static boolean method3149(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-601221244"
   )
   static final void method3152() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            MapCacheArchiveNames.method592(var2, var2.composition.field3710);
         }
      }

   }
}
