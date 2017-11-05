import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2036602737
   )
   static int field3223;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2081756965
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("s")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("q")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("g")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("v")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("p")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("e")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("d")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("z")
   Object[] field3219;
   @ObfuscatedName("n")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1337078623
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("a")
   boolean field3221;
   @ObfuscatedName("i")
   boolean field3222;

   static {
      gzip = new GZipDecompressor();
      field3223 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3221 = var1;
      this.field3222 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-16320977"
   )
   void method4239(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.crc32Table[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.crc = var5;
      Buffer var15 = new Buffer(class174.decodeContainer(var1));
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
         this.field3219 = new Object[var8 + 1];
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "609099973"
   )
   void vmethod4299(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "956093548"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-888105318"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4205(var1, var3);
            if(!var4) {
               this.vmethod4295(var1);
               var4 = this.method4205(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class164.toByteArray(this.childs[var1][var2], false);
         if(this.field3222) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "275602336"
   )
   public boolean method4192(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3219[var1] != null) {
            return true;
         } else {
            this.vmethod4295(var1);
            return this.field3219[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1374586146"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3219[var1] != null) {
         return true;
      } else {
         this.vmethod4295(var1);
         return this.field3219[var1] != null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "851966412"
   )
   public boolean method4225() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3219[var3] == null) {
            this.vmethod4295(var3);
            if(this.field3219[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "6612"
   )
   int vmethod4320(int var1) {
      return this.field3219[var1] != null?100:0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-382690982"
   )
   public byte[] method4230(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1813101280"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4205(var1, (int[])null);
            if(!var3) {
               this.vmethod4295(var1);
               var3 = this.method4205(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class164.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1728994573"
   )
   public byte[] method4242(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   void vmethod4295(int var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "3"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-83"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1900446636"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-109"
   )
   public void method4203(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1648386888"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "2139485055"
   )
   boolean method4205(int var1, int[] var2) {
      if(this.field3219[var1] == null) {
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
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class164.toByteArray(this.field3219[var1], false);
            } else {
               var18 = class164.toByteArray(this.field3219[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = class174.decodeContainer(var18);
            if(this.field3221) {
               this.field3219[var1] = null;
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
                  if(!this.field3222) {
                     var5[var4[var15]] = GameEngine.method934(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3222) {
               var5[var4[0]] = GameEngine.method934(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1919654631"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class266.djb2Hash(var1));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "73"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class266.djb2Hash(var2));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1832159931"
   )
   public boolean method4208(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class266.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class266.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "57"
   )
   public byte[] method4265(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class266.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class266.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-2021397364"
   )
   public boolean method4210(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class266.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class266.djb2Hash(var2));
      return this.method4192(var3, var4);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-35"
   )
   public boolean method4211(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class266.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1072406549"
   )
   public void method4212(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class266.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4299(var2);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2104177364"
   )
   public int method4213(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class266.djb2Hash(var1));
      return this.vmethod4320(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-890781099"
   )
   public static boolean method4278() {
      long var0 = class174.currentTimeMs();
      int var2 = (int)(var0 - class238.field3258);
      class238.field3258 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3245 += var2;
      if(class238.field3259 == 0 && class238.field3250 == 0 && class238.field3253 == 0 && class238.field3248 == 0) {
         return true;
      } else if(class238.field3255 == null) {
         return false;
      } else {
         try {
            if(class238.field3245 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class238.field3250 < 20 && class238.field3248 > 0) {
                  var3 = (FileRequest)class238.field3247.method3637();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3255.queueForWrite(var4.payload, 0, 4);
                  class238.field3244.put(var3, var3.hash);
                  --class238.field3248;
                  ++class238.field3250;
               }

               while(class238.field3259 < 20 && class238.field3253 > 0) {
                  var3 = (FileRequest)class238.field3261.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3255.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class238.field3254.put(var3, var3.hash);
                  --class238.field3253;
                  ++class238.field3259;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3255.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3245 = 0;
                  byte var5 = 0;
                  if(class238.currentRequest == null) {
                     var5 = 8;
                  } else if(class238.field3251 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3246.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3255.read(class238.field3246.payload, class238.field3246.offset, var6);
                     if(class238.field3262 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3246.payload[var7 + class238.field3246.offset] ^= class238.field3262;
                        }
                     }

                     class238.field3246.offset += var6;
                     if(class238.field3246.offset < var5) {
                        break;
                     }

                     if(class238.currentRequest == null) {
                        class238.field3246.offset = 0;
                        var7 = class238.field3246.readUnsignedByte();
                        var8 = class238.field3246.readUnsignedShort();
                        int var17 = class238.field3246.readUnsignedByte();
                        var10 = class238.field3246.readInt();
                        long var18 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class238.field3244.get(var18);
                        class238.field3256 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class238.field3254.get(var18);
                           class238.field3256 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var17 == 0?5:9;
                        class238.currentRequest = var13;
                        ScriptEvent.field858 = new Buffer(var10 + var14 + class238.currentRequest.padding);
                        ScriptEvent.field858.putByte(var17);
                        ScriptEvent.field858.putInt(var10);
                        class238.field3251 = 8;
                        class238.field3246.offset = 0;
                     } else if(class238.field3251 == 0) {
                        if(class238.field3246.payload[0] == -1) {
                           class238.field3251 = 1;
                           class238.field3246.offset = 0;
                        } else {
                           class238.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = ScriptEvent.field858.payload.length - class238.currentRequest.padding;
                     var7 = 512 - class238.field3251;
                     if(var7 > var6 - ScriptEvent.field858.offset) {
                        var7 = var6 - ScriptEvent.field858.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class238.field3255.read(ScriptEvent.field858.payload, ScriptEvent.field858.offset, var7);
                     if(class238.field3262 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           ScriptEvent.field858.payload[var8 + ScriptEvent.field858.offset] ^= class238.field3262;
                        }
                     }

                     ScriptEvent.field858.offset += var7;
                     class238.field3251 += var7;
                     if(var6 == ScriptEvent.field858.offset) {
                        if(16711935L == class238.currentRequest.hash) {
                           WorldMapType3.field404 = ScriptEvent.field858;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var9 = class238.field3260[var8];
                              if(var9 != null) {
                                 WorldMapType3.field404.offset = var8 * 8 + 5;
                                 var10 = WorldMapType3.field404.readInt();
                                 int var11 = WorldMapType3.field404.readInt();
                                 var9.setInformation(var10, var11);
                              }
                           }
                        } else {
                           class238.field3265.reset();
                           class238.field3265.update(ScriptEvent.field858.payload, 0, var6);
                           var8 = (int)class238.field3265.getValue();
                           if(var8 != class238.currentRequest.crc) {
                              try {
                                 class238.field3255.close();
                              } catch (Exception var21) {
                                 ;
                              }

                              ++class238.field3263;
                              class238.field3255 = null;
                              class238.field3262 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3263 = 0;
                           class238.field3264 = 0;
                           class238.currentRequest.index.method4321((int)(class238.currentRequest.hash & 65535L), ScriptEvent.field858.payload, (class238.currentRequest.hash & 16711680L) == 16711680L, class238.field3256);
                        }

                        class238.currentRequest.unlink();
                        if(class238.field3256) {
                           --class238.field3250;
                        } else {
                           --class238.field3259;
                        }

                        class238.field3251 = 0;
                        class238.currentRequest = null;
                        ScriptEvent.field858 = null;
                     } else {
                        if(class238.field3251 != 512) {
                           break;
                        }

                        class238.field3251 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var22) {
            try {
               class238.field3255.close();
            } catch (Exception var20) {
               ;
            }

            ++class238.field3264;
            class238.field3255 = null;
            return false;
         }
      }
   }
}
