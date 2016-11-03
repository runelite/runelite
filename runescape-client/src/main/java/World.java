import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("World")
public class World {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1349933699
   )
   static int field643 = 0;
   @ObfuscatedName("y")
   static int[] field644 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("u")
   static int[] field645 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -519314511
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @Export("activity")
   String activity;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -898846793
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("e")
   @Export("address")
   String address;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1928327297
   )
   @Export("index")
   int index;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -481056593
   )
   @Export("location")
   int location;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -748257955
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1666381949
   )
   static int field656 = 0;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-805974466"
   )
   boolean method621() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-19"
   )
   boolean method622() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   boolean method624() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "30"
   )
   boolean method625() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1805043573"
   )
   boolean method626() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "1501080277"
   )
   static final boolean method646(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label88:
      while(true) {
         int var6 = var4.method2554();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2554();
               if(var9 == 0) {
                  continue label88;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2571() >> 2;
               int var13 = var1 + var11;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = Projectile.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field282 || var15.field982 != 0 || var15.field952 == 1 || var15.field973) {
                     if(!var15.method839()) {
                        ++Client.field514;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2554();
            if(var9 == 0) {
               break;
            }

            var4.method2571();
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "26031"
   )
   boolean method649() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)[Lclass155;",
      garbageValue = "5767"
   )
   public static class155[] method657() {
      return new class155[]{class155.field2310, class155.field2312, class155.field2304, class155.field2306, class155.field2308};
   }
}
