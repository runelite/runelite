import java.io.IOException;
import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public abstract class class28 {
   @ObfuscatedName("n")
   byte[][][] field406;
   @ObfuscatedName("f")
   byte[][][] field407;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 549642693
   )
   int field408;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 749744531
   )
   int field409;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 868407543
   )
   int field410;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -340622857
   )
   int field411;
   @ObfuscatedName("h")
   short[][][] field412;
   @ObfuscatedName("x")
   short[][][] field413;
   @ObfuscatedName("rx")
   @ObfuscatedGetter(
      longValue = -2556036718580548451L
   )
   static long field414;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1983275243
   )
   int field415;
   @ObfuscatedName("a")
   class31[][][][] field416;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1855894791
   )
   int field417;
   @ObfuscatedName("fh")
   static int[] field420;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "948064424"
   )
   void method206(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field413[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field412[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "1409949746"
   )
   void method207(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field412[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var14 = var3.readUnsignedByte();
            if(var14 != 0) {
               this.field413[var9][var1][var2] = (short)var14;
               var11 = var3.readUnsignedByte();
               this.field407[var9][var1][var2] = (byte)(var11 >> 2);
               this.field406[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var10 = this.field416[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3156();
                  int var13 = var3.readUnsignedByte();
                  var10[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "53"
   )
   int method208(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field412[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1941687234"
   )
   int method209() {
      return this.field408;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1030569287"
   )
   int method210() {
      return this.field415;
   }

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-324302307"
   )
   static final void method215(boolean var0) {
      Client.field1053 = 0;
      Client.field970 = 0;
      class232.method4102();
      WidgetNode.method1085(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.field970; ++var1) {
         var2 = Client.field971[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.secretPacketBuffer2.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 16) != 0) {
            var5 = Client.secretPacketBuffer2.method3168();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.secretPacketBuffer2.method3154();
                  if(var7 == 32767) {
                     var7 = Client.secretPacketBuffer2.method3154();
                     var9 = Client.secretPacketBuffer2.method3154();
                     var8 = Client.secretPacketBuffer2.method3154();
                     var10 = Client.secretPacketBuffer2.method3154();
                  } else if(var7 != 32766) {
                     var9 = Client.secretPacketBuffer2.method3154();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.secretPacketBuffer2.method3154();
                  var3.method1516(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.method3169();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3154();
                  var9 = Client.secretPacketBuffer2.method3154();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.method3154();
                     var11 = Client.secretPacketBuffer2.method3314();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.method3314():var11;
                     var3.method1529(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1524(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var5 = Client.secretPacketBuffer2.method3177();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.method3168();
            if(var3.animation == var5 && var5 != -1) {
               var7 = class227.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1260 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1278 = 0;
               }

               if(var7 == 2) {
                  var3.field1278 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class227.getAnimation(var5).forcedPriority >= class227.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1260 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1278 = 0;
               var3.field1301 = var3.field1263;
            }
         }

         if((var4 & 64) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            var6 = Client.secretPacketBuffer2.readUnsignedShort();
            var7 = var3.x - (var5 - class41.baseX - class41.baseX) * 64;
            var8 = var3.y - (var6 - WorldMapType3.baseY - WorldMapType3.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1270 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 4) != 0) {
            var3.graphic = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.readInt();
            var3.field1302 = var5 >> 16;
            var3.field1296 = (var5 & '\uffff') + Client.gameCycle;
            var3.field1280 = 0;
            var3.field1281 = 0;
            if(var3.field1296 > Client.gameCycle) {
               var3.field1280 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 8) != 0) {
            var3.composition = class220.getNpcDefinition(Client.secretPacketBuffer2.method3178());
            var3.field1268 = var3.composition.field3577;
            var3.field1295 = var3.composition.field3574;
            var3.field1242 = var3.composition.field3557;
            var3.field1299 = var3.composition.field3578;
            var3.field1288 = var3.composition.field3560;
            var3.field1253 = var3.composition.field3545;
            var3.idlePoseAnimation = var3.composition.field3550;
            var3.field1248 = var3.composition.field3555;
            var3.field1249 = var3.composition.field3556;
         }

         if((var4 & 2) != 0) {
            var3.interacting = Client.secretPacketBuffer2.method3176();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1258 = 100;
         }
      }

      for(var1 = 0; var1 < Client.field1053; ++var1) {
         var2 = Client.field1076[var1];
         if(Client.gameCycle != Client.cachedNPCs[var2].field1276) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.secretPacketBuffer2.offset != Client.packetLength) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field968; ++var1) {
            if(Client.cachedNPCs[Client.field950[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field968);
            }
         }

      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1267879738"
   )
   static void method223(Buffer var0) {
      if(Client.field966 != null) {
         var0.putBytes(Client.field966, 0, Client.field966.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class155.field2268.method2316(0L);
            class155.field2268.method2318(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.putBytes(var2, 0, var2.length);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "211401916"
   )
   public static void method225() {
      Sequence.field3616.reset();
      Sequence.field3601.reset();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILBuffer;I)V",
      garbageValue = "-412129730"
   )
   void method227(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method206(var1, var2, var3, var4);
         } else {
            this.method207(var1, var2, var3, var4);
         }

      }
   }
}
