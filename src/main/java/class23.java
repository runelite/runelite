import java.awt.Desktop;
import java.awt.FontMetrics;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public final class class23 extends class208 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -306122209
   )
   int field610;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1621948727
   )
   static int field611;
   @ObfuscatedName("r")
   class40 field612;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1154280245
   )
   int field613;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1201050161
   )
   int field614;
   @ObfuscatedName("m")
   class64 field615;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -47827889
   )
   int field616;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -928763515
   )
   int field617;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2018319937
   )
   int field618;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 939932933
   )
   int field619;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1609336091
   )
   int field620;
   @ObfuscatedName("z")
   int[] field621;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1451431931
   )
   int field622;
   @ObfuscatedName("t")
   class64 field623;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1247926881
   )
   int field624;
   @ObfuscatedName("bf")
   static FontMetrics field625;
   @ObfuscatedName("f")
   public static String field626;
   @ObfuscatedName("a")
   static class199 field627 = new class199();

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "656775884"
   )
   static void method657(class173 var0) {
      if(client.field451 == var0.field2890) {
         client.field323[var0.field2889] = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1923287079"
   )
   void method658() {
      int var1 = this.field620;
      class40 var2 = this.field612.method894();
      if(var2 != null) {
         this.field620 = var2.field967;
         this.field616 = var2.field968 * 128;
         this.field610 = var2.field962;
         this.field617 = var2.field948;
         this.field621 = var2.field971;
      } else {
         this.field620 = -1;
         this.field616 = 0;
         this.field610 = 0;
         this.field617 = 0;
         this.field621 = null;
      }

      if(var1 != this.field620 && null != this.field615) {
         class10.field178.method1235(this.field615);
         this.field615 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "416767951"
   )
   public static void method660() {
      while(true) {
         class199 var1 = class170.field2707;
         class169 var0;
         synchronized(class170.field2707) {
            var0 = (class169)class170.field2711.method3903();
         }

         if(var0 == null) {
            return;
         }

         var0.field2697.method3444(var0.field2699, (int)var0.field3125, var0.field2695, false);
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIII)V",
      garbageValue = "448938181"
   )
   static final void method669(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field376) {
         client.field468 = 32;
      } else {
         client.field468 = 0;
      }

      client.field376 = false;
      int var7;
      if(class140.field2147 == 1 || !class7.field143 && 4 == class140.field2147) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2780 -= 4;
            method657(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.field2780 += 4;
            method657(var0);
         } else if(var5 >= var1 - client.field468 && var5 < client.field468 + 16 + var1 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2780 = (var4 - var3) * var8 / var9;
            method657(var0);
            client.field376 = true;
         }
      }

      if(client.field571 != 0) {
         var7 = var0.field2773;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2780 += client.field571 * 45;
            method657(var0);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "0"
   )
   public static void method670(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class138.field2135.startsWith("win")) {
            class4.method54(var0, 0, "openjs");
            return;
         }

         if(class138.field2135.startsWith("mac")) {
            class4.method54(var0, 1, var2);
            return;
         }

         class4.method54(var0, 2, "openjs");
      } else {
         class4.method54(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "976277909"
   )
   static final void method671(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field433) {
         if(client.field434 < 500) {
            client.field439[client.field434] = var0;
            client.field440[client.field434] = var1;
            client.field437[client.field434] = var2;
            client.field500[client.field434] = var3;
            client.field435[client.field434] = var4;
            client.field525[client.field434] = var5;
            ++client.field434;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;B)Ljava/lang/String;",
      garbageValue = "-128"
   )
   public static String method672(CharSequence var0, class212 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || 45 == var5;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || 32 == var5 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var12 = var3 - var2;
         if(var12 >= 1 && var12 <= class115.method2551(var1)) {
            StringBuilder var13 = new StringBuilder(var12);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class122.method2864(var7)) {
                  var8 = true;
               } else {
                  char[] var9 = class164.field2646;
                  int var10 = 0;

                  label111:
                  while(true) {
                     char var11;
                     if(var10 >= var9.length) {
                        var9 = class164.field2647;

                        for(var10 = 0; var10 < var9.length; ++var10) {
                           var11 = var9[var10];
                           if(var7 == var11) {
                              var8 = true;
                              break label111;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var9[var10];
                     if(var7 == var11) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var14 = class24.method677(var7);
                  if(var14 != 0) {
                     var13.append(var14);
                  }
               }
            }

            if(var13.length() == 0) {
               return null;
            } else {
               return var13.toString();
            }
         } else {
            return null;
         }
      }
   }
}
