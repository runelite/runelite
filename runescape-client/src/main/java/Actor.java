import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("Actor")
public abstract class Actor extends Entity {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1573449469
   )
   @Export("x")
   int x;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 676600595
   )
   @Export("y")
   int y;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1439711403
   )
   @Export("__ac")
   int __ac;
   @ObfuscatedName("ay")
   @Export("__ay")
   boolean __ay;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1357622739
   )
   @Export("size")
   int size;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 141226463
   )
   @Export("playerCycle")
   int playerCycle;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -299122235
   )
   @Export("idleSequence")
   int idleSequence;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -831787909
   )
   @Export("turnLeftSequence")
   int turnLeftSequence;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1788714977
   )
   @Export("turnRightSequence")
   int turnRightSequence;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2075997699
   )
   @Export("walkSequence")
   int walkSequence;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1598871111
   )
   @Export("walkTurnSequence")
   int walkTurnSequence;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -568830521
   )
   @Export("walkTurnLeftSequence")
   int walkTurnLeftSequence;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -257240117
   )
   @Export("walkTurnRightSequence")
   int walkTurnRightSequence;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1708570917
   )
   @Export("runSequence")
   int runSequence;
   @ObfuscatedName("am")
   @Export("overheadText")
   String overheadText;
   @ObfuscatedName("an")
   @Export("isAutoChatting")
   boolean isAutoChatting;
   @ObfuscatedName("az")
   @Export("__az")
   boolean __az;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 137508815
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1905191799
   )
   @Export("overheadTextColor")
   int overheadTextColor;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 541000549
   )
   @Export("overheadTextEffect")
   int overheadTextEffect;
   @ObfuscatedName("af")
   @Export("hitSplatCount")
   byte hitSplatCount;
   @ObfuscatedName("ai")
   @Export("hitSplatTypes")
   int[] hitSplatTypes;
   @ObfuscatedName("ba")
   @Export("hitSplatValues")
   int[] hitSplatValues;
   @ObfuscatedName("bb")
   @Export("hitSplatCycles")
   int[] hitSplatCycles;
   @ObfuscatedName("bs")
   @Export("hitSplatTypes2")
   int[] hitSplatTypes2;
   @ObfuscatedName("bq")
   @Export("hitSplatValues2")
   int[] hitSplatValues2;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("healthBars")
   IterableNodeDeque healthBars;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1387109107
   )
   @Export("targetIndex")
   int targetIndex;
   @ObfuscatedName("bd")
   @Export("false0")
   boolean false0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 139384875
   )
   @Export("__bc")
   int __bc;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1614854211
   )
   @Export("movementSequence")
   int movementSequence;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1119758739
   )
   @Export("movementFrame")
   int movementFrame;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1646413227
   )
   @Export("movementFrameCycle")
   int movementFrameCycle;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 323216015
   )
   @Export("sequence")
   int sequence;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1425662251
   )
   @Export("sequenceFrame")
   int sequenceFrame;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1753867715
   )
   @Export("sequenceFrameCycle")
   int sequenceFrameCycle;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -134491649
   )
   @Export("sequenceDelay")
   int sequenceDelay;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1523249259
   )
   @Export("__bj")
   int __bj;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -220610999
   )
   @Export("spotAnimation")
   int spotAnimation;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2125404733
   )
   @Export("spotAnimationFrame")
   int spotAnimationFrame;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 330334599
   )
   @Export("spotAnimationFrameCycle")
   int spotAnimationFrameCycle;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 886371765
   )
   @Export("__bt")
   int __bt;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -779457309
   )
   @Export("heightOffset")
   int heightOffset;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 2121599561
   )
   @Export("__bf")
   int __bf;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 280591281
   )
   @Export("__bh")
   int __bh;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 837989037
   )
   @Export("__be")
   int __be;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1857513783
   )
   @Export("__bv")
   int __bv;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1630403001
   )
   @Export("__bw")
   int __bw;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1367256299
   )
   @Export("__cr")
   int __cr;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1723834619
   )
   @Export("__cv")
   int __cv;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 2051334073
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1003085333
   )
   @Export("defaultHeight")
   int defaultHeight;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1189634367
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1252341007
   )
   @Export("__cm")
   int __cm;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -336931157
   )
   @Export("__cj")
   int __cj;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -2033082375
   )
   @Export("pathLength")
   int pathLength;
   @ObfuscatedName("cb")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ck")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cn")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1583514013
   )
   @Export("__cq")
   int __cq;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1584102533
   )
   @Export("__ch")
   int __ch;

   Actor() {
      this.__ay = false;
      this.size = 1;
      this.idleSequence = -1;
      this.turnLeftSequence = -1;
      this.turnRightSequence = -1;
      this.walkSequence = -1;
      this.walkTurnSequence = -1;
      this.walkTurnLeftSequence = -1;
      this.walkTurnRightSequence = -1;
      this.runSequence = -1;
      this.overheadText = null;
      this.__az = false;
      this.overheadTextCyclesRemaining = 100;
      this.overheadTextColor = 0;
      this.overheadTextEffect = 0;
      this.hitSplatCount = 0;
      this.hitSplatTypes = new int[4];
      this.hitSplatValues = new int[4];
      this.hitSplatCycles = new int[4];
      this.hitSplatTypes2 = new int[4];
      this.hitSplatValues2 = new int[4];
      this.healthBars = new IterableNodeDeque();
      this.targetIndex = -1;
      this.false0 = false;
      this.__bc = -1;
      this.movementSequence = -1;
      this.movementFrame = 0;
      this.movementFrameCycle = 0;
      this.sequence = -1;
      this.sequenceFrame = 0;
      this.sequenceFrameCycle = 0;
      this.sequenceDelay = 0;
      this.__bj = 0;
      this.spotAnimation = -1;
      this.spotAnimationFrame = 0;
      this.spotAnimationFrameCycle = 0;
      this.npcCycle = 0;
      this.defaultHeight = 200;
      this.__cm = 0;
      this.__cj = 32;
      this.pathLength = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.__cq = 0;
      this.__ch = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean isVisible() {
      return false;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1415393262"
   )
   @Export("__bb_143")
   final void __bb_143() {
      this.pathLength = 0;
      this.__ch = 0;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1925126781"
   )
   @Export("addHitSplat")
   final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitSplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         HitSplatDefinition var12 = class72.getHitSplatDefinition(var1);
         var10 = var12.__c;
         var11 = var12.__i;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.hitSplatCycles[0];
         } else if(var10 == 1) {
            var14 = this.hitSplatValues[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitSplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitSplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitSplatValues[var13] < var14) {
               var9 = var13;
               var14 = this.hitSplatValues[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.hitSplatCount = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.hitSplatCount;
            this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
            if(this.hitSplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.hitSplatTypes[var9] = var1;
         this.hitSplatValues[var9] = var2;
         this.hitSplatTypes2[var9] = var3;
         this.hitSplatValues2[var9] = var4;
         this.hitSplatCycles[var9] = var5 + var11 + var6;
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "27"
   )
   @Export("addHealthBar")
   final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
      HealthBarDefinition var7 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var8;
      if(var7 != null) {
         var8 = var7;
      } else {
         byte[] var9 = HealthBarDefinition.__ii_m.takeRecord(33, var1);
         var7 = new HealthBarDefinition();
         if(var9 != null) {
            var7.read(new Buffer(var9));
         }

         HealthBarDefinition.HealthBarDefinition_cached.put(var7, (long)var1);
         var8 = var7;
      }

      var7 = var8;
      HealthBar var14 = null;
      HealthBar var10 = null;
      int var11 = var8.int2;
      int var12 = 0;

      HealthBar var13;
      for(var13 = (HealthBar)this.healthBars.last(); var13 != null; var13 = (HealthBar)this.healthBars.previous()) {
         ++var12;
         if(var13.definition.__o == var7.__o) {
            var13.put(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.definition.int1 <= var7.int1) {
            var14 = var13;
         }

         if(var13.definition.int2 > var11) {
            var10 = var13;
            var11 = var13.definition.int2;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new HealthBar(var7);
         if(var14 == null) {
            this.healthBars.addLast(var13);
         } else {
            IterableNodeDeque.IterableNodeDeque_addBefore(var13, var14);
         }

         var13.put(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.remove();
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-31198"
   )
   @Export("removeHealthBar")
   final void removeHealthBar(int var1) {
      HealthBarDefinition var2 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var3;
      if(var2 != null) {
         var3 = var2;
      } else {
         byte[] var4 = HealthBarDefinition.__ii_m.takeRecord(33, var1);
         var2 = new HealthBarDefinition();
         if(var4 != null) {
            var2.read(new Buffer(var4));
         }

         HealthBarDefinition.HealthBarDefinition_cached.put(var2, (long)var1);
         var3 = var2;
      }

      var2 = var3;

      for(HealthBar var5 = (HealthBar)this.healthBars.last(); var5 != null; var5 = (HealthBar)this.healthBars.previous()) {
         if(var2 == var5.definition) {
            var5.remove();
            return;
         }
      }

   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "493234011"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketBufferNode var8;
      if(var2 == 1) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_an, Client.packetWriter.isaacCipher);
         var8.packetBuffer.__bx_323(GraphicsObject.baseY + var1);
         var8.packetBuffer.writeShortLE(HealthBarDefinition.selectedItemSlot);
         var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         var8.packetBuffer.writeIntLE(ServerPacket.selectedItemWidget);
         var8.packetBuffer.__bx_323(var0 + class50.baseX);
         var8.packetBuffer.writeShort(var3);
         var8.packetBuffer.writeShortLE(MenuAction.selectedItemId);
         Client.packetWriter.__q_167(var8);
      } else if(var2 == 2) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_cg, Client.packetWriter.isaacCipher);
         var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         var8.packetBuffer.writeShort(var0 + class50.baseX);
         var8.packetBuffer.__bo_322(var3);
         var8.packetBuffer.writeIntLE16(ServerBuild.__iy_lo);
         var8.packetBuffer.writeShort(Client.__client_lc);
         var8.packetBuffer.writeShortLE(GraphicsObject.baseY + var1);
         Client.packetWriter.__q_167(var8);
      } else if(var2 == 3) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_d, Client.packetWriter.isaacCipher);
         var8.packetBuffer.writeShort(GraphicsObject.baseY + var1);
         var8.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         var8.packetBuffer.__bo_322(var3);
         var8.packetBuffer.__bx_323(var0 + class50.baseX);
         Client.packetWriter.__q_167(var8);
      } else if(var2 == 4) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_cv, Client.packetWriter.isaacCipher);
         var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         var8.packetBuffer.writeShort(var3);
         var8.packetBuffer.writeShort(GraphicsObject.baseY + var1);
         var8.packetBuffer.writeShort(var0 + class50.baseX);
         Client.packetWriter.__q_167(var8);
      } else if(var2 == 5) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_cq, Client.packetWriter.isaacCipher);
         var8.packetBuffer.__bx_323(var0 + class50.baseX);
         var8.packetBuffer.__bo_322(var3);
         var8.packetBuffer.__bx_323(GraphicsObject.baseY + var1);
         var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         Client.packetWriter.__q_167(var8);
      } else if(var2 == 6) {
         Client.mouseCrossX = var6;
         Client.mouseCrossY = var7;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Interpreter.method1915(ClientPacket.__gs_w, Client.packetWriter.isaacCipher);
         var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
         var8.packetBuffer.__bo_322(GraphicsObject.baseY + var1);
         var8.packetBuffer.__bo_322(var0 + class50.baseX);
         var8.packetBuffer.writeShortLE(var3);
         Client.packetWriter.__q_167(var8);
      } else {
         PacketBufferNode var9;
         NPC var10;
         if(var2 == 7) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_r, Client.packetWriter.isaacCipher);
               var9.packetBuffer.__bx_323(MenuAction.selectedItemId);
               var9.packetBuffer.writeShort(HealthBarDefinition.selectedItemSlot);
               var9.packetBuffer.__bx_323(var3);
               var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var9.packetBuffer.writeInt(ServerPacket.selectedItemWidget);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 8) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_cb, Client.packetWriter.isaacCipher);
               var9.packetBuffer.__bx_323(var3);
               var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var9.packetBuffer.writeIntLE(ServerBuild.__iy_lo);
               var9.packetBuffer.__bo_322(Client.__client_lc);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 9) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_bt, Client.packetWriter.isaacCipher);
               var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var9.packetBuffer.writeShortLE(var3);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 10) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_f, Client.packetWriter.isaacCipher);
               var9.packetBuffer.__bo_322(var3);
               var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 11) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_ah, Client.packetWriter.isaacCipher);
               var9.packetBuffer.__bx_323(var3);
               var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 12) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_bc, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var9);
            }
         } else if(var2 == 13) {
            var10 = Client.npcs[var3];
            if(var10 != null) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Interpreter.method1915(ClientPacket.__gs_ac, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var9.packetBuffer.__bo_322(var3);
               Client.packetWriter.__q_167(var9);
            }
         } else {
            Player var11;
            if(var2 == 14) {
               var11 = Client.players[var3];
               if(var11 != null) {
                  Client.mouseCrossX = var6;
                  Client.mouseCrossY = var7;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = Interpreter.method1915(ClientPacket.__gs_cy, Client.packetWriter.isaacCipher);
                  var9.packetBuffer.__bx_323(HealthBarDefinition.selectedItemSlot);
                  var9.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  var9.packetBuffer.writeIntME(ServerPacket.selectedItemWidget);
                  var9.packetBuffer.writeShort(var3);
                  var9.packetBuffer.writeShort(MenuAction.selectedItemId);
                  Client.packetWriter.__q_167(var9);
               }
            } else if(var2 == 15) {
               var11 = Client.players[var3];
               if(var11 != null) {
                  Client.mouseCrossX = var6;
                  Client.mouseCrossY = var7;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = Interpreter.method1915(ClientPacket.__gs_bq, Client.packetWriter.isaacCipher);
                  var9.packetBuffer.writeIntLE16(ServerBuild.__iy_lo);
                  var9.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  var9.packetBuffer.__bo_322(Client.__client_lc);
                  var9.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var9);
               }
            } else if(var2 == 16) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_t, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeIntME(ServerPacket.selectedItemWidget);
               var8.packetBuffer.__bx_323(MenuAction.selectedItemId);
               var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var8.packetBuffer.writeShortLE(HealthBarDefinition.selectedItemSlot);
               var8.packetBuffer.__bx_323(var3);
               var8.packetBuffer.__bx_323(var0 + class50.baseX);
               var8.packetBuffer.writeShortLE(GraphicsObject.baseY + var1);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 17) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_bb, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeIntME(ServerBuild.__iy_lo);
               var8.packetBuffer.writeShort(Client.__client_lc);
               var8.packetBuffer.__bo_322(GraphicsObject.baseY + var1);
               var8.packetBuffer.__bo_322(var0 + class50.baseX);
               var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var8.packetBuffer.writeShortLE(var3);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 18) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_u, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__bx_323(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.writeShortLE(var0 + class50.baseX);
               var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 19) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_bh, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__bx_323(var3);
               var8.packetBuffer.__bo_322(var0 + class50.baseX);
               var8.packetBuffer.writeShort(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 20) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_g, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShortLE(GraphicsObject.baseY + var1);
               var8.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var8.packetBuffer.writeShortLE(var0 + class50.baseX);
               var8.packetBuffer.writeShortLE(var3);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 21) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_av, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__bo_322(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.writeShort(var0 + class50.baseX);
               var8.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 22) {
               Client.mouseCrossX = var6;
               Client.mouseCrossY = var7;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Interpreter.method1915(ClientPacket.__gs_ai, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
               var8.packetBuffer.__bx_323(var3);
               var8.packetBuffer.__bo_322(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeShort(var0 + class50.baseX);
               Client.packetWriter.__q_167(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class65.scene.__as_250();
               } else {
                  class65.scene.menuOpen(SoundSystem.plane, var0, var1, true);
               }
            } else {
               PacketBufferNode var12;
               Widget var13;
               if(var2 == 24) {
                  var13 = Huffman.getWidget(var1);
                  boolean var14 = true;
                  if(var13.contentType > 0) {
                     var14 = ViewportMouse.method2957(var13);
                  }

                  if(var14) {
                     var12 = Interpreter.method1915(ClientPacket.__gs_bz, Client.packetWriter.isaacCipher);
                     var12.packetBuffer.writeInt(var1);
                     Client.packetWriter.__q_167(var12);
                  }
               } else {
                  if(var2 == 25) {
                     var13 = class204.getWidgetChild(var1, var0);
                     if(var13 != null) {
                        Player.method1281();
                        class25.method350(var1, var0, class211.method4107(class1.getWidgetClickMask(var13)), var13.itemId);
                        Client.isItemSelected = 0;
                        Client.selectedSpellActionName = class198.method3745(var13);
                        if(Client.selectedSpellActionName == null) {
                           Client.selectedSpellActionName = "null";
                        }

                        if(var13.isIf3) {
                           Client.selectedSpellName = var13.dataText + BufferedFile.colorStartTag(16777215);
                        } else {
                           Client.selectedSpellName = BufferedFile.colorStartTag(65280) + var13.spellName + BufferedFile.colorStartTag(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     WorldMapLabelSize.method198();
                  } else {
                     Widget var15;
                     int var17;
                     if(var2 == 28) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_bz, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeInt(var1);
                        Client.packetWriter.__q_167(var8);
                        var15 = Huffman.getWidget(var1);
                        if(var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var17 = var15.cs1Instructions[0][1];
                           Varps.Varps_main[var17] = 1 - Varps.Varps_main[var17];
                           IndexCache.method4703(var17);
                        }
                     } else if(var2 == 29) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_bz, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeInt(var1);
                        Client.packetWriter.__q_167(var8);
                        var15 = Huffman.getWidget(var1);
                        if(var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var17 = var15.cs1Instructions[0][1];
                           if(Varps.Varps_main[var17] != var15.cs1ComparisonValues[0]) {
                              Varps.Varps_main[var17] = var15.cs1ComparisonValues[0];
                              IndexCache.method4703(var17);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.__client_mo == null) {
                           TilePaint.method3060(var1, var0);
                           Client.__client_mo = class204.getWidgetChild(var1, var0);
                           class22.method295(Client.__client_mo);
                        }
                     } else if(var2 == 31) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_bu, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeIntME(var1);
                        var8.packetBuffer.writeIntLE16(ServerPacket.selectedItemWidget);
                        var8.packetBuffer.__bx_323(HealthBarDefinition.selectedItemSlot);
                        var8.packetBuffer.writeShortLE(MenuAction.selectedItemId);
                        var8.packetBuffer.writeShortLE(var0);
                        var8.packetBuffer.__bx_323(var3);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 32) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_q, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeIntME(ServerBuild.__iy_lo);
                        var8.packetBuffer.writeInt(var1);
                        var8.packetBuffer.writeShort(var0);
                        var8.packetBuffer.writeShortLE(var3);
                        var8.packetBuffer.writeShortLE(Client.__client_lc);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 33) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_ck, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeShortLE(var3);
                        var8.packetBuffer.writeIntME(var1);
                        var8.packetBuffer.writeShort(var0);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 34) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_cc, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.__bo_322(var3);
                        var8.packetBuffer.writeIntLE16(var1);
                        var8.packetBuffer.__bx_323(var0);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 35) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_bp, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeIntLE(var1);
                        var8.packetBuffer.__bx_323(var0);
                        var8.packetBuffer.__bx_323(var3);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 36) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_l, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.__bx_323(var3);
                        var8.packetBuffer.writeInt(var1);
                        var8.packetBuffer.__bx_323(var0);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else if(var2 == 37) {
                        var8 = Interpreter.method1915(ClientPacket.__gs_bd, Client.packetWriter.isaacCipher);
                        var8.packetBuffer.writeInt(var1);
                        var8.packetBuffer.writeShort(var0);
                        var8.packetBuffer.writeShort(var3);
                        Client.packetWriter.__q_167(var8);
                        Client.__client_ju = 0;
                        BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                        Client.__client_jz = var0;
                     } else {
                        if(var2 == 38) {
                           Player.method1281();
                           var13 = Huffman.getWidget(var1);
                           Client.isItemSelected = 1;
                           HealthBarDefinition.selectedItemSlot = var0;
                           ServerPacket.selectedItemWidget = var1;
                           MenuAction.selectedItemId = var3;
                           class22.method295(var13);
                           Client.selectedItemName = BufferedFile.colorStartTag(16748608) + Skills.getItemDefinition(var3).name + BufferedFile.colorStartTag(16777215);
                           if(Client.selectedItemName == null) {
                              Client.selectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = Interpreter.method1915(ClientPacket.__gs_au, Client.packetWriter.isaacCipher);
                           var8.packetBuffer.__bx_323(var3);
                           var8.packetBuffer.writeIntLE16(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           Client.packetWriter.__q_167(var8);
                           Client.__client_ju = 0;
                           BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                           Client.__client_jz = var0;
                        } else if(var2 == 40) {
                           var8 = Interpreter.method1915(ClientPacket.__gs_ag, Client.packetWriter.isaacCipher);
                           var8.packetBuffer.writeIntLE16(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           var8.packetBuffer.__bo_322(var3);
                           Client.packetWriter.__q_167(var8);
                           Client.__client_ju = 0;
                           BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                           Client.__client_jz = var0;
                        } else if(var2 == 41) {
                           var8 = Interpreter.method1915(ClientPacket.__gs_bl, Client.packetWriter.isaacCipher);
                           var8.packetBuffer.writeIntLE(var1);
                           var8.packetBuffer.__bo_322(var0);
                           var8.packetBuffer.writeShort(var3);
                           Client.packetWriter.__q_167(var8);
                           Client.__client_ju = 0;
                           BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                           Client.__client_jz = var0;
                        } else if(var2 == 42) {
                           var8 = Interpreter.method1915(ClientPacket.__gs_bm, Client.packetWriter.isaacCipher);
                           var8.packetBuffer.writeInt(var1);
                           var8.packetBuffer.__bo_322(var0);
                           var8.packetBuffer.writeShort(var3);
                           Client.packetWriter.__q_167(var8);
                           Client.__client_ju = 0;
                           BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                           Client.__client_jz = var0;
                        } else if(var2 == 43) {
                           var8 = Interpreter.method1915(ClientPacket.__gs_ay, Client.packetWriter.isaacCipher);
                           var8.packetBuffer.writeShort(var3);
                           var8.packetBuffer.writeIntME(var1);
                           var8.packetBuffer.writeShort(var0);
                           Client.packetWriter.__q_167(var8);
                           Client.__client_ju = 0;
                           BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                           Client.__client_jz = var0;
                        } else if(var2 == 44) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_ao, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShort(var3);
                              var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 45) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_bn, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var9.packetBuffer.__bo_322(var3);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 46) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_by, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__bo_322(var3);
                              var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 47) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_aq, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__bx_323(var3);
                              var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 48) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_cm, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var9.packetBuffer.__bo_322(var3);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 49) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_cf, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__bo_322(var3);
                              var9.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 50) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_be, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__ba_316(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else if(var2 == 51) {
                           var11 = Client.players[var3];
                           if(var11 != null) {
                              Client.mouseCrossX = var6;
                              Client.mouseCrossY = var7;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Interpreter.method1915(ClientPacket.__gs_af, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.__ai_315(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var9.packetBuffer.__bx_323(var3);
                              Client.packetWriter.__q_167(var9);
                           }
                        } else {
                           label415: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var13 = class204.getWidgetChild(var1, var0);
                                    if(var13 != null) {
                                       var9 = Interpreter.method1915(ClientPacket.__gs_cs, Client.packetWriter.isaacCipher);
                                       var9.packetBuffer.writeShortLE(Client.__client_lc);
                                       var9.packetBuffer.writeIntLE16(var1);
                                       var9.packetBuffer.writeShortLE(Client.__client_mh);
                                       var9.packetBuffer.__bx_323(var0);
                                       var9.packetBuffer.writeInt(ServerBuild.__iy_lo);
                                       var9.packetBuffer.__bx_323(var13.itemId);
                                       Client.packetWriter.__q_167(var9);
                                    }
                                    break label415;
                                 }

                                 if(var2 == 1001) {
                                    Client.mouseCrossX = var6;
                                    Client.mouseCrossY = var7;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = Interpreter.method1915(ClientPacket.__gs_cp, Client.packetWriter.isaacCipher);
                                    var8.packetBuffer.writeShort(var3);
                                    var8.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                    var8.packetBuffer.__bo_322(var0 + class50.baseX);
                                    var8.packetBuffer.__bx_323(GraphicsObject.baseY + var1);
                                    Client.packetWriter.__q_167(var8);
                                    break label415;
                                 }

                                 if(var2 == 1002) {
                                    Client.mouseCrossX = var6;
                                    Client.mouseCrossY = var7;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var8 = Interpreter.method1915(ClientPacket.__gs_al, Client.packetWriter.isaacCipher);
                                    var8.packetBuffer.__bo_322(var3);
                                    Client.packetWriter.__q_167(var8);
                                    break label415;
                                 }

                                 if(var2 == 1003) {
                                    Client.mouseCrossX = var6;
                                    Client.mouseCrossY = var7;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var10 = Client.npcs[var3];
                                    if(var10 != null) {
                                       NPCDefinition var16 = var10.definition;
                                       if(var16.transforms != null) {
                                          var16 = var16.transform();
                                       }

                                       if(var16 != null) {
                                          var12 = Interpreter.method1915(ClientPacket.__gs_ar, Client.packetWriter.isaacCipher);
                                          var12.packetBuffer.__bo_322(var16.id);
                                          Client.packetWriter.__q_167(var12);
                                       }
                                    }
                                    break label415;
                                 }

                                 if(var2 == 1004) {
                                    Client.mouseCrossX = var6;
                                    Client.mouseCrossY = var7;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var8 = Interpreter.method1915(ClientPacket.__gs_p, Client.packetWriter.isaacCipher);
                                    var8.packetBuffer.writeShortLE(var3);
                                    Client.packetWriter.__q_167(var8);
                                    break label415;
                                 }

                                 if(var2 == 1005) {
                                    var13 = Huffman.getWidget(var1);
                                    if(var13 != null && var13.itemQuantities[var0] >= 100000) {
                                       WorldMapIcon1.method219(27, "", var13.itemQuantities[var0] + " x " + Skills.getItemDefinition(var3).name);
                                    } else {
                                       var9 = Interpreter.method1915(ClientPacket.__gs_p, Client.packetWriter.isaacCipher);
                                       var9.packetBuffer.writeShortLE(var3);
                                       Client.packetWriter.__q_167(var9);
                                    }

                                    Client.__client_ju = 0;
                                    BoundaryObject.__ej_jv = Huffman.getWidget(var1);
                                    Client.__client_jz = var0;
                                    break label415;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1008 || var2 == 1011 || var2 == 1010 || var2 == 1009 || var2 == 1012) {
                                       class60.worldMap0.menuAction(var2, var3, new TileLocation(var0), new TileLocation(var1));
                                    }
                                    break label415;
                                 }
                              }

                              var13 = class204.getWidgetChild(var1, var0);
                              if(var13 != null) {
                                 class171.method3494(var3, var1, var0, var13.itemId, var5);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.isItemSelected != 0) {
         Client.isItemSelected = 0;
         class22.method295(Huffman.getWidget(ServerPacket.selectedItemWidget));
      }

      if(Client.isSpellSelected) {
         Player.method1281();
      }

      if(BoundaryObject.__ej_jv != null && Client.__client_ju == 0) {
         class22.method295(BoundaryObject.__ej_jv);
      }

   }
}
