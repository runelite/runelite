import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1430541935
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("a")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("r")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "4"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = WorldMapType2.font_p12full.method4717(var0, 250);
      int var6 = WorldMapType2.font_p12full.method4794(var0, 250) * 13;
      Rasterizer2D.method4890(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
      WorldMapType2.font_p12full.method4789(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      ChatLineBuffer.method1867(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         class20.field342.vmethod4967(0, 0);
      } else {
         class14.method87(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "477831264"
   )
   static int method1103(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--Ignore.intStackSize];
         var4 = GZipDecompressor.method3177(var3);
      } else {
         var4 = var2?class31.field452:class23.field366;
      }

      if(var0 == 1000) {
         Ignore.intStackSize -= 4;
         var4.originalX = class82.intStack[Ignore.intStackSize];
         var4.originalY = class82.intStack[Ignore.intStackSize + 1];
         var4.field2663 = class82.intStack[Ignore.intStackSize + 2];
         var4.field2664 = class82.intStack[Ignore.intStackSize + 3];
         class7.method34(var4);
         class87.clientInstance.method1426(var4);
         if(var3 != -1 && var4.type == 0) {
            class64.method1114(class268.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         Ignore.intStackSize -= 4;
         var4.originalWidth = class82.intStack[Ignore.intStackSize];
         var4.field2670 = class82.intStack[Ignore.intStackSize + 1];
         var4.field2665 = class82.intStack[Ignore.intStackSize + 2];
         var4.buttonType = class82.intStack[Ignore.intStackSize + 3];
         class7.method34(var4);
         class87.clientInstance.method1426(var4);
         if(var3 != -1 && var4.type == 0) {
            class64.method1114(class268.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--Ignore.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class7.method34(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2654 = class82.intStack[--Ignore.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2792 = class82.intStack[--Ignore.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lcp;Lcp;IZB)I",
      garbageValue = "-15"
   )
   static int method1102(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1553()?(var1.method1553()?0:1):(var1.method1553()?-1:0)):(var2 == 5?(var0.method1556()?(var1.method1556()?0:1):(var1.method1556()?-1:0)):(var2 == 6?(var0.method1552()?(var1.method1552()?0:1):(var1.method1552()?-1:0)):(var2 == 7?(var0.method1550()?(var1.method1550()?0:1):(var1.method1550()?-1:0)):var0.id - var1.id)))));
      }
   }
}
