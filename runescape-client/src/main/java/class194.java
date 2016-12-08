import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class194 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 659049889
   )
   public int field2846;
   @ObfuscatedName("m")
   public static NodeCache field2847 = new NodeCache(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -460208191
   )
   public int field2849;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1442727279
   )
   public int field2850;
   @ObfuscatedName("o")
   public static class182 field2851;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-26"
   )
   public void method3452(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3453(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "15046"
   )
   void method3453(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2850 = var1.readUnsignedShort();
         this.field2849 = var1.readUnsignedByte();
         this.field2846 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "59"
   )
   static String method3456() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field945.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "1225037476"
   )
   static ModIcon[] method3462() {
      ModIcon[] var0 = new ModIcon[class225.field3218];

      for(int var1 = 0; var1 < class225.field3218; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class204.field3077;
         var2.originalHeight = class225.field3216;
         var2.offsetX = class211.field3125[var1];
         var2.offsetY = class225.field3217[var1];
         var2.originalWidth = FaceNormal.field1557[var1];
         var2.height = FileOnDisk.field1199[var1];
         var2.palette = class225.field3215;
         var2.pixels = XGrandExchangeOffer.field36[var1];
      }

      class176.method3182();
      return var0;
   }
}
