import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class3 implements Comparator {
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1354163607
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass166;ILPlayer;IB)V",
      garbageValue = "5"
   )
   static final void method31(class166 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method3095(var6, 0, var5);
         class45.field900[var1] = var7;
         var2.method235(var7);
      }

      int var17;
      if((var3 & 128) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var17 = var0.readUnsignedByte();
         class13.method188(var2, var5, var17);
      }

      if((var3 & 64) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 8) != 0) {
         var2.overhead = var0.method2934();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            ChatLineBuffer.sendGameMessage(2, var2.name, var2.overhead);
         } else if(VertexNormal.localPlayer == var2) {
            ChatLineBuffer.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field604 = false;
         var2.field607 = 0;
         var2.field648 = 0;
         var2.field606 = 150;
      }

      int var8;
      int var9;
      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var18;
         if(var5 > 0) {
            for(var17 = 0; var17 < var5; ++var17) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var18 = var0.method2939();
               if(var18 == 32767) {
                  var18 = var0.method2939();
                  var9 = var0.method2939();
                  var8 = var0.method2939();
                  var10 = var0.method2939();
               } else if(var18 != 32766) {
                  var9 = var0.method2939();
               } else {
                  var18 = -1;
               }

               var11 = var0.method2939();
               var2.method628(var18, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var17 = var0.readUnsignedByte();
         if(var17 > 0) {
            for(var18 = 0; var18 < var17; ++var18) {
               var8 = var0.method2939();
               var9 = var0.method2939();
               if(var9 != 32767) {
                  var10 = var0.method2939();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method625(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method629(var8);
               }
            }
         }
      }

      if((var3 & 4) != 0) {
         var2.field635 = var0.readUnsignedShort();
         if(var2.field644 == 0) {
            var2.field641 = var2.field635;
            var2.field635 = -1;
         }
      }

      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedShort();
         class177 var23 = (class177)CombatInfoListHolder.method732(class114.method2189(), var0.readUnsignedByte());
         boolean var26 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(null != var2.name && null != var2.composition) {
            boolean var25 = false;
            if(var23.field2654 && class1.method20(var2.name)) {
               var25 = true;
            }

            if(!var25 && Client.field397 == 0 && !var2.field262) {
               class45.field912.offset = 0;
               var0.method3095(class45.field912.payload, 0, var8);
               class45.field912.offset = 0;
               Buffer var19 = class45.field912;

               String var13;
               int var14;
               try {
                  var14 = var19.method2939();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var19.offset += class210.field3110.method2852(var19.payload, var19.offset, var15, 0, var14);
                  String var16 = class72.method1414(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var22) {
                  var13 = "Cabbage";
               }

               var13 = FontTypeFace.method3937(RSCanvas.method2070(var13));
               var2.overhead = var13.trim();
               var2.field607 = var5 >> 8;
               var2.field648 = var5 & 255;
               var2.field606 = 150;
               var2.field604 = var26;
               var2.inSequence = VertexNormal.localPlayer != var2 && var23.field2654 && "" != Client.field559 && var13.toLowerCase().indexOf(Client.field559) == -1;
               if(var23.field2656) {
                  var14 = var26?91:1;
               } else {
                  var14 = var26?90:2;
               }

               if(var23.field2647 != -1) {
                  ChatLineBuffer.sendGameMessage(var14, class114.method2191(var23.field2647) + var2.name, var13);
               } else {
                  ChatLineBuffer.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.method3062();
         var2.field631 = var5 >> 16;
         var2.field630 = (var5 & '\uffff') + Client.gameCycle;
         var2.field647 = 0;
         var2.field629 = 0;
         if(var2.field630 > Client.gameCycle) {
            var2.field647 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field632 = var0.readByte();
         var2.field634 = var0.readByte();
         var2.field633 = var0.readByte();
         var2.field605 = var0.readByte();
         var2.field636 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field637 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field616 = var0.readUnsignedShort();
         if(var2.field265) {
            var2.field632 += var2.field242;
            var2.field634 += var2.field253;
            var2.field633 += var2.field242;
            var2.field605 += var2.field253;
            var2.field644 = 0;
         } else {
            var2.field632 += var2.pathX[0];
            var2.field634 += var2.pathY[0];
            var2.field633 += var2.pathX[0];
            var2.field605 += var2.pathY[0];
            var2.field644 = 1;
         }

         var2.field645 = 0;
      }

      if((var3 & 512) != 0) {
         class45.field899[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2934();
         }
      }

      if(var2.field265) {
         if(var4 == 127) {
            var2.method250(var2.field242, var2.field253);
         } else {
            byte var24;
            if(var4 != -1) {
               var24 = var4;
            } else {
               var24 = class45.field899[var1];
            }

            var2.method243(var2.field242, var2.field253, var24);
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1721525852"
   )
   static final void method33() {
      if(null != CombatInfoListHolder.field760) {
         CombatInfoListHolder.field760.method1094();
      }

      if(class139.field1944 != null) {
         class139.field1944.method1094();
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method42((class2)var1, (class2)var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   static void method39() {
      FileOnDisk var0 = null;

      try {
         var0 = Client.method610("", MessageNode.field229.field2675, true);
         Buffer var1 = class85.field1456.method684();
         var0.method1418(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1419();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "619933369"
   )
   static final void method40(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field300.method2403(); null != var10; var10 = (class25)Client.field300.method2398()) {
         if(var0 == var10.field575 && var10.field564 == var1 && var2 == var10.field565 && var3 == var10.field563) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field575 = var0;
         var9.field563 = var3;
         var9.field564 = var1;
         var9.field565 = var2;
         class180.method3268(var9);
         Client.field300.method2380(var9);
      }

      var9.field569 = var4;
      var9.field571 = var5;
      var9.field570 = var6;
      var9.field566 = var7;
      var9.field573 = var8;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "93"
   )
   static final void method41(boolean var0) {
      while(true) {
         if(Client.field323.method3178(Client.field324) >= 27) {
            int var1 = Client.field323.method3176(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field554[++Client.field317 - 1] = var1;
               var3.field639 = Client.gameCycle;
               int var4 = Client.field323.method3176(1);
               int var5 = Client.field406[Client.field323.method3176(3)];
               if(var2) {
                  var3.field641 = var3.angle = var5;
               }

               int var6 = Client.field323.method3176(1);
               if(var6 == 1) {
                  Client.field320[++Client.field311 - 1] = var1;
               }

               int var7;
               if(var0) {
                  var7 = Client.field323.method3176(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = Client.field323.method3176(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               var3.composition = class45.getNpcDefinition(Client.field323.method3176(14));
               int var8;
               if(var0) {
                  var8 = Client.field323.method3176(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.field323.method3176(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field597 = var3.composition.field2987;
               var3.field643 = var3.composition.field2984;
               if(var3.field643 == 0) {
                  var3.angle = 0;
               }

               var3.field598 = var3.composition.field2993;
               var3.field599 = var3.composition.field3007;
               var3.field600 = var3.composition.field2995;
               var3.field601 = var3.composition.field2996;
               var3.idlePoseAnimation = var3.composition.field2990;
               var3.field596 = var3.composition.field2991;
               var3.field642 = var3.composition.field2992;
               var3.method735(var7 + VertexNormal.localPlayer.pathX[0], VertexNormal.localPlayer.pathY[0] + var8, var4 == 1);
               continue;
            }
         }

         Client.field323.method3177();
         return;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1769950246"
   )
   int method42(class2 var1, class2 var2) {
      return var1.field22.totalQuantity < var2.field22.totalQuantity?-1:(var2.field22.totalQuantity == var1.field22.totalQuantity?0:1);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2016458264"
   )
   static final void method43(boolean var0) {
      Client.field401 = 0;
      Client.field311 = 0;
      Client.field323.method3175();
      int var1 = Client.field323.method3176(8);
      int var2;
      if(var1 < Client.field317) {
         for(var2 = var1; var2 < Client.field317; ++var2) {
            Client.field402[++Client.field401 - 1] = Client.field554[var2];
         }
      }

      if(var1 > Client.field317) {
         throw new RuntimeException("");
      } else {
         Client.field317 = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field554[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = Client.field323.method3176(1);
            if(var5 == 0) {
               Client.field554[++Client.field317 - 1] = var3;
               var4.field639 = Client.gameCycle;
            } else {
               int var6 = Client.field323.method3176(2);
               if(var6 == 0) {
                  Client.field554[++Client.field317 - 1] = var3;
                  var4.field639 = Client.gameCycle;
                  Client.field320[++Client.field311 - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.field554[++Client.field317 - 1] = var3;
                     var4.field639 = Client.gameCycle;
                     var7 = Client.field323.method3176(3);
                     var4.method742(var7, (byte)1);
                     var8 = Client.field323.method3176(1);
                     if(var8 == 1) {
                        Client.field320[++Client.field311 - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.field554[++Client.field317 - 1] = var3;
                     var4.field639 = Client.gameCycle;
                     var7 = Client.field323.method3176(3);
                     var4.method742(var7, (byte)2);
                     var8 = Client.field323.method3176(3);
                     var4.method742(var8, (byte)2);
                     int var9 = Client.field323.method3176(1);
                     if(var9 == 1) {
                        Client.field320[++Client.field311 - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field402[++Client.field401 - 1] = var3;
                  }
               }
            }
         }

         method41(var0);
         class22.method229();

         for(var1 = 0; var1 < Client.field401; ++var1) {
            var2 = Client.field402[var1];
            if(Client.cachedNPCs[var2].field639 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field324 != Client.field323.offset) {
            throw new RuntimeException(Client.field323.offset + "," + Client.field324);
         } else {
            for(var1 = 0; var1 < Client.field317; ++var1) {
               if(Client.cachedNPCs[Client.field554[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field317);
               }
            }

         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "1161402115"
   )
   public static class189 method44(int var0) {
      class189 var1 = (class189)class189.field2767.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class189.field2769.getConfigData(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3442(new Buffer(var2));
         }

         class189.field2767.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   static final void method45(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)[Lclass40;",
      garbageValue = "68"
   )
   static class40[] method47() {
      return new class40[]{class40.field808, class40.field818, class40.field817, class40.field810};
   }
}
