import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -472173089
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -853454743
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 981160403
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -99640513
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1018806865
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Leq;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("d")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 605210429
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1161757145
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("t")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("f")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("m")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 159963173
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1624082665
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 496207615
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 219923401
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;Lgv;I)Lgv;",
      garbageValue = "-1519230824"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class156.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lgd;IB)Lgd;",
      garbageValue = "121"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljd;",
      garbageValue = "204857634"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }
}
