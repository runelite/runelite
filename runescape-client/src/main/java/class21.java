import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public abstract class class21 {
   @ObfuscatedName("by")
   @Export("__b_by")
   static String __b_by;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -474193537
   )
   int field149;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1952285401
   )
   int field146;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1560078681
   )
   int field159;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 549708301
   )
   int field147;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -814742029
   )
   int field148;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2075507241
   )
   int field156;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1715718119
   )
   int field150;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2119420619
   )
   int field152;
   @ObfuscatedName("e")
   short[][][] field151;
   @ObfuscatedName("x")
   short[][][] field145;
   @ObfuscatedName("d")
   byte[][][] field154;
   @ObfuscatedName("k")
   byte[][][] field155;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[[[[Lv;"
   )
   class25[][][][] field144;
   @ObfuscatedName("i")
   boolean field157;
   @ObfuscatedName("a")
   boolean field153;

   class21() {
      this.field150 = -1;
      this.field152 = -1;
      new LinkedList();
      this.field157 = false;
      this.field153 = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1937224298"
   )
   abstract void vmethod715(Buffer var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-947070877"
   )
   boolean method271() {
      return this.field157 && this.field153;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lir;B)V",
      garbageValue = "-108"
   )
   void method263(AbstractIndexCache var1) {
      if(!this.method271()) {
         byte[] var2 = var1.takeRecord(this.field150, this.field152);
         if(var2 != null) {
            this.vmethod715(new Buffer(var2));
            this.field157 = true;
            this.field153 = true;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2111523326"
   )
   void method282() {
      this.field151 = (short[][][])null;
      this.field145 = (short[][][])null;
      this.field154 = (byte[][][])null;
      this.field155 = (byte[][][])null;
      this.field144 = (class25[][][][])null;
      this.field157 = false;
      this.field153 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILgr;I)V",
      garbageValue = "-1039890176"
   )
   void method259(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method260(var1, var2, var3, var4);
         } else {
            this.method257(var1, var2, var3, var4);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILgr;IB)V",
      garbageValue = "34"
   )
   void method260(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field145[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field151[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILgr;II)V",
      garbageValue = "1538895535"
   )
   void method257(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field151[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var10;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var11 = var3.readUnsignedByte();
            if(var11 != 0) {
               this.field145[var9][var1][var2] = (short)var11;
               var10 = var3.readUnsignedByte();
               this.field154[var9][var1][var2] = (byte)(var10 >> 2);
               this.field155[var9][var1][var2] = (byte)(var10 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class25[] var14 = this.field144[var8][var1][var2] = new class25[var9];

               for(var10 = 0; var10 < var9; ++var10) {
                  int var12 = var3.__ap_310();
                  int var13 = var3.readUnsignedByte();
                  var14[var10] = new class25(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1061931388"
   )
   int method256() {
      return this.field159;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-128"
   )
   int method264() {
      return this.field147;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lhx;B)V",
      garbageValue = "-3"
   )
   static final void method293(PacketBuffer var0) {
      for(int var1 = 0; var1 < Players.__cq_n; ++var1) {
         int var2 = Players.__cq_i[var1];
         Player var3 = Client.players[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 8) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if((var4 & 64) != 0) {
            var6 = var0.__bb_317();
            int var11;
            int var12;
            int var13;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = -1;
                  var9 = -1;
                  var12 = -1;
                  var11 = var0.__ae_307();
                  if(var11 == 32767) {
                     var11 = var0.__ae_307();
                     var9 = var0.__ae_307();
                     var8 = var0.__ae_307();
                     var12 = var0.__ae_307();
                  } else if(var11 != 32766) {
                     var9 = var0.__ae_307();
                  } else {
                     var11 = -1;
                  }

                  var13 = var0.__ae_307();
                  var3.addHitSplat(var11, var9, var8, var12, Client.cycle, var13);
               }
            }

            var7 = var0.readUnsignedByteNegate();
            if(var7 > 0) {
               for(var11 = 0; var11 < var7; ++var11) {
                  var8 = var0.__ae_307();
                  var9 = var0.__ae_307();
                  if(var9 != 32767) {
                     var12 = var0.__ae_307();
                     var13 = var0.__bb_317();
                     var10 = var9 > 0?var0.readUnsignedByte():var13;
                     var3.addHealthBar(var8, Client.cycle, var9, var12, var13, var10);
                  } else {
                     var3.removeHealthBar(var8);
                  }
               }
            }
         }

         if((var4 & 512) != 0) {
            var3.spotAnimation = var0.__bm_326();
            var6 = var0.__bp_331();
            var3.heightOffset = var6 >> 16;
            var3.__bt = (var6 & 65535) + Client.cycle;
            var3.spotAnimationFrame = 0;
            var3.spotAnimationFrameCycle = 0;
            if(var3.__bt > Client.cycle) {
               var3.spotAnimationFrame = -1;
            }

            if(var3.spotAnimation == 65535) {
               var3.spotAnimation = -1;
            }
         }

         if((var4 & 4096) != 0) {
            var5 = var0.__bn_319();
         }

         if((var4 & 1024) != 0) {
            var3.__bf = var0.__bd_321();
            var3.__be = var0.__bn_319();
            var3.__bh = var0.__bn_319();
            var3.__bv = var0.__bd_321();
            var3.__bw = var0.__bu_325() + Client.cycle;
            var3.__cr = var0.__by_324() + Client.cycle;
            var3.__cv = var0.__ag_302();
            if(var3.__ag) {
               var3.__bf += var3.tileX;
               var3.__be += var3.tileY;
               var3.__bh += var3.tileX;
               var3.__bv += var3.tileY;
               var3.pathLength = 0;
            } else {
               var3.__bf += var3.pathX[0];
               var3.__be += var3.pathY[0];
               var3.__bh += var3.pathX[0];
               var3.__bv += var3.pathY[0];
               var3.pathLength = 1;
            }

            var3.__ch = 0;
         }

         if((var4 & 32) != 0) {
            var3.overheadText = var0.readStringCp1252NullTerminated();
            if(var3.overheadText.charAt(0) == '~') {
               var3.overheadText = var3.overheadText.substring(1);
               WorldMapIcon1.method219(2, var3.username.getName(), var3.overheadText);
            } else if(var3 == Canvas.localPlayer) {
               WorldMapIcon1.method219(2, var3.username.getName(), var3.overheadText);
            }

            var3.isAutoChatting = false;
            var3.overheadTextColor = 0;
            var3.overheadTextEffect = 0;
            var3.overheadTextCyclesRemaining = 150;
         }

         if((var4 & 4) != 0) {
            var3.__bc = var0.__by_324();
            if(var3.pathLength == 0) {
               var3.orientation = var3.__bc;
               var3.__bc = -1;
            }
         }

         if((var4 & 1) != 0) {
            var6 = var0.__bq_318();
            byte[] var15 = new byte[var6];
            Buffer var16 = new Buffer(var15);
            var0.__bh_333(var15, 0, var6);
            Players.__cq_o[var2] = var16;
            var3.read(var16);
         }

         if((var4 & 2) != 0) {
            var3.targetIndex = var0.__bu_325();
            if(var3.targetIndex == 65535) {
               var3.targetIndex = -1;
            }
         }

         if((var4 & 2048) != 0) {
            Players.__cq_w[var2] = var0.__bn_319();
         }

         if((var4 & 16) != 0) {
            var6 = var0.__bu_325();
            PlayerType var17 = (PlayerType)ScriptFrame.findEnumerated(class48.method865(), var0.readUnsignedByte());
            boolean var18 = var0.readUnsignedByteNegate() == 1;
            var8 = var0.readUnsignedByte();
            var9 = var0.index;
            if(var3.username != null && var3.appearance != null) {
               boolean var19 = false;
               if(var17.isUser && WorldMapArea.friendSystem.isIgnored(var3.username)) {
                  var19 = true;
               }

               if(!var19 && Client.__client_jc == 0 && !var3.isHidden) {
                  Players.__cq_a.index = 0;
                  var0.__al_305(Players.__cq_a.array, 0, var8);
                  Players.__cq_a.index = 0;
                  String var14 = AbstractFont.escapeBrackets(class233.method4527(KitDefinition.method4866(Players.__cq_a)));
                  var3.overheadText = var14.trim();
                  var3.overheadTextColor = var6 >> 8;
                  var3.overheadTextEffect = var6 & 255;
                  var3.overheadTextCyclesRemaining = 150;
                  var3.isAutoChatting = var18;
                  var3.__az = var3 != Canvas.localPlayer && var17.isUser && "" != Client.__client_pz && var14.toLowerCase().indexOf(Client.__client_pz) == -1;
                  if(var17.isPrivileged) {
                     var10 = var18?91:1;
                  } else {
                     var10 = var18?90:2;
                  }

                  if(var17.modIcon != -1) {
                     WorldMapIcon1.method219(var10, ItemContainer.method1170(var17.modIcon) + var3.username.getName(), var14);
                  } else {
                     WorldMapIcon1.method219(var10, var3.username.getName(), var14);
                  }
               }
            }

            var0.index = var9 + var8;
         }

         if((var4 & 256) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.readStringCp1252NullTerminated();
            }
         }

         if((var4 & 128) != 0) {
            var6 = var0.__ag_302();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var0.readUnsignedByte();
            class234.method4534(var3, var6, var7);
         }

         if(var3.__ag) {
            if(var5 == 127) {
               var3.resetPath(var3.tileX, var3.tileY);
            } else {
               byte var20;
               if(var5 != -1) {
                  var20 = var5;
               } else {
                  var20 = Players.__cq_w[var2];
               }

               var3.__x_130(var3.tileX, var3.tileY, var20);
            }
         }
      }

   }
}
