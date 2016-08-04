import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class0 extends class211 {
   @ObfuscatedName("b")
   String field0;
   @ObfuscatedName("g")
   boolean field1;
   @ObfuscatedName("r")
   class176 field2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1034100333
   )
   int field3;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -598270317
   )
   int field4;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1801662737
   )
   int field5;
   @ObfuscatedName("k")
   class176 field6;
   @ObfuscatedName("l")
   Object[] field8;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 802213195
   )
   int field9;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1809307049
   )
   int field10;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -765471335
   )
   @Export("baseX")
   static int field11;
   @ObfuscatedName("be")
   static class171 field12;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1997724013
   )
   int field14;

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1815765643"
   )
   static void method0() {
      if(client.field448) {
         class176 var0 = class151.method3265(class13.field209, client.field449);
         if(var0 != null && null != var0.field2899) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field8 = var0.field2899;
            class16.method203(var1);
         }

         client.field448 = false;
         class79.method1777(var0);
      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILclass81;Lclass178;B)V",
      garbageValue = "-21"
   )
   static final void method1(int var0, int var1, int var2, int var3, class81 var4, class178 var5) {
      if(var4 != null) {
         int var6 = client.field365 + client.field399 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1661[var6];
            int var9 = class94.field1662[var6];
            var8 = 256 * var8 / (client.field367 + 256);
            var9 = 256 * var9 / (256 + client.field367);
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1816(var5.field2953 / 2 + var10 - var4.field1484 / 2, var5.field2950 / 2 - var11 - var4.field1483 / 2, var0, var1, var5.field2953, var5.field2950, var5.field2954, var5.field2951);
            } else {
               var4.method1824(var0 + var5.field2953 / 2 + var10 - var4.field1484 / 2, var5.field2950 / 2 + var1 - var11 - var4.field1483 / 2);
            }

         }
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIZB)V",
      garbageValue = "-84"
   )
   static void method2(class176[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class176 var6 = var0[var5];
         if(null != var6 && var1 == var6.field2826) {
            class101.method2286(var6, var2, var3, var4);
            class36.method772(var6, var2, var3);
            if(var6.field2864 > var6.field2830 - var6.field2822) {
               var6.field2864 = var6.field2830 - var6.field2822;
            }

            if(var6.field2864 < 0) {
               var6.field2864 = 0;
            }

            if(var6.field2850 > var6.field2831 - var6.field2823) {
               var6.field2850 = var6.field2831 - var6.field2823;
            }

            if(var6.field2850 < 0) {
               var6.field2850 = 0;
            }

            if(var6.field2910 == 0) {
               class53.method1145(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1236996506"
   )
   static void method3(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class175 var4 = (class175)class174.field2776.method3936(var2);
      if(var4 != null) {
         class174.field2772.method4043(var4);
      }
   }
}
