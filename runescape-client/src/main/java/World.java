import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("World")
public class World {
   @ObfuscatedName("b")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -926216409
   )
   @Export("index")
   int index;
   @ObfuscatedName("x")
   static int[] field1318;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 186242501
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("io")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 813015327
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1427287969
   )
   static int field1322;
   @ObfuscatedName("q")
   @Export("address")
   String address;
   @ObfuscatedName("j")
   @Export("activity")
   String activity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 547025441
   )
   @Export("location")
   int location;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1471446757
   )
   static int field1326;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1252733993
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   static int[] field1328;
   @ObfuscatedName("bu")
   static class289 field1331;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "64"
   )
   boolean method1545() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1907707327"
   )
   public static final boolean method1546() {
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         if(class50.field635 == class50.field644) {
            return false;
         } else {
            class3.field27 = class50.field651[class50.field635];
            class50.field642 = class50.field637[class50.field635];
            class50.field635 = class50.field635 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1567173617"
   )
   boolean method1547() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method1548() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-465050274"
   )
   boolean method1550() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-180582743"
   )
   boolean method1551() {
      return (33554432 & this.mask) != 0;
   }

   static {
      field1326 = 0;
      field1322 = 0;
      field1318 = new int[]{1, 1, 1, 1};
      field1328 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2142455045"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[FaceNormal.plane][var0][var1];
      if(var2 == null) {
         class1.region.method2695(FaceNormal.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3576(); var6 != null; var6 = (Item)var2.method3578()) {
            ItemComposition var7 = Buffer.getItemDefinition(var6.id);
            long var10 = (long)var7.price;
            if(var7.isStackable == 1) {
               var10 *= (long)(var6.quantity + 1);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class1.region.method2695(FaceNormal.plane, var0, var1);
         } else {
            var2.method3572(var5);
            Item var12 = null;
            Item var8 = null;

            for(var6 = (Item)var2.method3576(); var6 != null; var6 = (Item)var2.method3578()) {
               if(var5.id != var6.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var6.id != var12.id && var8 == null) {
                     var8 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class1.region.method2681(FaceNormal.plane, var0, var1, class21.method139(var0 * 128 + 64, var1 * 128 + 64, FaceNormal.plane), var5, var9, var12, var8);
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method1567() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass186;III)I",
      garbageValue = "1743928357"
   )
   static int method1583(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         class198 var3 = (class198)var0.method3475((long)var1);
         return var3 == null?var2:var3.field2494;
      }
   }
}
