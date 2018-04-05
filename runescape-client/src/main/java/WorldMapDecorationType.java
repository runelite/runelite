import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2992(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3003(1, 0),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2986(2, 0),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2989(3, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2990(9, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2991(4, 1),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2995(5, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3006(6, 1),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2994(7, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3009(8, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2996(12, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2997(13, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3007(14, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2999(15, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3000(16, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3001(17, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3002(18, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2987(19, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3004(20, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3005(21, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2988(10, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field2993(11, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3008(22, 3);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 8449017
   )
   @Export("rsOrdinal")
   public final int rsOrdinal;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.rsOrdinal = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.rsOrdinal;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1751832585"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(FaceNormal.listFetcher == null) {
            FaceNormal.listFetcher = MapIconReference.urlRequester.request(new URL(Client.field876));
         } else if(FaceNormal.listFetcher.isDone()) {
            byte[] var0 = FaceNormal.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            WorldMapType1.method308(World.worldList, 0, World.worldList.length - 1, World.field1230, World.field1229);
            FaceNormal.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         FaceNormal.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-87"
   )
   public static void method4499() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
