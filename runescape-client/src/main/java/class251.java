import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class251 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3385;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1058038549
   )
   static int field3390;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3386;
   @ObfuscatedName("n")
   char field3391;
   @ObfuscatedName("e")
   boolean field3389;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1482762385
   )
   public int field3387;
   @ObfuscatedName("v")
   public String field3384;

   static {
      field3385 = new NodeCache(64);
   }

   class251() {
      this.field3389 = true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfe;IB)V",
      garbageValue = "3"
   )
   void method4388(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3391 = class262.method4659(var1.readByte());
      } else if(var2 == 2) {
         this.field3387 = var1.readInt();
      } else if(var2 == 4) {
         this.field3389 = false;
      } else if(var2 == 5) {
         this.field3384 = var1.readString();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2084270026"
   )
   public boolean method4382() {
      return this.field3391 == 115;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1231284179"
   )
   void method4379() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1015913555"
   )
   void method4380(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4388(var1, var2);
      }
   }
}
