import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -151355893
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1960985619
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 237331929
   )
   int field1547 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -825712711
   )
   int field1548;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 390668661
   )
   int field1549;
   @ObfuscatedName("j")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("q")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 361638875
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 881373909
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   static class20 field1557;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "-1971175514"
   )
   public static int method1884(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class63.method1174(var1);
      var0.method2925(var3.length);
      var0.offset += class210.field3110.method2851(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
