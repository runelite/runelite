import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class251 extends CacheableNode {
   @ObfuscatedName("m")
   public static NodeCache field3394;
   @ObfuscatedName("p")
   public static IndexDataBase field3395;
   @ObfuscatedName("z")
   boolean field3396;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -79095343
   )
   public int field3397;
   @ObfuscatedName("w")
   public String field3398;
   @ObfuscatedName("e")
   char field3399;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-645008832"
   )
   public boolean method4300() {
      return this.field3399 == 115;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "244516128"
   )
   void method4301(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4302(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "102"
   )
   void method4302(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3399 = class204.method3645(var1.readByte());
      } else if(var2 == 2) {
         this.field3397 = var1.readInt();
      } else if(var2 == 4) {
         this.field3396 = false;
      } else if(var2 == 5) {
         this.field3398 = var1.readString();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-82797810"
   )
   void method4308() {
   }

   class251() {
      this.field3396 = true;
   }

   static {
      field3394 = new NodeCache(64);
   }
}
