import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1281248939
   )
   int field1464;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -286881175
   )
   int field1465;
   @ObfuscatedName("q")
   int[][] field1466;
   @ObfuscatedName("x")
   int[] field1469;

   FrameMap(int var1, byte[] var2) {
      this.field1465 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1464 = var3.readUnsignedByte();
      this.field1469 = new int[this.field1464];
      this.field1466 = new int[this.field1464][];

      int var4;
      for(var4 = 0; var4 < this.field1464; ++var4) {
         this.field1469[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1464; ++var4) {
         this.field1466[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1464; ++var4) {
         for(int var5 = 0; var5 < this.field1466[var4].length; ++var5) {
            this.field1466[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "-8518"
   )
   public static synchronized long method1695() {
      long var0 = System.currentTimeMillis();
      if(var0 < class88.field1539) {
         class155.field2106 += class88.field1539 - var0;
      }

      class88.field1539 = var0;
      return var0 + class155.field2106;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2018062187"
   )
   public static void method1696() {
      if(class185.field2757 != null) {
         class185.field2757.method2059();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;B)Ljava/lang/String;",
      garbageValue = "7"
   )
   public static String method1697(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var10 = var3 - var2;
         if(var10 >= 1 && var10 <= class188.method3439(var1)) {
            StringBuilder var9 = new StringBuilder(var10);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(class36.method722(var7)) {
                  char var8 = class97.method1918(var7);
                  if(var8 != 0) {
                     var9.append(var8);
                  }
               }
            }

            if(var9.length() == 0) {
               return null;
            } else {
               return var9.toString();
            }
         } else {
            return null;
         }
      }
   }
}
