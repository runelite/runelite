import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class82 implements class112 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 539409601
   )
   public final int field1431;
   @ObfuscatedName("i")
   static final class82 field1432 = new class82(1, 1);
   @ObfuscatedName("g")
   static final class82 field1433 = new class82(2, 2);
   @ObfuscatedName("h")
   static final class82 field1434 = new class82(3, 3);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 588704619
   )
   final int field1436;
   @ObfuscatedName("t")
   public static final class82 field1437 = new class82(0, 0);
   @ObfuscatedName("z")
   static final class82 field1439 = new class82(4, 4);
   @ObfuscatedName("ca")
   static class224 field1440;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int vmethod3145() {
      return this.field1436;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass122;ILclass2;IB)V",
      garbageValue = "0"
   )
   static final void method1840(class122 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 128) != 0) {
         var5 = var0.method2494();
         byte[] var6 = new byte[var5];
         class119 var7 = new class119(var6);
         var0.method2479(var6, 0, var5);
         class32.field736[var1] = var7;
         var2.method12(var7);
      }

      int var17;
      if((var3 & 16) != 0) {
         var5 = var0.method2470();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var17 = var0.method2494();
         class1.method2(var2, var5, var17);
      }

      if((var3 & 64) != 0) {
         var2.field828 = var0.method2470();
         if(var2.field828 == '\uffff') {
            var2.field828 = -1;
         }
      }

      if((var3 & 4) != 0) {
         var2.field816 = var0.method2476();
         if(var2.field816.charAt(0) == 126) {
            var2.field816 = var2.field816.substring(1);
            class33.method702(2, var2.field39, var2.field816);
         } else if(class152.field2301 == var2) {
            class33.method702(2, var2.field39, var2.field816);
         }

         var2.field817 = false;
         var2.field820 = 0;
         var2.field821 = 0;
         var2.field842 = 150;
      }

      if((var3 & 2) != 0) {
         var5 = var0.method2470();
         var17 = var0.method2494();
         var2.method736(var5, var17, client.field332);
         var2.field858 = client.field332 + 300;
         var2.field826 = var0.method2494();
         var2.field844 = var0.method2494();
      }

      if((var3 & 8) != 0) {
         var2.field830 = var0.method2470();
         if(var2.field856 == 0) {
            var2.field831 = var2.field830;
            var2.field830 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.method2470();
         class152[] var18 = new class152[]{class152.field2299, class152.field2294, class152.field2293, class152.field2290, class152.field2291};
         class152 var19 = (class152)class30.method651(var18, var0.method2494());
         boolean var8 = var0.method2494() == 1;
         int var9 = var0.method2494();
         int var10 = var0.field2000;
         if(var2.field39 != null && null != var2.field59) {
            boolean var11 = false;
            if(var19.field2298 && class19.method202(var2.field39)) {
               var11 = true;
            }

            if(!var11 && client.field404 == 0 && !var2.field56) {
               class32.field750.field2000 = 0;
               var0.method2479(class32.field750.field2001, 0, var9);
               class32.field750.field2000 = 0;
               String var12 = class223.method3967(class16.method161(class191.method3709(class32.field750)));
               var2.field816 = var12.trim();
               var2.field820 = var5 >> 8;
               var2.field821 = var5 & 255;
               var2.field842 = 150;
               var2.field817 = var8;
               var2.field835 = class152.field2301 != var2 && var19.field2298 && client.field299 != "" && var12.toLowerCase().indexOf(client.field299) == -1;
               int var13;
               if(var19.field2297) {
                  var13 = var8?91:1;
               } else {
                  var13 = var8?90:2;
               }

               if(var19.field2296 != -1) {
                  int var16 = var19.field2296;
                  String var15 = "<img=" + var16 + ">";
                  class33.method702(var13, var15 + var2.field39, var12);
               } else {
                  class33.method702(var13, var2.field39, var12);
               }
            }
         }

         var0.field2000 = var9 + var10;
      }

      if((var3 & 256) != 0) {
         var2.field836 = var0.method2470();
         var5 = var0.method2505();
         var2.field803 = var5 >> 16;
         var2.field843 = (var5 & '\uffff') + client.field332;
         var2.field840 = 0;
         var2.field841 = 0;
         if(var2.field843 > client.field332) {
            var2.field840 = -1;
         }

         if(var2.field836 == '\uffff') {
            var2.field836 = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field813 = var0.method2469();
         var2.field846 = var0.method2469();
         var2.field845 = var0.method2469();
         var2.field855 = var0.method2469();
         var2.field848 = var0.method2470() + client.field332;
         var2.field849 = var0.method2470() + client.field332;
         var2.field850 = var0.method2470();
         if(var2.field48) {
            var2.field813 += var2.field44;
            var2.field846 += var2.field61;
            var2.field845 += var2.field44;
            var2.field855 += var2.field61;
            var2.field856 = 0;
         } else {
            var2.field813 += var2.field847[0];
            var2.field846 += var2.field839[0];
            var2.field845 += var2.field847[0];
            var2.field855 += var2.field839[0];
            var2.field856 = 1;
         }

         var2.field861 = 0;
      }

      if((var3 & 512) != 0) {
         var5 = var0.method2470();
         var17 = var0.method2494();
         var2.method736(var5, var17, client.field332);
         var2.field858 = 300 + client.field332;
         var2.field826 = var0.method2494();
         var2.field844 = var0.method2494();
      }

      if((var3 & 1024) != 0) {
         class32.field739[var1] = var0.method2469();
      }

      if((var3 & 8192) != 0) {
         var4 = var0.method2469();
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field40[var5] = var0.method2476();
         }
      }

      if(var2.field48) {
         if(var4 == 127) {
            var2.method29(var2.field44, var2.field61);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class32.field739[var1];
            }

            var2.method11(var2.field44, var2.field61, var20);
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class82(int var1, int var2) {
      this.field1431 = var1;
      this.field1436 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lclass131;",
      garbageValue = "19097746"
   )
   public static class131 method1843() {
      try {
         return new class145();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1862956984"
   )
   public static void method1845(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class137.field2137);
      var0.addFocusListener(class137.field2137);
   }
}
