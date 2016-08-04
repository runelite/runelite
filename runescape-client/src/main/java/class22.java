import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class22 implements Comparator {
   @ObfuscatedName("m")
   static class83 field596;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("av")
   static class146 field601;

   public int compare(Object var1, Object var2) {
      return this.method593((class217)var1, (class217)var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass44;",
      garbageValue = "-93"
   )
   @Export("getAnimation")
   public static class44 method585(int var0) {
      class44 var1 = (class44)class44.field1014.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1013.method3411(12, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method908(new class122(var2));
         }

         var1.method910();
         class44.field1014.method3907(var1, (long)var0);
         return var1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1813958165"
   )
   int method593(class217 var1, class217 var2) {
      if(var1.field3208 == var2.field3208) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field407 == var1.field3208) {
               return -1;
            }

            if(client.field407 == var2.field3208) {
               return 1;
            }
         }

         return var1.field3208 < var2.field3208?-1:1;
      }
   }

   @ObfuscatedName("l")
   public static final void method594(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class124.method2887(var0 - 1L);
            class124.method2887(1L);
         } else {
            class124.method2887(var0);
         }

      }
   }
}
