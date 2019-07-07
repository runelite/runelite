import java.awt.Component;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ao")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
   @ObfuscatedName("s")
   public static String[] field94;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1131782991
   )
   static int field95;
   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "Lbr;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("m")
   @Export("component")
   Component component;

   Canvas(Component var1) {
      this.component = var1;
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "2032921954"
   )
   static String method860(Throwable var0) throws IOException {
      String var1;
      if (var0 instanceof RunException) {
         RunException var2 = (RunException)var0;
         var1 = var2.string + " | ";
         var0 = var2.throwable;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while (true) {
         while (true) {
            String var7 = var5.readLine();
            if (var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if (var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if (var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "708667926"
   )
   static synchronized byte[] method862(int var0) {
      return ByteArrayPool.ByteArrayPool_get(var0, false);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "2144935109"
   )
   static int method861(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      Widget var5;
      if (var0 == ScriptOpcodes.CC_CREATE) {
         RouteStrategy.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         int var9 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
         if (var4 == 0) {
            throw new RuntimeException();
         } else {
            var5 = Huffman.getWidget(var3);
            if (var5.children == null) {
               var5.children = new Widget[var9 + 1];
            }

            if (var5.children.length <= var9) {
               Widget[] var7 = new Widget[var9 + 1];

               for (int var8 = 0; var8 < var5.children.length; ++var8) {
                  var7[var8] = var5.children[var8];
               }

               var5.children = var7;
            }

            if (var9 > 0 && var5.children[var9 - 1] == null) {
               throw new RuntimeException("" + (var9 - 1));
            } else {
               Widget var10 = new Widget();
               var10.type = var4;
               var10.parentId = var10.id = var5.id;
               var10.childIndex = var9;
               var10.isIf3 = true;
               var5.children[var9] = var10;
               if (var2) {
                  WorldMapIcon1.field1030 = var10;
               } else {
                  GrandExchangeOfferAgeComparator.field1111 = var10;
               }

               class22.method295(var5);
               return 1;
            }
         }
      } else {
         Widget var6;
         if (var0 == ScriptOpcodes.CC_DELETE) {
            var6 = var2 ? WorldMapIcon1.field1030 : GrandExchangeOfferAgeComparator.field1111;
            var5 = Huffman.getWidget(var6.id);
            var5.children[var6.childIndex] = null;
            class22.method295(var5);
            return 1;
         } else if (var0 == ScriptOpcodes.CC_DELETEALL) {
            var6 = Huffman.getWidget(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
            var6.children = null;
            class22.method295(var6);
            return 1;
         } else if (var0 != ScriptOpcodes.CC_FIND) {
            if (var0 == ScriptOpcodes.IF_FIND) {
               var6 = Huffman.getWidget(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
               if (var6 != null) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
                  if (var2) {
                     WorldMapIcon1.field1030 = var6;
                  } else {
                     GrandExchangeOfferAgeComparator.field1111 = var6;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            RouteStrategy.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
            var5 = class204.getWidgetChild(var3, var4);
            if (var5 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
               if (var2) {
                  WorldMapIcon1.field1030 = var5;
               } else {
                  GrandExchangeOfferAgeComparator.field1111 = var5;
               }
            } else {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILir;Ljava/lang/String;Ljava/lang/String;IZS)V",
      garbageValue = "-9124"
   )
   public static void method858(int var0, AbstractArchive var1, String groupName, String fileName, int var4, boolean var5) {
      int var6 = var1.getGroupId(groupName);
      int var7 = var1.getFileId(var6, fileName);
      class214.field1129 = 1;
      class214.field1130 = var1;
      class30.musicTrackGroupId = var6;
      GrandExchangeOffer.musicTrackFileId = var7;
      WorldMapLabel.field1039 = var4;
      RectangleMode.musicTrackBoolean = var5;
      FaceNormal.field344 = var0;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1032035944"
   )
   static final void method855() {
      for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if (var0.hitpoints == 0) {
            if (var0.field903 < 0 || VarbitDefinition.method4910(var0.field903, var0.field905)) {
               ParamDefinition.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.field903, var0.field904, var0.field905);
               var0.remove();
            }
         } else {
            if (var0.delay > 0) {
               --var0.delay;
            }

            if (var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || VarbitDefinition.method4910(var0.id, var0.field908))) {
               ParamDefinition.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field908);
               var0.delay = -1;
               if (var0.field903 == var0.id && var0.field903 == -1) {
                  var0.remove();
               } else if (var0.id == var0.field903 && var0.field904 == var0.orientation && var0.field908 == var0.field905) {
                  var0.remove();
               }
            }
         }
      }

   }
}
