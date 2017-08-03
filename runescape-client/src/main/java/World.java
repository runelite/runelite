import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("World")
public class World {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -461448333
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2117310937
   )
   static int field1261;
   @ObfuscatedName("t")
   static int[] field1265;
   @ObfuscatedName("i")
   static int[] field1266;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   @Export("listFetcher")
   static WorldListFetcher listFetcher;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lcc;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -918875453
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("p")
   @Export("address")
   String address;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -648111305
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1082900469
   )
   @Export("index")
   int index;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -797627623
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("u")
   @Export("activity")
   String activity;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1361672969
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1261 = 0;
      field1265 = new int[]{1, 1, 1, 1};
      field1266 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "712882473"
   )
   boolean method1596() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-68"
   )
   boolean method1560() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean method1563() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-135540606"
   )
   boolean method1584() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1723442772"
   )
   boolean method1561() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-6926"
   )
   boolean method1573() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Z",
      garbageValue = "572474237"
   )
   static final boolean method1597(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class92.method1758(var0, var1);
            int var3 = var0.field2743[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
