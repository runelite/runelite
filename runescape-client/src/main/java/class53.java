import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class53 extends CacheableNode {
   @ObfuscatedName("a")
   public static class170 field1155;
   @ObfuscatedName("bh")
   static class171 field1156;
   @ObfuscatedName("v")
   public boolean field1157 = false;
   @ObfuscatedName("nk")
   static class77 field1160;
   @ObfuscatedName("d")
   public static NodeCache field1164 = new NodeCache(64);

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "823222654"
   )
   static void method1101(Widget var0) {
      if(Client.field484 == var0.field2948) {
         Client.field374[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "61"
   )
   void method1103(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1157 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-759196504"
   )
   public void method1104(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1103(var1, var2);
      }
   }
}
