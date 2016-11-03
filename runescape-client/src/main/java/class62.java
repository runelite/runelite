import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class62 {
   @ObfuscatedName("c")
   XHashTable field1274 = new XHashTable(256);
   @ObfuscatedName("f")
   XHashTable field1275 = new XHashTable(256);
   @ObfuscatedName("k")
   class170 field1279;
   @ObfuscatedName("q")
   class170 field1280;

   public class62(class170 var1, class170 var2) {
      this.field1279 = var1;
      this.field1280 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass65;",
      garbageValue = "126"
   )
   class65 method1295(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1274.method3828(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1275.method3828(var5);
         if(null == var8) {
            var8 = class73.method1593(this.field1280, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1275.method3822(var8, var5);
         }

         var7 = var8.method1594(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1274.method3822(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "-60"
   )
   public class65 method1296(int var1, int[] var2) {
      if(this.field1279.method3291() == 1) {
         return this.method1309(0, var1, var2);
      } else if(this.field1279.method3290(var1) == 1) {
         return this.method1309(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "-56"
   )
   public class65 method1298(int var1, int[] var2) {
      if(this.field1280.method3291() == 1) {
         return this.method1295(0, var1, var2);
      } else if(this.field1280.method3290(var1) == 1) {
         return this.method1295(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LActor;IB)V",
      garbageValue = "1"
   )
   static final void method1302(Actor var0, int var1) {
      if(var0.field871 > Client.gameCycle) {
         NPCComposition.method830(var0);
      } else if(var0.field855 >= Client.gameCycle) {
         class20.method571(var0);
      } else {
         class54.method1110(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field871 = 0;
         var0.field855 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field841 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field841 * 64;
         var0.method773();
      }

      if(var0 == class165.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field871 = 0;
         var0.field855 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field841 * 64;
         var0.y = 128 * var0.pathY[0] + var0.field841 * 64;
         var0.method773();
      }

      Tile.method2351(var0);
      Projectile.method86(var0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "1790268955"
   )
   class65 method1309(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1274.method3828(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1292(this.field1279, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1284();
            this.field1274.method3822(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1292.length;
            }

            return var7;
         }
      }
   }
}
