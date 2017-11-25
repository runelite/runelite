import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -222724907
   )
   static int field629;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("d")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1644162656"
   )
   static void method793() {
      if(MouseInput.renderOverview != null) {
         MouseInput.renderOverview.method5402(class233.plane, (class181.localPlayer.x >> 7) + IndexDataBase.baseX, (class181.localPlayer.y >> 7) + Occluder.baseY, false);
         MouseInput.renderOverview.method5416();
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "159858313"
   )
   @Export("addMenuEntry")
   @Hook("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.field889[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }
}
