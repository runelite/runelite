import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class278 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3551;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3548;
   @ObfuscatedName("i")
   char field3549;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -40850781
   )
   public int field3550;
   @ObfuscatedName("l")
   public String field3547;
   @ObfuscatedName("b")
   boolean field3552;

   static {
      field3548 = new NodeCache(64);
   }

   class278() {
      this.field3552 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2146415150"
   )
   void method4885() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "1"
   )
   void method4904(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4888(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "1736913398"
   )
   void method4888(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3549 = Huffman.method3458(var1.readByte());
      } else if(var2 == 2) {
         this.field3550 = var1.readInt();
      } else if(var2 == 4) {
         this.field3552 = false;
      } else if(var2 == 5) {
         this.field3547 = var1.readString();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-60"
   )
   public boolean method4889() {
      return this.field3549 == 's';
   }
}
