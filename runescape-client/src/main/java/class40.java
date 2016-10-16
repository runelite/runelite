import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class40 extends class210 {
   @ObfuscatedName("z")
   String field863;
   @ObfuscatedName("t")
   short field865;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1018885611
   )
   int field866 = (int)(class113.method2394() / 1000L);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1495110468"
   )
   public static void method782(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.keyboard);
      var0.addFocusListener(class140.keyboard);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)LObjectComposition;",
      garbageValue = "24"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field910.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field921.method3272(6, var0);
         var1 = new ObjectComposition();
         var1.field940 = var0;
         if(var2 != null) {
            var1.method814(new Buffer(var2));
         }

         var1.method816();
         if(var1.field947) {
            var1.field914 = 0;
            var1.field951 = false;
         }

         ObjectComposition.field910.put(var1, (long)var0);
         return var1;
      }
   }

   class40(String var1, int var2) {
      this.field863 = var1;
      this.field865 = (short)var2;
   }
}
