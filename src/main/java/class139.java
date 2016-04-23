import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ee")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class139 extends Canvas {
   @ObfuscatedName("aa")
   static boolean field2116;
   @ObfuscatedName("j")
   Component field2117;

   class139(Component var1) {
      this.field2117 = var1;
   }

   public final void paint(Graphics var1) {
      this.field2117.paint(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[Lclass154;",
      garbageValue = "1757352430"
   )
   public static class154[] method2910() {
      return new class154[]{class154.field2270, class154.field2268, class154.field2274, class154.field2271, class154.field2272, class154.field2267};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-449822473"
   )
   public static String method2912(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2655[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   public final void update(Graphics var1) {
      this.field2117.update(var1);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   static final void method2913() {
      int var0 = class167.field2665;
      int var1 = class28.field663;
      int var2 = class18.field256;
      int var3 = class93.field1585;
      int var4 = 6116423;
      class79.method1783(var0, var1, var2, var3, var4);
      class79.method1783(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      class79.method1801(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      class95.field1606.method4006("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class140.field2128;
      int var6 = class140.field2126;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < client.field415; ++var7) {
         var8 = 15 * (client.field415 - 1 - var7) + var1 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class224 var10 = class95.field1606;
         String var11;
         if(client.field290[var7].length() > 0) {
            var11 = client.field420[var7] + " " + client.field290[var7];
         } else {
            var11 = client.field420[var7];
         }

         var10.method4006(var11, var0 + 3, var8, var9, 0);
      }

      var7 = class167.field2665;
      var8 = class28.field663;
      var9 = class18.field256;
      int var12 = class93.field1585;

      for(int var13 = 0; var13 < client.field476; ++var13) {
         if(client.field321[var13] + client.field483[var13] > var7 && client.field321[var13] < var7 + var9 && client.field551[var13] + client.field315[var13] > var8 && client.field315[var13] < var8 + var12) {
            client.field391[var13] = true;
         }
      }

   }
}
