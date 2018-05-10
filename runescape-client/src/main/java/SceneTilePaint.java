import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 49564075
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1955356749
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 468269921
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1438735933
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 415292689
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("n")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1234806617
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "711248926"
   )
   public static void method2897(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         class78.field1123 = var0;
         class183.field2370 = new int[var0.length];
         class183.field2373 = new byte[var0.length][][];

         for(int var2 = 0; var2 < class78.field1123.length; ++var2) {
            class183.field2373[var2] = new byte[var1[var2]][];
         }

      } else {
         class78.field1123 = null;
         class183.field2370 = null;
         class183.field2373 = null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;IZI)Lec;",
      garbageValue = "-656092176"
   )
   public static Frames method2899(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lla;S)Ljava/lang/String;",
      garbageValue = "-2125"
   )
   public static String method2898(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            char var5 = var0.charAt(var2);
            boolean var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2 && GraphicsObject.method1813(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= class158.method3317(var1)) {
            StringBuilder var12 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class148.method3206(var7)) {
                  var8 = true;
               } else {
                  char[] var9 = class302.field3730;
                  int var10 = 0;

                  label82:
                  while(true) {
                     char var11;
                     if(var10 >= var9.length) {
                        var9 = class302.field3729;

                        for(var10 = 0; var10 < var9.length; ++var10) {
                           var11 = var9[var10];
                           if(var11 == var7) {
                              var8 = true;
                              break label82;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var9[var10];
                     if(var11 == var7) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var13 = class171.method3473(var7);
                  if(var13 != 0) {
                     var12.append(var13);
                  }
               }
            }

            if(var12.length() == 0) {
               return null;
            } else {
               return var12.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-39"
   )
   static int method2895(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class83.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "834039602"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }
}
