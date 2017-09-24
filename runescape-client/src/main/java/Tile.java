import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -703632049
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lef;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -350125137
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("t")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1191428389
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 679790241
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("z")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1630502139
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1955080215
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1640367019
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2049021203
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("u")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -615840821
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1807073215
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1533611519
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
