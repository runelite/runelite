import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class222 {
   @ObfuscatedName("s")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("g")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("m")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -636739319
   )
   static int field2709;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "2139940145"
   )
   static long method4356(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
