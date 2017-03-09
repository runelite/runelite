import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("av")
   static class110 field909;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2079758699
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1570569195
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      return class154.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-728411423"
   )
   static final String[] method875(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "36"
   )
   public static boolean method880() {
      try {
         if(class138.field1920 == 2) {
            if(null == class179.field2679) {
               class179.field2679 = class144.method2751(class138.field1916, class138.field1922, class8.field86);
               if(class179.field2679 == null) {
                  return false;
               }
            }

            if(class30.field721 == null) {
               class30.field721 = new class60(class138.field1918, class138.field1917);
            }

            if(class138.field1919.method2604(class179.field2679, class138.field1924, class30.field721, 22050)) {
               class138.field1919.method2533();
               class138.field1919.method2566(Ignore.field245);
               class138.field1919.method2550(class179.field2679, class138.field1923);
               class138.field1920 = 0;
               class179.field2679 = null;
               class30.field721 = null;
               class138.field1916 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class138.field1919.method2536();
         class138.field1920 = 0;
         class179.field2679 = null;
         class30.field721 = null;
         class138.field1916 = null;
      }

      return false;
   }
}
