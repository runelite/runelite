import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class168 implements class165 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   public static final class168 field2407;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   static final class168 field2405;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   public static final class168 field2406;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   public static final class168 field2404;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lfj;"
   )
   static final class168[] field2409;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1321054409
   )
   public final int field2408;

   static {
      field2407 = new class168(14, 0);
      field2405 = new class168(15, 4);
      field2406 = new class168(16, -2);
      field2404 = new class168(18, -2);
      field2409 = new class168[32];
      class168[] var0 = new class168[]{field2407, field2404, field2406, field2405};
      class168[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2409[var1[var2].field2408] = var1[var2];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class168(int var1, int var2) {
      this.field2408 = var1;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Lhk;B)Z",
      garbageValue = "-94"
   )
   static final boolean method3183(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class12.method73(var0, var1);
            int var3 = var0.field2716[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
