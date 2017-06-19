import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1175051205
   )
   int field1897;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2062959725
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -765533945
   )
   int field1899;
   @ObfuscatedName("w")
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("z")
   SceneTileModel field1901;
   @ObfuscatedName("x")
   Tile field1902;
   @ObfuscatedName("j")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1880579833
   )
   int field1904;
   @ObfuscatedName("f")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1925272247
   )
   int field1907;
   @ObfuscatedName("q")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("n")
   int[] field1909;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 115496623
   )
   int field1910;
   @ObfuscatedName("v")
   boolean field1912;
   @ObfuscatedName("s")
   boolean field1913;
   @ObfuscatedName("k")
   boolean field1914;
   @ObfuscatedName("c")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1813839453
   )
   int field1916;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2145245483
   )
   int field1917;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 737600113
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1481425817
   )
   @Export("y")
   int y;
   @ObfuscatedName("rt")
   @ObfuscatedGetter(
      longValue = 5381003057868263389L
   )
   static long field1921;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -371972077
   )
   int field1922;

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1603859061"
   )
   static void method2390() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.field1100 = 1;
      Client.field955 = -1;
      Client.field956 = -1;
      Client.packetLength = 0;
      Client.field952 = 0;
      Client.field919 = 0;
      Client.menuOptionCount = 0;
      Client.field1053 = -1;
      Client.isMenuOpen = false;
      Client.field1087 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class20.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1226 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      class23.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1111[var0] = true;
      }

      class66.method1024();
   }

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.field1909 = new int[5];
      this.field1910 = 0;
      this.field1917 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
