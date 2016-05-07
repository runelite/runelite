import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class59 {
   @ObfuscatedName("p")
   class196 field1220 = new class196(256);
   @ObfuscatedName("j")
   class167 field1221;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 416073991
   )
   @Export("cameraPitch")
   static int field1222;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1755262423
   )
   static int field1223;
   @ObfuscatedName("s")
   class167 field1224;
   @ObfuscatedName("x")
   class196 field1226 = new class196(256);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "-1041200359"
   )
   class62 method1232(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1226.method3777(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1228(this.field1224, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1222();
            this.field1226.method3778(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1237.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "61690512"
   )
   public class62 method1234(int var1, int[] var2) {
      if(this.field1224.method3250() == 1) {
         return this.method1232(0, var1, var2);
      } else if(this.field1224.method3249(var1) == 1) {
         return this.method1232(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "-1936402545"
   )
   class62 method1235(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1226.method3777(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1220.method3777(var5);
         if(var8 == null) {
            var8 = class70.method1522(this.field1221, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1220.method3778(var8, var5);
         }

         var7 = var8.method1521(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3898();
            this.field1226.method3778(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "815157477"
   )
   public class62 method1238(int var1, int[] var2) {
      if(this.field1221.method3250() == 1) {
         return this.method1235(0, var1, var2);
      } else if(this.field1221.method3249(var1) == 1) {
         return this.method1235(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-68"
   )
   static final void method1241(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class188.method3731(var0)) {
         class99.field1689 = null;
         class29.method642(class217.field3171[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class99.field1689 != null) {
            class29.method642(class99.field1689, -1412584499, var1, var2, var3, var4, class154.field2291, class25.field630, var7);
            class99.field1689 = null;
         }

      } else {
         if(-1 != var7) {
            client.field482[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field482[var8] = true;
            }
         }

      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1224 = var1;
      this.field1221 = var2;
   }
}
