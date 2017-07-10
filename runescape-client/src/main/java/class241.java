import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class241 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 971956589
   )
   public static int field3289;
   @ObfuscatedName("a")
   public static NodeCache field3290;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2137069147
   )
   public int field3291;
   @ObfuscatedName("i")
   public static IndexDataBase field3292;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-52"
   )
   public void method4281(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4285(var1, var2);
      }
   }

   public class241() {
      this.field3291 = 0;
   }

   static {
      field3290 = new NodeCache(64);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1931581430"
   )
   void method4285(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field3291 = var1.readUnsignedShort();
      }

   }
}
