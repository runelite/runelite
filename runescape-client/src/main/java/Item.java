import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("cp")
   static boolean field1399;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -196392353
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -205096159
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   protected final Model getModel() {
      return class250.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1935416466"
   )
   public static int method1849(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = class12.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class218.field2689[var5 - var4];
      return class218.widgetSettings[var3] >> var4 & var6;
   }
}
