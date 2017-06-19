import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class112 {
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1915956721
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("m")
   IndexDataBase field1661;
   @ObfuscatedName("t")
   XHashTable field1663;
   @ObfuscatedName("s")
   static String[] field1664;
   @ObfuscatedName("p")
   IndexDataBase field1668;
   @ObfuscatedName("e")
   XHashTable field1670;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "255"
   )
   public static int method1991(CharSequence var0) {
      return class12.parseInt(var0, 10, true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass107;",
      garbageValue = "2"
   )
   public class107 method1993(int var1, int[] var2) {
      if(this.field1668.method4007() == 1) {
         return this.method1999(0, var1, var2);
      } else if(this.field1668.method4075(var1) == 1) {
         return this.method1999(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[IS)Lclass107;",
      garbageValue = "6968"
   )
   public class107 method1994(int var1, int[] var2) {
      if(this.field1661.method4007() == 1) {
         return this.method1996(0, var1, var2);
      } else if(this.field1661.method4075(var1) == 1) {
         return this.method1996(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "1638468625"
   )
   class107 method1996(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1663.method3425(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1670.method3425(var5);
         if(var8 == null) {
            var8 = class106.method1855(this.field1661, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1670.method3426(var8, var5);
         }

         var7 = var8.method1856(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1663.method3426(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "-294133009"
   )
   class107 method1999(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1663.method3425(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1843(this.field1668, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1839();
            this.field1663.method3426(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1605.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1474727691"
   )
   static void method2005() {
      Object var0 = class236.field3239;
      Object var1 = class236.field3239;
      Object var2 = class236.field3239;
      synchronized(class236.field3239) {
         if(class236.field3241 == 0) {
            class21.field352 = new Thread(new class236());
            class21.field352.setDaemon(true);
            class21.field352.start();
            class21.field352.setPriority(5);
         }

         class236.field3241 = 600;
      }
   }

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1670 = new XHashTable(256);
      this.field1663 = new XHashTable(256);
      this.field1668 = var1;
      this.field1661 = var2;
   }
}
