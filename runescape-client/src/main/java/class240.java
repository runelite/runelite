import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class240 extends CacheableNode {
   @ObfuscatedName("i")
   public static IndexDataBase field3276;
   @ObfuscatedName("c")
   public static NodeCache field3277;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -949416431
   )
   public int field3279;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "66"
   )
   public void method4274(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4275(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1662391623"
   )
   void method4275(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3279 = var1.readUnsignedShort();
      }

   }

   public class240() {
      this.field3279 = 0;
   }

   static {
      field3277 = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-161388946"
   )
   public static void method4280(IndexDataBase var0, IndexDataBase var1) {
      class17.field309 = var0;
      KitDefinition.field3348 = var1;
      KitDefinition.field3350 = class17.field309.method4187(3);
   }
}
