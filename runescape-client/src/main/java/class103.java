import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Frames")
public class class103 extends class204 {
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -960527903
   )
   static int field1771;
   @ObfuscatedName("f")
   class88[] field1774;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;ILclass2;II)V",
      garbageValue = "-2101838042"
   )
   static final void method2345(class122 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 32) != 0) {
         var5 = var0.method2554();
         byte[] var6 = new byte[var5];
         class119 var7 = new class119(var6);
         var0.method2565(var6, 0, var5);
         class32.field756[var1] = var7;
         var2.method15(var7);
      }

      int var15;
      if((var3 & 128) != 0) {
         var5 = var0.method2556();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var15 = var0.method2554();
         class7.method110(var2, var5, var15);
      }

      if((var3 & 2) != 0) {
         var2.field846 = var0.method2556();
         if(var2.field846 == '\uffff') {
            var2.field846 = -1;
         }
      }

      if((var3 & 4) != 0) {
         var2.field824 = var0.method2668();
         if(var2.field824.charAt(0) == 126) {
            var2.field824 = var2.field824.substring(1);
            class52.method1147(2, var2.field60, var2.field824);
         } else if(class15.field225 == var2) {
            class52.method1147(2, var2.field60, var2.field824);
         }

         var2.field835 = false;
         var2.field852 = 0;
         var2.field877 = 0;
         var2.field882 = 150;
      }

      if((var3 & 16) != 0) {
         var5 = var0.method2556();
         var15 = var0.method2554();
         var2.method806(var5, var15, client.field301);
         var2.field843 = client.field301 + 300;
         var2.field861 = var0.method2554();
         var2.field834 = var0.method2554();
      }

      if((var3 & 64) != 0) {
         var2.field848 = var0.method2556();
         if(var2.field874 == 0) {
            var2.field871 = var2.field848;
            var2.field848 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.method2556();
         class152 var17 = (class152)class14.method177(class9.method135(), var0.method2554());
         boolean var16 = var0.method2554() == 1;
         int var8 = var0.method2554();
         int var9 = var0.field1998;
         if(var2.field60 != null && var2.field36 != null) {
            boolean var10 = false;
            if(var17.field2262 && class2.method43(var2.field60)) {
               var10 = true;
            }

            if(!var10 && client.field409 == 0 && !var2.field46) {
               class32.field757.field1998 = 0;
               var0.method2565(class32.field757.field2000, 0, var8);
               class32.field757.field1998 = 0;
               class119 var12 = class32.field757;
               String var11 = class178.method3498(var12, 32767);
               String var13 = class223.method4069(class15.method185(var11));
               var2.field824 = var13.trim();
               var2.field852 = var5 >> 8;
               var2.field877 = var5 & 255;
               var2.field882 = 150;
               var2.field835 = var16;
               var2.field836 = class15.field225 != var2 && var17.field2262 && "" != client.field507 && var13.toLowerCase().indexOf(client.field507) == -1;
               int var14;
               if(var17.field2261) {
                  var14 = var16?91:1;
               } else {
                  var14 = var16?90:2;
               }

               if(var17.field2260 != -1) {
                  class52.method1147(var14, class113.method2487(var17.field2260) + var2.field60, var13);
               } else {
                  class52.method1147(var14, var2.field60, var13);
               }
            }
         }

         var0.field1998 = var8 + var9;
      }

      if((var3 & 8192) != 0) {
         var2.field857 = var0.method2556();
         var5 = var0.method2696();
         var2.field842 = var5 >> 16;
         var2.field860 = client.field301 + (var5 & '\uffff');
         var2.field821 = 0;
         var2.field859 = 0;
         if(var2.field860 > client.field301) {
            var2.field821 = -1;
         }

         if(var2.field857 == '\uffff') {
            var2.field857 = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field862 = var0.method2538();
         var2.field864 = var0.method2538();
         var2.field838 = var0.method2538();
         var2.field844 = var0.method2538();
         var2.field823 = var0.method2556() + client.field301;
         var2.field866 = var0.method2556() + client.field301;
         var2.field850 = var0.method2556();
         if(var2.field58) {
            var2.field862 += var2.field59;
            var2.field864 += var2.field55;
            var2.field838 += var2.field59;
            var2.field844 += var2.field55;
            var2.field874 = 0;
         } else {
            var2.field862 += var2.field875[0];
            var2.field864 += var2.field876[0];
            var2.field838 += var2.field875[0];
            var2.field844 += var2.field876[0];
            var2.field874 = 1;
         }

         var2.field879 = 0;
      }

      if((var3 & 2048) != 0) {
         var5 = var0.method2556();
         var15 = var0.method2554();
         var2.method806(var5, var15, client.field301);
         var2.field843 = 300 + client.field301;
         var2.field861 = var0.method2554();
         var2.field834 = var0.method2554();
      }

      if((var3 & 256) != 0) {
         class32.field767[var1] = var0.method2538();
      }

      if((var3 & 512) != 0) {
         var4 = var0.method2538();
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field39[var5] = var0.method2668();
         }
      }

      if(var2.field58) {
         if(var4 == 127) {
            var2.method33(var2.field59, var2.field55);
         } else {
            byte var18;
            if(var4 != -1) {
               var18 = var4;
            } else {
               var18 = class32.field767[var1];
            }

            var2.method18(var2.field59, var2.field55, var18);
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZ)V",
      garbageValue = "0"
   )
   public class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3321(var3);
      this.field1774 = new class88[var6];
      int[] var7 = var1.method3342(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3286(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3852(); null != var12; var12 = (class102)var5.method3857()) {
            if(var12.field1766 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3295(var11, 0);
            var10 = new class102(var11, var13);
            var5.method3877(var10);
         }

         this.field1774[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1307111341"
   )
   public boolean method2347(int var1) {
      return this.field1774[var1].field1556;
   }
}
