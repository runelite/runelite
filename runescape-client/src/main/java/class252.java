import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
public class class252 extends CacheableNode {
   @ObfuscatedName("n")
   public static IndexDataBase field3401;
   @ObfuscatedName("i")
   class186 field3402;
   @ObfuscatedName("p")
   public static NodeCache field3403;

   static {
      field3403 = new NodeCache(64);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "290978638"
   )
   public void method4473() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "594015992"
   )
   public void method4474(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4475(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-38"
   )
   void method4475(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3402 = ChatMessages.method1795(var1, this.field3402);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1897899550"
   )
   public int method4482(int var1, int var2) {
      return class243.method4341(this.field3402, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "125"
   )
   public String method4486(int var1, String var2) {
      return class204.method3838(this.field3402, var1, var2);
   }
}
