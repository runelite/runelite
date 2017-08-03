import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 700378273
   )
   static int field3209;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static class262 field3208;
   @ObfuscatedName("t")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("q")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("g")
   Object[] field3203;
   @ObfuscatedName("s")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("u")
   boolean field3198;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("f")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("v")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 558586559
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("b")
   boolean field3211;
   @ObfuscatedName("e")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 492664775
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("x")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("i")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3209 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3198 = var1;
      this.field3211 = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1207597032"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4166(var1, var3);
            if(!var4) {
               this.vmethod4201(var1);
               var4 = this.method4166(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = IndexFile.toByteArray(this.childs[var1][var2], false);
         if(this.field3211) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "122"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-960757753"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4166(var1, (int[])null);
            if(!var3) {
               this.vmethod4201(var1);
               var3 = this.method4166(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = IndexFile.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-662820782"
   )
   void vmethod4201(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "44"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1886340173"
   )
   public byte[] method4117(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-282715715"
   )
   int vmethod4221(int var1) {
      return this.field3203[var1] != null?100:0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-426491968"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1909095673"
   )
   void method4137(byte[] var1) {
      this.crc = CombatInfo1.method1557(var1, var1.length);
      Buffer var2 = new Buffer(WidgetNode.decodeContainer(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.validArchivesCount = var2.getLargeSmart();
         } else {
            this.validArchivesCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.getLargeSmart();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.readUnsignedShort();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         }

         this.archiveCrcs = new int[var6 + 1];
         this.archiveRevisions = new int[var6 + 1];
         this.archiveNumberOfFiles = new int[var6 + 1];
         this.archiveFileIds = new int[var6 + 1][];
         this.field3203 = new Object[var6 + 1];
         this.childs = new Object[var6 + 1][];
         if(var4 != 0) {
            this.archiveNames = new int[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveNames[this.archiveIds[var7]] = var2.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveCrcs[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveRevisions[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveNumberOfFiles[this.archiveIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.getLargeSmart();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.childs[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.childs[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.archiveFileNames = new int[var6 + 1][];
            this.childIdentifiers = new Identifiers[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               this.archiveFileNames[var8] = new int[this.childs[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.archiveFileNames[var8][this.archiveFileIds[var8][var10]] = var2.readInt();
               }

               this.childIdentifiers[var8] = new Identifiers(this.archiveFileNames[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean method4115(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3203[var1] != null) {
            return true;
         } else {
            this.vmethod4201(var1);
            return this.field3203[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-846247908"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3203[var1] != null) {
         return true;
      } else {
         this.vmethod4201(var1);
         return this.field3203[var1] != null;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-107"
   )
   public boolean method4135(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class222.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class222.djb2Hash(var2));
      return this.method4115(var3, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1194485401"
   )
   void vmethod4203(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "919090893"
   )
   public byte[] method4119(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "977833872"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "659858164"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class222.djb2Hash(var1));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "8"
   )
   public boolean method4150(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class222.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class222.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1559753099"
   )
   boolean method4166(int var1, int[] var2) {
      if(this.field3203[var1] == null) {
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
               var18 = IndexFile.toByteArray(this.field3203[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = IndexFile.toByteArray(this.field3203[var1], false);
            }

            byte[] var20 = WidgetNode.decodeContainer(var18);
            if(this.field3198) {
               this.field3203[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
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
                  if(!this.field3211) {
                     var5[var4[var15]] = XClanMember.method1171(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3211) {
               var5[var4[0]] = XClanMember.method1171(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1076008074"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class222.djb2Hash(var2));
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1321059825"
   )
   public int method4136(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class222.djb2Hash(var1));
      return this.vmethod4221(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "3"
   )
   public byte[] method4132(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class222.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class222.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-123"
   )
   public boolean method4133() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3203[var3] == null) {
            this.vmethod4201(var3);
            if(this.field3203[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-444956202"
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

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "65028477"
   )
   public boolean method4147(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class222.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method4126(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1632374305"
   )
   public void method4188(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class222.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4203(var2);
      }
   }
}
