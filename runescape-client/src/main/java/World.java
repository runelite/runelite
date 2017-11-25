import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("World")
public class World {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lcw;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1638493389
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -59334701
   )
   static int field1217;
   @ObfuscatedName("t")
   static int[] field1219;
   @ObfuscatedName("p")
   static int[] field1220;
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static Font field1226;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1384891259
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1740109915
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1352415529
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("c")
   @Export("address")
   String address;
   @ObfuscatedName("y")
   @Export("activity")
   String activity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1436676545
   )
   @Export("location")
   int location;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2064665491
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1217 = 0;
      field1219 = new int[]{1, 1, 1, 1};
      field1220 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   boolean method1624() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1646221508"
   )
   boolean method1595() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1920707398"
   )
   boolean method1627() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-7"
   )
   boolean method1597() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "24"
   )
   boolean method1598() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2016383393"
   )
   boolean method1599() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIILjv;IB)V",
      garbageValue = "2"
   )
   static void method1615(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class81 var5 = new class81();
      var5.field1241 = var0;
      var5.field1242 = var1 * 128;
      var5.field1244 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1251 = (var6 + var1) * 128;
      var5.field1245 = (var7 + var2) * 128;
      var5.field1247 = var3.ambientSoundId;
      var5.field1246 = var3.field3541 * 128;
      var5.field1249 = var3.field3500;
      var5.field1243 = var3.field3546;
      var5.field1240 = var3.field3547;
      if(var3.impostorIds != null) {
         var5.field1254 = var3;
         var5.method1646();
      }

      class81.field1248.addFront(var5);
      if(var5.field1240 != null) {
         var5.field1252 = var5.field1249 + (int)(Math.random() * (double)(var5.field1243 - var5.field1249));
      }

   }
}
