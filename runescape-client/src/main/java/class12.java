import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class12 extends class88 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1300336611
   )
   int field194;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1463787869
   )
   int field195;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 407572459
   )
   int field196;
   @ObfuscatedName("v")
   public static String field197;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1602783089
   )
   int field198;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -566425231
   )
   int field199;
   @ObfuscatedName("b")
   class44 field200;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 973195267
   )
   int field201;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 104381883
   )
   int field202;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 566198023
   )
   int field204;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      if(null != this.field200) {
         int var1 = client.field567 - this.field204;
         if(var1 > 100 && this.field200.field1027 > 0) {
            var1 = 100;
         }

         label70: {
            do {
               do {
                  if(var1 <= this.field200.field1025[this.field201]) {
                     break label70;
                  }

                  var1 -= this.field200.field1025[this.field201];
                  ++this.field201;
               } while(this.field201 < this.field200.field1023.length);

               this.field201 -= this.field200.field1027;
            } while(this.field201 >= 0 && this.field201 < this.field200.field1023.length);

            this.field200 = null;
         }

         this.field204 = client.field567 - var1;
      }

      class42 var12 = class146.method3102(this.field194);
      if(null != var12.field969) {
         var12 = var12.method847();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field196 != 1 && this.field196 != 3) {
            var2 = var12.field959;
            var3 = var12.field1000;
         } else {
            var2 = var12.field1000;
            var3 = var12.field959;
         }

         int var4 = this.field198 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field198;
         int var6 = (var3 >> 1) + this.field199;
         int var7 = (1 + var3 >> 1) + this.field199;
         int[][] var8 = class5.field78[this.field202];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (var2 << 6) + (this.field198 << 7);
         int var11 = (this.field199 << 7) + (var3 << 6);
         return var12.method845(this.field195, this.field196, var8, var10, var9, var11, this.field200, this.field201);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1919523061"
   )
   public static long method144(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method145() {
      if(class33.field773) {
         class33.field759 = null;
         class33.field760 = null;
         class35.field818 = null;
         class33.field761 = null;
         class8.field151 = null;
         class33.field762 = null;
         class29.field712 = null;
         class192.field3095 = null;
         class3.field61 = null;
         class29.field708 = null;
         class8.field154 = null;
         class188.field3041 = null;
         class77.field1436 = null;
         class26.field660 = null;
         class79.field1456 = null;
         class33.field785 = null;
         class101.field1744 = null;
         class110.field1954 = null;
         class22.field606 = null;
         class143.field2210 = null;
         class33.field771 = null;
         class0.field6 = null;
         class182.method3600(2);
         class62.method1369(true);
         class33.field773 = false;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass39;B)V",
      garbageValue = "100"
   )
   static final void method146(class39 var0) {
      if(var0.field903 != 0) {
         if(var0.field876 != -1) {
            Object var1 = null;
            if(var0.field876 < '耀') {
               var1 = client.field331[var0.field876];
            } else if(var0.field876 >= '耀') {
               var1 = client.field467[var0.field876 - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.field896 - ((class39)var1).field896;
               int var3 = var0.field879 - ((class39)var1).field879;
               if(var2 != 0 || var3 != 0) {
                  var0.field889 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field877) {
               var0.field876 = -1;
               var0.field877 = false;
            }
         }

         if(var0.field878 != -1 && (var0.field852 == 0 || var0.field908 > 0)) {
            var0.field889 = var0.field878;
            var0.field878 = -1;
         }

         int var4 = var0.field889 - var0.field905 & 2047;
         if(var4 == 0 && var0.field877) {
            var0.field876 = -1;
            var0.field877 = false;
         }

         if(var4 != 0) {
            ++var0.field902;
            boolean var6;
            if(var4 > 1024) {
               var0.field905 -= var0.field903;
               var6 = true;
               if(var4 < var0.field903 || var4 > 2048 - var0.field903) {
                  var0.field905 = var0.field889;
                  var6 = false;
               }

               if(var0.field900 == var0.field854 && (var0.field902 > 25 || var6)) {
                  if(var0.field856 != -1) {
                     var0.field900 = var0.field856;
                  } else {
                     var0.field900 = var0.field858;
                  }
               }
            } else {
               var0.field905 += var0.field903;
               var6 = true;
               if(var4 < var0.field903 || var4 > 2048 - var0.field903) {
                  var0.field905 = var0.field889;
                  var6 = false;
               }

               if(var0.field854 == var0.field900 && (var0.field902 > 25 || var6)) {
                  if(var0.field857 != -1) {
                     var0.field900 = var0.field857;
                  } else {
                     var0.field900 = var0.field858;
                  }
               }
            }

            var0.field905 &= 2047;
         } else {
            var0.field902 = 0;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1271000666"
   )
   public static void method147() {
      class48.field1093.method3835();
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class88 var9) {
      this.field194 = var1;
      this.field195 = var2;
      this.field196 = var3;
      this.field202 = var4;
      this.field198 = var5;
      this.field199 = var6;
      if(var7 != -1) {
         this.field200 = class13.method153(var7);
         this.field201 = 0;
         this.field204 = client.field567 - 1;
         if(this.field200.field1036 == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field200 == this.field200) {
               this.field201 = var10.field201;
               this.field204 = var10.field204;
               return;
            }
         }

         if(var8 && this.field200.field1027 != -1) {
            this.field201 = (int)(Math.random() * (double)this.field200.field1023.length);
            this.field204 -= (int)(Math.random() * (double)this.field200.field1025[this.field201]);
         }
      }

   }
}
