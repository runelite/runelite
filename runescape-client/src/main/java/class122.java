import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class122 extends class119 {
   @ObfuscatedName("d")
   class123 field2022;
   @ObfuscatedName("l")
   static final int[] field2023 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2026295157
   )
   int field2024;
   @ObfuscatedName("bh")
   static class168 field2028;

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-937450932"
   )
   public void method2709(int[] var1) {
      this.field2022 = new class123(var1);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2067875870"
   )
   public int method2713(int var1) {
      int var2 = this.field2024 >> 3;
      int var3 = 8 - (this.field2024 & 7);
      int var4 = 0;

      for(this.field2024 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2001[var2++] & field2023[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field2001[var2] & field2023[var3];
      } else {
         var4 += super.field2001[var2] >> var3 - var1 & field2023[var1];
      }

      return var4;
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-126"
   )
   public void method2714() {
      super.field2000 = (this.field2024 + 7) / 8;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1852825903"
   )
   public int method2715(int var1) {
      return var1 * 8 - this.field2024;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;I)V",
      garbageValue = "-516453963"
   )
   public static void method2718(class136 var0, Object var1) {
      if(null != var0.field2117) {
         for(int var2 = 0; var2 < 50 && var0.field2117.peekEvent() != null; ++var2) {
            class45.method926(1L);
         }

         if(null != var1) {
            var0.field2117.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1566317697"
   )
   public void method2726() {
      this.field2024 = super.field2000 * 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1110894757"
   )
   public int method2728() {
      return super.field2001[++super.field2000 - 1] - this.field2022.method2735() & 255;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1345745098"
   )
   public static void method2732(class119 var0, int var1) {
      if(class149.field2269 != null) {
         try {
            class149.field2269.method4096(0L);
            class149.field2269.method4113(var0.field2001, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "159"
   )
   public void method2733(int var1) {
      super.field2001[++super.field2000 - 1] = (byte)(var1 + this.field2022.method2735());
   }
}
