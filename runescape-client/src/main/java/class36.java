import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class36 {
   @ObfuscatedName("v")
   static int[] field761;
   @ObfuscatedName("k")
   static final BigInteger field763 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("h")
   static final BigInteger field764 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = 8482159697053895823L
   )
   static long field766;
   @ObfuscatedName("ai")
   static boolean field769;
   @ObfuscatedName("qc")
   static class109 field770;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1420859533
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1309192527"
   )
   static final void method797(Actor var0, int var1) {
      ItemLayer.method1516(var0.x, var0.y, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "117"
   )
   static void method798(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class181 var4 = (class181)class185.field2744.method2428(var2);
      if(null != var4) {
         class185.field2748.method2365(var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "-1211854055"
   )
   static void method799(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field819) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4096();
         byte[] var5 = var1.method3365("title.jpg", "");
         class41.field820 = new SpritePixels(var5, var0);
         class41.field846 = class41.field820.method4242();
         if((Client.flags & 536870912) != 0) {
            XGrandExchangeOffer.field43 = class41.method854(var2, "logo_deadman_mode", "");
         } else {
            XGrandExchangeOffer.field43 = class41.method854(var2, "logo", "");
         }

         class41.field818 = class41.method854(var2, "titlebox", "");
         class41.field816 = class41.method854(var2, "titlebutton", "");
         class6.field53 = class164.method3217(var2, "runes", "");
         class7.field64 = class164.method3217(var2, "title_mute", "");
         class41.field822 = class41.method854(var2, "options_radio_buttons,0", "");
         class41.field837 = class41.method854(var2, "options_radio_buttons,2", "");
         class159.field2122 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class159.field2122[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class159.field2122[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class159.field2122[128 + var6] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class159.field2122[var6 + 192] = 16777215;
         }

         class72.field1173 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class72.field1173[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class72.field1173[var6 + 64] = '\uff00' + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class72.field1173[var6 + 128] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class72.field1173[var6 + 192] = 16777215;
         }

         field761 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            field761[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field761[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field761[128 + var6] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field761[192 + var6] = 16777215;
         }

         class150.field2037 = new int[256];
         Buffer.field2088 = new int['耀'];
         class13.field130 = new int['耀'];
         Tile.method1607((ModIcon)null);
         class41.field828 = new int['耀'];
         class5.field51 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field841 = "";
         }

         class41.field843 = 0;
         class154.authCode = "";
         class41.field844 = true;
         class41.worldSelectShown = false;
         if(!WallObject.field1551.field692) {
            class184 var9 = XItemContainer.field122;
            int var7 = var9.method3363("scape main");
            int var8 = var9.method3407(var7, "");
            class25.method613(2, var9, var7, var8, 255, false);
         } else {
            class33.method765(2);
         }

         class30.method695(false);
         class41.field819 = true;
         class41.field817 = (class2.field21 - Client.field500) / 2;
         class41.loginWindowX = class41.field817 + 202;
         class41.field820.method4252(class41.field817, 0);
         class41.field846.method4252(class41.field817 + 382, 0);
         XGrandExchangeOffer.field43.method4191(class41.field817 + 382 - XGrandExchangeOffer.field43.originalWidth / 2, 18);
      }
   }

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-1196601446"
   )
   public static void method800(class182 var0, class182 var1, class182 var2) {
      class196.field2880 = var0;
      class196.field2881 = var1;
      class196.field2875 = var2;
   }
}
