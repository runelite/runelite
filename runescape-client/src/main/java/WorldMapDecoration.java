import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("archive4")
   static Archive archive4;
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
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1452888767
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -501025733
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1540935608"
   )
   static final int method348(int var0, int var1) {
      if (var0 == -2) {
         return 12345678;
      } else if (var0 == -1) {
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
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
   @Export("addLocalPlayerToScene")
   static void addLocalPlayerToScene() {
      if (Client.renderSelf) {
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
      if (var4 != null && var4.onTargetEnter != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.args0 = var4.onTargetEnter;
         AbstractArchive.runScript(var5);
      }

      Client.field157 = var3;
      Client.isSpellSelected = true;
      ServerBuild.field788 = var0;
      Client.field220 = var1;
      FloorDecoration.selectedSpellFlags = var2;
      WorldMapRectangle.method295(var4);
   }
}
