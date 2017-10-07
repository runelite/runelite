import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1797069395
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 368331799
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1278590781
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 714644041
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -920204661
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1603183835
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1853959003
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1734027379
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 66951815
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1772330859"
   )
   public static byte[] method2965() {
      byte[] var0 = new byte[24];

      try {
         class155.field2258.seek(0L);
         class155.field2258.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1906184680"
   )
   public static String method2967(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
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

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;S)[Ljava/lang/String;",
      garbageValue = "-18869"
   )
   static final String[] method2966(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
