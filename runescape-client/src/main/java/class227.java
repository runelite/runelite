import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class227 {
   @ObfuscatedName("d")
   @Export("spritePixels")
   public static byte[][] spritePixels;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2056707241
   )
   static int field3145;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgk;IIB)I",
      garbageValue = "-43"
   )
   static int method4159(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;S)V",
      garbageValue = "256"
   )
   public static void method4158(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3367 = var0;
      CombatInfo2.field3369 = var1;
   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "-29"
   )
   static void method4160(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class33.field483; ++var4) {
         ItemComposition var5 = FaceNormal.getItemDefinition(var4);
         if((!var1 || var5.field3526) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class169.field2340 = -1;
               class3.field31 = null;
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

      class3.field31 = var2;
      class14.field300 = 0;
      class169.field2340 = var3;
      String[] var8 = new String[class169.field2340];

      for(int var9 = 0; var9 < class169.field2340; ++var9) {
         var8[var9] = FaceNormal.getItemDefinition(var2[var9]).name;
      }

      class8.method39(var8, class3.field31);
   }
}
