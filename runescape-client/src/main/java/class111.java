import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
public class class111 implements Runnable {
   @ObfuscatedName("p")
   volatile class109[] field1659;

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class109 var2 = this.field1659[var1];
            if(var2 != null) {
               var2.method1912();
            }
         }
      } catch (Exception var4) {
         class8.method43((String)null, var4);
      }

   }

   class111() {
      this.field1659 = new class109[2];
   }
}
