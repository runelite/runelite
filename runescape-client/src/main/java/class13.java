import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class13 {
   @ObfuscatedName("q")
   public static Comparator field265;
   @ObfuscatedName("x")
   public static Comparator field266;
   @ObfuscatedName("y")
   public static Comparator field275;
   @ObfuscatedName("e")
   public static Comparator field268;
   @ObfuscatedName("oq")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("d")
   public final List field270;

   static {
      field265 = new class19();
      new class12();
      field266 = new class17();
      field275 = new class18();
      field268 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfw;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field270 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field270.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "242882797"
   )
   public void method73(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field270, var1);
      } else {
         Collections.sort(this.field270, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lim;III)Lji;",
      garbageValue = "2031301144"
   )
   public static SpritePixels method72(IndexDataBase var0, int var1, int var2) {
      if(!WallObject.method2899(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class286.field3779;
         var4.maxHeight = class286.field3780;
         var4.offsetX = class270.field3666[0];
         var4.offsetY = class286.offsetsY[0];
         var4.width = class286.field3778[0];
         var4.height = class286.field3782[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = class177.spritePixels[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class286.field3783[var6[var7] & 255];
         }

         class229.method4093();
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lcc;II[I[IB)V",
      garbageValue = "36"
   )
   static void method76(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1596()?1:0;
                     var12 = var8.method1596()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1596()?1:0;
                     var12 = var8.method1596()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method76(var0, var1, var6, var3, var4);
         method76(var0, var6 + 1, var2, var3, var4);
      }

   }
}
