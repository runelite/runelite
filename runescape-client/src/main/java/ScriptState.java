import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 931067829
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("i")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("u")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lix;",
      garbageValue = "1114291424"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2211 != null) {
         var4 = new IndexFile(var0, class155.field2211, Signlink.field2199[var0], 1000000);
      }

      return new IndexData(var4, GraphicsObject.field1347, var0, var1, var2, var3);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lbp;ZI)V",
      garbageValue = "-627084311"
   )
   static final void method1021(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class98.method1769(var2);
      }

      for(WidgetConfig var4 = (WidgetConfig)Client.widgetFlags.method3492(); var4 != null; var4 = (WidgetConfig)Client.widgetFlags.method3493()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = class239.method4167(var3);
      if(var5 != null) {
         class21.method156(var5);
      }

      class7.method37();
      if(Client.widgetRoot != -1) {
         class208.method3824(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "915478594"
   )
   static int method1023(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class48.field614:FaceNormal.field2099;
      if(var0 == 1600) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.field2649;
         return 1;
      } else if(var0 == 1611) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.field2643;
         return 1;
      } else if(var0 == 1613) {
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.field2647.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1812123348"
   )
   static final void method1024(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1409080781"
   )
   public static final boolean method1025(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
