import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class212 {
   @ObfuscatedName("gk")
   public static final int[] field3143 = new int[]{-1, 0, 0, 0, -1, 0, 0, 7, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, -2, -1, -2, 2, 8, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 8, 0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, -2, 0, 0, 6, 8, 0, 0, 0, 2, 5, -2, 5, 20, 0, -1, -2, -2, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 28, 2, 0, 0, 0, 2, 4, 0, 0, 0, 0, 10, 0, 12, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, 0, 6, 0, 0, -2, 0, 0, 6, 5, 2, 0, 0, 0, 4, 0, 0, 0, 0, 2, 0, 0, 14, -2, 0, 6, 0, 0, 0, 0, 0, -1, 1, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 1, 2, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 4, 0, 0, 6, 0, -2, 4, 0, 7, 0, 0, 0, 2, 0, 0, 2, -2, 15, 0, -2, 0, 0, 3, 0, 0, 3, 0, 0, 0, 1, 0, 6, 0, 0, 0, 6, -2};

   class212() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1577574274"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class104.field1684 = null;
            WallObject.field1551 = null;
            class60.field1085 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field311 = 0;
            Client.field303 = 0;
            Client.field313 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != Client.field496) {
            Client.field496.method2059();
            Client.field496 = null;
         }

         if(Client.gameState == 25) {
            Client.field349 = 0;
            Client.field333 = 0;
            Client.field334 = 1;
            Client.field335 = 0;
            Client.field498 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class37.method734(class157.canvas, class94.field1595, class184.field2739, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class37.method734(class157.canvas, class94.field1595, class184.field2739, false, 4);
            } else if(class41.field826) {
               class41.field851 = null;
               class41.field820 = null;
               class211.field3124 = null;
               class41.field821 = null;
               CombatInfo1.field658 = null;
               class41.field819 = null;
               class41.field823 = null;
               class41.field824 = null;
               class41.field825 = null;
               class202.field3066 = null;
               class41.field839 = null;
               class118.field1851 = null;
               class31.field710 = null;
               class49.field959 = null;
               class0.field3 = null;
               class3.field31 = null;
               class145.field2018 = null;
               class41.field829 = null;
               CollisionData.field1841 = null;
               FileOnDisk.field1191 = null;
               class40.field806 = null;
               class10.field101 = null;
               class138.field1921 = 1;
               Item.field887 = null;
               class181.field2695 = -1;
               Frames.field1569 = -1;
               class105.field1721 = 0;
               class138.field1922 = false;
               class138.field1926 = 2;
               class119.method2295(true);
               class41.field826 = false;
            }
         } else {
            class37.method734(class157.canvas, class94.field1595, class184.field2739, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
