import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("a")
   static int[] field810;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1233913405
   )
   int field811;
   @ObfuscatedName("h")
   public static String field812;
   @ObfuscatedName("fm")
   static byte[][] field814;
   @ObfuscatedName("e")
   boolean field815;
   @ObfuscatedName("ez")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -346953953
   )
   @Export("id")
   int id;

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(I)LRenderOverview;",
      garbageValue = "-1980899095"
   )
   static RenderOverview method1030() {
      return class46.field601;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1423434307"
   )
   static final void method1031(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.method3294(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.method3290(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field930 - 1] = var1;
               var3.field1240 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.secretPacketBuffer2.method3290(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.secretPacketBuffer2.method3290(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               var3.composition = class158.getNpcDefinition(Client.secretPacketBuffer2.method3290(14));
               int var5 = Client.secretPacketBuffer2.method3290(1);
               if(var5 == 1) {
                  Client.field946[++Client.field1096 - 1] = var1;
               }

               int var6 = Client.field1154[Client.secretPacketBuffer2.method3290(3)];
               if(var2) {
                  var3.orientation = var3.angle = var6;
               }

               int var7 = Client.secretPacketBuffer2.method3290(1);
               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.method3290(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.method3290(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field1212 = var3.composition.field3559;
               var3.field1227 = var3.composition.field3582;
               if(var3.field1227 == 0) {
                  var3.angle = 0;
               }

               var3.field1216 = var3.composition.field3565;
               var3.field1217 = var3.composition.field3560;
               var3.field1218 = var3.composition.field3567;
               var3.field1219 = var3.composition.field3568;
               var3.idlePoseAnimation = var3.composition.field3558;
               var3.field1214 = var3.composition.field3563;
               var3.field1215 = var3.composition.field3564;
               var3.method1589(class20.localPlayer.pathX[0] + var4, var8 + class20.localPlayer.pathY[0], var7 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.method3292();
         return;
      }
   }

   WidgetNode() {
      this.field815 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-885350328"
   )
   static int method1032(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var5;
      if(var0 == 3400) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         Enum var9 = class176.method3269(var3);
         if(var9.valType != 115) {
            ;
         }

         for(var5 = 0; var5 < var9.size; ++var5) {
            if(var4 == var9.keys[var5]) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.stringVals[var5];
               var9 = null;
               break;
            }
         }

         if(var9 != null) {
            class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class83.intStackSize -= 4;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var6 = class83.intStack[class83.intStackSize + 2];
         var5 = class83.intStack[class83.intStackSize + 3];
         Enum var7 = class176.method3269(var6);
         if(var7.keyType == var3 && var7.valType == var4) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var5 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "null";
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "1677707536"
   )
   public static ModIcon[] method1033(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4055(var1);
      int var4 = var0.method4020(var3, var2);
      return class43.method597(var0, var3, var4);
   }
}
