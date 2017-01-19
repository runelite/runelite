import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class181 extends CacheableNode {
   @ObfuscatedName("s")
   class184 field2706;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1140797941
   )
   int field2707;
   @ObfuscatedName("f")
   byte field2708;
   @ObfuscatedName("h")
   public static int[] field2710;

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "404784203"
   )
   static void method3178(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field2962; ++var4) {
         ItemComposition var5 = NPC.getItemDefinition(var4);
         if((!var1 || var5.field2998) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class168.field2197 = -1;
               class22.field249 = null;
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

      class22.field249 = var2;
      ChatMessages.field918 = 0;
      class168.field2197 = var3;
      String[] var9 = new String[class168.field2197];

      for(int var8 = 0; var8 < class168.field2197; ++var8) {
         var9[var8] = NPC.getItemDefinition(var2[var8]).name;
      }

      short[] var10 = class22.field249;
      class22.method191(var9, var10, 0, var9.length - 1);
   }
}
