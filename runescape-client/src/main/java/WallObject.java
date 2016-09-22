import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2125835859
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2097589959
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 891795181
   )
   int field1615;
   @ObfuscatedName("t")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 329673587
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2051919887
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1482240209
   )
   int field1619 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -808726379
   )
   int field1620;
   @ObfuscatedName("qx")
   protected static java.awt.Frame field1621;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass21;",
      garbageValue = "-296515580"
   )
   static class21[] method2110() {
      return new class21[]{class21.field578, class21.field580, class21.field581, class21.field587};
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "98"
   )
   static final void method2111(boolean var0) {
      for(int var1 = 0; var1 < Client.field319; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field320[var1]];
         int var3 = (Client.field320[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod785() && var0 == var2.composition.isVisible && var2.composition.method811()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field843 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field472[var4][var5] == Client.field387) {
                     continue;
                  }

                  Client.field472[var4][var5] = Client.field387;
               }

               if(!var2.composition.field942) {
                  var3 -= Integer.MIN_VALUE;
               }

               class16.region.method1959(Item.plane, var2.x, var2.y, class116.method2462(var2.field843 * 64 - 64 + var2.x, var2.y + (var2.field843 * 64 - 64), Item.plane), var2.field843 * 64 - 64 + 60, var2, var2.angle, var3, var2.field842);
            }
         }
      }

   }
}
