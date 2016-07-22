import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("l")
   @Export("messages")
   String[] field256;
   @ObfuscatedName("e")
   boolean[] field257;
   @ObfuscatedName("o")
   boolean[] field258;
   @ObfuscatedName("g")
   int[] field259;
   @ObfuscatedName("v")
   static int[] field260;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -8839052825793104133L
   )
   long field262;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1980764529
   )
   static int field263;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1756069531
   )
   protected static int field264;
   @ObfuscatedName("j")
   boolean field266 = false;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-12"
   )
   int method195(int var1) {
      return this.field259[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2068169737"
   )
   void method196(int var1, int var2) {
      this.field259[var1] = var2;
      if(this.field257[var1]) {
         this.field266 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-239256901"
   )
   public static void method197() {
      class51.field1141.method3814();
      class51.field1135.method3814();
      class51.field1123.method3814();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "43"
   )
   void method198(int var1, String var2) {
      this.field256[var1] = var2;
      if(this.field258[var1]) {
         this.field266 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-931210842"
   )
   String method199(int var1) {
      return this.field256[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383244433"
   )
   void method200() {
      int var1;
      for(var1 = 0; var1 < this.field259.length; ++var1) {
         if(!this.field257[var1]) {
            this.field259[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field256.length; ++var1) {
         if(!this.field258[var1]) {
            this.field256[var1] = null;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZB)Lclass230;",
      garbageValue = "-21"
   )
   class230 method201(boolean var1) {
      return class7.method96("2", class56.field1240.field2343, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1142021275"
   )
   void method202() {
      class230 var1 = this.method201(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field259.length; ++var4) {
            if(this.field257[var4] && this.field259[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field256.length; ++var5) {
            if(this.field258[var5] && null != this.field256[var5]) {
               var2 += 2 + class77.method1679(this.field256[var5]);
               ++var4;
            }
         }

         class122 var9 = new class122(var2);
         var9.method2557(1);
         var9.method2558(var3);

         int var6;
         for(var6 = 0; var6 < this.field259.length; ++var6) {
            if(this.field257[var6] && this.field259[var6] != -1) {
               var9.method2558(var6);
               var9.method2560(this.field259[var6]);
            }
         }

         var9.method2558(var4);

         for(var6 = 0; var6 < this.field256.length; ++var6) {
            if(this.field258[var6] && this.field256[var6] != null) {
               var9.method2558(var6);
               var9.method2563(this.field256[var6]);
            }
         }

         var1.method4207(var9.field2047, 0, var9.field2045);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4223();
         } catch (Exception var16) {
            ;
         }

      }

      this.field266 = false;
      this.field262 = class193.method3805();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   void method204() {
      if(this.field266 && this.field262 < class193.method3805() - 60000L) {
         this.method202();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1900090968"
   )
   boolean method205() {
      return this.field266;
   }

   class19() {
      this.field259 = new int[class56.field1231.method3317(19)];
      this.field256 = new String[class56.field1231.method3317(15)];
      this.field257 = new boolean[this.field259.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field259.length; ++var1) {
         class47 var3 = (class47)class47.field1065.method3817((long)var1);
         class47 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            var4 = class47.field1068.method3304(19, var1);
            var3 = new class47();
            if(null != var4) {
               var3.method988(new class122(var4));
            }

            class47.field1065.method3823(var3, (long)var1);
            var2 = var3;
         }

         this.field257[var1] = var2.field1066;
      }

      this.field258 = new boolean[this.field256.length];

      for(var1 = 0; var1 < this.field256.length; ++var1) {
         class53 var6 = (class53)class53.field1163.method3817((long)var1);
         class53 var5;
         if(null != var6) {
            var5 = var6;
         } else {
            var4 = class22.field583.method3304(15, var1);
            var6 = new class53();
            if(var4 != null) {
               var6.method1113(new class122(var4));
            }

            class53.field1163.method3823(var6, (long)var1);
            var5 = var6;
         }

         this.field258[var1] = var5.field1156;
      }

      for(var1 = 0; var1 < this.field259.length; ++var1) {
         this.field259[var1] = -1;
      }

      this.method229();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass39;I)V",
      garbageValue = "-429260133"
   )
   static final void method228(class39 var0) {
      if(var0.field877 == client.field282 || var0.field884 == -1 || var0.field865 != 0 || var0.field862 + 1 > class28.method646(var0.field884).field1011[var0.field863]) {
         int var1 = var0.field877 - var0.field852;
         int var2 = client.field282 - var0.field852;
         int var3 = var0.field872 * 128 + var0.field858 * 64;
         int var4 = var0.field874 * 128 + var0.field858 * 64;
         int var5 = var0.field873 * 128 + var0.field858 * 64;
         int var6 = var0.field836 * 128 + var0.field858 * 64;
         var0.field864 = (var2 * var5 + (var1 - var2) * var3) / var1;
         var0.field831 = ((var1 - var2) * var4 + var6 * var2) / var1;
      }

      var0.field888 = 0;
      var0.field881 = var0.field846;
      var0.field832 = var0.field881;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1687870473"
   )
   void method229() {
      class230 var1 = this.method201(false);

      label202: {
         try {
            byte[] var2 = new byte[(int)var1.method4214()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4210(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class122 var13 = new class122(var2);
            if(var13.field2047.length - var13.field2045 >= 1) {
               int var14 = var13.method2556();
               if(var14 >= 0 && var14 <= 1) {
                  int var15 = var13.method2706();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var15; ++var7) {
                     var8 = var13.method2706();
                     var9 = var13.method2577();
                     if(this.field257[var8]) {
                        this.field259[var8] = var9;
                     }
                  }

                  var7 = var13.method2706();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label202;
                     }

                     var9 = var13.method2706();
                     String var10 = var13.method2580();
                     if(this.field258[var9]) {
                        this.field256[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var24) {
            break label202;
         } finally {
            try {
               var1.method4223();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field266 = false;
   }
}
