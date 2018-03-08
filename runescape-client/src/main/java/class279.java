import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class279 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static IndexDataBase field3557;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3555;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1622980393
   )
   static int field3554;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   IterableHashTable field3556;

   static {
      field3555 = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1901847816"
   )
   void method4913() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-778703665"
   )
   void method4914(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4906(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-259942776"
   )
   void method4906(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3556 = class2.readStringIntParameters(var1, this.field3556);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-564949288"
   )
   public int method4908(int var1, int var2) {
      return class297.method5284(this.field3556, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1891280640"
   )
   public String method4910(int var1, String var2) {
      IterableHashTable var4 = this.field3556;
      String var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         ObjectNode var5 = (ObjectNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = (String)var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljc;II)Llk;",
      garbageValue = "-1744035330"
   )
   public static IndexedSprite method4934(IndexDataBase var0, int var1) {
      if(!class80.method1799(var0, var1)) {
         return null;
      } else {
         IndexedSprite var3 = new IndexedSprite();
         var3.width = class332.field3995;
         var3.originalHeight = class332.field3996;
         var3.offsetX = class90.field1360[0];
         var3.offsetY = class153.offsetsY[0];
         var3.originalWidth = class332.field3998[0];
         var3.height = GrandExchangeOffer.field294[0];
         var3.palette = class332.field3994;
         var3.pixels = ClassInfo.spritePixels[0];
         class316.method5605();
         return var3;
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-591446213"
   )
   static boolean method4933() {
      return (Client.field968 & 2) != 0;
   }
}
