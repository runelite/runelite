import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -727419127
   )
   int field2053;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1159242553
   )
   int field2054;
   @ObfuscatedName("i")
   int[] field2055;
   @ObfuscatedName("j")
   int[][] field2057;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "424070309"
   )
   public static String method2672(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class10.method68(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "776017608"
   )
   public static int method2673(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   FrameMap(int var1, byte[] var2) {
      this.field2053 = var1;
      Buffer var3 = new Buffer(var2);
      this.field2054 = var3.readUnsignedByte();
      this.field2055 = new int[this.field2054];
      this.field2057 = new int[this.field2054][];

      int var4;
      for(var4 = 0; var4 < this.field2054; ++var4) {
         this.field2055[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field2054; ++var4) {
         this.field2057[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field2054; ++var4) {
         for(int var5 = 0; var5 < this.field2057[var4].length; ++var5) {
            this.field2057[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
