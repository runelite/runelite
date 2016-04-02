import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class38 extends class207 {
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -145163117
   )
   protected static int field848;
   @ObfuscatedName("w")
   String field849;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -833754531
   )
   static int field853;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -194942551
   )
   protected static int field854;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1036192057
   )
   int field855 = (int)(class140.method2967() / 1000L);
   @ObfuscatedName("f")
   short field858;

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1458673269"
   )
   static void method754(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1126; ++var4) {
         class51 var5 = class33.method711(var4);
         if((!var1 || var5.field1104) && -1 == var5.field1122 && var5.field1091.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class16.field229 = -1;
               class121.field1994 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class121.field1994 = var2;
      field853 = 0;
      class16.field229 = var3;
      String[] var8 = new String[class16.field229];

      for(int var9 = 0; var9 < class16.field229; ++var9) {
         var8[var9] = class33.method711(var2[var9]).field1091;
      }

      short[] var10 = class121.field1994;
      class14.method170(var8, var10, 0, var8.length - 1);
   }

   @ObfuscatedName("w")
   static void method755(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class25.field619[var5] != var0) {
            var2[var4] = class25.field619[var5];
            var3[var4] = class25.field618[var5];
            ++var4;
         }
      }

      class25.field619 = var2;
      class25.field618 = var3;
      class27.method647(class25.field615, 0, class25.field615.length - 1, class25.field619, class25.field618);
   }

   class38(String var1, int var2) {
      this.field849 = var1;
      this.field858 = (short)var2;
   }
}
