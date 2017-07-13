import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("co")
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("v")
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("s")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("p")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("l")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1745112963
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("w")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("u")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1206013741
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("e")
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("g")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("d")
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1497025439
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1887313475
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("o")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1372765931
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2042781905
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1978890247
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("c")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 522290313
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("x")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -586775189
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 842419767
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -834579137
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1215378627"
   )
   static void method2491(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field718 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "177163951"
   )
   public static boolean method2492(int var0) {
      return var0 == class221.field2834.field2816;
   }
}
