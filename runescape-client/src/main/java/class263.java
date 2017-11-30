import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class263 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3471;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3472;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   IterableHashTable field3473;

   static {
      field3472 = new NodeCache(64);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-228330703"
   )
   public void method4591() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1485479522"
   )
   public void method4599(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4593(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-1992208378"
   )
   void method4593(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3473 = ItemContainer.readStringIntParameters(var1, this.field3473);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1907336580"
   )
   public int method4594(int var1, int var2) {
      return GraphicsObject.method1615(this.field3473, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-187762377"
   )
   public String method4590(int var1, String var2) {
      return class192.method3599(this.field3473, var1, var2);
   }
}
