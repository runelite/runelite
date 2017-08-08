import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class253 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3388;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3387;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   IterableHashTable field3390;

   static {
      field3388 = new NodeCache(64);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "2"
   )
   void method4481(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3390 = XItemContainer.method1083(var1, this.field3390);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1045623950"
   )
   public int method4467(int var1, int var2) {
      return class34.method494(this.field3390, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1819271755"
   )
   public String method4474(int var1, String var2) {
      return class169.method3148(this.field3390, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1129328309"
   )
   public void method4464() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-1408225349"
   )
   public void method4465(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4481(var1, var2);
      }
   }
}
