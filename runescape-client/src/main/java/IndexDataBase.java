import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1616261181
   )
   static int field3198;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 539733011
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("x")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("o")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("r")
   Object[] field3192;
   @ObfuscatedName("w")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("t")
   boolean field3195;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgb;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1642671775
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("m")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("s")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("a")
   boolean field3197;
   @ObfuscatedName("g")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -691597279
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("i")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("p")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3198 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3195 = var1;
      this.field3197 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-171381566"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4023(var1, var3);
            if(!var4) {
               this.vmethod4129(var1);
               var4 = this.method4023(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = WorldMapType1.toByteArray(this.childs[var1][var2], false);
         if(this.field3197) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2044241239"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-1"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4023(var1, (int[])null);
            if(!var3) {
               this.vmethod4129(var1);
               var3 = this.method4023(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = WorldMapType1.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "83"
   )
   void vmethod4129(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-447625167"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "7"
   )
   public byte[] method4016(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-6"
   )
   int vmethod4125(int var1) {
      return this.field3192[var1] != null?100:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "6"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "6"
   )
   void method4104(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.crc32Table[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.crc = var5;
      Buffer var15 = new Buffer(FileOnDisk.decodeContainer(var1));
      var5 = var15.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var15.readInt();
         }

         var6 = var15.readUnsignedByte();
         if(var5 >= 7) {
            this.validArchivesCount = var15.getLargeSmart();
         } else {
            this.validArchivesCount = var15.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var15.getLargeSmart();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var15.readUnsignedShort();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         }

         this.archiveCrcs = new int[var8 + 1];
         this.archiveRevisions = new int[var8 + 1];
         this.archiveNumberOfFiles = new int[var8 + 1];
         this.archiveFileIds = new int[var8 + 1][];
         this.field3192 = new Object[var8 + 1];
         this.childs = new Object[var8 + 1][];
         if(var6 != 0) {
            this.archiveNames = new int[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveNames[this.archiveIds[var9]] = var15.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveCrcs[this.archiveIds[var9]] = var15.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveRevisions[this.archiveIds[var9]] = var15.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveNumberOfFiles[this.archiveIds[var9]] = var15.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var15.getLargeSmart();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.childs[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var15.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.childs[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.archiveFileNames = new int[var8 + 1][];
            this.childIdentifiers = new Identifiers[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               this.archiveFileNames[var10] = new int[this.childs[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.archiveFileNames[var10][this.archiveFileIds[var10][var12]] = var15.readInt();
               }

               this.childIdentifiers[var10] = new Identifiers(this.archiveFileNames[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1334993411"
   )
   public boolean method4010(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3192[var1] != null) {
            return true;
         } else {
            this.vmethod4129(var1);
            return this.field3192[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "526045595"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3192[var1] != null) {
         return true;
      } else {
         this.vmethod4129(var1);
         return this.field3192[var1] != null;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-104"
   )
   public boolean method4028(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(ItemComposition.djb2Hash(var2));
      return this.method4010(var3, var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-92"
   )
   void vmethod4120(int var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-457182655"
   )
   public byte[] method4014(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1831054787"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "597920391"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(ItemComposition.djb2Hash(var1));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1259310911"
   )
   public boolean method4026(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(ItemComposition.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1460683982"
   )
   boolean method4023(int var1, int[] var2) {
      if(this.field3192[var1] == null) {
         return false;
      } else {
         int var3 = this.archiveNumberOfFiles[var1];
         int[] var4 = this.archiveFileIds[var1];
         Object[] var5 = this.childs[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var18 = WorldMapType1.toByteArray(this.field3192[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = WorldMapType1.toByteArray(this.field3192[var1], false);
            }

            byte[] var20 = FileOnDisk.decodeContainer(var18);
            if(this.field3195) {
               this.field3192[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.readInt();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field3197) {
                     var5[var4[var15]] = WallObject.method2806(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3197) {
               var5[var4[0]] = WallObject.method2806(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-22"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(ItemComposition.djb2Hash(var2));
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2070817518"
   )
   public int method4031(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      return this.vmethod4125(var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "14"
   )
   public byte[] method4027(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(ItemComposition.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1325111022"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.childs.length; ++var1) {
         if(this.childs[var1] != null) {
            for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
               this.childs[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "198696506"
   )
   public boolean method4012() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3192[var3] == null) {
            this.vmethod4129(var3);
            if(this.field3192[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1494769736"
   )
   public boolean method4029(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "976913403"
   )
   public void method4021(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1428799116"
   )
   public void method4030(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(ItemComposition.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4120(var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lcw;I)V",
      garbageValue = "439172148"
   )
   static void method4052(World var0) {
      if(var0.method1507() != Client.isMembers) {
         Client.isMembers = var0.method1507();
         class225.method3980(var0.method1507());
      }

      DynamicObject.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      WidgetNode.field827 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      class33.field456 = Client.socketType == 0?443:var0.id + '썐';
      class18.myWorldPort = WidgetNode.field827;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "73381403"
   )
   static final void method4093(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field953 - 1] = var1;
               var3.field1258 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.secretPacketBuffer2.getBits(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.secretPacketBuffer2.getBits(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               var3.composition = WorldMapType3.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
               int var5 = Client.secretPacketBuffer2.getBits(1);
               int var6;
               if(var0) {
                  var6 = Client.secretPacketBuffer2.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.secretPacketBuffer2.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = Client.secretPacketBuffer2.getBits(1);
               if(var7 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
               }

               int var8 = Client.field983[Client.secretPacketBuffer2.getBits(3)];
               if(var2) {
                  var3.orientation = var3.angle = var8;
               }

               var3.field1213 = var3.composition.field3532;
               var3.field1232 = var3.composition.field3555;
               if(var3.field1232 == 0) {
                  var3.angle = 0;
               }

               var3.field1217 = var3.composition.field3538;
               var3.field1264 = var3.composition.field3539;
               var3.field1244 = var3.composition.field3540;
               var3.field1220 = var3.composition.field3541;
               var3.idlePoseAnimation = var3.composition.field3547;
               var3.field1215 = var3.composition.field3550;
               var3.field1216 = var3.composition.field3537;
               var3.method1634(var4 + class226.localPlayer.pathX[0], var6 + class226.localPlayer.pathY[0], var5 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         return;
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "92000412"
   )
   static final String[] method4103(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
