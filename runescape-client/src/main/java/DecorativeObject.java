import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -87904951
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 705668615
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 800423499
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1718065305
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("al")
   static class102 field1600;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1529701103
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1277473667
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("s")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -205852319
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("o")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1577351627
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1139257251
   )
   @Export("rotation")
   int rotation;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   static void method1913() {
      Canvas var0 = class157.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1711 = -1;
      class72.method1398(class157.canvas);
      if(class138.field1917 != null) {
         class138.field1917.vmethod2084(class157.canvas);
      }

      class88.field1536.method2137();
      class157.canvas.setBackground(Color.black);
      Canvas var1 = class157.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      FileOnDisk.method1428(class157.canvas);
      if(class138.field1917 != null) {
         class138.field1917.vmethod2092(class157.canvas);
      }

      if(Client.widgetRoot != -1) {
         class41.method756(false);
      }

      GameEngine.field1783 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1803332362"
   )
   public static void method1914() {
      ItemComposition.field2942.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
