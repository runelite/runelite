import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   @Export("LONG")
   LONG(2, 1, Long.class, new class3()),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   @Export("STRING")
   STRING(1, 2, String.class, new class5());

   @ObfuscatedName("ap")
   static int[] field30;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 269470427
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 307420811
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1900067095
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lc;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;II)Ljava/lang/String;",
      garbageValue = "-1832196444"
   )
   public static String method13(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = CollisionData.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1037241275"
   )
   static final int method12(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "([Lib;II)V",
      garbageValue = "-974304014"
   )
   static final void method11(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class157.method3183(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class157.method3183(var3) && var3 != Coordinates.field2775) {
                  continue;
               }

               method11(var0, var3.id);
               if(var3.children != null) {
                  method11(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  ClientPacket.method3422(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2831 != -1 || var3.field2862 != -1) {
                  boolean var7 = class167.method3248(var3);
                  if(var7) {
                     var5 = var3.field2862;
                  } else {
                     var5 = var3.field2831;
                  }

                  if(var5 != -1) {
                     Sequence var6 = ISAACCipher.getAnimation(var5);

                     for(var3.field2806 += Client.field893; var3.field2806 > var6.frameLengths[var3.field2837]; WorldMapType1.method274(var3)) {
                        var3.field2806 -= var6.frameLengths[var3.field2837];
                        ++var3.field2837;
                        if(var3.field2837 >= var6.frameIDs.length) {
                           var3.field2837 -= var6.frameStep;
                           if(var3.field2837 < 0 || var3.field2837 >= var6.frameIDs.length) {
                              var3.field2837 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2906 != 0 && !var3.hasScript) {
                  int var8 = var3.field2906 >> 16;
                  var5 = var3.field2906 << 16 >> 16;
                  var8 *= Client.field893;
                  var5 *= Client.field893;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  WorldMapType1.method274(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "(IIIILla;Lir;I)V",
      garbageValue = "-1666033635"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5885(var10 + var5.field2765 / 2 - var4.maxWidth / 2, var5.field2763 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2765, var5.field2763, var5.field2766, var5.field2768);
            } else {
               var4.drawAt(var0 + var10 + var5.field2765 / 2 - var4.maxWidth / 2, var5.field2763 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
