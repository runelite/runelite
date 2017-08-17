import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class245 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3306;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3307;
   @ObfuscatedName("f")
   public boolean field3308;

   static {
      field3306 = new NodeCache(64);
   }

   public class245() {
      this.field3308 = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-1319619141"
   )
   void method4354(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3308 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1442975388"
   )
   public void method4357(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4354(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;ZLjh;B)V",
      garbageValue = "-19"
   )
   public static void method4360(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      class18.item_ref = var0;
      class3.field19 = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field3520 = class18.item_ref.fileCount(10);
      ISAACCipher.field2433 = var3;
   }
}
