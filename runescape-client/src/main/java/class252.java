import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class252 extends CacheableNode {
   @ObfuscatedName("w")
   public static NodeCache field3402;
   @ObfuscatedName("a")
   class186 field3404;
   @ObfuscatedName("i")
   public static IndexDataBase field3406;
   @ObfuscatedName("z")
   static Font field3407;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1093300583"
   )
   public int method4457(int var1, int var2) {
      return ChatLineBuffer.method1884(this.field3404, var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "471920943"
   )
   public void method4458() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   public void method4459(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4460(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1104737414"
   )
   void method4460(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3404 = XClanMember.method1181(var1, this.field3404);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-520118081"
   )
   public String method4462(int var1, String var2) {
      return class92.method1733(this.field3404, var1, var2);
   }

   static {
      field3402 = new NodeCache(64);
   }
}
