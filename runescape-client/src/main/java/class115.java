import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class115 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 187508384712622927L
   )
   static long field1983;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -6295939875462635615L
   )
   static long field1986;
   @ObfuscatedName("av")
   static class168 field1988;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-123"
   )
   public static void method2439(boolean var0) {
      if(null != class171.field2731) {
         try {
            class119 var1 = new class119(4);
            var1.method2477(var0?2:3);
            var1.method2606(0);
            class171.field2731.method2964(var1.field2007, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2731.method2960();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2741;
            class171.field2731 = null;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "126"
   )
   public static void method2440(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2440(var0, var1, var2, var5 - 1);
         method2440(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lclass152;",
      garbageValue = "-2136131108"
   )
   public static class152[] method2441() {
      return new class152[]{class152.field2278, class152.field2275, class152.field2273, class152.field2279, class152.field2272};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "126"
   )
   static final void method2442() {
      if(client.field332 > 0) {
         class14.method172();
      } else {
         class15.method188(40);
         client.field562 = class167.field2697;
         class167.field2697 = null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "528246428"
   )
   public static int method2443(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
