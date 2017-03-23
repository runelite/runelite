import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class7 implements Comparator {
   @ObfuscatedName("i")
   public static String method80(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3092[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-62"
   )
   int method83(class2 var1, class2 var2) {
      return var1.field18 < var2.field18?-1:(var2.field18 == var1.field18?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method83((class2)var1, (class2)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Lclass30;",
      garbageValue = "42"
   )
   static class30 method86() {
      FileOnDisk var0 = null;
      class30 var1 = new class30();

      try {
         var0 = class45.method868("", Client.field304.field2709, false);
         byte[] var2 = new byte[(int)var0.method1449()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method1450(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class30(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1448();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1883989763"
   )
   static final int method87() {
      if(class148.field2058.field716) {
         return Sequence.plane;
      } else {
         int var0 = class103.method2025(MessageNode.cameraX, DecorativeObject.cameraY, Sequence.plane);
         return var0 - class16.cameraZ < 800 && (class10.tileSettings[Sequence.plane][MessageNode.cameraX >> 7][DecorativeObject.cameraY >> 7] & 4) != 0?Sequence.plane:3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static void method88() {
      for(class31 var0 = (class31)class31.field732.method2464(); null != var0; var0 = (class31)class31.field732.method2472()) {
         if(null != var0.field736) {
            Ignore.field224.method943(var0.field736);
            var0.field736 = null;
         }

         if(var0.field735 != null) {
            Ignore.field224.method943(var0.field735);
            var0.field735 = null;
         }
      }

      class31.field732.method2458();
   }
}
