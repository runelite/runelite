import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class111 implements Runnable {
   @ObfuscatedName("i")
   volatile class109[] field1651;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-2049136634"
   )
   public static void method2113(IndexDataBase var0) {
      class244.field3308 = var0;
   }

   class111() {
      this.field1651 = new class109[2];
   }

   @ObfuscatedName("i")
   public static String method2116(long var0) {
      class182.field2437.setTime(new Date(var0));
      int var2 = class182.field2437.get(7);
      int var3 = class182.field2437.get(5);
      int var4 = class182.field2437.get(2);
      int var5 = class182.field2437.get(1);
      int var6 = class182.field2437.get(11);
      int var7 = class182.field2437.get(12);
      int var8 = class182.field2437.get(13);
      return class182.field2438[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class182.field2436[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class109 var2 = this.field1651[var1];
            if(var2 != null) {
               var2.method2046();
            }
         }
      } catch (Exception var4) {
         class232.method4169((String)null, var4);
      }

   }
}
