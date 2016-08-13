import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public final class class16 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -11393719
   )
   int field228;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1238990429
   )
   int field229;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1601248467
   )
   int field230;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 713105585
   )
   int field231;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1890095527
   )
   int field232;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 479771607
   )
   int field233;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -594781665
   )
   int field235;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1290161685
   )
   int field236;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -728216903
   )
   int field237 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1330004585
   )
   int field238;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 266103885
   )
   int field239;
   @ObfuscatedName("al")
   static class171 field240;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1001024629
   )
   int field241 = 0;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 840326773
   )
   static int field242;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "8"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field929.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field921.method3411(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method838(new Buffer(var2));
         }

         var1.method815();
         NPCComposition.field929.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "65280"
   )
   static void method203(class0 var0) {
      TextureProvider.method2282(var0, 200000);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "80"
   )
   public static class48 method204(int var0) {
      class48 var1 = (class48)class48.field1078.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class48.field1086.method3411(4, var0);
         var1 = new class48();
         if(var2 != null) {
            var1.method1014(new Buffer(var2), var0);
         }

         var1.method1013();
         class48.field1078.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1706960153"
   )
   static String method205(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   static final void method206(boolean var0) {
      for(int var1 = 0; var1 < Client.field486; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field334[var1]];
         int var3 = (Client.field334[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod794() && var0 == var2.composition.isVisible && var2.composition.method844()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field877 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field400 == Client.field560[var4][var5]) {
                     continue;
                  }

                  Client.field560[var4][var5] = Client.field400;
               }

               if(!var2.composition.field940) {
                  var3 -= Integer.MIN_VALUE;
               }

               class136.region.method2003(VertexNormal.plane, var2.x, var2.y, class127.method2936(var2.x + (var2.field877 * 64 - 64), var2.field877 * 64 - 64 + var2.y, VertexNormal.plane), var2.field877 * 64 - 64 + 60, var2, var2.angle, var3, var2.field834);
            }
         }
      }

   }
}
