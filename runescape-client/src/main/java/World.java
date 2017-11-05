import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("World")
public class World {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field1293;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1993179921
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1899503073
   )
   static int field1283;
   @ObfuscatedName("e")
   static int[] field1284;
   @ObfuscatedName("d")
   static int[] field1286;
   @ObfuscatedName("aw")
   static int[] field1285;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static IndexData field1295;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 106497689
   )
   static int field1296;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 98824363
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1492516791
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1943864787
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1436804291
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("t")
   @Export("address")
   String address;
   @ObfuscatedName("a")
   @Export("activity")
   String activity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 728451097
   )
   @Export("location")
   int location;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1161696173
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1283 = 0;
      field1284 = new int[]{1, 1, 1, 1};
      field1286 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-345763950"
   )
   boolean method1546() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "430992285"
   )
   boolean method1547() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-499528172"
   )
   boolean method1548() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1921116594"
   )
   boolean method1545() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-25570557"
   )
   boolean method1550() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "616538404"
   )
   boolean method1551() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-691625522"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "459668945"
   )
   static final void method1577(boolean var0) {
      if(var0) {
         Client.field1002 = class90.field1438?class149.field2195:class149.field2194;
      } else {
         LinkedHashMap var1 = class70.preferences.preferences;
         String var3 = class90.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field1002 = var1.containsKey(Integer.valueOf(var5))?class149.field2197:class149.field2196;
      }

   }
}
