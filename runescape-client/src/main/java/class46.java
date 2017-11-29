import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class46 {
   @ObfuscatedName("z")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   static SpritePixels[] field570;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 34044409
   )
   int field568;
   @ObfuscatedName("x")
   byte[][][] field565;

   class46(int var1) {
      this.field568 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-896363624"
   )
   void method667(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field568 != 0 && this.field565 != null) {
         var8 = this.method668(var8, var7);
         var7 = this.method669(var7);
         Rasterizer2D.method5188(var1, var2, var5, var6, var3, var4, this.field565[var7 - 1][var8], this.field568);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1652664361"
   )
   int method668(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-2"
   )
   int method669(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-596088469"
   )
   void method707() {
      if(this.field565 == null) {
         this.field565 = new byte[8][4][];
         this.method671();
         this.method700();
         this.method673();
         this.method674();
         this.method686();
         this.method676();
         this.method677();
         this.method681();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-830293634"
   )
   void method671() {
      byte[] var1 = new byte[this.field568 * this.field568];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[0][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[0][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[0][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[0][3] = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   void method700() {
      byte[] var1 = new byte[this.field568 * this.field568];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[1][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field565[1][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[1][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[1][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "805992487"
   )
   void method673() {
      byte[] var1 = new byte[this.field568 * this.field568];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[2][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[2][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[2][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[2][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "862949605"
   )
   void method674() {
      byte[] var1 = new byte[this.field568 * this.field568];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[3][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[3][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[3][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[3][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1332043498"
   )
   void method686() {
      byte[] var1 = new byte[this.field568 * this.field568];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[4][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[4][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[4][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var2 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field565[4][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1478148415"
   )
   void method676() {
      byte[] var1 = new byte[this.field568 * this.field568];
      boolean var2 = false;
      var1 = new byte[this.field568 * this.field568];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[5][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var3 <= this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[5][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[5][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var3 >= this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[5][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   void method677() {
      byte[] var1 = new byte[this.field568 * this.field568];
      boolean var2 = false;
      var1 = new byte[this.field568 * this.field568];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[6][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 <= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[6][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[6][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[6][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   void method681() {
      byte[] var1 = new byte[this.field568 * this.field568];
      boolean var2 = false;
      var1 = new byte[this.field568 * this.field568];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[7][0] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field568; ++var4) {
            if(var4 >= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[7][1] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = this.field568 - 1; var3 >= 0; --var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[7][2] = var1;
      var1 = new byte[this.field568 * this.field568];
      var5 = 0;

      for(var3 = 0; var3 < this.field568; ++var3) {
         for(var4 = this.field568 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field568 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field565[7][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "30826676"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(ScriptState.listFetcher == null) {
            ScriptState.listFetcher = class221.urlRequester.request(new URL(InvType.field3356));
         } else if(ScriptState.listFetcher.isDone()) {
            byte[] var0 = ScriptState.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            MouseRecorder.method1127(World.worldList, 0, World.worldList.length - 1, World.field1220, World.field1219);
            ScriptState.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         ScriptState.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldt;",
      garbageValue = "1647619938"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(WidgetNode.field793, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(DynamicObject.field1459 == 33) {
         var4 = "_rc";
      } else if(DynamicObject.field1459 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(Enum.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;Ljava/lang/String;I)[Lky;",
      garbageValue = "1481371132"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Friend.method1108(var0, var3, var4);
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "252012134"
   )
   static void method706(int var0, int var1, int var2) {
      if(Client.field1009 != 0 && var1 != 0 && Client.field985 < 50) {
         Client.field970[Client.field985] = var0;
         Client.field1096[Client.field985] = var1;
         Client.field930[Client.field985] = var2;
         Client.audioEffects[Client.field985] = null;
         Client.field1098[Client.field985] = 0;
         ++Client.field985;
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(ZLgv;I)V",
      garbageValue = "-1940486671"
   )
   static final void method705(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field916.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5 = var1.getBits(1);
               var4.composition = class1.getNpcDefinition(var1.getBits(14));
               int var6;
               if(var0) {
                  var6 = var1.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = var1.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = var1.getBits(1);
               if(var7 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var8;
               if(var0) {
                  var8 = var1.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               int var9 = Client.field944[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var9;
               }

               var4.field1147 = var4.composition.field3619;
               var4.field1199 = var4.composition.field3613;
               if(var4.field1199 == 0) {
                  var4.angle = 0;
               }

               var4.field1154 = var4.composition.field3641;
               var4.field1155 = var4.composition.field3617;
               var4.field1156 = var4.composition.field3640;
               var4.field1157 = var4.composition.field3628;
               var4.idlePoseAnimation = var4.composition.field3622;
               var4.field1152 = var4.composition.field3623;
               var4.field1153 = var4.composition.field3624;
               var4.method1738(class181.localPlayer.pathX[0] + var6, class181.localPlayer.pathY[0] + var8, var5 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
