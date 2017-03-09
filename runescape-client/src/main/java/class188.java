import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("gt")
public class class188 extends CacheableNode {
   @ObfuscatedName("c")
   public boolean field2774 = false;
   @ObfuscatedName("x")
   public static class182 field2775;
   @ObfuscatedName("bd")
   static class184 field2778;
   @ObfuscatedName("j")
   public static NodeCache field2779 = new NodeCache(64);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1589811899"
   )
   public void method3459(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3463(var1, var2);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "236383623"
   )
   static void method3460() {
      int var0 = class108.field1748;
      int var1 = class145.field2018;
      if(class16.field208 < var0) {
         var0 = class16.field208;
      }

      if(class178.field2668 < var1) {
         var1 = class178.field2668;
      }

      if(null != class8.field84) {
         try {
            Client var2 = Client.field308;
            Object[] var3 = new Object[]{Integer.valueOf(class13.method196())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1969165552"
   )
   void method3463(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2774 = true;
      }

   }
}
