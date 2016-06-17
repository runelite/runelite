import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class157 {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      longValue = 8613657831162160565L
   )
   static long field2576;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;Lclass167;I)V",
      garbageValue = "66036080"
   )
   public static void method3179(class167 var0, class167 var1, class167 var2, class167 var3) {
      class173.field2739 = var0;
      class229.field3232 = var1;
      class173.field2828 = var2;
      class173.field2774 = var3;
      class173.field2750 = new class173[class173.field2739.method3277()][];
      class173.field2788 = new boolean[class173.field2739.method3277()];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-780618792"
   )
   static final void method3180() {
      if(client.field399 > 0) {
         class158.method3182();
      } else {
         class43.method919(40);
         class89.field1530 = class13.field195;
         class13.field195 = null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lclass112;II)Lclass112;",
      garbageValue = "1167961702"
   )
   public static class112 method3181(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3185()) {
            return var4;
         }
      }

      return null;
   }
}
