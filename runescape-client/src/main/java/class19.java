import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("v")
   public static String field274;
   @ObfuscatedName("x")
   boolean[] field275;
   @ObfuscatedName("b")
   boolean[] field276;
   @ObfuscatedName("l")
   int[] field277;
   @ObfuscatedName("n")
   boolean field279 = false;
   @ObfuscatedName("d")
   @Export("messages")
   String[] field280;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -6558405528978310251L
   )
   long field281;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -578271165
   )
   @Export("menuY")
   static int field284;
   @ObfuscatedName("p")
   static int[][][] field286;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   void method210() {
      int var1;
      for(var1 = 0; var1 < this.field277.length; ++var1) {
         if(!this.field275[var1]) {
            this.field277[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field280.length; ++var1) {
         if(!this.field276[var1]) {
            this.field280[var1] = null;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "788622844"
   )
   void method211(int var1, int var2) {
      this.field277[var1] = var2;
      if(this.field275[var1]) {
         this.field279 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1759942172"
   )
   int method212(int var1) {
      return this.field277[var1];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZB)Lclass227;",
      garbageValue = "-99"
   )
   class227 method216(boolean var1) {
      return class41.method896("2", class137.field2130.field2280, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1170589478"
   )
   void method218() {
      class227 var1 = this.method216(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4150()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4146(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class119 var13 = new class119(var2);
            if(var13.field2000.length - var13.field1998 >= 1) {
               int var14 = var13.method2554();
               if(var14 < 0 || var14 > 1) {
                  return;
               }

               int var15 = var13.method2556();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2556();
                  var9 = var13.method2696();
                  if(this.field275[var8]) {
                     this.field277[var8] = var9;
                  }
               }

               var7 = var13.method2556();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var13.method2556();
                  String var10 = var13.method2668();
                  if(this.field276[var9]) {
                     this.field280[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label192;
         } finally {
            try {
               var1.method4149();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field279 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "25734"
   )
   void method219() {
      if(this.field279 && this.field281 < class130.method2846() - 60000L) {
         this.method227();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "16"
   )
   boolean method226() {
      return this.field279;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709438052"
   )
   void method227() {
      class227 var1 = this.method216(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field277.length; ++var4) {
            if(this.field275[var4] && this.field277[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field280.length; ++var5) {
            if(this.field276[var5] && null != this.field280[var5]) {
               var2 += 2 + class23.method629(this.field280[var5]);
               ++var4;
            }
         }

         class119 var9 = new class119(var2);
         var9.method2654(1);
         var9.method2540(var3);

         int var6;
         for(var6 = 0; var6 < this.field277.length; ++var6) {
            if(this.field275[var6] && this.field277[var6] != -1) {
               var9.method2540(var6);
               var9.method2539(this.field277[var6]);
            }
         }

         var9.method2540(var4);

         for(var6 = 0; var6 < this.field280.length; ++var6) {
            if(this.field276[var6] && this.field280[var6] != null) {
               var9.method2540(var6);
               var9.method2545(this.field280[var6]);
            }
         }

         var1.method4158(var9.field2000, 0, var9.field1998);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4149();
         } catch (Exception var16) {
            ;
         }

      }

      this.field279 = false;
      this.field281 = class130.method2846();
   }

   class19() {
      this.field277 = new int[class11.field177.method3321(19)];
      this.field280 = new String[class11.field177.method3321(15)];
      this.field275 = new boolean[this.field277.length];

      int var1;
      for(var1 = 0; var1 < this.field277.length; ++var1) {
         class45 var2 = class30.method708(var1);
         this.field275[var1] = var2.field1053;
      }

      this.field276 = new boolean[this.field280.length];

      for(var1 = 0; var1 < this.field280.length; ++var1) {
         class49 var3 = class179.method3547(var1);
         this.field276[var1] = var3.field1101;
      }

      for(var1 = 0; var1 < this.field277.length; ++var1) {
         this.field277[var1] = -1;
      }

      this.method218();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1739727059"
   )
   void method239(int var1, String var2) {
      this.field280[var1] = var2;
      if(this.field276[var1]) {
         this.field279 = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1405475795"
   )
   String method243(int var1) {
      return this.field280[var1];
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1473295399"
   )
   static void method244() {
      int var0 = class30.field708;
      int var1 = class153.field2274;
      if(class41.field995 < var0) {
         var0 = class41.field995;
      }

      if(class45.field1055 < var1) {
         var1 = class45.field1055;
      }

      if(null != class20.field580) {
         try {
            client var2 = client.field530;
            int var3 = client.field501?2:1;
            class132.method2871(var2, "resize", new Object[]{Integer.valueOf(var3)});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1253326633"
   )
   public static String method245(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(1 + var7 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class41.method894(var3);
      if(null == var8) {
         var8 = "";
      }

      return var8;
   }
}
