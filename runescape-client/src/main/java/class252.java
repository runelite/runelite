import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class252 extends CacheableNode {
   @ObfuscatedName("v")
   static int[] field3387;
   @ObfuscatedName("h")
   public static NodeCache field3388;
   @ObfuscatedName("u")
   class186 field3390;
   @ObfuscatedName("i")
   static IndexDataBase field3391;

   static {
      field3388 = new NodeCache(64);
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1149678379"
   )
   static final void method4506(int var0) {
      if(class14.method75(var0)) {
         RSCanvas.method783(class90.widgets[var0], -1);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-26"
   )
   void method4507(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4508(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "120"
   )
   void method4508(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3390 = Frames.method2913(var1, this.field3390);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-703490975"
   )
   public int method4509(int var1, int var2) {
      return class169.method3168(this.field3390, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   void method4517() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-164131117"
   )
   public String method4525(int var1, String var2) {
      return KitDefinition.method4451(this.field3390, var1, var2);
   }
}
