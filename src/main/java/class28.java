import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("aw")
   static class80[] field688;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2076836937
   )
   @Export("quantity")
   int field689;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -750453073
   )
   @Export("id")
   int field691;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -1257959381
   )
   static int field692;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 1998696883
   )
   static int field693;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1204696871
   )
   static int field694;
   @ObfuscatedName("qu")
   public static class77 field695;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1393439703"
   )
   public static int method730(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      return class11.method178(this.field691).method1132(this.field689);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass39;",
      garbageValue = "-828280955"
   )
   public static class39 method734(int var0) {
      class39 var1 = (class39)class39.field912.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field892.method3403(9, var0);
         var1 = new class39();
         var1.field890 = var0;
         if(null != var2) {
            var1.method858(new class119(var2));
         }

         var1.method877();
         class39.field912.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1960953197"
   )
   static final void method735(int var0, int var1) {
      if(class30.field710 != var0 || field694 != var1) {
         class30.field710 = var0;
         field694 = var1;
         class3.method49(25);
         class25.method682("Loading - please wait.", true);
         int var2 = class144.field2204;
         int var3 = class3.field67;
         class144.field2204 = (var0 - 6) * 8;
         class3.field67 = (var1 - 6) * 8;
         int var4 = class144.field2204 - var2;
         int var5 = class3.field67 - var3;
         var2 = class144.field2204;
         var3 = class3.field67;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field546[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field871[var8] -= var4;
                  var7.field835[var8] -= var5;
               }

               var7.field844 -= var4 * 128;
               var7.field819 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field550[var6];
            if(var18 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field871[var8] -= var4;
                  var18.field835[var8] -= var5;
               }

               var18.field844 -= var4 * 128;
               var18.field819 -= 128 * var5;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var17; var12 != var19; var12 += var20) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field425[var16][var12][var13] = client.field425[var16][var14][var15];
                  } else {
                     client.field425[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field426.method3926(); var21 != null; var21 = (class16)client.field426.method3902()) {
            var21.field238 -= var4;
            var21.field243 -= var5;
            if(var21.field238 < 0 || var21.field243 < 0 || var21.field238 >= 104 || var21.field243 >= 104) {
               var21.method3998();
            }
         }

         if(0 != client.field528) {
            client.field528 -= var4;
            client.field347 -= var5;
         }

         client.field536 = 0;
         client.field542 = false;
         client.field523 = -1;
         client.field428.method3898();
         client.field449.method3898();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field361[var13].method2488();
         }

      }
   }
}
