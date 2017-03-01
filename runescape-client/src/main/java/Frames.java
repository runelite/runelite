import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("qh")
   static class109 field1576;
   @ObfuscatedName("x")
   Frame[] field1581;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-27"
   )
   public boolean method1990(int var1) {
      return this.field1581[var1].field1337;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "28384996"
   )
   public static Font method1991(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3426(var2);
      int var5 = var0.method3370(var4, var3);
      return class49.method980(var0, var1, var4, var5);
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3352(var3);
      this.field1581 = new Frame[var6];
      int[] var7 = var1.method3364(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2503(); var12 != null; var12 = (FrameMap)var5.method2492()) {
            if(var11 == var12.field1470) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3361(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2511(var10);
         }

         this.field1581[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "2"
   )
   static final void method1993(boolean var0) {
      for(int var1 = 0; var1 < Client.field328; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field285[var1]];
         int var3 = (Client.field285[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod794() && var0 == var2.composition.isVisible && var2.composition.method3784()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field607 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field502 == Client.field453[var4][var5]) {
                     continue;
                  }

                  Client.field453[var4][var5] = Client.field502;
               }

               if(!var2.composition.field3039) {
                  var3 -= Integer.MIN_VALUE;
               }

               Friend.region.method1878(CollisionData.plane, var2.x, var2.y, class25.method615(var2.field607 * 64 - 64 + var2.x, var2.field607 * 64 - 64 + var2.y, CollisionData.plane), 60 + (var2.field607 * 64 - 64), var2, var2.angle, var3, var2.field655);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "864327586"
   )
   static void method1994(World var0) {
      if(var0.method658() != Client.isMembers) {
         Client.isMembers = var0.method658();
         boolean var1 = var0.method658();
         if(Item.isMembersWorld != var1) {
            method1995();
            Item.isMembersWorld = var1;
         }
      }

      BufferProvider.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class212.field3145 = Client.field309 == 0?'ꩊ':var0.id + '鱀';
      class20.field217 = Client.field309 == 0?443:'썐' + var0.id;
      Client.field325 = class212.field3145;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   public static void method1995() {
      ItemComposition.field2993.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static void method1996() {
      if(Client.field444) {
         Widget var0 = class33.method774(Player.field269, Client.field529);
         if(var0 != null && null != var0.field2298) {
            class18 var1 = new class18();
            var1.field188 = var0;
            var1.field196 = var0.field2298;
            class40.method828(var1);
         }

         Client.field444 = false;
         ChatLineBuffer.method996(var0);
      }
   }
}
