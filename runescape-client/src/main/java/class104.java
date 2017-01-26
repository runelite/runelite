import java.awt.Image;
import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class104 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2043612989
   )
   static int field1681;
   @ObfuscatedName("q")
   static File field1682;
   @ObfuscatedName("c")
   public static class72 field1683 = null;
   @ObfuscatedName("qq")
   protected static Image field1684;
   @ObfuscatedName("v")
   static String field1687;
   @ObfuscatedName("m")
   public static class72 field1688 = null;
   @ObfuscatedName("h")
   public static class72 field1689 = null;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -23115803
   )
   static int field1691;

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   public static final void method1988(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "1"
   )
   static boolean method1989(class159 var0, int var1) {
      int var2 = var0.method3061(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3061(1) != 0) {
            method1989(var0, var1);
         }

         var3 = var0.method3061(13);
         var4 = var0.method3061(13);
         boolean var12 = var0.method3061(1) == 1;
         if(var12) {
            class45.field906[++class45.field909 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field260 = var1;
            if(null != class45.field897[var1]) {
               var6.method220(class45.field897[var1]);
            }

            var6.field643 = class45.field903[var1];
            var6.interacting = class45.field904[var1];
            var7 = class45.field902[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field649[0] = class45.field910[var1];
            var6.field259 = (byte)var8;
            var6.method224(var3 + (var9 << 13) - Projectile.baseX, (var10 << 13) + var4 - class3.baseY);
            var6.field262 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3061(2);
         var4 = class45.field902[var1];
         class45.field902[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3061(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field902[var1];
            var7 = (var11 >> 28) + var4 & 3;
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

            class45.field902[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method3061(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field902[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class45.field902[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }
}
