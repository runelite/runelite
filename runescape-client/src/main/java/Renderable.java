import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -918845775
   )
   @Export("modelHeight")
   public int modelHeight;

   @ObfuscatedName("bj")
   void vmethod2753(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2753(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "2"
   )
   static int method2756(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "603335196"
   )
   static int method2758(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class83.intStackSize -= 5;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var11 = class83.intStack[class83.intStackSize + 2];
         int var6 = class83.intStack[class83.intStackSize + 3];
         int var12 = class83.intStack[class83.intStackSize + 4];
         class83.intStack[++class83.intStackSize - 1] = var3 + (var4 - var3) * (var12 - var11) / (var6 - var11);
         return 1;
      } else if(var0 == 4007) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else if(var4 == 0) {
            class83.intStack[++class83.intStackSize - 1] = Integer.MAX_VALUE;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class83.intStackSize -= 3;
         long var5 = (long)class83.intStack[class83.intStackSize];
         long var7 = (long)class83.intStack[class83.intStackSize + 1];
         long var9 = (long)class83.intStack[class83.intStackSize + 2];
         class83.intStack[++class83.intStackSize - 1] = (int)(var9 * var5 / var7);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-1943561861"
   )
   static final void method2760(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class14.field296.length; ++var2) {
         class14.field296[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class14.field296[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               Script.field1536[var5] = (class14.field296[var5 + 128] + class14.field296[var5 - 1] + class14.field296[var5 + 1] + class14.field296[var5 - 128]) / 4;
            }
         }

         int[] var6 = class14.field296;
         class14.field296 = Script.field1536;
         Script.field1536 = var6;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var8 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var8 << 7);
                  class14.field296[var7] = 0;
               }
            }
         }
      }

   }
}
