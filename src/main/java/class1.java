import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class1 {
   @ObfuscatedName("by")
   static class167 field18;
   @ObfuscatedName("ma")
   static class78 field21;

   @ObfuscatedName("i")
   static void method7() {
      class76.field1386 = null;
      class76.field1382 = null;
      class102.field1764 = null;
      class76.field1383 = null;
      class115.field1968 = null;
      class30.field708 = (byte[][])null;
   }

   @ObfuscatedName("n")
   static void method9(int var0) {
      if(client.field552 != var0) {
         if(client.field552 == 0) {
            class101.field1754 = null;
            class50.field1099 = null;
            class137.field2124 = null;
         }

         if(var0 == 20 || 40 == var0 || var0 == 45) {
            client.field335 = 0;
            client.field384 = 0;
            client.field421 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class133.field2069) {
            class133.field2069.method3019();
            class133.field2069 = null;
         }

         if(client.field552 == 25) {
            client.field351 = 0;
            client.field444 = 0;
            client.field348 = 1;
            client.field349 = 0;
            client.field478 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class140.method2988(class45.field1042, class213.field3146, class7.field127, true, 11 == client.field552?4:0);
            } else if(var0 == 11) {
               class140.method2988(class45.field1042, class213.field3146, class7.field127, false, 4);
            } else if(class31.field745) {
               class126.field2038 = null;
               class208.field3112 = null;
               class212.field3138 = null;
               class31.field717 = null;
               class31.field718 = null;
               class10.field159 = null;
               class52.field1160 = null;
               class77.field1393 = null;
               class31.field719 = null;
               class29.field700 = null;
               class38.field880 = null;
               class49.field1094 = null;
               class92.field1587 = null;
               class31.field746 = null;
               class17.field256 = null;
               class31.field724 = null;
               class12.field172 = null;
               class31.field723 = null;
               class21.field590 = null;
               class149.field2229 = null;
               class76.field1384 = null;
               class33.field775 = null;
               class154.method3173(2);
               method16(true);
               class31.field745 = false;
            }
         } else {
            class140.method2988(class45.field1042, class213.field3146, class7.field127, true, 0);
         }

         client.field552 = var0;
      }
   }

   @ObfuscatedName("du")
   static final void method10(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field546 + client.field495 & 2047;
         int var8 = class90.field1572[var7];
         int var9 = class90.field1578[var7];
         var8 = 256 * var8 / (256 + client.field365);
         var9 = var9 * 256 / (client.field365 + 256);
         int var10 = var8 * var3 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class19.field279.method1789(4 + var14 + 94 + var0 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class47.method1000(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([Lclass172;IIIZI)V",
      garbageValue = "-1662232799"
   )
   static void method11(class172[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class172 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2762) {
            class3.method48(var6, var2, var3, var4);
            class49.method1030(var6, var2, var3);
            if(var6.field2803 > var6.field2766 - var6.field2752) {
               var6.field2803 = var6.field2766 - var6.field2752;
            }

            if(var6.field2803 < 0) {
               var6.field2803 = 0;
            }

            if(var6.field2765 > var6.field2813 - var6.field2759) {
               var6.field2765 = var6.field2813 - var6.field2759;
            }

            if(var6.field2765 < 0) {
               var6.field2765 = 0;
            }

            if(var6.field2764 == 0) {
               method14(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("y")
   public static void method13() {
      class47.field1062.method3800();
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([Lclass172;Lclass172;ZI)V",
      garbageValue = "878408240"
   )
   static void method14(class172[] var0, class172 var1, boolean var2) {
      int var3 = var1.field2766 != 0?var1.field2766:var1.field2752;
      int var4 = var1.field2813 != 0?var1.field2813:var1.field2759;
      method11(var0, var1.field2800 * -1, var3, var4, var2);
      if(var1.field2865 != null) {
         method11(var1.field2865, var1.field2800 * -1, var3, var4, var2);
      }

      class3 var5 = (class3)client.field454.method3824((long)(var1.field2800 * -1));
      if(null != var5) {
         int var6 = var5.field56;
         if(class103.method2303(var6)) {
            method11(class172.field2850[var6], -1, var3, var4, var2);
         }
      }

      if(1337 == var1.field2747) {
         ;
      }

   }

   @ObfuscatedName("h")
   static final int method15(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class90.field1578[1024 * var2 / var3] >> 1;
      return (var0 * (65536 - var4) >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-382976126"
   )
   public static void method16(boolean var0) {
      if(null != class89.field1549) {
         try {
            class118 var1 = new class118(4);
            var1.method2497(var0?2:3);
            var1.method2499(0);
            class89.field1549.method3003(var1.field1980, 0, 4);
         } catch (IOException var4) {
            try {
               class89.field1549.method3019();
            } catch (Exception var3) {
               ;
            }

            ++class170.field2721;
            class89.field1549 = null;
         }

      }
   }

   @ObfuscatedName("ax")
   static final void method17(class37 var0) {
      if(var0.field863 == client.field303 || -1 == var0.field869 || var0.field846 != 0 || var0.field856 + 1 > class134.method2875(var0.field869).field990[var0.field844]) {
         int var1 = var0.field863 - var0.field857;
         int var2 = client.field303 - var0.field857;
         int var3 = var0.field853 * 128 + var0.field816 * 64;
         int var4 = var0.field812 * 128 + var0.field816 * 64;
         int var5 = var0.field854 * 128 + var0.field816 * 64;
         int var6 = var0.field834 * 128 + var0.field816 * 64;
         var0.field870 = ((var1 - var2) * var3 + var2 * var5) / var1;
         var0.field813 = (var6 * var2 + (var1 - var2) * var4) / var1;
      }

      var0.field848 = 0;
      var0.field862 = var0.field824;
      var0.field814 = var0.field862;
   }
}
