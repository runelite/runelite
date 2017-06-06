import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
public class class111 implements Runnable {
   @ObfuscatedName("i")
   volatile class109[] field1675;
   @ObfuscatedName("b")
   static Thread field1676;

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class109 var2 = this.field1675[var1];
            if(var2 != null) {
               var2.method2012();
            }
         }
      } catch (Exception var4) {
         class21.method138((String)null, var4);
      }

   }

   class111() {
      this.field1675 = new class109[2];
   }
}
