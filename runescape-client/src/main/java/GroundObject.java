import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -51176517
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1421060607
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -124099207
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1211280609
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1159915109
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-664782633"
   )
   public static boolean method2669(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "1912020908"
   )
   static int method2672(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         WorldComparator.intStackSize -= 2;
         var3 = class81.intStack[WorldComparator.intStackSize];
         int var4 = class81.intStack[WorldComparator.intStackSize + 1];
         if(!Client.field1111) {
            Client.cameraPitchTarget = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.cameraPitchTarget;
         return 1;
      } else if(var0 == 5506) {
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field945 = var3;
         return 1;
      } else if(var0 == 5531) {
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.field945;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-541187702"
   )
   static void method2670() {
      if(SoundTaskDataProvider.localPlayer.x >> 7 == Client.destinationX && SoundTaskDataProvider.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   static final void method2671() {
      PacketNode var0 = WorldMapRectangle.method280(ClientPacket.field2398, Client.field957.field1484);
      var0.packetBuffer.putByte(0);
      Client.field957.method2052(var0);
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lin;I)I",
      garbageValue = "-261087095"
   )
   @Export("getWidgetClickMask")
   static int getWidgetClickMask(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.clickMask;
   }
}
