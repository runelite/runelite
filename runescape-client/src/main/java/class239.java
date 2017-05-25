import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class239 implements class178 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 88745985
   )
   final int field3260;
   @ObfuscatedName("h")
   static final class239 field3261;
   @ObfuscatedName("u")
   static final class239 field3262;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 482688479
   )
   public final int field3263;
   @ObfuscatedName("i")
   static final class239 field3264;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZIB)V",
      garbageValue = "54"
   )
   static void method4338(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1427) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.method5002();
         byte[] var4 = var0.method4192("title.jpg", "");
         class92.field1429 = class154.method2980(var4);
         class269.field3672 = class92.field1429.method5178();
         if((Client.flags & 536870912) != 0) {
            class268.field3670 = class238.method4337(var1, "logo_deadman_mode", "");
         } else {
            class268.field3670 = class238.method4337(var1, "logo", "");
         }

         class92.field1417 = class238.method4337(var1, "titlebox", "");
         class92.field1425 = class238.method4337(var1, "titlebutton", "");
         class29.field419 = class56.method826(var1, "runes", "");
         class89.field1392 = class56.method826(var1, "title_mute", "");
         class92.field1420 = class238.method4337(var1, "options_radio_buttons,0", "");
         class56.field676 = class238.method4337(var1, "options_radio_buttons,2", "");
         World.field1265 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            World.field1265[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            World.field1265[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            World.field1265[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            World.field1265[var5 + 192] = 16777215;
         }

         class24.field365 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class24.field365[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class24.field365[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class24.field365[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class24.field365[var5 + 192] = 16777215;
         }

         class2.field10 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class2.field10[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class2.field10[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class2.field10[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class2.field10[var5 + 192] = 16777215;
         }

         class30.field430 = new int[256];
         class30.field437 = new int['耀'];
         Preferences.field1289 = new int['耀'];
         class64.method1094((ModIcon)null);
         class5.field33 = new int['耀'];
         GroundObject.field1847 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         class175.authCodeForLogin = 0;
         ItemLayer.authCode = "";
         class92.field1440 = true;
         class92.worldSelectShown = false;
         if(!class134.field1989.field1285) {
            IndexData var8 = class44.indexTrack1;
            int var6 = var8.method4189("scape main");
            int var7 = var8.method4190(var6, "");
            class13.method62(2, var8, var6, var7, 255, false);
         } else {
            class203.field2498 = 1;
            Varbit.field3380 = null;
            class169.field2325 = -1;
            class203.field2499 = -1;
            class203.field2500 = 0;
            class203.field2495 = false;
            class203.field2501 = 2;
         }

         class91.method1753(false);
         class92.field1427 = true;
         class92.field1416 = (class261.field3626 - 765) / 2;
         class92.loginWindowX = class92.field1416 + 202;
         class92.field1429.method5130(class92.field1416, 0);
         class269.field3672.method5130(class92.field1416 + 382, 0);
         class268.field3670.method5101(class92.field1416 + 382 - class268.field3670.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3260;
   }

   static {
      field3264 = new class239(0, 0);
      field3261 = new class239(1, 1);
      field3262 = new class239(2, 2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class239(int var1, int var2) {
      this.field3263 = var1;
      this.field3260 = var2;
   }
}
