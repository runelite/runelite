import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("au")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static Buffer field620;
   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field616;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field614;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -835264019
   )
   int field619;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -288640331
   )
   int field612;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1799009057
   )
   int field610;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1879833797
   )
   int field611;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2014094369
   )
   int field609;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1268241735
   )
   int field618;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -613760999
   )
   int field613;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1902350965
   )
   int field617;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -729577629
   )
   int field608;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 373242119
   )
   int field615;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-1713"
   )
   public boolean vmethod676(int var1, int var2) {
      return var1 >= (this.field612 << 6) + (this.field610 << 3) && var1 <= (this.field612 << 6) + (this.field610 << 3) + 7 && var2 >= (this.field613 << 6) + (this.field617 << 3) && var2 <= (this.field613 << 6) + (this.field617 << 3) + 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-762941504"
   )
   public boolean vmethod675(int var1, int var2, int var3) {
      return var1 >= this.field619 && var1 < this.field611 + this.field619?var2 >= (this.field609 << 6) + (this.field618 << 3) && var2 <= (this.field618 << 3) + (this.field609 << 6) + 7 && var3 >= (this.field608 << 6) + (this.field615 << 3) && var3 <= (this.field608 << 6) + (this.field615 << 3) + 7:false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lab;S)V",
      garbageValue = "-29128"
   )
   public void vmethod693(WorldMapData var1) {
      if(var1.field443 > this.field612) {
         var1.field443 = this.field612;
      }

      if(var1.field444 < this.field612) {
         var1.field444 = this.field612;
      }

      if(var1.field442 > this.field613) {
         var1.field442 = this.field613;
      }

      if(var1.field435 < this.field613) {
         var1.field435 = this.field613;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "861336956"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod676(var1, var2)) {
         return null;
      } else {
         int var3 = this.field609 * 64 - this.field612 * 64 + var1 + (this.field618 * 8 - this.field610 * 8);
         int var4 = this.field615 * 8 - this.field617 * 8 + this.field608 * 64 - this.field613 * 64 + var2;
         return new Coordinates(this.field619, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1119600547"
   )
   public int[] vmethod677(int var1, int var2, int var3) {
      if(!this.vmethod675(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field610 * 8 - this.field618 * 8 + this.field612 * 64 - this.field609 * 64 + var2, this.field617 * 8 - this.field615 * 8 + var3 + (this.field613 * 64 - this.field608 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-58"
   )
   public void vmethod678(Buffer var1) {
      this.field619 = var1.readUnsignedByte();
      this.field611 = var1.readUnsignedByte();
      this.field609 = var1.readUnsignedShort();
      this.field618 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field615 = var1.readUnsignedByte();
      this.field612 = var1.readUnsignedShort();
      this.field610 = var1.readUnsignedByte();
      this.field613 = var1.readUnsignedShort();
      this.field617 = var1.readUnsignedByte();
      this.method673();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2146447265"
   )
   void method673() {
   }

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1502527516"
   )
   static final void method674() {
      if(class13.rssocket != null) {
         class13.rssocket.close();
         class13.rssocket = null;
      }

      class5.method17();
      class19.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class112.method2031(2);
      Client.field1140 = -1;
      Client.field1141 = false;

      for(class82 var1 = (class82)class82.field1311.getFront(); var1 != null; var1 = (class82)class82.field1311.getNext()) {
         if(var1.field1308 != null) {
            class1.field4.method1809(var1.field1308);
            var1.field1308 = null;
         }

         if(var1.field1316 != null) {
            class1.field4.method1809(var1.field1316);
            var1.field1316 = null;
         }
      }

      class82.field1311.clear();
      class152.setGameState(10);

      try {
         Client var3 = CombatInfoListHolder.clientInstance;
         JSObject.getWindow(var3).call("loggedout", (Object[])null);
      } catch (Throwable var2) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILfz;Lix;I)V",
      garbageValue = "-1960331279"
   )
   static void method699(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3207;
      synchronized(class236.field3207) {
         for(FileSystem var5 = (FileSystem)class236.field3207.getFront(); var5 != null; var5 = (FileSystem)class236.field3207.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.field3171 == 0) {
               var3 = var5.field3170;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4124(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2938(var0);
         var2.method4124(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   static void method698() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field984[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087461453"
   )
   static void method685() {
      for(class82 var0 = (class82)class82.field1311.getFront(); var0 != null; var0 = (class82)class82.field1311.getNext()) {
         if(var0.field1310 != null) {
            var0.method1560();
         }
      }

   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "15493634"
   )
   static final void method690() {
      for(int var0 = 0; var0 < Client.pendingNpcFlagsCount; ++var0) {
         int var1 = Client.pendingNpcFlagsIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.secretPacketBuffer2.readUnsignedByte();
         if((var3 & 4) != 0) {
            var2.interacting = Client.secretPacketBuffer2.method3132();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 64) != 0) {
            var4 = Client.secretPacketBuffer2.method3132();
            var5 = Client.secretPacketBuffer2.method3132();
            var6 = var2.x - (var4 - class21.baseX - class21.baseX) * 64;
            var7 = var2.y - (var5 - class164.baseY - class164.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field1237 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 32) != 0) {
            var2.composition = WorldMapType3.getNpcDefinition(Client.secretPacketBuffer2.method3132());
            var2.field1213 = var2.composition.field3532;
            var2.field1232 = var2.composition.field3555;
            var2.field1217 = var2.composition.field3538;
            var2.field1264 = var2.composition.field3539;
            var2.field1244 = var2.composition.field3540;
            var2.field1220 = var2.composition.field3541;
            var2.idlePoseAnimation = var2.composition.field3547;
            var2.field1215 = var2.composition.field3550;
            var2.field1216 = var2.composition.field3537;
         }

         if((var3 & 1) != 0) {
            var4 = Client.secretPacketBuffer2.method3122();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.secretPacketBuffer2.getUSmart();
                  if(var6 == 32767) {
                     var6 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var6 != 32766) {
                     var8 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.secretPacketBuffer2.getUSmart();
                  var2.method1487(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.secretPacketBuffer2.readUnsignedByte();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  if(var8 != 32767) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.readUnsignedByte();
                     int var11 = var8 > 0?Client.secretPacketBuffer2.method3280():var10;
                     var2.method1477(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method1478(var7);
                  }
               }
            }
         }

         if((var3 & 2) != 0) {
            var4 = Client.secretPacketBuffer2.readByteOb1();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.secretPacketBuffer2.method3122();
            if(var4 == var2.animation && var4 != -1) {
               var6 = class31.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field1243 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field1245 = 0;
               }

               if(var6 == 2) {
                  var2.field1245 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class31.getAnimation(var4).forcedPriority >= class31.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field1243 = 0;
               var2.actionAnimationDisable = var5;
               var2.field1245 = 0;
               var2.field1219 = var2.queueSize;
            }
         }

         if((var3 & 16) != 0) {
            var2.graphic = Client.secretPacketBuffer2.readUnsignedShort();
            var4 = Client.secretPacketBuffer2.method3141();
            var2.field1250 = var4 >> 16;
            var2.graphicsDelay = (var4 & '\uffff') + Client.gameCycle;
            var2.field1247 = 0;
            var2.field1248 = 0;
            if(var2.graphicsDelay > Client.gameCycle) {
               var2.field1247 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.overhead = Client.secretPacketBuffer2.readString();
            var2.field1225 = 100;
         }
      }

   }
}
