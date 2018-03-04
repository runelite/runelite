import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("fq")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -90458615
   )
   static int field476;
   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field477;
   @ObfuscatedName("d")
   @Export("text")
   String text;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1484258121
   )
   int field472;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -741667759
   )
   int field473;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILo;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field472 = var2;
      this.field473 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1843859818"
   )
   static final void method369(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2997(var0, var1, var2);
      int[] var8 = Region.method2997(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "119"
   )
   static void method367(int var0) {
      if(var0 != -1) {
         if(class18.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2829 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.field2829;
                  BoundingBox.runScript(var4, 5000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method368() {
      if(class248.renderOverview != null) {
         class248.renderOverview.method6170(class36.plane, (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX, (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY, false);
         class248.renderOverview.method6095();
      }

   }
}
