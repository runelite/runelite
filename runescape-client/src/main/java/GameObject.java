import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      longValue = -6104270600047501055L
   )
   @Export("js5StartTimeMs")
   static long js5StartTimeMs;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -457229589
   )
   @Export("__eh_fy")
   static int __eh_fy;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1393658667
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2095667225
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1791908691
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 109300811
   )
   @Export("centerX")
   int centerX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 714046631
   )
   @Export("centerY")
   int centerY;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("entity")
   public Entity entity;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1017836867
   )
   @Export("startX")
   int startX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -379698951
   )
   @Export("endX")
   int endX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1519796265
   )
   @Export("startY")
   int startY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -607228629
   )
   @Export("endY")
   int endY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1941106389
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1043687633
   )
   @Export("lastDrawn")
   int lastDrawn;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -114546124748632877L
   )
   @Export("tag")
   public long tag;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -161115901
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.tag = 0L;
      this.flags = 0;
   }
}
