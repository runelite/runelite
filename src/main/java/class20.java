import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class20 implements class112 {
   @ObfuscatedName("pt")
   static class160 field579;
   @ObfuscatedName("w")
   static final class20 field580 = new class20(1);
   @ObfuscatedName("d")
   static final class20 field581 = new class20(2);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1382970397
   )
   final int field583;
   @ObfuscatedName("c")
   static final class20 field585 = new class20(3);
   @ObfuscatedName("a")
   static final class20 field587 = new class20(0);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1405875737"
   )
   public int vmethod3266() {
      return this.field583;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field583 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1017984442"
   )
   static final int method638(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(-1 == var0) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZIZI)I",
      garbageValue = "-2018140493"
   )
   static int method639(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class8.method154(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class8.method154(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method640(int var0, boolean var1) {
      return var0 < 0?Integer.toString(var0):class142.method3093(var0, 10, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass173;",
      garbageValue = "109"
   )
   public static class173 method641(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class173.field2886[var1] == null || null == class173.field2886[var1][var2]) {
         boolean var3 = class9.method161(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2886[var1][var2];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass167;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "2"
   )
   public static void method642(int var0, class167 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3377(var2);
      int var7 = var1.method3378(var6, var3);
      class176.method3536(var0, var1, var6, var7, var4, var5);
   }
}
