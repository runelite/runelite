import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class271 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3485;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3482;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -828255141
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("i")
   public boolean field3484;

   static {
      field3482 = new NodeCache(64);
   }

   public class271() {
      this.field3484 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-380806387"
   )
   public void method4797(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4795(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-935218479"
   )
   void method4795(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3484 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   public static void method4800() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
