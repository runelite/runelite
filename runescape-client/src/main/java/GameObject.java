import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 226488859
   )
   @Export("height")
   int height;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1792746953
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 583976291
   )
   int field1601;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1157442211
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 11468501
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1609534405
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1852537067
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1714062357
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 209216397
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1422508051
   )
   int field1610;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -588997769
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -841170993
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("qt")
   protected static java.awt.Frame field1615;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1498728505
   )
   @Export("x")
   int x;

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "46"
   )
   static int method1872(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2339((long)var0.index + ((long)var0.id << 32));
      return null != var1?var1.field1881:var0.field2257;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass112;",
      garbageValue = "-743947520"
   )
   public static class112 method1873() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }
}
