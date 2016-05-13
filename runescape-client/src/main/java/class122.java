import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public final class class122 extends class119 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1175337411
   )
   int field2022;
   @ObfuscatedName("c")
   static final int[] field2023 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("qu")
   @Export("canvas")
   public static Canvas field2024;
   @ObfuscatedName("k")
   class123 field2027;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "8"
   )
   public void method2736(int[] var1) {
      this.field2027 = new class123(var1);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "203"
   )
   public void method2737(int var1) {
      super.field2007[++super.field2005 - 1] = (byte)(var1 + this.field2027.method2764());
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "974814221"
   )
   public int method2738() {
      return super.field2007[++super.field2005 - 1] - this.field2027.method2764() & 255;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "379630077"
   )
   public void method2739() {
      this.field2022 = super.field2005 * 8;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1795249300"
   )
   public void method2740() {
      super.field2005 = (this.field2022 + 7) / 8;
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "597554062"
   )
   public int method2741(int var1) {
      return var1 * 8 - this.field2022;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1542303965"
   )
   public int method2750(int var1) {
      int var2 = this.field2022 >> 3;
      int var3 = 8 - (this.field2022 & 7);
      int var4 = 0;

      for(this.field2022 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2007[var2++] & field2023[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field2007[var2] & field2023[var3];
      } else {
         var4 += super.field2007[var2] >> var3 - var1 & field2023[var1];
      }

      return var4;
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method2758(String var0, boolean var1) {
      String var2 = "https://";
      if(client.field281 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field281 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field281 == 3) {
         var0 = var0 + "-wtwip";
      } else if(5 == client.field281) {
         var0 = var0 + "-wti";
      } else if(client.field281 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class10.field164) {
         var3 = "/p=" + class10.field164;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field285 + "/a=" + class15.field207 + var3 + "/";
   }
}
