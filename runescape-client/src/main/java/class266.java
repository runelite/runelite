import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public class class266 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static Buffer field3650;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lhg;",
      garbageValue = "1521319593"
   )
   public static Widget method4862(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Item.widgets[var1] == null || Item.widgets[var1][var2] == null) {
         boolean var3 = class10.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Item.widgets[var1][var2];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-101"
   )
   static int method4861(int var0, int var1) {
      Overlay var2 = class226.method4083(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = class14.method70(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         int var8 = class14.method70(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1160896544"
   )
   public static String method4863(String var0) {
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
}
