import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("World")
public class class25 {
   @ObfuscatedName("v")
   @Export("address")
   String field630;
   @ObfuscatedName("y")
   @Export("worldList")
   static class25[] field633;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -879427759
   )
   static int field634 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1673311441
   )
   @Export("playerCount")
   int field635;
   @ObfuscatedName("m")
   static int[] field636 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("j")
   static int[] field637 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1453645189
   )
   @Export("id")
   int field638;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -678873207
   )
   @Export("mask")
   int field639;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1234669083
   )
   static int field640 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1983248697
   )
   @Export("index")
   int field641;
   @ObfuscatedName("z")
   @Export("activity")
   String field643;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -416090705
   )
   @Export("location")
   int field644;

   @ObfuscatedName("h")
   boolean method598() {
      return (33554432 & this.field639) != 0;
   }

   @ObfuscatedName("g")
   boolean method599() {
      return 0 != (1 & this.field639);
   }

   @ObfuscatedName("j")
   boolean method601() {
      return (4 & this.field639) != 0;
   }

   @ObfuscatedName("l")
   boolean method604() {
      return 0 != (536870912 & this.field639);
   }

   @ObfuscatedName("n")
   boolean method609() {
      return (8 & this.field639) != 0;
   }

   @ObfuscatedName("m")
   boolean method615() {
      return (2 & this.field639) != 0;
   }

   @ObfuscatedName("a")
   public static void method620(Applet var0, String var1) {
      class137.field2126 = var0;
      class137.field2123 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass121;IB)V",
      garbageValue = "-1"
   )
   static final void method630(class121 var0, int var1) {
      int var2 = var0.field1979;
      class32.field765 = 0;
      class112.method2444(var0);

      for(int var3 = 0; var3 < class32.field765; ++var3) {
         int var4 = class32.field766[var3];
         class2 var5 = client.field415[var4];
         int var6 = var0.method2579();
         if(0 != (var6 & 1)) {
            var6 += var0.method2579() << 8;
         }

         byte var7 = -1;
         int var8;
         if((var6 & 4) != 0) {
            var8 = var0.method2579();
            byte[] var9 = new byte[var8];
            class118 var10 = new class118(var9);
            var0.method2506(var9, 0, var8);
            class32.field757[var4] = var10;
            var5.method19(var10);
         }

         int var22;
         if(0 != (var6 & 64)) {
            var8 = var0.method2514();
            if(var8 == '\uffff') {
               var8 = -1;
            }

            var22 = var0.method2579();
            class14.method186(var5, var8, var22);
         }

         if(0 != (var6 & 16)) {
            var5.field837 = var0.method2514();
            if(var5.field837 == '\uffff') {
               var5.field837 = -1;
            }
         }

         if(0 != (var6 & 128)) {
            var5.field825 = var0.method2520();
            if(var5.field825.charAt(0) == 126) {
               var5.field825 = var5.field825.substring(1);
               class137.method2943(2, var5.field40, var5.field825);
            } else if(var5 == class151.field2253) {
               class137.method2943(2, var5.field40, var5.field825);
            }

            var5.field826 = false;
            var5.field822 = 0;
            var5.field827 = 0;
            var5.field855 = 150;
         }

         if(0 != (var6 & 2)) {
            var8 = var0.method2514();
            var22 = var0.method2579();
            var5.method758(var8, var22, client.field303);
            var5.field838 = 300 + client.field303;
            var5.field835 = var0.method2579();
            var5.field836 = var0.method2579();
         }

         if((var6 & 32) != 0) {
            var5.field839 = var0.method2514();
            if(0 == var5.field865) {
               var5.field862 = var5.field839;
               var5.field839 = -1;
            }
         }

         if(0 != (var6 & 8)) {
            var8 = var0.method2514();
            class151 var23 = (class151)class155.method3174(class211.method3970(), var0.method2579());
            boolean var24 = var0.method2579() == 1;
            int var11 = var0.method2579();
            int var12 = var0.field1979;
            if(null != var5.field40 && null != var5.field43) {
               boolean var13 = false;
               if(var23.field2250 && class26.method635(var5.field40)) {
                  var13 = true;
               }

               if(!var13 && client.field414 == 0 && !var5.field52) {
                  class32.field764.field1979 = 0;
                  var0.method2506(class32.field764.field1980, 0, var11);
                  class32.field764.field1979 = 0;
                  class118 var15 = class32.field764;

                  String var16;
                  int var17;
                  String var19;
                  try {
                     var17 = var15.method2659();
                     if(var17 > 32767) {
                        var17 = 32767;
                     }

                     byte[] var18 = new byte[var17];
                     var15.field1979 += class221.field3177.method2441(var15.field1980, var15.field1979, var18, 0, var17);
                     var19 = class47.method1009(var18, 0, var17);
                     var16 = var19;
                  } catch (Exception var21) {
                     var16 = "Cabbage";
                  }

                  var16 = class222.method4130(class188.method3784(var16));
                  var5.field825 = var16.trim();
                  var5.field822 = var8 >> 8;
                  var5.field827 = var8 & 255;
                  var5.field855 = 150;
                  var5.field826 = var24;
                  var5.field829 = var5 != class151.field2253 && var23.field2250 && client.field514 != "" && var16.toLowerCase().indexOf(client.field514) == -1;
                  if(var23.field2249) {
                     var17 = var24?91:1;
                  } else {
                     var17 = var24?90:2;
                  }

                  if(var23.field2248 != -1) {
                     int var20 = var23.field2248;
                     var19 = "<img=" + var20 + ">";
                     class137.method2943(var17, var19 + var5.field40, var16);
                  } else {
                     class137.method2943(var17, var5.field40, var16);
                  }
               }
            }

            var0.field1979 = var11 + var12;
         }

         if(0 != (var6 & 8192)) {
            var5.field859 = var0.method2514();
            var8 = var0.method2517();
            var5.field852 = var8 >> 16;
            var5.field868 = client.field303 + (var8 & '\uffff');
            var5.field849 = 0;
            var5.field850 = 0;
            if(var5.field868 > client.field303) {
               var5.field849 = -1;
            }

            if('\uffff' == var5.field859) {
               var5.field859 = -1;
            }
         }

         if(0 != (var6 & 512)) {
            var5.field853 = var0.method2707();
            var5.field812 = var0.method2707();
            var5.field854 = var0.method2707();
            var5.field834 = var0.method2707();
            var5.field857 = var0.method2514() + client.field303;
            var5.field863 = var0.method2514() + client.field303;
            var5.field824 = var0.method2514();
            if(var5.field49) {
               var5.field853 += var5.field28;
               var5.field812 += var5.field29;
               var5.field854 += var5.field28;
               var5.field834 += var5.field29;
               var5.field865 = 0;
            } else {
               var5.field853 += var5.field866[0];
               var5.field812 += var5.field867[0];
               var5.field854 += var5.field866[0];
               var5.field834 += var5.field867[0];
               var5.field865 = 1;
            }

            var5.field861 = 0;
         }

         if(0 != (var6 & 4096)) {
            var8 = var0.method2514();
            var22 = var0.method2579();
            var5.method758(var8, var22, client.field303);
            var5.field838 = 300 + client.field303;
            var5.field835 = var0.method2579();
            var5.field836 = var0.method2579();
         }

         if((var6 & 2048) != 0) {
            class32.field756[var4] = var0.method2707();
         }

         if(0 != (var6 & 256)) {
            var7 = var0.method2707();
         }

         if((var6 & 1024) != 0) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.field30[var8] = var0.method2520();
            }
         }

         if(var5.field49) {
            if(var7 == 127) {
               var5.method39(var5.field28, var5.field29);
            } else {
               byte var25;
               if(var7 != -1) {
                  var25 = var7;
               } else {
                  var25 = class32.field756[var4];
               }

               var5.method22(var5.field28, var5.field29, var25);
            }
         }
      }

      if(var0.field1979 - var2 != var1) {
         throw new RuntimeException(var0.field1979 - var2 + " " + var1);
      }
   }

   @ObfuscatedName("a")
   static int method631() {
      return (class11.field166 += 987845255) * 1130287927 - 1;
   }

   @ObfuscatedName("q")
   static void method633(class42 var0, int var1, int var2, int var3) {
      if(client.field536 < 50 && client.field535 != 0) {
         if(var0.field987 != null && var1 < var0.field987.length) {
            int var4 = var0.field987[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field326[client.field536] = var5;
               client.field538[client.field536] = var6;
               client.field539[client.field536] = 0;
               client.field541[client.field536] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field503[client.field536] = (var8 << 16) + (var9 << 8) + var7;
               ++client.field536;
            }
         }
      }
   }
}
