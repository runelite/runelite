import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2044320753
   )
   @Export("type")
   int type;
   @ObfuscatedName("j")
   @Export("sender")
   String sender;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 739659917
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 88343429
   )
   static int field239;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 641821159
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @Export("value")
   String value;
   @ObfuscatedName("e")
   static int[] field242;
   @ObfuscatedName("i")
   static class228 field244;
   @ObfuscatedName("p")
   @Export("name")
   String name;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "-86"
   )
   static void method211(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2749.method2399(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2756.method2399(var6);
         if(null == var8) {
            var8 = (class181)class185.field2754.method2399(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2484();
                  class185.field2749.method2400(var8, var6);
                  --class185.field2751;
                  ++class185.field2763;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2767.method2399(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2707 = var0;
               var8.field2703 = var3;
               var8.field2702 = var4;
               if(var5) {
                  class185.field2749.method2400(var8, var6);
                  ++class185.field2763;
               } else {
                  class185.field2753.method2357(var8);
                  class185.field2754.method2400(var8, var6);
                  ++class185.field2751;
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-347950799"
   )
   void method212(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field949 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-2051044449"
   )
   static void method214(String[] var0, short[] var1, int var2, int var3) {
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
         method214(var0, var1, var2, var5 - 1);
         method214(var0, var1, 1 + var5, var3);
      }

   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field949 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-414308843"
   )
   static final void method215(Actor var0, int var1) {
      class176.method3278(var0.x, var0.y, var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZIB)V",
      garbageValue = "-35"
   )
   static void method216(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field841) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4044();
         byte[] var5 = var1.method3338("title.jpg", "");
         class5.field60 = new SpritePixels(var5, var0);
         XGrandExchangeOffer.field57 = class5.field60.method4161();
         if((Client.flags & 536870912) != 0) {
            XGrandExchangeOffer.field46 = class72.method1431(var2, "logo_deadman_mode", "");
         } else {
            XGrandExchangeOffer.field46 = class72.method1431(var2, "logo", "");
         }

         class41.field871 = class72.method1431(var2, "titlebox", "");
         class203.field3076 = class72.method1431(var2, "titlebutton", "");
         ChatLineBuffer.field989 = Frames.method1957(var2, "runes", "");
         class41.field874 = Frames.method1957(var2, "title_mute", "");
         class37.field813 = class72.method1431(var2, "options_radio_buttons,0", "");
         class41.field842 = class72.method1431(var2, "options_radio_buttons,2", "");
         class211.field3128 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class211.field3128[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class211.field3128[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class211.field3128[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class211.field3128[192 + var6] = 16777215;
         }

         class31.field722 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field722[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field722[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field722[128 + var6] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field722[var6 + 192] = 16777215;
         }

         class5.field61 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field61[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field61[var6 + 64] = 262144 * var6 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field61[var6 + 128] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field61[var6 + 192] = 16777215;
         }

         class41.field847 = new int[256];
         class41.field854 = new int['耀'];
         field242 = new int['耀'];
         class8.method99((ModIcon)null);
         class41.field872 = new int['耀'];
         VertexNormal.field1443 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field864 = "";
         }

         class105.field1728 = 0;
         class30.authCode = "";
         class41.field866 = true;
         class41.worldSelectShown = false;
         if(!class184.field2735.field720) {
            XItemContainer.method167(2, class11.field127, "scape main", "", 255, false);
         } else {
            class118.method2335(2);
         }

         class110.method2137(false);
         class41.field841 = true;
         class41.field839 = (class32.field758 - Client.field563) / 2;
         class41.loginWindowX = 202 + class41.field839;
         class5.field60.method4171(class41.field839, 0);
         XGrandExchangeOffer.field57.method4171(382 + class41.field839, 0);
         XGrandExchangeOffer.field46.method4122(382 + class41.field839 - XGrandExchangeOffer.field46.originalWidth / 2, 18);
      }
   }
}
