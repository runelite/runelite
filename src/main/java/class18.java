import java.awt.Component;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class18 {
   @ObfuscatedName("x")
   class146 field263;
   @ObfuscatedName("y")
   byte[] field264;
   @ObfuscatedName("p")
   byte[] field265 = new byte[4];
   @ObfuscatedName("t")
   DataInputStream field266;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1665042767
   )
   static int field267;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1057696427
   )
   int field268;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 2611493014437820449L
   )
   long field269;
   @ObfuscatedName("z")
   static class154 field270;
   @ObfuscatedName("bo")
   static class168 field271;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1538647457
   )
   int field272;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1550517011
   )
   int field273;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -905175395
   )
   static int field277;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1292833925
   )
   static int field278;

   @ObfuscatedName("w")
   byte[] method191() throws IOException {
      if(class14.method165() > this.field269) {
         throw new IOException();
      } else {
         if(this.field268 == 0) {
            if(this.field263.field2235 == 2) {
               throw new IOException();
            }

            if(this.field263.field2235 == 1) {
               this.field266 = (DataInputStream)this.field263.field2234;
               this.field268 = 1;
            }
         }

         int var1;
         if(this.field268 == 1) {
            var1 = this.field266.available();
            if(var1 > 0) {
               if(this.field272 + var1 > 4) {
                  var1 = 4 - this.field272;
               }

               this.field272 += this.field266.read(this.field265, this.field272, var1);
               if(this.field272 == 4) {
                  int var2 = (new class119(this.field265)).method2511();
                  this.field264 = new byte[var2];
                  this.field268 = 2;
               }
            }
         }

         if(2 == this.field268) {
            var1 = this.field266.available();
            if(var1 > 0) {
               if(var1 + this.field273 > this.field264.length) {
                  var1 = this.field264.length - this.field273;
               }

               this.field273 += this.field266.read(this.field264, this.field273, var1);
               if(this.field273 == this.field264.length) {
                  return this.field264;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "-1533109304"
   )
   static void method194(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(class31.field715) {
         if(4 == var4) {
            class31.field729 = 4;
         }

      } else {
         class31.field729 = var4;
         class79.method1777();
         byte[] var5 = var1.method3352("title.jpg", "");
         class161.field2668 = new class78(var5, var0);
         class213.field3152 = class161.field2668.method1718();
         if(0 != (client.field503 & 536870912)) {
            class139.field2156 = class126.method2818(var2, "logo_deadman_mode", "");
         } else {
            class139.field2156 = class126.method2818(var2, "logo", "");
         }

         class31.field731 = class126.method2818(var2, "titlebox", "");
         class31.field717 = class126.method2818(var2, "titlebutton", "");
         class139.field2162 = class56.method1236(var2, "runes", "");
         class33.field779 = class56.method1236(var2, "title_mute", "");
         class189.field3061 = class126.method2818(var2, "options_radio_buttons,0", "");
         class90.field1566 = class126.method2818(var2, "options_radio_buttons,2", "");
         class96.field1645 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class96.field1645[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class96.field1645[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class96.field1645[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class96.field1645[var6 + 192] = 16777215;
         }

         class122.field2025 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class122.field2025[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class122.field2025[64 + var6] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class122.field2025[var6 + 128] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class122.field2025[var6 + 192] = 16777215;
         }

         class106.field1883 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class106.field1883[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class106.field1883[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class106.field1883[128 + var6] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class106.field1883[var6 + 192] = 16777215;
         }

         class229.field3232 = new int[256];
         class4.field87 = new int['耀'];
         class31.field737 = new int['耀'];
         class40.method871((class80)null);
         class48.field1097 = new int['耀'];
         class28.field684 = new int['耀'];
         if(var3) {
            class31.field734 = "";
            class31.field735 = "";
         }

         class33.field778 = 0;
         class26.field668 = "";
         class31.field722 = true;
         class31.field741 = false;
         if(!class41.field989.field157) {
            class38.method786(2, class19.field289, "scape main", "", 255, false);
         } else {
            class52.method1116(2);
         }

         class77.method1685(false);
         class31.field715 = true;
         class31.field720 = (class15.field235 - client.field509) / 2;
         class31.field718 = class31.field720 + 202;
         class161.field2668.method1697(class31.field720, 0);
         class213.field3152.method1697(class31.field720 + 382, 0);
         class139.field2156.method1855(382 + class31.field720 - class139.field2156.field1425 / 2, 18);
      }
   }

   class18(class136 var1, URL var2) {
      this.field263 = var1.method2888(var2);
      this.field268 = 0;
      this.field269 = class14.method165() + 30000L;
   }
}
