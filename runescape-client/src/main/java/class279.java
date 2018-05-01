import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class279 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3554;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static NodeCache field3553;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   IterableHashTable field3552;

   static {
      field3553 = new NodeCache(64);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1566824344"
   )
   void method5007() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "-1640531527"
   )
   void method5020(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5008(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-385960396"
   )
   void method5008(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3552 = class160.readStringIntParameters(var1, this.field3552);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2031177499"
   )
   public int method5011(int var1, int var2) {
      return NetWriter.method2162(this.field3552, var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "89197415"
   )
   public String method5010(int var1, String var2) {
      return class169.method3365(this.field3552, var1, var2);
   }
}
