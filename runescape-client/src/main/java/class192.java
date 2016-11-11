import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class192 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "-217485694"
   )
   public static class50 method3770(int var0) {
      class50 var1 = (class50)class50.field1098.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class50.field1096.method3292(14, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1022(new Buffer(var2));
         }

         class50.field1098.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-916140650"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field1015.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field1010.method3292(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method930(new Buffer(var2));
         }

         var1.method899();
         Sequence.field1015.put(var1, (long)var0);
         return var1;
      }
   }
}
