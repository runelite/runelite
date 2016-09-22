import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public abstract class class110 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1632059039
   )
   public int field1958;
   @ObfuscatedName("ps")
   static short[] field1959;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 949965011
   )
   public int field1960;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1373606635
   )
   public int field1961;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -930545971
   )
   public int field1962;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "13978395"
   )
   static final void method2404(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field368 - Client.field535) / 100 + Client.field535;
      int var7 = 512 * var3 * var6 / (334 * var2);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field541) {
         var15 = Client.field541;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 > Client.field540) {
            var6 = Client.field540;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var14 = (var2 - var8) / 2;
            if(var4) {
               class82.method1822();
               class82.method1883(var0, var1, var14, var3, -16777216);
               class82.method1883(var0 + var2 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= 2 * var14;
         }
      } else if(var7 > Client.field542) {
         var15 = Client.field542;
         var6 = var15 * var2 * 334 / (512 * var3);
         if(var6 < Client.field284) {
            var6 = Client.field284;
            var8 = 334 * var15 * var2 / (512 * var6);
            var14 = (var3 - var8) / 2;
            if(var4) {
               class82.method1822();
               class82.method1883(var0, var1, var2, var14, -16777216);
               class82.method1883(var0, var1 + var3 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= var14 * 2;
         }
      }

      var8 = var5 * (Client.field530 - Client.field537) / 100 + Client.field537;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(var2 != Client.camera2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class94.field1670[var11];
            var9[var10] = var12 * var13 >> 16;
         }

         Region.method2102(var9, 500, 800, var2, var3);
      }

      Client.field543 = var0;
      Client.field297 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "2145480561"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method619() != Client.isMembers) {
         Client.isMembers = var0.method619();
         boolean var1 = var0.method619();
         if(ItemComposition.isMembersWorld != var1) {
            ItemComposition.field1181.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class62.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class21.field583 = Client.field281 == 0?'ꩊ':'鱀' + var0.id;
      class21.field584 = Client.field281 == 0?443:var0.id + '썐';
      class50.field1115 = class21.field583;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "113"
   )
   public abstract boolean vmethod2408(int var1, int var2, int var3, CollisionData var4);
}
