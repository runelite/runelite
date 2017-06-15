import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("World")
public class World {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1522516599
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1687822551
   )
   static int field1281;
   @ObfuscatedName("c")
   @Export("worldServersDownload")
   static class77 worldServersDownload;
   @ObfuscatedName("i")
   static int[] field1283;
   @ObfuscatedName("f")
   static int[] field1284;
   @ObfuscatedName("a")
   @Export("address")
   String address;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -286118705
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 648398151
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 524176219
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("g")
   @Export("activity")
   String activity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1016556063
   )
   @Export("location")
   int location;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 848943803
   )
   @Export("index")
   int index;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1216446893
   )
   static int field1293;
   @ObfuscatedName("aj")
   public static BufferProvider field1296;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean method1461() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2087575053"
   )
   boolean method1462() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1678610055"
   )
   boolean method1465() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-385747484"
   )
   boolean method1466() {
      return (33554432 & this.mask) != 0;
   }

   static {
      field1281 = 0;
      field1293 = 0;
      field1283 = new int[]{1, 1, 1, 1};
      field1284 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2046959771"
   )
   boolean method1469() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)I",
      garbageValue = "973992588"
   )
   static int method1475(PacketBuffer var0) {
      int var1 = var0.method3290(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3290(5);
      } else if(var1 == 2) {
         var2 = var0.method3290(8);
      } else {
         var2 = var0.method3290(11);
      }

      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   boolean method1488() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;II)Lclass207;",
      garbageValue = "-939152258"
   )
   static class207 method1499(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4001(var1);
      return var2 == null?null:new class207(var2);
   }
}
