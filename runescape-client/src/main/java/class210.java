import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class210 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 459041411
   )
   public final int field2601;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1664306749
   )
   public final int field2602;
   @ObfuscatedName("v")
   public final int[] field2603;
   @ObfuscatedName("e")
   public final int[] field2605;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2602 = var1;
      this.field2601 = var2;
      this.field2605 = var3;
      this.field2603 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "558570032"
   )
   public boolean method3902(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2603.length) {
         int var3 = this.field2603[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2605[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(LWidget;S)I",
      garbageValue = "-13589"
   )
   static int method3903(Widget var0) {
      class198 var1 = (class198)Client.widgetFlags.method3520((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field2494:var0.field2723;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "472275897"
   )
   public static void method3905(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.field3602 = var0;
      Sequence.field3600 = var1;
      Sequence.field3610 = var2;
   }
}
