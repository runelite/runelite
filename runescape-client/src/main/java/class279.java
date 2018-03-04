import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class279 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static IndexDataBase field3550;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3548;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   IterableHashTable field3549;

   static {
      field3548 = new NodeCache(64);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-665187011"
   )
   void method5046() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1208932295"
   )
   void method5047(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5048(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "746317232"
   )
   void method5048(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3549 = class167.readStringIntParameters(var1, this.field3549);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-114"
   )
   public int method5055(int var1, int var2) {
      return class47.method699(this.field3549, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1920999928"
   )
   public String method5050(int var1, String var2) {
      return Huffman.method3512(this.field3549, var1, var2);
   }
}
