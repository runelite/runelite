import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public final class class84 extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1772251247
   )
   int field1328;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 27502713
   )
   int field1329;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 597275809
   )
   int field1330;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1585271537
   )
   int field1331;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 50397993
   )
   int field1333;
   @ObfuscatedName("t")
   Sequence field1334;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1469672185
   )
   int field1335;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1849499669
   )
   int field1336;
   @ObfuscatedName("a")
   boolean field1337;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1249147547
   )
   int field1338;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   final void method1688(int var1) {
      if(!this.field1337) {
         this.field1335 += var1;

         while(this.field1335 > this.field1334.frameLenghts[this.field1338]) {
            this.field1335 -= this.field1334.frameLenghts[this.field1338];
            ++this.field1338;
            if(this.field1338 >= this.field1334.frameIDs.length) {
               this.field1337 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      Spotanim var1 = class203.method3752(this.field1336);
      Model var2;
      if(!this.field1337) {
         var2 = var1.method4407(this.field1338);
      } else {
         var2 = var1.method4407(-1);
      }

      return var2 == null?null:var2;
   }

   class84(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1338 = 0;
      this.field1335 = 0;
      this.field1337 = false;
      this.field1336 = var1;
      this.field1330 = var2;
      this.field1331 = var3;
      this.field1329 = var4;
      this.field1333 = var5;
      this.field1328 = var6 + var7;
      int var8 = class203.method3752(this.field1336).field3319;
      if(var8 != -1) {
         this.field1337 = false;
         this.field1334 = class165.getAnimation(var8);
      } else {
         this.field1337 = true;
      }

   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "84"
   )
   static final int method1694() {
      return Client.menuOptionCount <= 0?-1:(Client.field1005 && class50.field624[81] && Client.field1037 != -1?Client.field1037:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-452871222"
   )
   static final void method1695() {
      if(XGrandExchangeOffer.rssocket != null) {
         XGrandExchangeOffer.rssocket.method3048();
         XGrandExchangeOffer.rssocket = null;
      }

      class170.method3171();
      class46.region.method2709();

      for(int var1 = 0; var1 < 4; ++var1) {
         Client.collisionMaps[var1].method3073();
      }

      System.gc();
      class203.field2498 = 1;
      Varbit.field3380 = null;
      class169.field2325 = -1;
      class203.field2499 = -1;
      class203.field2500 = 0;
      class203.field2495 = false;
      class203.field2501 = 2;
      Client.field1127 = -1;
      Client.field1109 = false;

      for(class82 var0 = (class82)class82.field1299.method3660(); var0 != null; var0 = (class82)class82.field1299.method3661()) {
         if(var0.field1298 != null) {
            class164.field2291.method1910(var0.field1298);
            var0.field1298 = null;
         }

         if(var0.field1303 != null) {
            class164.field2291.method1910(var0.field1303);
            var0.field1303 = null;
         }
      }

      class82.field1299.method3656();
      class12.setGameState(10);
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "24"
   )
   static void method1696(byte[] var0, int var1) {
      if(Client.field967 == null) {
         Client.field967 = new byte[24];
      }

      class183.method3509(var0, var1, Client.field967, 0, 24);
   }
}
