import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1816415247
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1543364837"
   )
   static void method1940(int var0, int var1) {
      class38 var2 = class65.field1115;
      class65.menuAction(var2.field822, var2.field831, var2.field823, var2.field830, var2.field825, var2.field825, var0, var1);
      class65.field1115 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   public static void method1947() {
      if(class103.field1678.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1730[186] = 57;
         class105.field1730[187] = 27;
         class105.field1730[188] = 71;
         class105.field1730[189] = 26;
         class105.field1730[190] = 72;
         class105.field1730[191] = 73;
         class105.field1730[192] = 58;
         class105.field1730[219] = 42;
         class105.field1730[220] = 74;
         class105.field1730[221] = 43;
         class105.field1730[222] = 59;
         class105.field1730[223] = 28;
      } else {
         class105.field1730[44] = 71;
         class105.field1730[45] = 26;
         class105.field1730[46] = 72;
         class105.field1730[47] = 73;
         class105.field1730[59] = 57;
         class105.field1730[61] = 27;
         class105.field1730[91] = 42;
         class105.field1730[92] = 74;
         class105.field1730[93] = 43;
         class105.field1730[192] = 28;
         class105.field1730[222] = 58;
         class105.field1730[520] = 59;
      }

   }

   @ObfuscatedName("cb")
   void vmethod1948(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1948(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass184;II)V",
      garbageValue = "1289003186"
   )
   static void method1949(class184 var0, int var1) {
      if(null != class216.field3182) {
         class216.field3182.offset = 5 + 8 * var1;
         int var2 = class216.field3182.readInt();
         int var3 = class216.field3182.readInt();
         var0.method3409(var2, var3);
      } else {
         class31.method704((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2755[var1] = var0;
      }
   }
}
