import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class111 implements Runnable {
   @ObfuscatedName("n")
   volatile class109[] field1666;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)I",
      garbageValue = "561777426"
   )
   public static int method2072(int var0, class219 var1) {
      return (var0 << 8) + var1.field2799;
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class109 var2 = this.field1666[var1];
            if(var2 != null) {
               var2.method2009();
            }
         }
      } catch (Exception var4) {
         Projectile.method1734((String)null, var4);
      }

   }

   class111() {
      this.field1666 = new class109[2];
   }
}
