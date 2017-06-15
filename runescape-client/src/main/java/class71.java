import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class71 implements Runnable {
   @ObfuscatedName("p")
   boolean field840;
   @ObfuscatedName("m")
   Object field841;
   @ObfuscatedName("t")
   int[] field842;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1312165879
   )
   int field843;
   @ObfuscatedName("w")
   int[] field844;
   @ObfuscatedName("ay")
   protected static String field845;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1840369121
   )
   static int field847;

   public void run() {
      for(; this.field840; class172.method3014(50L)) {
         Object var1 = this.field841;
         synchronized(this.field841) {
            if(this.field843 < 500) {
               this.field842[this.field843] = class59.field730;
               this.field844[this.field843] = class59.field731;
               ++this.field843;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1221135019"
   )
   static int method1047(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class83.intStackSize];
         var3 = class223.method3959(var4);
      } else {
         var3 = var2?class43.field582:class31.field457;
      }

      if(var0 == 1100) {
         class83.intStackSize -= 2;
         var3.scrollX = class83.intStack[class83.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class83.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2683 = class83.intStack[--class83.intStackSize] == 1;
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2687 = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2691 = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2692 = class83.intStack[--class83.intStackSize] == 1;
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class83.intStackSize];
         XItemContainer.method1020(var3);
         return 1;
      } else if(var0 == 1109) {
         class83.intStackSize -= 6;
         var3.field2750 = class83.intStack[class83.intStackSize];
         var3.field2731 = class83.intStack[class83.intStackSize + 1];
         var3.rotationX = class83.intStack[class83.intStackSize + 2];
         var3.rotationZ = class83.intStack[class83.intStackSize + 3];
         var3.rotationY = class83.intStack[class83.intStackSize + 4];
         var3.field2737 = class83.intStack[class83.intStackSize + 5];
         XItemContainer.method1020(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class83.intStack[--class83.intStackSize];
            if(var3.field2777 != var8) {
               var3.field2777 = var8;
               var3.field2776 = 0;
               var3.field2758 = 0;
               XItemContainer.method1020(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2711 = class83.intStack[--class83.intStackSize] == 1;
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class83.scriptStringStack[--class24.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               XItemContainer.method1020(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1114) {
            class83.intStackSize -= 3;
            var3.field2696 = class83.intStack[class83.intStackSize];
            var3.field2718 = class83.intStack[class83.intStackSize + 1];
            var3.field2680 = class83.intStack[class83.intStackSize + 2];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2736 = class83.intStack[--class83.intStackSize] == 1;
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class83.intStackSize] == 1;
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class83.intStackSize] == 1;
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1120) {
            class83.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class83.intStackSize];
            var3.scrollHeight = class83.intStack[class83.intStackSize + 1];
            XItemContainer.method1020(var3);
            if(var4 != -1 && var3.type == 0) {
               class95.method1670(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class23.method189(var3.id, var3.index);
            Client.field1070 = var3;
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2690 = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2728 = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2686 = class83.intStack[--class83.intStackSize];
            XItemContainer.method1020(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class83.intStack[--class83.intStackSize];
            class283 var6 = (class283)RSCanvas.method735(class59.method963(), var8);
            if(var6 != null) {
               var3.field2684 = var6;
               XItemContainer.method1020(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class83.intStackSize] == 1;
            var3.field2688 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1067680447"
   )
   static File method1049(String var0) {
      if(!class157.field2270) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2269.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class5.field40, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2269.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-3916"
   )
   static String method1050() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class98.field1517.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   class71() {
      this.field840 = true;
      this.field841 = new Object();
      this.field843 = 0;
      this.field842 = new int[500];
      this.field844 = new int[500];
   }
}
