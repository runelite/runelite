import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class79 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1824812903
   )
   static int field1418;
   @ObfuscatedName("y")
   static int[] field1419;
   @ObfuscatedName("g")
   static int[] field1420;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -188782023
   )
   static int field1422;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-20"
   )
   static final int method1656(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.tileHeights[var5][var3][var4] * (128 - var6) + class5.tileHeights[var5][1 + var3][var4] * var6 >> 7;
         int var9 = class5.tileHeights[var5][var3][1 + var4] * (128 - var6) + class5.tileHeights[var5][1 + var3][var4 + 1] * var6 >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2093018403"
   )
   static boolean method1679(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "21939213"
   )
   static void method1680(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class138.field2126; ++var4) {
         ItemComposition var5 = class174.getItemDefinition(var4);
         if((!var1 || var5.field1188) && var5.field1181 == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class1.field19 = -1;
               class14.field197 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class14.field197 = var2;
      XItemContainer.field203 = 0;
      class1.field19 = var3;
      String[] var9 = new String[class1.field19];

      for(int var8 = 0; var8 < class1.field19; ++var8) {
         var9[var8] = class174.getItemDefinition(var2[var8]).name;
      }

      short[] var10 = class14.field197;
      class12.method163(var9, var10, 0, var9.length - 1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "-19957"
   )
   static void method1681(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }
}
