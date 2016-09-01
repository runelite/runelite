import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("z")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1422157853
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("i")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("b")
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1318079679
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -907738251
   )
   @Export("height")
   int height;
   @ObfuscatedName("c")
   static int[] field1734;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1940608491
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 630922051
   )
   @Export("x")
   int x;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 806245801
   )
   protected static int field1738;
   @ObfuscatedName("ae")
   static ModIcon[] field1739;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZIB)V",
      garbageValue = "96"
   )
   static void method2260(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class93.field1615) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1829();
         byte[] var5 = var1.method3296("title.jpg", "");
         class40.field883 = new SpritePixels(var5, var0);
         class13.field195 = class40.field883.method1728();
         if((Client.flags & 536870912) != 0) {
            class162.field2660 = Item.method650(var2, "logo_deadman_mode", "");
         } else {
            class162.field2660 = Item.method650(var2, "logo", "");
         }

         class232.field3276 = Item.method650(var2, "titlebox", "");
         class33.field721 = Item.method650(var2, "titlebutton", "");
         class33.field722 = Sequence.method898(var2, "runes", "");
         ChatMessages.field276 = Sequence.method898(var2, "title_mute", "");
         class21.field576 = Item.method650(var2, "options_radio_buttons,0", "");
         class33.field723 = Item.method650(var2, "options_radio_buttons,2", "");
         class0.field12 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class0.field12[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field12[64 + var6] = 16711680 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field12[var6 + 128] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field12[192 + var6] = 16777215;
         }

         field1734 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            field1734[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field1734[var6 + 64] = '\uff00' + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field1734[128 + var6] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field1734[192 + var6] = 16777215;
         }

         FrameMap.field1816 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            FrameMap.field1816[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            FrameMap.field1816[64 + var6] = 255 + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            FrameMap.field1816[var6 + 128] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            FrameMap.field1816[var6 + 192] = 16777215;
         }

         class33.field730 = new int[256];
         class130.field2098 = new int['耀'];
         World.field659 = new int['耀'];
         class116.method2497((ModIcon)null);
         ChatMessages.field270 = new int['耀'];
         Frames.field1835 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field733 = "";
         }

         class159.field2362 = 0;
         SecondaryBufferProvider.authCode = "";
         class33.field731 = true;
         class33.worldSelectShown = false;
         if(!class161.field2659.field136) {
            NPC.method731(2, class192.field3108, "scape main", "", 255, false);
         } else {
            class40.method771(2);
         }

         class22.method558(false);
         class93.field1615 = true;
         class33.field745 = (FaceNormal.field1499 - Client.field333) / 2;
         class33.loginWindowX = class33.field745 + 202;
         class40.field883.method1738(class33.field745, 0);
         class13.field195.method1738(class33.field745 + 382, 0);
         class162.field2660.method1896(382 + class33.field745 - class162.field2660.originalWidth / 2, 18);
      }
   }
}
