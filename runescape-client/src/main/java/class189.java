import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class189 extends CacheableNode {
   @ObfuscatedName("x")
   static NodeCache field2760 = new NodeCache(64);
   @ObfuscatedName("i")
   public boolean field2761 = false;
   @ObfuscatedName("u")
   public static class182 field2764;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-93"
   )
   void method3437(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3439(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1885163256"
   )
   void method3439(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2761 = true;
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "510135746"
   )
   static void method3445(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            class2.method17(var6, var2, var3, var4);
            class1.method14(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class6.method97(var0, var6, var4);
            }
         }
      }

   }
}
