import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class264 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3415;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3417;
   @ObfuscatedName("o")
   public boolean field3416;

   static {
      field3417 = new NodeCache(64);
   }

   public class264() {
      this.field3416 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "793300872"
   )
   public void method4776(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4777(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "333616645"
   )
   void method4777(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3416 = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-954339385"
   )
   public static boolean method4775(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
