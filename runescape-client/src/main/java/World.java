import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("World")
public class World {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 870452627
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1937794089
   )
   static int field1211;
   @ObfuscatedName("x")
   static int[] field1204;
   @ObfuscatedName("p")
   static int[] field1210;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 354819381
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -632448853
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1270343535
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("v")
   @Export("address")
   String address;
   @ObfuscatedName("u")
   @Export("activity")
   String activity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1500916537
   )
   @Export("location")
   int location;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1290981435
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1211 = 0;
      field1204 = new int[]{1, 1, 1, 1};
      field1210 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1718212214"
   )
   boolean method1690() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   boolean method1677() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "642767242"
   )
   boolean method1673() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2055537262"
   )
   boolean method1675() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1092386556"
   )
   boolean method1672() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "375025298"
   )
   boolean method1676() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1925890860"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var1 = VerticalAlignment.method4748(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class237.varpsMasks[var4 - var3];
      return class237.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lcf;I)V",
      garbageValue = "563586675"
   )
   public static final void method1707(class101 var0) {
      AbstractSoundSystem.soundTaskDataProvider = var0;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lig;B)Ljava/lang/String;",
      garbageValue = "93"
   )
   static String method1709(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + Buffer.method3763(class110.method2292(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
