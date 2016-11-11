import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class0 extends Node {
   @ObfuscatedName("j")
   String field0;
   @ObfuscatedName("v")
   static int[] field1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1623461563
   )
   int field3;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1165674709
   )
   int field4;
   @ObfuscatedName("h")
   boolean field5;
   @ObfuscatedName("d")
   Widget field6;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -523367225
   )
   int field7;
   @ObfuscatedName("i")
   Object[] field8;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1096672941
   )
   int field9;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -359700355
   )
   int field10;
   @ObfuscatedName("nk")
   static class58 field11;
   @ObfuscatedName("e")
   Widget field13;
   @ObfuscatedName("qo")
   protected static java.awt.Frame field15;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -806232595
   )
   int field17;

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "55"
   )
   static boolean method0(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class93.method2141(var0, Client.field302);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class93.method2141(Client.friends[var3].name, Client.field302)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class93.method2141(class138.localPlayer.name, Client.field302))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-613151895"
   )
   public static void method1() {
      class50.field1098.reset();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1974453647"
   )
   static final void method2(Actor var0, int var1) {
      class116.method2468(var0.x, var0.y, var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "2066759689"
   )
   static void method3(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field758) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1835();
         byte[] var5 = var1.method3306("title.jpg", "");
         class33.field745 = new SpritePixels(var5, var0);
         class164.field2694 = class33.field745.method1791();
         if((Client.flags & 536870912) != 0) {
            Client.field583 = Item.method658(var2, "logo_deadman_mode", "");
         } else {
            Client.field583 = Item.method658(var2, "logo", "");
         }

         class180.field2958 = Item.method658(var2, "titlebox", "");
         class33.field743 = Item.method658(var2, "titlebutton", "");
         class33.field744 = class51.method1072(var2, "runes", "");
         class33.field770 = class51.method1072(var2, "title_mute", "");
         XItemContainer.field236 = Item.method658(var2, "options_radio_buttons,0", "");
         class14.field223 = Item.method658(var2, "options_radio_buttons,2", "");
         class109.field1925 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class109.field1925[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class109.field1925[64 + var6] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class109.field1925[var6 + 128] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class109.field1925[var6 + 192] = 16777215;
         }

         class155.field2308 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class155.field2308[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class155.field2308[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class155.field2308[var6 + 128] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class155.field2308[var6 + 192] = 16777215;
         }

         class33.field754 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field754[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field754[64 + var6] = 255 + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field754[var6 + 128] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field754[var6 + 192] = 16777215;
         }

         class52.field1139 = new int[256];
         SecondaryBufferProvider.field1434 = new int['耀'];
         class79.field1442 = new int['耀'];
         Actor.method800((ModIcon)null);
         Frames.field1832 = new int['耀'];
         GameObject.field1727 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field764 = "";
         }

         class157.field2336 = 0;
         class157.authCode = "";
         class33.field766 = true;
         class33.worldSelectShown = false;
         if(!Player.field42.field157) {
            class171 var9 = Client.field476;
            int var7 = var9.method3304("scape main");
            int var8 = var9.method3305(var7, "");
            class186.field3010 = 1;
            class35.field800 = var9;
            FrameMap.field1823 = var7;
            class186.field3015 = var8;
            class186.field3016 = 255;
            class186.field3017 = false;
            class54.field1154 = 2;
         } else {
            class186.field3010 = 1;
            class35.field800 = null;
            FrameMap.field1823 = -1;
            class186.field3015 = -1;
            class186.field3016 = 0;
            class186.field3017 = false;
            class54.field1154 = 2;
         }

         class20.method533(false);
         class33.field758 = true;
         class33.field755 = (class62.field1267 - Client.field515) / 2;
         class33.loginWindowX = class33.field755 + 202;
         class33.field745.method1748(class33.field755, 0);
         class164.field2694.method1748(class33.field755 + 382, 0);
         Client.field583.method1905(382 + class33.field755 - Client.field583.originalWidth / 2, 18);
      }
   }
}
