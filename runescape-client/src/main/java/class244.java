import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class244 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3316;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3319;
   @ObfuscatedName("e")
   public boolean field3317;

   static {
      field3316 = new NodeCache(64);
   }

   public class244() {
      this.field3317 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-2091067975"
   )
   void method4431(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3317 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-1904677155"
   )
   public void method4427(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4431(var1, var2);
      }
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lhj;I)I",
      garbageValue = "2022379037"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfc;I)V",
      garbageValue = "-248473500"
   )
   public static void method4432(Huffman var0) {
      class265.field3664 = var0;
   }
}
