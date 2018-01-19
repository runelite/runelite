import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("World")
public class World {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 942053817
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1481306265
   )
   static int field1217;
   @ObfuscatedName("b")
   static int[] field1223;
   @ObfuscatedName("e")
   static int[] field1224;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -73332619
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1964230429
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -222012739
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("w")
   @Export("address")
   String address;
   @ObfuscatedName("t")
   @Export("activity")
   String activity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1687134911
   )
   @Export("location")
   int location;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -573712759
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1217 = 0;
      field1223 = new int[]{1, 1, 1, 1};
      field1224 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "895801383"
   )
   boolean method1592() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-872648565"
   )
   boolean method1579() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-246638536"
   )
   boolean method1580() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2072930225"
   )
   boolean method1581() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1386960340"
   )
   boolean method1589() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "302215926"
   )
   boolean method1583() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lil;IIIZI)V",
      garbageValue = "545938496"
   )
   public static void method1618(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class214.field2631 = 1;
      class214.field2632 = var0;
      Ignore.field810 = var1;
      class262.field3474 = var2;
      class35.field477 = var3;
      class214.field2627 = var4;
      FontName.field3711 = 10000;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1931493629"
   )
   static boolean method1617(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   static void method1616() {
      FileOnDisk var0 = null;

      try {
         var0 = BoundingBox3D.getPreferencesFile("", class3.field18.name, true);
         Buffer var1 = class222.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
