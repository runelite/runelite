import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public abstract class class28 {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1463904951
   )
   static int field416;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1319955551
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1081795101
   )
   int field406;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -485778823
   )
   int field407;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2030795397
   )
   int field420;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1667783465
   )
   int field409;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 944730053
   )
   int field410;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 77637933
   )
   int field411;
   @ObfuscatedName("z")
   short[][][] field414;
   @ObfuscatedName("i")
   short[][][] field413;
   @ObfuscatedName("u")
   byte[][][] field408;
   @ObfuscatedName("x")
   byte[][][] field415;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[[[[Lal;"
   )
   @Export("decorations")
   WorldMapDecoration[][][][] decorations;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILgc;I)V",
      garbageValue = "1551952072"
   )
   void method251(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method252(var1, var2, var3, var4);
         } else {
            this.method266(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILgc;IB)V",
      garbageValue = "-116"
   )
   void method252(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field413[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field414[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILgc;II)V",
      garbageValue = "-513412478"
   )
   void method266(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field414[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field413[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field408[var9][var1][var2] = (byte)(var11 >> 2);
               this.field415[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3576();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-441"
   )
   int method269(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field414[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1551051098"
   )
   int method255() {
      return this.field420;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1234369929"
   )
   int method256() {
      return this.field409;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;Lha;I)Lha;",
      garbageValue = "-2098945237"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = GraphicsObject.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1679438329"
   )
   public static boolean method268() {
      ClassInfo var0 = (ClassInfo)class326.classInfos.last();
      return var0 != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-947075320"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1218267046"
   )
   static int method273(int var0, Script var1, boolean var2) {
      Widget var3 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++WorldComparator.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1148349486"
   )
   static final void method275() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class55.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.unknownSoundValues2[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.unknownSoundValues2[var0] < 0) {
               int var2;
               if(Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - SoundTaskDataProvider.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - SoundTaskDataProvider.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field951 / var3;
               } else {
                  var2 = Client.field1075;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2124().applyResampler(WorldMapDecoration.field446);
                  class115 var11 = class115.method2317(var10, 100, var2);
                  var11.method2320(Client.unknownSoundValues1[var0] - 1);
                  MouseInput.field727.method2059(var11);
               }

               Client.unknownSoundValues2[var0] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = var0; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.unknownSoundValues2[var1] = Client.unknownSoundValues2[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1102) {
         boolean var12;
         if(class229.field2687 != 0) {
            var12 = true;
         } else {
            var12 = class229.field2690.method4151();
         }

         if(!var12) {
            if(Client.field996 != 0 && Client.field1026 != -1) {
               PacketNode.method3442(PacketBuffer.indexTrack1, Client.field1026, 0, Client.field996, false);
            }

            Client.field1102 = false;
         }
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(ZLgs;B)V",
      garbageValue = "-24"
   )
   static final void method274(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field957.packetLength) >= 27) {
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
               if(var5 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

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

               int var7 = Client.field995[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var7;
               }

               var4.composition = class234.getNpcDefinition(var1.getBits(14));
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

               int var9 = var1.getBits(1);
               var4.field1172 = var4.composition.size;
               var4.field1205 = var4.composition.rotation;
               if(var4.field1205 == 0) {
                  var4.angle = 0;
               }

               var4.field1165 = var4.composition.walkingAnimation;
               var4.field1209 = var4.composition.rotate180Animation;
               var4.field1167 = var4.composition.rotate90RightAnimation;
               var4.field1177 = var4.composition.rotate90LeftAnimation;
               var4.idlePoseAnimation = var4.composition.standingAnimation;
               var4.field1163 = var4.composition.field3716;
               var4.field1164 = var4.composition.field3714;
               var4.method1874(SoundTaskDataProvider.localPlayer.pathX[0] + var6, SoundTaskDataProvider.localPlayer.pathY[0] + var8, var9 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
