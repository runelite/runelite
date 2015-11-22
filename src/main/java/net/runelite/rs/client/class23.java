package net.runelite.rs.client;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("o")
public final class class23 extends class207 {
   @ObfuscatedName("w")
   int[] field587;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1129856047
   )
   int field588;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -236140099
   )
   int field589;
   @ObfuscatedName("j")
   static class198 field590 = new class198();
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -28585155
   )
   int field591;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -549279397
   )
   int field592;
   @ObfuscatedName("p")
   class40 field593;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 804416049
   )
   int field594;
   @ObfuscatedName("t")
   class64 field595;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1001945765
   )
   int field596;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2001911543
   )
   int field597;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1511965839
   )
   int field598;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -76351301
   )
   int field599;
   @ObfuscatedName("z")
   class64 field600;
   @ObfuscatedName("en")
   static class78 field601;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 924558003
   )
   int field603;

   @ObfuscatedName("f")
   void method620() {
      int var1 = this.field594;
      class40 var2 = this.field593.method847();
      if(var2 != null) {
         this.field594 = var2.field906;
         this.field596 = var2.field949 * 128;
         this.field598 = var2.field950;
         this.field597 = var2.field951;
         this.field587 = var2.field955;
      } else {
         this.field594 = -1;
         this.field596 = 0;
         this.field598 = 0;
         this.field597 = 0;
         this.field587 = null;
      }

      if(var1 != this.field594 && this.field595 != null) {
         class16.field235.method1177(this.field595);
         this.field595 = null;
      }

   }

   @ObfuscatedName("ab")
   static final void method624(boolean var0) {
      class130.method2869();
      ++client.field324;
      if(client.field324 >= 50 || var0) {
         client.field324 = 0;
         if(!client.field329 && null != class11.field170) {
            client.field318.method2785(136);

            try {
               class11.field170.method3042(client.field318.field1980, 0, client.field318.field1981);
               client.field318.field1981 = 0;
            } catch (IOException var2) {
               client.field329 = true;
            }
         }

      }
   }

   @ObfuscatedName("ce")
   static final void method625(class172 var0, int var1, int var2) {
      if(null == client.field447 && !client.field500) {
         if(null != var0 && class28.method689(var0) != null) {
            client.field447 = var0;
            class172 var4 = class154.method3203(var0);
            if(var4 == null) {
               var4 = var0.field2775;
            }

            client.field448 = var4;
            client.field449 = var1;
            client.field450 = var2;
            class25.field625 = 0;
            client.field517 = false;
            if(client.field416 > 0) {
               class177.method3528(client.field416 - 1);
            }

         }
      }
   }

   @ObfuscatedName("j")
   public static class111 method634(class111[] var0, int var1) {
      class111[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class111 var4 = var2[var3];
         if(var1 == var4.vmethod3208()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("bs")
   static void method637() {
      if(client.field546) {
         class172 var0 = class214.method4009(class77.field1386, client.field355);
         if(var0 != null && var0.field2816 != null) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field10 = var0.field2816;
            class171.method3458(var1);
         }

         client.field546 = false;
         class42.method942(var0);
      }
   }
}
