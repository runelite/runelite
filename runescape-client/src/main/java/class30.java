import java.awt.Component;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class30 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1853940591
   )
   static int field695 = 4;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1458574131
   )
   int field696 = 1;
   @ObfuscatedName("g")
   LinkedHashMap field697 = new LinkedHashMap();
   @ObfuscatedName("ct")
   static class110 field698;
   @ObfuscatedName("f")
   boolean field699;
   @ObfuscatedName("h")
   boolean field702;

   class30() {
      this.method637(true);
   }

   class30(Buffer var1) {
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field695) {
            if(var1.readUnsignedByte() == 1) {
               this.field699 = true;
            }

            if(var2 > 1) {
               this.field702 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field696 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2727();
                  int var6 = var1.method2727();
                  this.field697.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method637(true);
         }
      } else {
         this.method637(true);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2020132422"
   )
   void method637(boolean var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "2081807830"
   )
   Buffer method641() {
      Buffer var1 = new Buffer(100);
      var1.method2708(field695);
      var1.method2708(this.field699?1:0);
      var1.method2708(this.field702?1:0);
      var1.method2708(this.field696);
      var1.method2708(this.field697.size());
      Iterator var2 = this.field697.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2711(((Integer)var3.getKey()).intValue());
         var1.method2711(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "1433179975"
   )
   static void method647(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field812) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method3868();
         byte[] var5 = var1.method3199("title.jpg", "");
         class41.field815 = new SpritePixels(var5, var0);
         class39.field798 = class41.field815.method4019();
         if((Client.flags & 536870912) != 0) {
            class41.field816 = class88.method1821(var2, "logo_deadman_mode", "");
         } else {
            class41.field816 = class88.method1821(var2, "logo", "");
         }

         class41.field819 = class88.method1821(var2, "titlebox", "");
         class41.field840 = class88.method1821(var2, "titlebutton", "");
         class41.field811 = Renderable.method1831(var2, "runes", "");
         class157.field2129 = Renderable.method1831(var2, "title_mute", "");
         class41.field817 = class88.method1821(var2, "options_radio_buttons,0", "");
         class41.field818 = class88.method1821(var2, "options_radio_buttons,2", "");
         class97.field1630 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class97.field1630[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class97.field1630[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class97.field1630[var6 + 128] = 16776960 + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class97.field1630[var6 + 192] = 16777215;
         }

         class85.field1464 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class85.field1464[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class85.field1464[var6 + 64] = '\uff00' + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class85.field1464[128 + var6] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class85.field1464[var6 + 192] = 16777215;
         }

         class41.field821 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field821[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field821[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field821[128 + var6] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field821[var6 + 192] = 16777215;
         }

         class146.field2031 = new int[256];
         class36.field771 = new int['耀'];
         class221.field3193 = new int['耀'];
         XItemContainer.method146((ModIcon)null);
         class203.field3076 = new int['耀'];
         FrameMap.field1470 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field810 = "";
         }

         class10.field108 = 0;
         class41.authCode = "";
         class41.field837 = true;
         class41.worldSelectShown = false;
         if(!class38.field794.field702) {
            class184 var9 = class164.field2170;
            int var7 = var9.method3197("scape main");
            int var8 = var9.method3198(var7, "");
            class138.field1933 = 1;
            ChatLineBuffer.field967 = var9;
            GroundObject.field1298 = var7;
            class207.field3097 = var8;
            class138.field1921 = 255;
            class138.field1927 = false;
            class138.field1926 = 2;
         } else {
            Renderable.method1825(2);
         }

         class183.method3266(false);
         class41.field812 = true;
         class41.field814 = (class16.field186 - Client.field355) / 2;
         class41.loginWindowX = class41.field814 + 202;
         class41.field815.method3969(class41.field814, 0);
         class39.field798.method3969(class41.field814 + 382, 0);
         class41.field816.method3919(382 + class41.field814 - class41.field816.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "37"
   )
   public static void method648() {
      class181.field2710 = null;
      class225.field3220 = null;
      class119.field1865 = null;
      class109.field1742 = null;
      class225.field3217 = null;
      class44.field888 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "15"
   )
   static void method649() {
      if(class41.field812) {
         class41.field819 = null;
         class41.field840 = null;
         class41.field811 = null;
         class41.field815 = null;
         class39.field798 = null;
         class41.field816 = null;
         class157.field2129 = null;
         class41.field817 = null;
         class41.field818 = null;
         Ignore.field222 = null;
         class85.field1462 = null;
         VertexNormal.field1426 = null;
         class41.field845 = null;
         class186.field2771 = null;
         class97.field1630 = null;
         class85.field1464 = null;
         class41.field821 = null;
         class146.field2031 = null;
         class36.field771 = null;
         class221.field3193 = null;
         class203.field3076 = null;
         FrameMap.field1470 = null;
         Renderable.method1825(2);
         class183.method3266(true);
         class41.field812 = false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-125"
   )
   public static int method650(int var0) {
      return var0 >> 17 & 7;
   }
}
