import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class25 {
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache4")
   static IndexCache indexCache4;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -12041645
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 916624935
   )
   final int field199;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1452888767
   )
   final int field198;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -501025733
   )
   final int field202;

   class25(int var1, int var2, int var3) {
      this.field199 = var1;
      this.field198 = var2;
      this.field202 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1540935608"
   )
   static final int method348(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "641029128"
   )
   static void method349() {
      if(Client.renderSelf) {
         WorldMapCacheName.addPlayerToScene(Canvas.localPlayer, false);
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "162108213"
   )
   static void method350(int var0, int var1, int var2, int var3) {
      Widget var4 = class204.getWidgetChild(var0, var1);
      if(var4 != null && var4.onTargetEnter != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.args0 = var4.onTargetEnter;
         AbstractIndexCache.runScript(var5);
      }

      Client.__client_mh = var3;
      Client.isSpellSelected = true;
      ServerBuild.__iy_lo = var0;
      Client.__client_lc = var1;
      FloorDecoration.selectedSpellFlags = var2;
      class22.method295(var4);
   }
}
