import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class97 implements class158 {
   @ObfuscatedName("d")
   public static final class97 field1633 = new class97(2, 1);
   @ObfuscatedName("h")
   public static final class97 field1634 = new class97(0, 2);
   @ObfuscatedName("p")
   public static final class97 field1636 = new class97(3, 3);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 560380795
   )
   public final int field1637;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1533338261
   )
   final int field1639;
   @ObfuscatedName("q")
   public static final class97 field1641 = new class97(1, 0);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "555633042"
   )
   public int vmethod4101() {
      return this.field1639;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1993226806"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2819.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2825.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3498(new Buffer(var2));
         }

         KitDefinition.field2819.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1637 = var1;
      this.field1639 = var2;
   }
}
