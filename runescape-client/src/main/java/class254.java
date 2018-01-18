import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class254 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field3408;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   static NodeCache field3405;
   @ObfuscatedName("s")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("e")
   public static byte[][][] field3404;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("y")
   public boolean field3406;

   static {
      field3405 = new NodeCache(64);
   }

   class254() {
      this.field3406 = false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-1094285084"
   )
   void method4511(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4509(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-495503792"
   )
   void method4509(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3406 = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1218641842"
   )
   static final boolean method4507(int var0, int var1) {
      ObjectComposition var2 = NPC.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4708(var1);
   }
}
