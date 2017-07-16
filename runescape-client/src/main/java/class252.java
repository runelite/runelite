import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class252 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3394;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1415133257
   )
   static int field3393;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   class186 field3392;

   static {
      field3394 = new NodeCache(64);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-1242190111"
   )
   void method4398(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3392 = World.method1549(var1, this.field3392);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "61"
   )
   public int method4399(int var1, int var2) {
      return Timer.method2973(this.field3392, var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "14"
   )
   public String method4414(int var1, String var2) {
      return IndexFile.method3005(this.field3392, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-77"
   )
   public void method4420() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-606058381"
   )
   public void method4397(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4398(var1, var2);
      }
   }
}
