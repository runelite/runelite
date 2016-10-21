import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class4 {
   @ObfuscatedName("e")
   static final BigInteger field67 = new BigInteger("b80c97968eedb6b24571b77e49337bfe9fc3f8769045f4d8153e6e892d7c74f1df86363c59cfd0bf01c82d4ae7592ced78b0bb6cf2a2b0e0acd57876b91844590c45785a6bac7617c646a73fd7002df1749c667babea40102c867520f9cfafa0deebb994492db56272d72c4cd78282a0c06f0a3e6ff1ab98572359de568b5ddf", 16);
   @ObfuscatedName("f")
   static final BigInteger field69 = new BigInteger("10001", 16);
   @ObfuscatedName("z")
   static int[] field70;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 86427549
   )
   static int field72;
   @ObfuscatedName("ex")
   static SpritePixels[] field74;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "806134577"
   )
   public static BufferProvider method49(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZIB)V",
      garbageValue = "-108"
   )
   static void method50(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field721) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1844();
         byte[] var5 = var1.method3285("title.jpg", "");
         class33.field731 = new SpritePixels(var5, var0);
         class33.field725 = class33.field731.method1815();
         if((Client.flags & 536870912) != 0) {
            class33.field749 = WidgetNode.method47(var2, "logo_deadman_mode", "");
         } else {
            class33.field749 = WidgetNode.method47(var2, "logo", "");
         }

         class33.field748 = WidgetNode.method47(var2, "titlebox", "");
         class33.field722 = WidgetNode.method47(var2, "titlebutton", "");
         class33.field723 = class51.method1062(var2, "runes", "");
         class168.field2699 = class51.method1062(var2, "title_mute", "");
         class33.field727 = WidgetNode.method47(var2, "options_radio_buttons,0", "");
         class33.field728 = WidgetNode.method47(var2, "options_radio_buttons,2", "");
         class79.field1435 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1435[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1435[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1435[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1435[var6 + 192] = 16777215;
         }

         class14.field211 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field211[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field211[var6 + 64] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field211[128 + var6] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field211[var6 + 192] = 16777215;
         }

         field70 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            field70[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field70[var6 + 64] = 255 + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field70[128 + var6] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field70[192 + var6] = 16777215;
         }

         class33.field733 = new int[256];
         ChatLineBuffer.field685 = new int['耀'];
         class188.field3046 = new int['耀'];
         class50.method1017((ModIcon)null);
         class33.field736 = new int['耀'];
         class220.field3209 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field724 = "";
         }

         class47.field1049 = 0;
         class20.authCode = "";
         class33.field751 = true;
         class33.worldSelectShown = false;
         if(!class16.field232.field138) {
            class171 var9 = class47.field1050;
            int var7 = var9.method3299("scape main");
            int var8 = var9.method3361(var7, "");
            class165.method3218(2, var9, var7, var8, 255, false);
         } else {
            class12.method146(2);
         }

         XItemContainer.method174(false);
         class33.field721 = true;
         class33.field720 = (class153.field2296 - Client.field436) / 2;
         class33.loginWindowX = 202 + class33.field720;
         class33.field731.method1761(class33.field720, 0);
         class33.field725.method1761(382 + class33.field720, 0);
         class33.field749.method1913(382 + class33.field720 - class33.field749.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1375753197"
   )
   static final void method51() {
      if(XItemContainer.plane != Client.field430) {
         Client.field430 = XItemContainer.plane;
         class163.method3208(XItemContainer.plane);
      }

   }
}
