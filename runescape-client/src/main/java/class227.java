import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class227 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljz;I)V",
      garbageValue = "-1235273336"
   )
   static final void method4199(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < ScriptState.field792.length; ++var2) {
         ScriptState.field792[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         ScriptState.field792[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               Varbit.field3383[var5] = (ScriptState.field792[var5 - 128] + ScriptState.field792[var5 - 1] + ScriptState.field792[var5 + 1] + ScriptState.field792[var5 + 128]) / 4;
            }
         }

         int[] var8 = ScriptState.field792;
         ScriptState.field792 = Varbit.field3383;
         Varbit.field3383 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  ScriptState.field792[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "-23"
   )
   static int method4198(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class81.field1341:class81.field1340;
      if(var0 == 1500) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class81.intStack[++class81.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class81.intStack[++class81.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class81.intStack[++class81.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class81.intStack[++class81.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
