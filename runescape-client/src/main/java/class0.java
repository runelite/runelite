import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class0 extends class208 {
   @ObfuscatedName("f")
   Object[] field0;
   @ObfuscatedName("x")
   class173 field1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -827670421
   )
   int field2;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 753662203
   )
   int field3;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1237878717
   )
   int field4;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1454660217
   )
   static int field5;
   @ObfuscatedName("u")
   boolean field6;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 337013143
   )
   int field7;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1091871293
   )
   int field8;
   @ObfuscatedName("s")
   String field9;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -176987991
   )
   int field10;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 1997997777
   )
   static int field11;
   @ObfuscatedName("n")
   class173 field12;
   @ObfuscatedName("ab")
   static class80[] field14;

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "447299548"
   )
   static final void method0(int var0, int var1, int var2, int var3, int var4) {
      class159.field2597[0].method1916(var0, var1);
      class159.field2597[1].method1916(var0, var3 + var1 - 16);
      class79.method1854(var0, var1 + 16, 16, var3 - 32, client.field367);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      class79.method1854(var0, var6 + 16 + var1, 16, var5, client.field368);
      class79.method1893(var0, 16 + var1 + var6, var5, client.field370);
      class79.method1893(var0 + 1, var1 + 16 + var6, var5, client.field370);
      class79.method1876(var0, var6 + 16 + var1, 16, client.field370);
      class79.method1876(var0, 17 + var1 + var6, 16, client.field370);
      class79.method1893(15 + var0, var1 + 16 + var6, var5, client.field364);
      class79.method1893(14 + var0, var1 + 17 + var6, var5 - 1, client.field364);
      class79.method1876(var0, var6 + var1 + 15 + var5, 16, client.field364);
      class79.method1876(1 + var0, var6 + 14 + var1 + var5, 15, client.field364);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-132710766"
   )
   public static boolean method1(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1869749008"
   )
   static void method2() {
      int var0 = class144.field2200;
      int var1 = class144.field2190;
      int var2 = class41.field995 - class30.field708 - var0;
      int var3 = class45.field1055 - class153.field2274 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field530.method3061();
            int var5 = 0;
            int var6 = 0;
            if(class102.field1764 == var4) {
               Insets var7 = class102.field1764.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class45.field1055);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class41.field995, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class41.field995 + var5 - var2, var6, var2, class45.field1055);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class45.field1055 + var6 - var3, class41.field995, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(IIIB)Lclass3;",
      garbageValue = "51"
   )
   static final class3 method3(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field64 = var1;
      var3.field62 = var2;
      client.field448.method3826(var3, (long)var0);
      class13.method168(var1);
      class173 var4 = class153.method3177(var0);
      class39.method818(var4);
      if(client.field312 != null) {
         class39.method818(client.field312);
         client.field312 = null;
      }

      class191.method3782();
      class75.method1698(class173.field2770[var0 >> 16], var4, false);
      class156.method3185(var1);
      if(client.field391 != -1) {
         class34.method767(client.field391, 1);
      }

      return var3;
   }
}
