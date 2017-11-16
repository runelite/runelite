import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class287 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1358539831
   )
   public int field3791;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 803531641
   )
   public int field3789;

   class287(int var1, int var2, int var3, int var4) {
      this.method4951(var1, var2);
      this.method4952(var3, var4);
   }

   public class287(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "52390628"
   )
   void method4951(int var1, int var2) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1530804961"
   )
   void method4952(int var1, int var2) {
      this.field3791 = var1;
      this.field3789 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;IIB)Ljn;",
      garbageValue = "-67"
   )
   public static Font method4954(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!Sequence.method4738(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, WidgetNode.field774, class285.offsetsY, class295.field3848, class295.field3845, class278.field3733, class70.spritePixels);
            class274.method4876();
            var4 = var6;
         }

         return var4;
      }
   }
}
