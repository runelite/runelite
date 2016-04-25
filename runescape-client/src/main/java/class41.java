import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class41 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1368022099
   )
   public int field957;
   @ObfuscatedName("h")
   static class193 field958 = new class193(64);
   @ObfuscatedName("j")
   static class167 field959;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1131881585
   )
   public int field960;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1666562117
   )
   int field961 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1136965553
   )
   public int field962;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 797061847
   )
   public int field963;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -1109706103
   )
   protected static int field965;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -204227059
   )
   static int field966;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1698617719"
   )
   void method827() {
      this.method830(this.field961);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIB)V",
      garbageValue = "-72"
   )
   void method829(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field961 = var1.method2662();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1436439683"
   )
   void method830(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field957 = (int)(256.0D * var14);
      this.field962 = (int)(var16 * 256.0D);
      if(this.field957 < 0) {
         this.field957 = 0;
      } else if(this.field957 > 255) {
         this.field957 = 255;
      }

      if(this.field962 < 0) {
         this.field962 = 0;
      } else if(this.field962 > 255) {
         this.field962 = 255;
      }

      if(var16 > 0.5D) {
         this.field963 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field963 = (int)(512.0D * var14 * var16);
      }

      if(this.field963 < 1) {
         this.field963 = 1;
      }

      this.field960 = (int)((double)this.field963 * var12);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "27"
   )
   void method836(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2500();
         if(0 == var3) {
            return;
         }

         this.method829(var1, var3, var2);
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-984094726"
   )
   static final void method842(class37 var0) {
      if(client.field285 == var0.field801 || -1 == var0.field825 || 0 != var0.field849 || 1 + var0.field827 > class161.method3153(var0.field825).field974[var0.field826]) {
         int var1 = var0.field801 - var0.field839;
         int var2 = client.field285 - var0.field839;
         int var3 = var0.field795 * 64 + var0.field835 * 128;
         int var4 = var0.field795 * 64 + var0.field837 * 128;
         int var5 = var0.field795 * 64 + var0.field813 * 128;
         int var6 = var0.field795 * 64 + var0.field838 * 128;
         var0.field816 = (var3 * (var1 - var2) + var2 * var5) / var1;
         var0.field840 = (var4 * (var1 - var2) + var6 * var2) / var1;
      }

      var0.field823 = 0;
      var0.field844 = var0.field841;
      var0.field796 = var0.field844;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1495268649"
   )
   static final void method849(int var0, int var1, int var2, int var3) {
      ++client.field473;
      class23.method593(class33.field760);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field405 >= 0) {
         var5 = class32.field737;
         int[] var6 = class32.field738;

         for(var7 = 0; var7 < var5; ++var7) {
            if(client.field405 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class23.method593(class33.field752);
      }

      class158.method3134(true);
      class23.method593(var4?class33.field751:class33.field753);
      class158.method3134(false);

      for(class6 var16 = (class6)client.field408.method3784(); var16 != null; var16 = (class6)client.field408.method3777()) {
         if(var16.field106 == class28.field655 && client.field285 <= var16.field110) {
            if(client.field285 >= var16.field111) {
               if(var16.field115 > 0) {
                  class34 var18 = client.field517[var16.field115 - 1];
                  if(var18 != null && var18.field816 >= 0 && var18.field816 < 13312 && var18.field840 >= 0 && var18.field840 < 13312) {
                     var16.method89(var18.field816, var18.field840, class148.method3106(var18.field816, var18.field840, var16.field106) - var16.field105, client.field285);
                  }
               }

               if(var16.field115 < 0) {
                  var7 = -var16.field115 - 1;
                  class2 var19;
                  if(var7 == client.field397) {
                     var19 = class47.field1053;
                  } else {
                     var19 = client.field396[var7];
                  }

                  if(var19 != null && var19.field816 >= 0 && var19.field816 < 13312 && var19.field840 >= 0 && var19.field840 < 13312) {
                     var16.method89(var19.field816, var19.field840, class148.method3106(var19.field816, var19.field840, var16.field106) - var16.field105, client.field285);
                  }
               }

               var16.method90(client.field351);
               class35.field771.method2009(class28.field655, (int)var16.field117, (int)var16.field118, (int)var16.field114, 60, var16, var16.field125, -1, false);
            }
         } else {
            var16.method3883();
         }
      }

      for(class29 var17 = (class29)client.field454.method3784(); null != var17; var17 = (class29)client.field454.method3777()) {
         if(var17.field682 == class28.field655 && !var17.field674) {
            if(client.field285 >= var17.field669) {
               var17.method651(client.field351);
               if(var17.field674) {
                  var17.method3883();
               } else {
                  class35.field771.method2009(var17.field682, var17.field671, var17.field672, var17.field673, 60, var17, 0, -1, false);
               }
            }
         } else {
            var17.method3883();
         }
      }

      class21.method567(var0, var1, var2, var3, true);
      var0 = client.field535;
      var1 = client.field536;
      var2 = client.field505;
      var3 = client.field538;
      class79.method1777(var0, var1, var0 + var2, var1 + var3);
      class91.method2087();
      int var20;
      if(!client.field499) {
         var5 = client.field359;
         if(client.field368 / 256 > var5) {
            var5 = client.field368 / 256;
         }

         if(client.field522[4] && client.field524[4] + 128 > var5) {
            var5 = 128 + client.field524[4];
         }

         var20 = client.field521 + client.field343 & 2047;
         class122.method2750(class21.field568, class148.method3106(class47.field1053.field816, class47.field1053.field840, class28.field655) - client.field365, class26.field634, var5, var20, var5 * 3 + 600);
      }

      if(!client.field499) {
         var5 = class17.method187();
      } else {
         var5 = class135.method2844();
      }

      var20 = class122.field1991;
      var7 = class115.field1952;
      int var8 = class24.field603;
      int var9 = class154.field2276;
      int var10 = class17.field243;

      int var11;
      int var12;
      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field522[var11]) {
            var12 = (int)(Math.random() * (double)(2 * client.field369[var11] + 1) - (double)client.field369[var11] + Math.sin((double)client.field526[var11] * ((double)client.field525[var11] / 100.0D)) * (double)client.field524[var11]);
            if(0 == var11) {
               class122.field1991 += var12;
            }

            if(var11 == 1) {
               class115.field1952 += var12;
            }

            if(2 == var11) {
               class24.field603 += var12;
            }

            if(var11 == 3) {
               class17.field243 = var12 + class17.field243 & 2047;
            }

            if(4 == var11) {
               class154.field2276 += var12;
               if(class154.field2276 < 128) {
                  class154.field2276 = 128;
               }

               if(class154.field2276 > 383) {
                  class154.field2276 = 383;
               }
            }
         }
      }

      var11 = class140.field2128;
      var12 = class140.field2126;
      if(class140.field2134 != 0) {
         var11 = class140.field2135;
         var12 = class140.field2136;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         class105.field1815 = true;
         class105.field1798 = 0;
         class105.field1839 = var11 - var0;
         class105.field1840 = var12 - var1;
      } else {
         class105.field1815 = false;
         class105.field1798 = 0;
      }

      class13.method165();
      class79.method1783(var0, var1, var2, var3, 0);
      class13.method165();
      int var13 = class91.field1553;
      class91.field1553 = client.field539;
      class35.field771.method2021(class122.field1991, class115.field1952, class24.field603, class154.field2276, class17.field243, var5);
      class91.field1553 = var13;
      class13.method165();
      class35.field771.method1974();
      class16.method186(var0, var1, var2, var3);
      if(2 == client.field275) {
         class50.method1009((client.field296 - class187.field3014 << 7) + client.field529, client.field300 + (client.field423 - class0.field12 << 7), client.field421 * 2);
         if(client.field277 > -1 && client.field285 % 20 < 10) {
            class129.field2029[0].method1700(client.field277 + var0 - 12, var1 + client.field382 - 28);
         }
      }

      ((class95)class91.field1566).method2177(client.field351);
      class3.method32(var0, var1, var2, var3);
      class122.field1991 = var20;
      class115.field1952 = var7;
      class24.field603 = var8;
      class154.field2276 = var9;
      class17.field243 = var10;
      if(client.field284) {
         byte var15 = 0;
         int var21 = var15 + class171.field2719 + class171.field2713;
         if(0 == var21) {
            client.field284 = false;
         }
      }

      if(client.field284) {
         class79.method1783(var0, var1, var2, var3, 0);
         class171.method3355("Loading - please wait.", false);
      }

   }
}
