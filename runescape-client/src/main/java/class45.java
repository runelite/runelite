import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class45 extends class204 {
   @ObfuscatedName("i")
   public static class193 field1042 = new class193(64);
   @ObfuscatedName("g")
   public boolean field1044 = false;
   @ObfuscatedName("d")
   static byte[][] field1045;
   @ObfuscatedName("t")
   public static class167 field1046;
   @ObfuscatedName("k")
   static boolean field1048;
   @ObfuscatedName("f")
   public static short[] field1049;
   @ObfuscatedName("bf")
   protected static FontMetrics field1050;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1513364407"
   )
   public void method922(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method923(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1794521720"
   )
   void method923(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1044 = true;
      }

   }

   @ObfuscatedName("t")
   public static final void method926(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class48.method970(var0 - 1L);
            class48.method970(1L);
         } else {
            class48.method970(var0);
         }

      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method929(int var0) {
      return client.field337[var0].length() > 0?client.field429[var0] + " " + client.field337[var0]:client.field429[var0];
   }
}
