import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class32 {
   @ObfuscatedName("af")
   static SpritePixels[] field744;
   @ObfuscatedName("n")
   static int[][] field746 = new int[5][5000];
   @ObfuscatedName("r")
   static int[] scriptIntStack = new int[1000];
   @ObfuscatedName("i")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 19963481
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1726422745
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("s")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];
   @ObfuscatedName("j")
   static int[] field752 = new int[5];
   @ObfuscatedName("f")
   static final String[] field753 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1035856417
   )
   static int field754 = 0;
   @ObfuscatedName("p")
   static String[] field757;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 58838083
   )
   public static int field758;
   @ObfuscatedName("v")
   static Calendar field759 = Calendar.getInstance();

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2098051591"
   )
   public static String method775(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
