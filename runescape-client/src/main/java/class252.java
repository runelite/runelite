import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class252 extends CacheableNode {
   @ObfuscatedName("i")
   public static IndexDataBase field3391;
   @ObfuscatedName("c")
   public static NodeCache field3392;
   @ObfuscatedName("e")
   class186 field3393;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "14"
   )
   public void method4460(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4461(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "460557905"
   )
   void method4461(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3393 = class116.method2101(var1, this.field3393);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-40"
   )
   public int method4462(int var1, int var2) {
      return World.method1583(this.field3393, var1, var2);
   }

   static {
      field3392 = new NodeCache(64);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "781387308"
   )
   public String method4468(int var1, String var2) {
      return class35.method480(this.field3393, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2038929526"
   )
   public void method4469() {
   }
}
