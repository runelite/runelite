import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("ry")
   static IndexFile field861;
   @ObfuscatedName("rb")
   static MachineInfo field866;
   @ObfuscatedName("ab")
   static int[] field864;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -726961477
   )
   static int field860;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   static void method1136(int var0) {
      if(var0 != -1) {
         if(class66.loadWidget(var0)) {
            Widget[] var1 = class46.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2735 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field857 = var3.field2735;
                  class31.method267(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass276;",
      garbageValue = "1025433868"
   )
   public static class276 method1137(int var0) {
      class276[] var1 = new class276[]{class276.field3739, class276.field3737, class276.field3740};
      class276[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class276 var4 = var2[var3];
         if(var0 == var4.field3738) {
            return var4;
         }
      }

      return null;
   }
}
