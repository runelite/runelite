import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class109 {
   @ObfuscatedName("a")
   public static class167 field1907;

   static {
      new HashMap();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;ILclass2;IB)V",
      garbageValue = "-52"
   )
   static final void method2526(class122 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 128) != 0) {
         var5 = var0.method2613();
         byte[] var6 = new byte[var5];
         class119 var7 = new class119(var6);
         var0.method2740(var6, 0, var5);
         class32.field761[var1] = var7;
         var2.method16(var7);
      }

      int var14;
      if((var3 & 64) != 0) {
         var5 = var0.method2615();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var14 = var0.method2613();
         class184.method3725(var2, var5, var14);
      }

      if((var3 & 16) != 0) {
         var2.field842 = var0.method2615();
         if('\uffff' == var2.field842) {
            var2.field842 = -1;
         }
      }

      if(0 != (var3 & 2)) {
         var2.field830 = var0.method2621();
         if(var2.field830.charAt(0) == 126) {
            var2.field830 = var2.field830.substring(1);
            class129.method2943(2, var2.field58, var2.field830);
         } else if(var2 == class5.field93) {
            class129.method2943(2, var2.field58, var2.field830);
         }

         var2.field861 = false;
         var2.field834 = 0;
         var2.field873 = 0;
         var2.field856 = 150;
      }

      if((var3 & 32) != 0) {
         var5 = var0.method2615();
         var14 = var0.method2613();
         var2.method837(var5, var14, client.field306);
         var2.field870 = client.field306 + 300;
         var2.field840 = var0.method2613();
         var2.field831 = var0.method2613();
      }

      if(0 != (var3 & 1)) {
         var2.field827 = var0.method2615();
         if(var2.field821 == 0) {
            var2.field853 = var2.field827;
            var2.field827 = -1;
         }
      }

      if((var3 & 8) != 0) {
         var5 = var0.method2615();
         class152[] var15 = new class152[]{class152.field2261, class152.field2268, class152.field2262, class152.field2263, class152.field2265};
         class152 var16 = (class152)class125.method2926(var15, var0.method2613());
         boolean var8 = var0.method2613() == 1;
         int var9 = var0.method2613();
         int var10 = var0.field1992;
         if(var2.field58 != null && var2.field33 != null) {
            boolean var11 = false;
            if(var16.field2259 && class33.method800(var2.field58)) {
               var11 = true;
            }

            if(!var11 && 0 == client.field366 && !var2.field51) {
               class32.field763.field1992 = 0;
               var0.method2740(class32.field763.field1993, 0, var9);
               class32.field763.field1992 = 0;
               String var12 = class223.method4115(class1.method14(class130.method2950(class32.field763)));
               var2.field830 = var12.trim();
               var2.field834 = var5 >> 8;
               var2.field873 = var5 & 255;
               var2.field856 = 150;
               var2.field861 = var8;
               var2.field832 = var2 != class5.field93 && var16.field2259 && client.field330 != "" && var12.toLowerCase().indexOf(client.field330) == -1;
               int var13;
               if(var16.field2266) {
                  var13 = var8?91:1;
               } else {
                  var13 = var8?90:2;
               }

               if(-1 != var16.field2260) {
                  class129.method2943(var13, class124.method2912(var16.field2260) + var2.field58, var12);
               } else {
                  class129.method2943(var13, var2.field58, var12);
               }
            }
         }

         var0.field1992 = var9 + var10;
      }

      if((var3 & 4096) != 0) {
         var2.field865 = var0.method2615();
         var5 = var0.method2618();
         var2.field857 = var5 >> 16;
         var2.field850 = (var5 & '\uffff') + client.field306;
         var2.field854 = 0;
         var2.field855 = 0;
         if(var2.field850 > client.field306) {
            var2.field854 = -1;
         }

         if(var2.field865 == '\uffff') {
            var2.field865 = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field858 = var0.method2699();
         var2.field860 = var0.method2699();
         var2.field859 = var0.method2699();
         var2.field833 = var0.method2699();
         var2.field862 = var0.method2615() + client.field306;
         var2.field866 = var0.method2615() + client.field306;
         var2.field864 = var0.method2615();
         if(var2.field56) {
            var2.field858 += var2.field57;
            var2.field860 += var2.field34;
            var2.field859 += var2.field57;
            var2.field833 += var2.field34;
            var2.field821 = 0;
         } else {
            var2.field858 += var2.field871[0];
            var2.field860 += var2.field835[0];
            var2.field859 += var2.field871[0];
            var2.field833 += var2.field835[0];
            var2.field821 = 1;
         }

         var2.field875 = 0;
      }

      if((var3 & 8192) != 0) {
         var5 = var0.method2615();
         var14 = var0.method2613();
         var2.method837(var5, var14, client.field306);
         var2.field870 = 300 + client.field306;
         var2.field840 = var0.method2613();
         var2.field831 = var0.method2613();
      }

      if(0 != (var3 & 2048)) {
         class32.field772[var1] = var0.method2699();
      }

      if(0 != (var3 & 256)) {
         var4 = var0.method2699();
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field55[var5] = var0.method2621();
         }
      }

      if(var2.field56) {
         if(127 == var4) {
            var2.method20(var2.field57, var2.field34);
         } else {
            byte var17;
            if(var4 != -1) {
               var17 = var4;
            } else {
               var17 = class32.field772[var1];
            }

            var2.method19(var2.field57, var2.field34, var17);
         }
      }

   }
}
