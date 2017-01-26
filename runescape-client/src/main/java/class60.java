import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class60 {
   @ObfuscatedName("j")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("g")
   class182 field1080;
   @ObfuscatedName("p")
   class182 field1081;
   @ObfuscatedName("q")
   XHashTable field1082 = new XHashTable(256);
   @ObfuscatedName("i")
   static String[] field1084;
   @ObfuscatedName("bf")
   protected static FontMetrics field1085;
   @ObfuscatedName("x")
   XHashTable field1087 = new XHashTable(256);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "-15"
   )
   public class55 method1107(int var1, int[] var2) {
      if(this.field1080.method3282() == 1) {
         return this.method1108(0, var1, var2);
      } else if(this.field1080.method3309(var1) == 1) {
         return this.method1108(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-200662082"
   )
   class55 method1108(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1082.method2374(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1087.method2374(var5);
         if(null == var8) {
            var8 = class54.method983(this.field1080, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1087.method2364(var8, var5);
         }

         var7 = var8.method973(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1082.method2364(var7, var5);
            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1081 = var1;
      this.field1080 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "99999999"
   )
   class55 method1112(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1082.method2374(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method957(this.field1081, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method955();
            this.field1082.method2364(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1024.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1282807151"
   )
   public class55 method1120(int var1, int[] var2) {
      if(this.field1081.method3282() == 1) {
         return this.method1112(0, var1, var2);
      } else if(this.field1081.method3309(var1) == 1) {
         return this.method1112(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "598906493"
   )
   static final void method1121(Actor var0, int var1) {
      class162.method3081(var0.x, var0.y, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lclass112;",
      garbageValue = "-36"
   )
   public static class112 method1122() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }
}
