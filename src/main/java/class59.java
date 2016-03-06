import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class59 {
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 537683397
   )
   static int field1220;
   @ObfuscatedName("l")
   class166 field1221;
   @ObfuscatedName("i")
   class195 field1222 = new class195(256);
   @ObfuscatedName("a")
   class195 field1223 = new class195(256);
   @ObfuscatedName("j")
   class166 field1226;

   @ObfuscatedName("a")
   public class62 method1254(int var1, int[] var2) {
      if(this.field1226.method3246() == 1) {
         return this.method1265(0, var1, var2);
      } else if(this.field1226.method3224(var1) == 1) {
         return this.method1265(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   class62 method1256(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1222.method3744(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1223.method3744(var5);
         if(null == var8) {
            var8 = class70.method1530(this.field1221, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1223.method3746(var8, var5);
         }

         var7 = var8.method1532(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method3853();
            this.field1222.method3746(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   public class62 method1258(int var1, int[] var2) {
      if(this.field1221.method3246() == 1) {
         return this.method1256(0, var1, var2);
      } else if(this.field1221.method3224(var1) == 1) {
         return this.method1256(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class59(class166 var1, class166 var2) {
      this.field1226 = var1;
      this.field1221 = var2;
   }

   @ObfuscatedName("j")
   class62 method1265(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1222.method3744(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1247(this.field1226, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1252();
            this.field1222.method3746(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1239.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   static void method1268(int var0, boolean var1, int var2, boolean var3) {
      if(class25.field632 != null) {
         class141.method2927(0, class25.field632.length - 1, var0, var1, var2, var3);
      }

   }
}
