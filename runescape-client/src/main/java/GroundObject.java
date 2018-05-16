import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("af")
   protected static String field1555;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 133833155
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 728614643722600121L
   )
   @Export("hash")
   public long hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -112250021
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1699475917
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -159480023
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-230957517"
   )
   public static void method2703(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class179.method3537(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lbb;",
      garbageValue = "-863280267"
   )
   static World method2704() {
      return World.field956 < World.worldCount?class143.worldList[++World.field956 - 1]:null;
   }
}
