import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1725557519
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -695857629
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1267689537
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -721315981
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1495705029
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Let;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("s")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 414760873
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1613392379
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("o")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("r")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("i")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -746627283
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1182737099
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 37190099
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1139868411
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lez;"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1910530156"
   )
   static void method2505() {
      try {
         File var0 = new File(class1.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class157.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label36:
            for(int var4 = 0; var4 < GrandExchangeOffer.field298.length; ++var4) {
               for(var2 = 0; var2 < class115.cacheLocations.length; ++var2) {
                  File var3 = new File(class115.cacheLocations[var2] + GrandExchangeOffer.field298[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class157.randomDat = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label36;
                  }
               }
            }
         }

         if(class157.randomDat == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class157.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
