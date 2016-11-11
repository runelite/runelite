import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class158 {
   @ObfuscatedName("h")
   public static final boolean[] field2344 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("e")
   public static int[] field2345 = new int[99];

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2345[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-30"
   )
   static void method3191(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = VertexNormal.worldList[var6];
         VertexNormal.worldList[var6] = VertexNormal.worldList[var1];
         VertexNormal.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = VertexNormal.worldList[var9];
            int var14 = XItemContainer.method187(var11, var8, var2, var3);
            int var10;
            if(var14 != 0) {
               if(var3) {
                  var10 = -var14;
               } else {
                  var10 = var14;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = XItemContainer.method187(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var12 = VertexNormal.worldList[var9];
               VertexNormal.worldList[var9] = VertexNormal.worldList[var7];
               VertexNormal.worldList[var7++] = var12;
            }
         }

         VertexNormal.worldList[var1] = VertexNormal.worldList[var7];
         VertexNormal.worldList[var7] = var8;
         method3191(var0, var7 - 1, var2, var3, var4, var5);
         method3191(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1993068312"
   )
   static void method3192() {
      Object var0 = class173.field2753;
      synchronized(class173.field2753) {
         if(class173.field2755 == 0) {
            class40.field898.method2920(new class173(), 5);
         }

         class173.field2755 = 600;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-42"
   )
   public static String method3193(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = Item.method662(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
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
}
