import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WidgetNode")
public class class3 extends class211 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1112051935
   )
   int field60;
   @ObfuscatedName("r")
   boolean field61 = false;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -60845651
   )
   static int field63;
   @ObfuscatedName("he")
   @Export("localPlayer")
   static class2 field65;
   @ObfuscatedName("dm")
   static int[] field66;
   @ObfuscatedName("x")
   public static String field67;
   @ObfuscatedName("t")
   static class13 field68;
   @ObfuscatedName("pj")
   static class163 field69;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 424982309
   )
   @Export("id")
   int field70;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IIII)Lclass3;",
      garbageValue = "-1404161959"
   )
   static final class3 method42(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field70 = var1;
      var3.field60 = var2;
      client.field475.method3940(var3, (long)var0);
      method43(var1);
      class176 var4 = class134.method2983(var0);
      class79.method1777(var4);
      if(client.field376 != null) {
         class79.method1777(client.field376);
         client.field376 = null;
      }

      class124.method2891();
      class53.method1145(class176.field2836[var0 >> 16], var4, false);
      class102.method2291(var1);
      if(client.field495 != -1) {
         int var5 = client.field495;
         if(class14.method179(var5)) {
            class9.method134(class176.field2836[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-730269376"
   )
   static final void method43(int var0) {
      if(class14.method179(var0)) {
         class176[] var1 = class176.field2836[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class176 var3 = var1[var2];
            if(var3 != null) {
               var3.field2929 = 0;
               var3.field2930 = 0;
            }
         }

      }
   }
}
