import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("x")
public final class class25 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1518438391
   )
   int field562;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 794835497
   )
   int field563;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1508037203
   )
   int field564;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1422585123
   )
   int field565;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1604791535
   )
   int field566 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1303589207
   )
   int field567;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1861677109
   )
   int field569;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1259748003
   )
   int field570;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1372766137
   )
   int field571;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2121448309
   )
   int field572;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 602539697
   )
   int field573 = -1;
   @ObfuscatedName("bp")
   static class184 field574;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2076220943
   )
   int field575;

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1197411500"
   )
   static final void method611(Widget var0, int var1, int var2) {
      if(Client.field450 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var6 = class32.method713(class88.method1872(var0));
            Widget var4;
            int var7;
            if(var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class37.method759(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if(null == var4) {
               var8 = var0.parent;
            }

            if(var8 != null) {
               Client.field450 = var0;
               var5 = var0;
               var6 = class32.method713(class88.method1872(var0));
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class37.method759(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(null == var4) {
                  var8 = var0.parent;
               }

               Client.field420 = var8;
               Client.field452 = var1;
               Client.field360 = var2;
               MessageNode.field230 = 0;
               Client.field460 = false;
               if(Client.menuOptionCount > 0) {
                  XGrandExchangeOffer.method70(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "824984713"
   )
   static final void method612() {
      for(class25 var0 = (class25)Client.field300.method2403(); null != var0; var0 = (class25)Client.field300.method2398()) {
         if(var0.field573 == -1) {
            var0.field566 = 0;
            class180.method3268(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "2135009757"
   )
   public static void method613(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method613(var0, var1, var2, var5 - 1);
         method613(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1108955043"
   )
   static void method614(String var0) {
      class1.field12 = var0;

      try {
         String var1 = Client.field277.getParameter(class214.field3148.field3151);
         String var2 = Client.field277.getParameter(class214.field3149.field3151);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class22.method224() + 94608000000L;
            class169.field2319.setTime(new Date(var6));
            int var8 = class169.field2319.get(7);
            int var9 = class169.field2319.get(5);
            int var10 = class169.field2319.get(2);
            int var11 = class169.field2319.get(1);
            int var12 = class169.field2319.get(11);
            int var13 = class169.field2319.get(12);
            int var14 = class169.field2319.get(13);
            var5 = class169.field2314[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class169.field2318[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = Client.field277;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1646655533"
   )
   static final String method615(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class163.method3157('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class163.method3157(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class163.method3157(16776960) + var1 + "</col>");
   }
}
