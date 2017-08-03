import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class252 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3373;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3374;

   static {
      field3373 = new NodeCache(64);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-1936731398"
   )
   void method4438(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3374 = FrameMap.method2698(var1, this.field3374);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "893826647"
   )
   public String method4433(int var1, String var2) {
      return class33.method356(this.field3374, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-505471085"
   )
   public int method4428(int var1, int var2) {
      return class56.method835(this.field3374, var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-460283898"
   )
   public void method4424() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-2037558499"
   )
   public void method4425(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4438(var1, var2);
      }
   }
}
