import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public enum class27 implements class185 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   field377(0, (byte)0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   field368(3, (byte)1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   field369(2, (byte)2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   field367(1, (byte)3);

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1363813321
   )
   final int field371;
   @ObfuscatedName("m")
   final byte field372;

   class27(int var3, byte var4) {
      this.field371 = var3;
      this.field372 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field372;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;ZII)V",
      garbageValue = "-1770378502"
   )
   static void method215(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class91.field1342) {
         if(var3 == 4) {
            class91.loginIndex = 4;
         }

      } else {
         class91.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4284("title.jpg", "");
         class182.field2511 = FileOnDisk.method2479(var4);
         class91.field1347 = class182.field2511.method5257();
         if((Client.flags & 536870912) != 0) {
            class91.logoSprite = ClanMember.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class91.logoSprite = ClanMember.getSprite(var1, "logo", "");
         }

         class91.field1341 = ClanMember.getSprite(var1, "titlebox", "");
         class91.field1340 = ClanMember.getSprite(var1, "titlebutton", "");
         class272.field3720 = class210.method3855(var1, "runes", "");
         class91.titlemuteSprite = class210.method3855(var1, "title_mute", "");
         class269.field3694 = ClanMember.getSprite(var1, "options_radio_buttons,0", "");
         class13.field269 = ClanMember.getSprite(var1, "options_radio_buttons,4", "");
         class148.field2098 = ClanMember.getSprite(var1, "options_radio_buttons,2", "");
         class33.field446 = ClanMember.getSprite(var1, "options_radio_buttons,6", "");
         class61.field737 = class269.field3694.originalWidth;
         class28.field392 = class269.field3694.height;
         ScriptEvent.field811 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            ScriptEvent.field811[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptEvent.field811[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptEvent.field811[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptEvent.field811[var5 + 192] = 16777215;
         }

         class295.field3851 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class295.field3851[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class295.field3851[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class295.field3851[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class295.field3851[var5 + 192] = 16777215;
         }

         class91.field1350 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class91.field1350[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class91.field1350[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class91.field1350[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class91.field1350[var5 + 192] = 16777215;
         }

         class34.field459 = new int[256];
         class234.field3220 = new int['耀'];
         BuildType.field3261 = new int['耀'];
         class87.method1753((IndexedSprite)null);
         class82.field1274 = new int['耀'];
         class82.field1275 = new int['耀'];
         if(var2) {
            class91.username = "";
            class91.password = "";
         }

         class28.field390 = 0;
         class28.field393 = "";
         class91.field1369 = true;
         class91.worldSelectShown = false;
         if(!RSCanvas.preferences.muted) {
            IndexFile.method3146(2, RSCanvas.indexTrack1, "scape main", "", 255, false);
         } else {
            class2.method6(2);
         }

         class156.sendConInfo(false);
         class91.field1342 = true;
         class91.field1354 = (class86.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1354 + 202;
         class91.field1348 = class91.loginWindowX + 180;
         class182.field2511.method5266(class91.field1354, 0);
         class91.field1347.method5266(class91.field1354 + 382, 0);
         class91.logoSprite.method5245(class91.field1354 + 382 - class91.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-2037504731"
   )
   static int method219(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class54.field636:class82.field1265;
      if(var0 == 1800) {
         int[] var4 = class82.intStack;
         int var5 = ++class13.intStackSize - 1;
         int var7 = ClanMember.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
            } else {
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class82.intStack[--class13.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
