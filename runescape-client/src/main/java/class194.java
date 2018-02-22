import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class194 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -738633985
   )
   static int field2551;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1938592793
   )
   static int field2544;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1630679593
   )
   static int field2545;
   @ObfuscatedName("p")
   static byte[][] field2546;
   @ObfuscatedName("a")
   static byte[][] field2549;
   @ObfuscatedName("h")
   static byte[][] field2548;
   @ObfuscatedName("l")
   public static int[] field2547;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 885237403
   )
   static int field2550;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;

   static {
      field2551 = 0;
      field2544 = 0;
      field2545 = 0;
      field2546 = new byte[1000][];
      field2549 = new byte[250][];
      field2548 = new byte[50][];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-688329758"
   )
   static synchronized byte[] method3783(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2551 > 0) {
         var2 = field2546[--field2551];
         field2546[field2551] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2544 > 0) {
         var2 = field2549[--field2544];
         field2549[field2544] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2545 > 0) {
         var2 = field2548[--field2545];
         field2548[field2545] = null;
         return var2;
      }

      if(class317.field3873 != null) {
         for(int var4 = 0; var4 < field2547.length; ++var4) {
            if(field2547[var4] != var0) {
               if(var0 < field2547[var4]) {
                  ;
               }
            } else if(class249.field3284[var4] > 0) {
               byte[] var3 = class317.field3873[var4][--class249.field3284[var4]];
               class317.field3873[var4][class249.field3284[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lba;I)V",
      garbageValue = "-1659141080"
   )
   public static void method3791(ScriptEvent var0) {
      WorldMapType2.runScript(var0, 500000);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "66"
   )
   static int method3793(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class223.field2643:class80.field1228;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class80.intStack[--class80.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class80.scriptStringStack[--class43.scriptStringStackSize]);
            return 1;
         } else {
            --class43.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class80.intStackSize -= 2;
         var4 = class80.intStack[class80.intStackSize];
         int var5 = class80.intStack[class80.intStackSize + 1];
         var3.dragParent = class201.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2855 = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2853 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2854 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class80.scriptStringStack[--class43.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class80.scriptStringStack[--class43.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   static void method3794(String var0, String var1, String var2) {
      class89.loginMessage1 = var0;
      class89.loginMessage2 = var1;
      class89.loginMessage3 = var2;
   }
}
