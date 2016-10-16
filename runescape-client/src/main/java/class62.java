import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class62 {
   @ObfuscatedName("s")
   class170 field1257;
   @ObfuscatedName("z")
   class170 field1258;
   @ObfuscatedName("t")
   XHashTable field1259 = new XHashTable(256);
   @ObfuscatedName("y")
   XHashTable field1260 = new XHashTable(256);
   @ObfuscatedName("m")
   static byte[][][] field1261;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "189381218"
   )
   class65 method1259(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1260.method3775(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1254(this.field1257, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1245();
            this.field1260.method3776(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1273.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass65;",
      garbageValue = "0"
   )
   class65 method1260(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1260.method3775(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1259.method3775(var5);
         if(var8 == null) {
            var8 = class73.method1545(this.field1258, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1259.method3776(var8, var5);
         }

         var7 = var8.method1560(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1260.method3776(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "8"
   )
   public class65 method1261(int var1, int[] var2) {
      if(this.field1257.method3327() == 1) {
         return this.method1259(0, var1, var2);
      } else if(this.field1257.method3260(var1) == 1) {
         return this.method1259(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-1107529844"
   )
   public class65 method1262(int var1, int[] var2) {
      if(this.field1258.method3327() == 1) {
         return this.method1260(0, var1, var2);
      } else if(this.field1258.method3260(var1) == 1) {
         return this.method1260(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1690091355"
   )
   static final void method1264(String var0) {
      if(Frames.clanMembers != null) {
         Client.field300.method2748(24);
         Client.field300.method2467(class113.method2395(var0));
         Client.field300.method2472(var0);
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1257 = var1;
      this.field1258 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "834935803"
   )
   static void method1272() {
      for(class24 var0 = (class24)class24.field590.method3808(); null != var0; var0 = (class24)class24.field590.method3810()) {
         if(var0.field604 != null) {
            var0.method584();
         }
      }

   }
}
