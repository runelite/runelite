import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("World")
public class World {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 487932509
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("pb")
   static class116 field695;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1652434179
   )
   static int field697 = 0;
   @ObfuscatedName("n")
   static int[] field698 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("m")
   static int[] field699 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1333541065
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2074202591
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("r")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("d")
   @Export("address")
   String address;
   @ObfuscatedName("p")
   @Export("activity")
   String activity;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 602323293
   )
   @Export("location")
   int location;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 567764767
   )
   @Export("index")
   int index;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 213691469
   )
   static int field708 = 0;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 900995253
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   static final void method596() {
      if(null != class137.field1927) {
         class137.field1927.method1082();
      }

      if(class2.field23 != null) {
         class2.field23.method1082();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "1024"
   )
   boolean method597() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-14"
   )
   boolean method598() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1170361681"
   )
   boolean method599() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "660653395"
   )
   boolean method600() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-62"
   )
   public static int method601(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1841091415"
   )
   public static void method612(String var0, boolean var1, boolean var2) {
      class13.method161(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1646819628"
   )
   boolean method619() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "580276827"
   )
   boolean method632() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-828986355"
   )
   static final int method635() {
      return Client.menuOptionCount <= 0?-1:(Client.field417 && class105.field1734[81] && Client.field449 != -1?Client.field449:Client.menuOptionCount - 1);
   }
}
