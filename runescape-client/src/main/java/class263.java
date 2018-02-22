import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class263 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   static IndexDataBase field3412;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3411;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("o")
   public boolean field3413;

   static {
      field3411 = new NodeCache(64);
   }

   class263() {
      this.field3413 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-659414489"
   )
   void method4765(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4764(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "2090683340"
   )
   void method4764(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3413 = true;
      }

   }
}
