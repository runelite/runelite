import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public abstract class class28 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 232149649
   )
   int field383;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1133086707
   )
   int field374;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2016732181
   )
   int field380;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1416790561
   )
   int field376;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1270484349
   )
   int field377;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -649722183
   )
   int field378;
   @ObfuscatedName("t")
   short[][][] field379;
   @ObfuscatedName("f")
   short[][][] field375;
   @ObfuscatedName("g")
   byte[][][] field381;
   @ObfuscatedName("j")
   byte[][][] field382;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[[[[Laq;"
   )
   class31[][][][] field384;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILgh;B)V",
      garbageValue = "-103"
   )
   void method241(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method224(var1, var2, var3, var4);
         } else {
            this.method225(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILgh;II)V",
      garbageValue = "328573213"
   )
   void method224(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field375[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field379[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILgh;IB)V",
      garbageValue = "-126"
   )
   void method225(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field379[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field375[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field381[var9][var1][var2] = (byte)(var11 >> 2);
               this.field382[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field384[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3372();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1648429735"
   )
   int method222(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field379[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1600331438"
   )
   int method227() {
      return this.field380;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1280515471"
   )
   int method228() {
      return this.field376;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-70"
   )
   static void method236() {
      for(class81 var0 = (class81)class81.field1235.getFront(); var0 != null; var0 = (class81)class81.field1235.getNext()) {
         if(var0.field1227 != null) {
            var0.method1540();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2027536189"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.messages.put(var5, (long)var5.id);
      class96.field1414.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "235782219"
   )
   static final boolean method242(int var0, int var1) {
      ObjectComposition var2 = CacheFile.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4662(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-931216708"
   )
   static final void method239() {
      short var0 = 256;
      int var1;
      if(class91.field1323 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1323 > 768) {
               Item.field1386[var1] = class188.method3534(class218.field2696[var1], class91.field1325[var1], 1024 - class91.field1323);
            } else if(class91.field1323 > 256) {
               Item.field1386[var1] = class91.field1325[var1];
            } else {
               Item.field1386[var1] = class188.method3534(class91.field1325[var1], class218.field2696[var1], 256 - class91.field1323);
            }
         }
      } else if(class91.field1327 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1327 > 768) {
               Item.field1386[var1] = class188.method3534(class218.field2696[var1], class2.field11[var1], 1024 - class91.field1327);
            } else if(class91.field1327 > 256) {
               Item.field1386[var1] = class2.field11[var1];
            } else {
               Item.field1386[var1] = class188.method3534(class2.field11[var1], class218.field2696[var1], 256 - class91.field1327);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            Item.field1386[var1] = class218.field2696[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1351, 9, class91.field1351 + 128, var0 + 7);
      class91.field1315.method5203(class91.field1351, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = ScriptState.rasterProvider.width * 9 + class91.field1351;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1324[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class89.field1302[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Item.field1386[var7];
               var10 = ScriptState.rasterProvider.pixels[var2];
               ScriptState.rasterProvider.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + ScriptState.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1351 + 765 - 128, 9, class91.field1351 + 765, var0 + 7);
      class91.field1319.method5203(class91.field1351 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = ScriptState.rasterProvider.width * 9 + class91.field1351 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1324[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class89.field1302[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Item.field1386[var7];
               var10 = ScriptState.rasterProvider.pixels[var2];
               ScriptState.rasterProvider.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += ScriptState.rasterProvider.width - var5 - var4;
      }

   }
}
