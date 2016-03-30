import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bi")
public class class59 {
   @ObfuscatedName("x")
   class167 field1220;
   @ObfuscatedName("w")
   class167 field1221;
   @ObfuscatedName("p")
   class196 field1222 = new class196(256);
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1064095811
   )
   static int field1224;
   @ObfuscatedName("t")
   class196 field1225 = new class196(256);

   @ObfuscatedName("w")
   class62 method1269(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1222.method3806(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1254(this.field1221, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1264();
            this.field1222.method3807(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1238.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   class62 method1270(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1222.method3806(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1225.method3806(var5);
         if(null == var8) {
            var8 = class70.method1552(this.field1220, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1225.method3807(var8, var5);
         }

         var7 = var8.method1561(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3935();
            this.field1222.method3807(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   public class62 method1271(int var1, int[] var2) {
      if(this.field1221.method3299() == 1) {
         return this.method1269(0, var1, var2);
      } else if(this.field1221.method3330(var1) == 1) {
         return this.method1269(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   static final void method1272() {
      if(null != class153.field2299) {
         class153.field2299.method1234();
      }

      if(null != class17.field253) {
         class17.field253.method1234();
      }

   }

   @ObfuscatedName("p")
   public class62 method1276(int var1, int[] var2) {
      if(this.field1220.method3299() == 1) {
         return this.method1270(0, var1, var2);
      } else if(this.field1220.method3330(var1) == 1) {
         return this.method1270(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1221 = var1;
      this.field1220 = var2;
   }

   @ObfuscatedName("p")
   public static boolean method1280(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
