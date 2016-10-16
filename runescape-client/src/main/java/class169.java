import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class169 {
   @ObfuscatedName("ed")
   static SpritePixels field2716;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass215;S)I",
      garbageValue = "28976"
   )
   static final int method3241(class215 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3193) {
         case 5:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-117"
   )
   static final int method3246(int var0, int var1) {
      int var2 = class38.method765(var0 - 1, var1 - 1) + class38.method765(1 + var0, var1 - 1) + class38.method765(var0 - 1, var1 + 1) + class38.method765(var0 + 1, 1 + var1);
      int var3 = class38.method765(var0 - 1, var1) + class38.method765(var0 + 1, var1) + class38.method765(var0, var1 - 1) + class38.method765(var0, 1 + var1);
      int var4 = class38.method765(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-103766526"
   )
   static final boolean method3247(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label85:
      while(true) {
         int var6 = var4.method2654();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2654();
               if(var9 == 0) {
                  continue label85;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2481() >> 2;
               int var13 = var1 + var11;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class40.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field271 || var15.field927 != 0 || var15.field914 == 1 || var15.field946) {
                     if(!var15.method812()) {
                        ++Client.field324;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2654();
            if(var9 == 0) {
               break;
            }

            var4.method2481();
         }
      }
   }
}
