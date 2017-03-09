import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class15 {
   @ObfuscatedName("x")
   static final class15 field184 = new class15();
   @ObfuscatedName("ci")
   static Font field185;
   @ObfuscatedName("c")
   static final class15 field186 = new class15();
   @ObfuscatedName("g")
   public static short[] field187;
   @ObfuscatedName("et")
   static SpritePixels[] field189;
   @ObfuscatedName("pq")
   static class116 field190;
   @ObfuscatedName("ee")
   static SpritePixels field193;
   @ObfuscatedName("ed")
   static SpritePixels[] field194;
   @ObfuscatedName("j")
   static final class15 field199 = new class15();
   @ObfuscatedName("d")
   static final class15 field200 = new class15();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lclass216;",
      garbageValue = "-43"
   )
   public static class216 method200(int var0) {
      class216[] var1 = new class216[]{class216.field3178, class216.field3181, class216.field3179};
      class216[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class216 var4 = var2[var3];
         if(var0 == var4.field3180) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "-81"
   )
   static boolean method201(class159 var0, int var1) {
      int var2 = var0.method3097(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3097(1) != 0) {
            method201(var0, var1);
         }

         var3 = var0.method3097(13);
         var4 = var0.method3097(13);
         boolean var12 = var0.method3097(1) == 1;
         if(var12) {
            class45.field932[++class45.field919 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field276 = var1;
            if(null != class45.field923[var1]) {
               var6.method244(class45.field923[var1]);
            }

            var6.field676 = class45.field929[var1];
            var6.interacting = class45.field930[var1];
            var7 = class45.field928[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field682[0] = class45.field935[var1];
            var6.field291 = (byte)var8;
            var6.method248((var9 << 13) + var3 - CombatInfoListHolder.baseX, var4 + (var10 << 13) - class3.baseY);
            var6.field293 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3097(2);
         var4 = class45.field928[var1];
         class45.field928[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3097(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field928[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field928[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method3097(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field928[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var11 + var7 & 255;
            class45.field928[var1] = (var9 << 14) + (var8 << 28) + var10;
            return false;
         }
      }
   }
}
