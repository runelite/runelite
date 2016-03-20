import java.awt.Component;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
public class class18 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 778262389
   )
   int field264;
   @ObfuscatedName("f")
   DataInputStream field265;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -791529075
   )
   int field266;
   @ObfuscatedName("s")
   byte[] field267 = new byte[4];
   @ObfuscatedName("r")
   class145 field268;
   @ObfuscatedName("e")
   byte[] field269;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1060798343
   )
   int field270;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 6960695493420835003L
   )
   long field271;
   @ObfuscatedName("j")
   static class153 field274;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 21055737
   )
   static int field275;

   @ObfuscatedName("a")
   byte[] method206() throws IOException {
      if(method214() > this.field271) {
         throw new IOException();
      } else {
         if(this.field270 == 0) {
            if(2 == this.field268.field2202) {
               throw new IOException();
            }

            if(1 == this.field268.field2202) {
               this.field265 = (DataInputStream)this.field268.field2206;
               this.field270 = 1;
            }
         }

         int var1;
         if(1 == this.field270) {
            var1 = this.field265.available();
            if(var1 > 0) {
               if(this.field264 + var1 > 4) {
                  var1 = 4 - this.field264;
               }

               this.field264 += this.field265.read(this.field267, this.field264, var1);
               if(this.field264 == 4) {
                  int var2 = (new class118(this.field267)).method2517();
                  this.field269 = new byte[var2];
                  this.field270 = 2;
               }
            }
         }

         if(this.field270 == 2) {
            var1 = this.field265.available();
            if(var1 > 0) {
               if(var1 + this.field266 > this.field269.length) {
                  var1 = this.field269.length - this.field266;
               }

               this.field266 += this.field265.read(this.field269, this.field266, var1);
               if(this.field269.length == this.field266) {
                  return this.field269;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("a")
   public static void method207(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class136.field2108);
      var0.addFocusListener(class136.field2108);
   }

   @ObfuscatedName("bg")
   static final void method210(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field497; ++var4) {
         if(client.field504[var4] + client.field502[var4] > var0 && client.field502[var4] < var0 + var2 && client.field505[var4] + client.field515[var4] > var1 && client.field515[var4] < var1 + var3) {
            client.field499[var4] = true;
         }
      }

   }

   @ObfuscatedName("l")
   static void method211(class25 var0) {
      if(var0.method599() != client.field296) {
         client.field296 = var0.method599();
         boolean var1 = var0.method599();
         if(var1 != class51.field1109) {
            class51.field1137.method3800();
            class51.field1111.method3800();
            class51.field1155.method3800();
            class51.field1109 = var1;
         }
      }

      class32.field768 = var0.field630;
      client.field527 = var0.field638;
      client.field506 = var0.field639;
      class72.field1350 = client.field295 == 0?'ꩊ':'鱀' + var0.field638;
      class94.field1612 = 0 == client.field295?443:var0.field638 + '썐';
      class36.field800 = class72.field1350;
   }

   @ObfuscatedName("da")
   static final boolean method212(class172 var0) {
      int var1 = var0.field2747;
      if(var1 == 205) {
         client.field345 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field378.method3504(var2, 1 == var3);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field378.method3498(var2, 1 == var3);
         }

         if(var1 == 324) {
            client.field378.method3497(false);
         }

         if(325 == var1) {
            client.field378.method3497(true);
         }

         if(var1 == 326) {
            client.field301.method2753(84);
            client.field378.method3500(client.field301);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   static int method213(class166 var0, class166 var1) {
      int var2 = 0;
      if(var0.method3281("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3281("logo", "")) {
         ++var2;
      }

      if(var1.method3281("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3281("titlebox", "")) {
         ++var2;
      }

      if(var1.method3281("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3281("runes", "")) {
         ++var2;
      }

      if(var1.method3281("title_mute", "")) {
         ++var2;
      }

      if(var1.method3275("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3275("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3281("sl_back", "");
      var1.method3281("sl_flags", "");
      var1.method3281("sl_arrows", "");
      var1.method3281("sl_stars", "");
      var1.method3281("sl_button", "");
      return var2;
   }

   @ObfuscatedName("a")
   public static synchronized long method214() {
      long var0 = System.currentTimeMillis();
      if(var0 < class114.field1966) {
         class114.field1963 += class114.field1966 - var0;
      }

      class114.field1966 = var0;
      return var0 + class114.field1963;
   }

   @ObfuscatedName("s")
   public static int method215(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(8364 == var7) {
               var3[var6 + var4] = -128;
            } else if(8218 == var7) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(8225 == var7) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(8240 == var7) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(338 == var7) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(8217 == var7) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(8211 == var7) {
               var3[var4 + var6] = -106;
            } else if(8212 == var7) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(8482 == var7) {
               var3[var6 + var4] = -103;
            } else if(353 == var7) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(339 == var7) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(376 == var7) {
               var3[var6 + var4] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   class18(class135 var1, URL var2) {
      this.field268 = var1.method2901(var2);
      this.field270 = 0;
      this.field271 = method214() + 30000L;
   }
}
